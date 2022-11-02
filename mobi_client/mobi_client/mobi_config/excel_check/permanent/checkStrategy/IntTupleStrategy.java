package com.mobi.config.checkStrategy;


import com.mobi.log.GameLog;

import java.util.*;
import java.util.regex.Pattern;

import static com.mobi.config.checkStrategy.CheckStrategyService.check0;


class IntTupleStrategy implements ICheckStrategy {

    @Override
    // TUPLE:[type];[1:ID:Hero$Monster;2:ID:Monster;3:ID:MonsterGroup], int类型，当type字段的值是1的时候，当前的值是Hero或者Monster这张表的id
    public boolean check(List<Object> list, String limitStateVales, ColumnInfo columnInfo) {
        // type: type
        String type = limitStateVales.substring(0, limitStateVales.indexOf(";")).replace("[", "").replace("]", "");
        // valAndLimit: 1:ID:Hero$Monster;2:ID:Monster;3:ID:MonsterGroup
        String valAndLimit = limitStateVales.substring(limitStateVales.indexOf(";") + 1).replace("[", "").replace("]", "");
        // 这个是type的list,[1,2,2,3,3,4]
        List<Object> limitValList;
        ColumnInfo limitValColInfo;
        if (Pattern.matches("[0-9].*", type)) {
            limitValColInfo = new ColumnInfo(columnInfo.getClassName(), columnInfo.getFieldName(), Integer.parseInt(type), columnInfo.getIndexInMap());
        } else {
            limitValColInfo = new ColumnInfo(columnInfo.getClassName(), type,0, columnInfo.getIndexInMap());
            if (columnInfo.getIndex() != 0 || columnInfo.getIndexInMap() != 0) {
                limitValColInfo.setIndexInMap(columnInfo.getIndexInMap());
                limitValColInfo.setRepeatNum(list.size());
            }
        }
        limitValList = CheckStrategyService.findList(limitValColInfo);

        // FIXME 这里可以优化成group流处理吗？
        // 格式：{1:"Hero$Monster", 2:"Monster", 3:"MonsterGroup"}
        HashMap<Integer, String> limitMap = new HashMap<>();

        String[] split1 = valAndLimit.split(";");
        Arrays.stream(split1).forEach(ele -> {
            String typeStr = ele.substring(0, ele.indexOf(":"));
            limitMap.put(Integer.parseInt(typeStr), ele.substring(ele.indexOf(":") + 1));
        });

        // 添加一个检查，type列的值是limitMap的KeySet的,检查不通过，直接返回false,不进行后续的检查了。
        if(!limitMap.keySet().containsAll(limitValList)) {
            GameLog.LogError("IntTupleStrategy check error, 类型组合不是limitMap的子集, limitMap:{}, limitValList:{}", limitMap, limitValList);
            return false;
        }

        // 格式：{"ID:Hero":[1,2,3,4],"ID:Monster":[1,2,3,4]}
        HashMap<String, List<Object>> needCheckMap = new HashMap<>();
        for (int i = 0; i < limitValList.size(); i++) {
            String limitStateUnit = limitMap.get(limitValList.get(i));
            needCheckMap.putIfAbsent(limitStateUnit, new ArrayList<>());
            List<Object> objectList = needCheckMap.get(limitStateUnit);
            objectList.add(list.get(i));
        }
        boolean result = true;
        for (Map.Entry<String, List<Object>> entry : needCheckMap.entrySet()) {
            if (!CheckStrategyService.check0(entry.getValue(), entry.getKey(), columnInfo)) {
                result = false;
                // 这里的元素是该列里的元素子集，这些元素的type是key值。
                GameLog.LogError("IntTupleStrategy check error,{} , 元素：{}， limitStateVal:{}, limitStateVales:{}",
                        columnInfo.toDesc(), entry.getValue(), entry.getKey(), limitStateVales);
            }
        }
        return result;
    }
}
