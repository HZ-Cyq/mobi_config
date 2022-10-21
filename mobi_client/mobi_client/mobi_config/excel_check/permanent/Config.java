package com.mobi.config;


import com.mobi.config.wrappedArrayList.ArrArrInt;
import com.mobi.config.wrappedArrayList.ArrArrString;
import com.mobi.config.wrappedArrayList.ArrInt;
import com.mobi.config.wrappedArrayList.ArrString;
import com.mobi.log.GameLog;

import java.io.File;
import java.lang.reflect.Field;
import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Pattern;
import java.util.stream.Collectors;


public class Config<T extends ConfigModel> {
    private boolean bInited = false;
    public static final String _path = "data" + File.separator;

    private long lastModifiedTime;

    public HashMap<Integer, T> dict = new HashMap<>();
    public HashMap<String, T> sDict = new HashMap<>();
    public HashMap<Integer, ArrayList<T>> gDict = new HashMap<>();

    public HashMap<String, String> limitStateMap = new HashMap<>();

    public long getLastModifiedTime() {
        return lastModifiedTime;
    }

    public void setLastModifiedTime(long lastModifiedTime) {
        this.lastModifiedTime = lastModifiedTime;
    }

    public boolean Init(Class<? extends ConfigModel> className) {
        if (bInited)
            return false;
        bInited = true;
        try {
            String loadFile = _path + getConfigName(className) + ".xml";
            String loadFileWithSeason = _path + getConfigName(className) + ".xml";
            File file = new File(loadFileWithSeason);
            if (!file.exists())
                file = new File(loadFile);
            GameLog.LogInfo("加载" + file.getPath());
            Init0(file, className);
        } catch (IllegalAccessException e) {
            GameLog.LogError(String.format("Parse xml Error: %s", className.toString()));
            return false;
        }
        return true;
    }

    public boolean check(Class<? extends  ConfigModel> configModelClazz) {
        boolean re = true;
        try {
            String[] split = configModelClazz.getName().split("\\.");
            String excelNameWithConfigModel = split[split.length - 1];
            if(excelNameWithConfigModel.endsWith("Ex")) {
                // 这里的13是ConfigModelEx这个字符串的长度
                GameLog.LogInfo("检查 {} 表格的配置", excelNameWithConfigModel.substring(0, excelNameWithConfigModel.length() - 13));

            } else {
                // 这里的11是ConfigModelEx这个字符串的长度
                GameLog.LogInfo("检查 {} 表格的配置", excelNameWithConfigModel.substring(0, excelNameWithConfigModel.length() - 11));
            }
            // limitStateMap:{"id":"LimitState","character_type":"IN:[1;2]","skills":"","hero_icon":"null"}
            for (Map.Entry<String, String> entry : limitStateMap.entrySet()) {
                if ("id".equals(entry.getKey()) || "null".equals(entry.getValue())) {
                    continue;
                }
                // 算出该限制语句对应的一列数据
                List<Object> values = dict.values().stream().map(ele -> {
                    Field declaredField;
                    try {
                        declaredField = configModelClazz.getField(entry.getKey());
                        return declaredField.get(ele);
                    } catch (NoSuchFieldException | IllegalAccessException e) {
                        GameLog.LogError(e.getMessage(), e);
                        GameLog.LogError("表格数据检查错误，configModelClazz:{}, 列名:{}", configModelClazz.getName(), entry.getKey());
                        throw new RuntimeException(e);
                    }
                }).collect(Collectors.toList());

                GameLog.LogInfo("列名:{}, LimitState:{}", entry.getKey(), entry.getValue());
                try {
                    boolean check = CheckStrategy.check(values, entry.getValue());
                    if(!check) {
                        re = false;
                    }
                } catch (RuntimeException exception) {
                    GameLog.LogError(exception.getMessage(), exception);
                    GameLog.LogError("表格数据未通过检查, 列名:{}. limitState:{}, values:{}",entry.getKey(), entry.getValue(), values);
                    re = false;
                }
            }
        } catch (Exception e) {
            re = false;
            GameLog.LogError(e.getMessage(), e);
        }
        return re;
    }

