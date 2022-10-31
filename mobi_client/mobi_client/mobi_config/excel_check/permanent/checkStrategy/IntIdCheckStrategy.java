package com.mobi.config.checkStrategy;


import com.mobi.config.ConfigModel;
import com.mobi.log.GameLog;

import java.util.*;
import java.util.stream.Collectors;


class IntIdCheckStrategy implements ICheckStrategy {
    @Override
    //"ID:Hero$Monster$NULL","int类型，并且值是Hero这张表的id或者Monster表的id或者是空",
    public boolean check(List<Object> list, String limitStateVale, ColumnInfo columnInfo) {
        String[] limitStateArray = limitStateVale.split("\\$");
        // 没有NULL
        Set<String> limitStateSet = Arrays.stream(limitStateArray).filter(ele -> !"Null".equals(ele)).collect(Collectors.toSet());
        boolean hasNull = limitStateSet.size() != limitStateArray.length;
        // list里存着Hero表和Monster表对应的map
        List<HashMap<Integer, ? extends ConfigModel>> dictList = new ArrayList<>();
        for (String limitStateVal : limitStateSet) {
            dictList.add(CheckStrategyService.findDict(limitStateVal));
        }
        boolean re = true;
        for (Object o : list) {
            // 如果有NULL并且o的值是0，不用继续检查
            if(hasNull && (o == null || (int)o == 0)) {
                continue;
            }
            if(dictList.stream().noneMatch(map -> map.containsKey(o))) {
                GameLog.LogError("IntIdCheckStrategy check error,{} , 元素：{}，limitStateVale:{}",columnInfo.toDesc(), o, limitStateVale);
                re = false;
            }
        }
        return re;
    }
}
