package com.mobi.config.checkStrategy;

import com.mobi.config.Config;
import com.mobi.config.ConfigManager;
import com.mobi.config.ConfigModel;
import com.mobi.log.GameLog;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import com.mobi.config.wrappedArrayList.ArrArrInt;
import com.mobi.config.wrappedArrayList.ArrArrString;
import com.mobi.config.wrappedArrayList.ArrInt;
import com.mobi.config.wrappedArrayList.ArrString;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Pattern;
public class CheckStrategyService {

    public static List<Class<?>> ONE_DIM = new ArrayList<Class<?>>(){{add(Integer.class); add(String.class);}};
    public static List<Class<?>> TWO_DIM = new ArrayList<Class<?>>(){{add(ArrInt.class);add(ArrString.class);}};
    public static List<Class<?>> THREE_DIM = new ArrayList<Class<?>>(){{add(ArrArrInt.class); add(ArrArrString.class);}};

    /**
     *
     * @param limitState
     * @param columnInfo 格式：className#fieldName，如com.mobi.config.configModel.Hero#gender
     * @return
     */
    public static boolean check(String limitState, ColumnInfo columnInfo) {
        List<Object> list = findList(columnInfo);
        if(list == null || list.isEmpty() || limitState == null || limitState.isEmpty()) {
            return true;
        }
        Class<?> clazz = list.get(0).getClass();
        if(ONE_DIM.contains(clazz)) {
            return checkOneDim(list, limitState,columnInfo);
        }
        if(TWO_DIM.contains(clazz)) {
            return checkTwoDim(list, limitState,columnInfo);
        }
        if(THREE_DIM.contains(clazz)) {
            return checkThreeDim(list, limitState, columnInfo);
        }
        GameLog.LogError("表格检查错误，不支持该类型的检查，{},clazz:{}, limitState:{}",columnInfo.toDesc(), clazz, limitState);
        return false;
    }

    /**
     *
     * @param list List<Integer>
     *             {heroId1,heroId2,heroId3}
     * @param oneDimState 格式：ID:Hero 或者 ID:Hero|IN:[1;3;4]
     * @return
     */
    private static boolean checkOneDim(List<Object> list, String oneDimState,ColumnInfo columnInfo) {
        String[] limitStateUnits = oneDimState.split("\\|");
        boolean re = true;
        for (String limitStateUnit : limitStateUnits) {
            if(!check0(list, limitStateUnit, columnInfo)) {
                re = false;
            }
        }
        return re;
    }

    /**
     *
     * @param list List<List<Integer>> 【一维的形式】
     *             {heroId1,heroId2,heroId3},
     *             {heroId2,heroId3,heroId4},
     *             {heroId5,heroId6,heroId7}
     *              或 【二维的形式】
     *             {heroId1,1},
     *             {heroId2,2},
     *             {heroId3,3},
     * @param twoDimState 格式：ID:Hero|IN:[1,3,4] 或 1:{ID:Hero}#2:{BETWEEN:[1;3]}
     * @return
     */
    private static boolean checkTwoDim(List<Object> list, String twoDimState,ColumnInfo columnInfo) {
        // 一维的形式
        if(!Pattern.matches("\\d+.*", twoDimState)) {
            AtomicBoolean re = new AtomicBoolean(true);
            list.forEach(ele -> {
                if(!checkOneDim((List<Object>) ele,twoDimState, columnInfo)) {
                    re.set(false);
                }
            });
            return re.get();
        }
        String[] split = twoDimState.split("#");
        boolean re = true;
        for (String s : split) {
            ColumnInfo column = new ColumnInfo(columnInfo);
            column.setIndex(Integer.parseInt(s.split(":")[0]));
            List<Object> collect = CheckStrategyService.findList(column);
            String oneDimState = s.substring(s.indexOf("{") + 1, s.indexOf("}"));
            boolean check = checkOneDim(collect, oneDimState, column);
            if(!check) {
                re = false;
            }
        }
        return re;
    }

    /**
     *
     * @param lists List<List<List<Integer>>>
     *              {{heroId1, 1},{heroId2, 2},{heroId3, 3}},
     *              {{heroId4, 4},{heroId5, 5},{heroId6, 6}},
     *              {{heroId7, 7},{heroId8, 8},{heroId9, 9}},
     * @param threeDimState 格式：1:{ID:Hero}#2:{BETWEEN:{1,10}}
     *                      每一行的第一个元素是 Hero 表的id
     *                      每一行的第二个元素在 [1,10] 之间
     * @return
     */
    private static boolean checkThreeDim(List<Object> lists, String threeDimState,ColumnInfo columnInfo) {
        AtomicBoolean re = new AtomicBoolean(true);
        for (int i = 0; i < lists.size(); i++) {
            // 将当前行的信息带入到fieldName中
            ColumnInfo column = new ColumnInfo(columnInfo);
            column.setIndexInMap(i + 1);
            if(!checkTwoDim((List<Object>) lists.get(i), threeDimState, column)) {
                re.set(false);
            }
        }
        return re.get();
    }

    /**
     * @param list 某一列数据，元素是基本类型。
     * @param limitStateUnit 这一列数据的限制Unit，如"ID:Hero$Monster$Null"
     * @return
     */

