package com.mobi.config;


import com.mobi.config.checkStrategy.CheckStrategyService;
import com.mobi.config.checkStrategy.ColumnInfo;
import com.mobi.log.GameLog;

import java.io.File;
import java.lang.reflect.Field;
import java.util.*;
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
            String excelName;
            if(excelNameWithConfigModel.endsWith("Ex")) {
                // 这里的13是ConfigModelEx这个字符串的长度
                excelName = excelNameWithConfigModel.substring(0, excelNameWithConfigModel.length() - 13);
            } else {
                // 这里的11是ConfigModelEx这个字符串的长度
                excelName = excelNameWithConfigModel.substring(0, excelNameWithConfigModel.length() - 11);
            }
            GameLog.LogInfo("检查 {} 表格的配置", excelName);
            // limitStateMap:{"id":"LimitState","character_type":"IN:[1;2]","skills":"","hero_icon":"null"}
            for (Map.Entry<String, String> entry : limitStateMap.entrySet()) {
                if ("id".equals(entry.getKey()) || "null".equals(entry.getValue())) {
                    continue;
                }
                // 算出该限制语句对应的一列数据
                GameLog.LogInfo("列名:{}, LimitState:{}", entry.getKey(), entry.getValue());
                try {
                    ColumnInfo columnInfo = new ColumnInfo(configModelClazz.getName(), entry.getKey(), 0, 0);
                    boolean check = CheckStrategyService.check(entry.getValue(), columnInfo);
                    if(!check) {
                        re = false;
                    }
                } catch (RuntimeException exception) {
                    GameLog.LogError(exception.getMessage(), exception);
                    GameLog.LogError("表格数据未通过检查,页签名:{}, 列名:{}. limitState{}",excelName, entry.getKey(), entry.getValue());
                    re = false;
                }
            }
        } catch (Exception e) {
            re = false;
            GameLog.LogError(e.getMessage(), e);
        }
        return re;
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