    private static class CheckStrategy {
        public static List<Class<?>> ONE_DIM = new ArrayList<Class<?>>(){{add(Integer.class); add(String.class);}};
        public static List<Class<?>> TWO_DIM = new ArrayList<Class<?>>(){{add(ArrInt.class);add(ArrString.class);}};
        public static List<Class<?>> THREE_DIM = new ArrayList<Class<?>>(){{add(ArrArrInt.class); add(ArrArrString.class);}};
        private static boolean check(List<Object> list, String limitState) {
            if(list == null || list.isEmpty() || limitState == null || limitState.isEmpty()) {
                return true;
            }
            Class<?> clazz = list.get(0).getClass();
            if(ONE_DIM.contains(clazz)) {
                return checkOneDim(list, limitState);
            }
            if(TWO_DIM.contains(clazz)) {
                return checkTwoDim(list, limitState);
            }
            if(THREE_DIM.contains(clazz)) {
                return checkThreeDim(list, limitState);
            }
            GameLog.LogError("表格检查错误，不支持该类型的检查，clazz:{}, limitState:{}", clazz, limitState);
            return false;
        }

        /**
         *
         * @param list List<Integer>
         *             {heroId1,heroId2,heroId3}
         * @param oneDimState 格式：ID:Hero 或者 ID:Hero|IN:[1;3;4]
         * @return
         */
        private static boolean checkOneDim(List<Object> list, String oneDimState) {
            String[] limitStateUnits = oneDimState.split("\\|");
            boolean re = true;
            for (String limitStateUnit : limitStateUnits) {
                if(!check0(list, limitStateUnit)) {
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
        private static boolean checkTwoDim(List<Object> list, String twoDimState) {
            // 一维的形式
            if(!Pattern.matches("\\d+.*", twoDimState)) {
                AtomicBoolean re = new AtomicBoolean(true);
                list.forEach(ele -> {
                    if(!checkOneDim((List<Object>) ele, twoDimState)) {
                        re.set(false);
                    }
                });
                return re.get();
            }
            //
            String[] split = twoDimState.split("#");
            boolean re = true;
            for (String s : split) {
                int index = Integer.parseInt(s.split(":")[0]) - 1;
                String oneDimState = s.substring(s.indexOf("{") + 1, s.indexOf("}"));
                List<Object> collect = list.stream().map(oneRow -> {
                    List<Object> oneRowList = (List<Object>) oneRow;
                    Object o = index < oneRowList.size() ? oneRowList.get(index) : null;
                    return o;
                }).collect(Collectors.toList());
                boolean check = checkOneDim(collect, oneDimState);
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
        private static boolean checkThreeDim(List<Object> lists, String threeDimState) {
            AtomicBoolean re = new AtomicBoolean(true);
            lists.forEach(list -> {
                if(!checkTwoDim((List<Object>) list, threeDimState)) {
                    re.set(false);
                }
            });
            return re.get();
        }

        /**
         * @param list 某一列数据，元素是基本类型。
         * @param limitStateUnit 这一列数据的限制Unit，如"ID:HERO"
         * @return
         */
        private static boolean check0(List<Object> list, String limitStateUnit) {
            if(list == null || list.isEmpty()) {
                boolean re = limitStateUnit.startsWith("ID_OR_NULL");
                if(!re) {
                    GameLog.LogError("传入的list为空，但是limitState不是ID_OR_NULL， limitStateUnit:{}", limitStateUnit);
                }
                return re;
            }
            Object o = list.get(0);
            String[] split = limitStateUnit.split(":");
            CheckStrategyEnum strategy = CheckStrategyEnum.findStrategy(o.getClass(), split[0]);
            if(strategy == null) {
                return false;
            }
            return strategy.checkStrategy.check(list, split[1]);
        }

        private enum CheckStrategyEnum {
            //"ID:Hero","int类型，并且值是Hero这张表的id",
            INT_ID(Integer.class,"ID", new IntIdCheckStrategy()),
            //"ID_OR_NULL:Hero","int类型，是Hero这张表的id或者是空"
            INT_ID_OR_NULL(Integer.class, "ID_OR_NULL", new IntIdOrNullCheckStrategy()),
            //"BETWEEN:[1;10]","int类型，并且值在1(包括)到10之间（包括）"
            INT_BETWEEN(Integer.class, "BETWEEN", new IntBetweenStrategy()),
            //"IN:[1;2;3;4]", "int类型，并且值是1,2,3,4中的1个"
            INT_IN(Integer.class, "IN", new IntInStrategy()),
            // "IN:[男;女]", "String类型，并且值是 男、女 中的1个"
            STRING_IN(String.class, "IN", new StringInStrategy()),
            ;
            public static CheckStrategyEnum findStrategy(Class<?> clazz, String limitStateKey) {
                for (CheckStrategyEnum value : values()) {
                    if(value.clazz.equals(clazz) && value.limitStateKey.equals(limitStateKey)) {
                        return value;
                    }
                }
                GameLog.LogError("表格检查错误，无法找到对应的CheckStrategyEnum,{},{}", clazz, limitStateKey);
                return null;
            }

            CheckStrategyEnum(Class<?> clazz, String limitStateKey, ICheckStrategy checkStrategy) {
                this.checkStrategy = checkStrategy;
                this.clazz = clazz;
                this.limitStateKey = limitStateKey;
            }

            private final ICheckStrategy checkStrategy;
            private final Class<?> clazz;
            private final String limitStateKey;
        }

        private interface ICheckStrategy {
            boolean check(List<Object> list, String limitStateUnitVal);
        }

        private static class IntIdCheckStrategy implements ICheckStrategy {
            @Override
            //"ID:Hero","int类型，并且值是Hero这张表的id",
            public boolean check(List<Object> list, String limitStateVal) {
                char firstChar = limitStateVal.charAt(0);
                if(firstChar >= 'a' && firstChar <= 'z') {
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
                boolean re = true;
                for (Object o : list) {
                    if(!dict.containsKey(o)) {
                        GameLog.LogError("IntIdCheckStrategy check error, 元素：{}， list:{}, {}表格的id集合{}, ", o, list, limitStateVal, dict.keySet());
                        re = false;
                    }
                }
                return re;
            }
        }

        private static class IntIdOrNullCheckStrategy implements ICheckStrategy {
            @Override
            //"ID:Hero","int类型，并且值是Hero这张表的id",
            public boolean check(List<Object> list, String limitStateVal) {
                char firstChar = limitStateVal.charAt(0);
                if(firstChar >= 'a' && firstChar <= 'z') {
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
                boolean re = true;
                for (Object o : list) {
                    if((int)o != 0 && !dict.containsKey(o)) {
                        GameLog.LogError("IntIdOrNullCheckStrategy check error, 元素：{}， list:{}, {}表格的id集合{}, ", o, list, limitStateVal, dict.keySet());
                        re = false;
                    }
                }
                return re;
            }
        }

        private static class IntBetweenStrategy implements ICheckStrategy {
            @Override
            //"BETWEEN:[1;10]","int类型，并且值在1(包括)到10之间（包括）"
            public boolean check(List<Object> list, String limitStateUnitVal) {
                String replace = limitStateUnitVal.replace("[", "").replace("]", "");
                String[] split = replace.split(";");
                int start = Integer.parseInt(split[0]);
                int end = Integer.parseInt(split[1]);
                boolean re = list.stream().allMatch(ele -> {
                    int eleVal = (int) ele;
                    return eleVal >= start && eleVal <= end;
                });
                if(!re) {
                    GameLog.LogError("IntBetweenStrategy check error, BETWEEN:{}, list:{}", limitStateUnitVal, list);
                }
                return re;
            }
        }

        private static class IntInStrategy implements ICheckStrategy {
            @Override
            //"IN:[1;2;3;4]", "int类型，并且值是1,2,3,4中的1个"
            public boolean check(List<Object> list, String limitStateUnitVal) {
                String replace = limitStateUnitVal.replace("[", "").replace("]", "");
                Set<Integer> collect = Arrays.stream(replace.split(";")).map(Integer::parseInt).collect(Collectors.toSet());
                boolean re = list.stream().allMatch(ele -> collect.contains((int) ele));
                if(!re) {
                    GameLog.LogError("IntInStrategy check error, IN:{}, list:{}", limitStateUnitVal, list);
                }
                return re;
            }
        }

        private static class StringInStrategy implements ICheckStrategy {
            @Override
            // "IN:[男;女]", "String类型，并且值是 男、女 中的1个"
            public boolean check(List<Object> list, String limitStateUnitVal) {
                String replace = limitStateUnitVal.replace("[", "").replace("]", "");
                Set<String> collect = Arrays.stream(replace.split(";")).collect(Collectors.toSet());
                boolean re = list.stream().allMatch(ele -> collect.contains((String) ele));
                if(!re) {
                    GameLog.LogError("StringInStrategy check error, IN:{}, list:{}", limitStateUnitVal, limitStateUnitVal);
                }
                return re;
            }
        }
    }

    public boolean ReInit(Class<? extends ConfigModel> className) {
        if (bInited) {
            try {
                String loadFile = _path + getConfigName(className) + ".xml";
                String loadFileWithSeason = _path + getConfigName(className) + ".xml";
                File file = new File(loadFileWithSeason);
                if (file.lastModified() != getLastModifiedTime()) {
                    Init0(file, className);
                    ConfigManager.refreshConfigList
                            .add(file.getPath());
                }
            } catch (IllegalAccessException e) {
                GameLog.LogError(String.format("Parse xml Error: %s", className.toString()));
                return false;
            }
        }
        return true;
    }

    @SuppressWarnings("unchecked")
    public void Init0(File file, Class<? extends ConfigModel> className) throws IllegalAccessException {

        long lastModified = file.lastModified();
        List<Map> load = (List<Map>) ConfigModel.load(file, className);
        dict = (HashMap<Integer, T>) load.get(0);
        limitStateMap = (HashMap<String, String>) load.get(1);
        if (dict == null) {
            throw new IllegalAccessException();
        }
        //string key
        {
            Field fi = getSpecialField(className, "key_", String.class);
            if (fi != null) {
                for (T cur : dict.values()) {
                    Object tempVar = fi.get(cur);  //fi.GetValue(cur);
                    String k = tempVar instanceof String ? (String) tempVar : null;
                    if (k == null || k.isEmpty())
                        continue;
                    sDict.put(k, cur);
                }
            }
        }

        //int group
        {
            Field fi = getSpecialField(className, "group_", int.class);
            if (fi != null) {
                for (T cur : dict.values()) {
                    int k = fi.getInt(cur);
                    if (!gDict.containsKey(k)) {
                        gDict.put(k, new ArrayList<>());
                    }
                    gDict.get(k).add(cur);
                }
            }
        }

        //int group sort
        {
            Field fi = getSpecialField(className, "g_sort_", int.class);
            if (fi != null) {
                for (ArrayList<T> curList : gDict.values()) {
                    curList.sort(new GroupComparator<>(fi));
                }
            }
        }
        setLastModifiedTime(lastModified);
    }

    public static String getConfigName(Class<? extends ConfigModel> clazz) {
        // String name = str.replaceFirst(str.substring(0, 1), str.substring(0,
        // 1)
        // .toLowerCase());
        String str = clazz.getSimpleName();
        if (str.endsWith("Ex")) {
            str = clazz.getSuperclass().getSimpleName();
        }
        if (str.endsWith("ConfigModel")) {
            return str.replace("ConfigModel", "");
        } else if (str.endsWith("ConfigModelEx")) {
            return str.replace("ConfigModelEx", "");
        }
        return str;
    }


    private Field getSpecialField(Class<? extends ConfigModel> className, String prefix, Class<?> classTypeName) {
        Field[] fields = className.getFields();
        Field fi = null;
        for (Field cur : fields) {
            if (cur.getName().startsWith(prefix) && cur.getType() == classTypeName) {
                fi = cur;
                break;
            }
        }
        return fi;
    }

    public T GetValue(int i) {
        return dict.get(i);
    }

    public T GetValue(String str) {
        return sDict.get(str);
    }

    public ArrayList<T> GetGroup(int groupId) {
        return gDict.get(groupId);
    }

    public void Clear() {
        dict.clear();
        sDict.clear();
        gDict.clear();
    }

    private static class GroupComparator<T> implements Comparator<T> {
        private final Field fi;

        public GroupComparator(Field fi) {
            this.fi = fi;
        }

        @Override
        public int compare(T arg0, T arg1) {
            try {
                int p0 = fi.getInt(arg0);
                int p1 = fi.getInt(arg1);
                return p0 - p1;
            } catch (IllegalArgumentException | IllegalAccessException | NullPointerException e) {
                return 0;
            }
        }
    }
}