    public static boolean check0(List<Object> list, String limitStateUnit, ColumnInfo columnInfo) {
        Class<?> cla = list == null || list.isEmpty() ? Integer.class : list.get(0).getClass();
        int i = limitStateUnit.indexOf(":");
        String strategyStr = limitStateUnit.substring(0, i);
        CheckStrategyEnum strategy = CheckStrategyEnum.findStrategy(cla, strategyStr);
        if(strategy == null) {
            return false;
        }

        return strategy.checkStrategy.check(list, limitStateUnit.substring(limitStateUnit.indexOf(":") + 1), columnInfo);
    }
    /**
     * 找到对应的dict
     *
     * @param limitStateVal: 页签名，兼容首字母小写，比如传入maze，会返回MazeConfigModels对应的dict
     * @return
     */
     static HashMap<Integer, ? extends ConfigModel> findDict(String limitStateVal) {
        // 兼容以小写字母开头
        char firstChar = limitStateVal.charAt(0);
        if (firstChar >= 'a' && firstChar <= 'z') {
            char replace = (char) (firstChar - 32);
            limitStateVal = replace + limitStateVal.substring(1);
        }
        String fileName = limitStateVal + "ConfigModels";
        HashMap<Integer, ? extends ConfigModel> dict;
        try {
            Field declaredField = ConfigManager.class.getDeclaredField(fileName);
            Config<? extends ConfigModel> config = (Config<? extends ConfigModel>) declaredField.get(null);
            dict = config.dict;
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
        return dict;
    }

    public static List<Object> findList(ColumnInfo columnInfo) {
        try {
            return findList0(columnInfo);
        } catch (NoSuchFieldException | ClassNotFoundException | IllegalAccessException e) {
            GameLog.LogError("无法找到对应的数据: columnInfo:{}", columnInfo);
            throw new RuntimeException(e);
        }
    }

    /**
     * 查找一列数据
     * @return
     */
    static List<Object> findList0(ColumnInfo columnInfo) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException {
        String className = columnInfo.getClassName();
        String simpleClassName = className.substring(className.lastIndexOf(".") + 1);
        String sheetName;
        if (simpleClassName.endsWith("ConfigModel")) {
            // 11是"ConfigModel"的长度
            sheetName = simpleClassName.substring(0, simpleClassName.length() - 11);
        } else if (simpleClassName.endsWith("ConfigModelEx")){
            // 13是"ConfigModelEx"的长度
            sheetName = simpleClassName.substring(0, simpleClassName.length() - 13);
        } else {
            throw new RuntimeException("className不合法：" + className);
        }
        HashMap<Integer, ? extends ConfigModel> dict = findDict(sheetName);
        Class<?> configModelClazz =  Class.forName(className);
        if(columnInfo.getIndexInMap() != 0) {
            ConfigModel configModel = dict.values().stream().collect(Collectors.toList()).get(columnInfo.getIndexInMap() - 1);
            if(columnInfo.getRepeatNum() == 0) {
                // 找到对应行的ConfigModel
                // 找到该model对应的字段值
                List<List<Object>> list = (List<List<Object>>) configModelClazz.getField(columnInfo.getFieldName()).get(configModel);
                return list.stream().map(ele -> ele.get(columnInfo.getIndex() - 1)).collect(Collectors.toList());
            } else {
                Object o = configModelClazz.getField(columnInfo.getFieldName()).get(configModel);
                List<Object> list = new ArrayList<>();
                for (int i = 0; i < columnInfo.getRepeatNum(); i++) {
                    list.add(o);
                }
                return list;
            }
        } else {
            return dict.values().stream().map(ele -> {
                Field declaredField;
                try {
                    declaredField = configModelClazz.getField(columnInfo.getFieldName());
                    if (columnInfo.getIndex() == 0) {
                        return declaredField.get(ele);
                    } else if (columnInfo.getIndexInMap() == 0) {
                        return getOrNull((List<Object>) declaredField.get(ele), columnInfo.getIndex() - 1);
                    }
                    return null;
                } catch (NoSuchFieldException | RuntimeException | IllegalAccessException runtimeException) {
                    GameLog.LogError("无法找到对应的数据: columnInfo:{}", columnInfo);
                    throw new RuntimeException(runtimeException);
                }
            }).collect(Collectors.toList());
        }
    }

    /**
     * 找到对应的dict
     *
     * @param limitStateVal: 页签名，兼容首字母小写，比如传入maze，会返回MazeConfigModels对应的dict
     * @return
     */
    static HashMap<String, ? extends ConfigModel> findSDict(String limitStateVal) {
        // 兼容以小写字母开头
        char firstChar = limitStateVal.charAt(0);
        if (firstChar >= 'a' && firstChar <= 'z') {
            char replace = (char) (firstChar - 32);
            limitStateVal = replace + limitStateVal.substring(1);
        }
        String fileName = limitStateVal + "ConfigModels";
        HashMap<String, ? extends ConfigModel> sDict;
        try {
            Field declaredField = ConfigManager.class.getDeclaredField(fileName);
            Config<? extends ConfigModel> config = (Config<? extends ConfigModel>) declaredField.get(null);
            sDict = config.sDict;
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
        return sDict;
    }

    private static Object getOrNull(List<Object> list, int index) {
        if(list == null) {
            return null;
        }
        if(index >= 0 && index < list.size()) {
            return list.get(index);
        }
        return null;
    }

    static String findSheetNameBySimpleClassName(String className) {
        if(className.endsWith("Ex")) {
            // 这里的13是ConfigModelEx这个字符串的长度
            return className.substring(0, className.length() - 13);
        } else {
            // 这里的11是ConfigModelEx这个字符串的长度
            return className.substring(0, className.length() - 11);
        }
    }
}
