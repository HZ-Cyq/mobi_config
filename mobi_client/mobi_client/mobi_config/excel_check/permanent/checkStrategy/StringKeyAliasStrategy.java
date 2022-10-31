package com.mobi.config.checkStrategy;


import com.mobi.config.ConfigModel;
import com.mobi.log.GameLog;

import java.util.*;
import java.util.stream.Collectors;

import static com.mobi.config.checkStrategy.CheckStrategyService.findSDict;

class StringKeyAliasStrategy implements ICheckStrategy {
    @Override
    //"KEY_ALIAS:Hero$Monster$NULL","String类型，并且值是Hero这张表的id或者Monster表的key_alias或者是空",
    public boolean check(List<Object> list, String limitStateVales, ColumnInfo columnInfo) {
        String[] limitStateArray = limitStateVales.split("\\$");
        // 没有NULL
        Set<String> limitStateSet = Arrays.stream(limitStateArray).filter(ele -> !"NULL".equals(ele)).collect(Collectors.toSet());
        boolean hasNull = limitStateSet.size() != limitStateArray.length;
        // list里存着Hero表和Monster表对应的map
        List<HashMap<String, ? extends ConfigModel>> dictList = new ArrayList<>();
        for (String limitStateVal : limitStateSet) {
            dictList.add(findSDict(limitStateVal));
        }
        boolean re = true;
        for (Object o : list) {
            // 如果有NULL并且o的值是0，不用继续检查
            if (hasNull && (o == null || "".equals(o))) {
                continue;
            }
            if (dictList.stream().noneMatch(map -> map.containsKey(o))) {
                GameLog.LogError("StringKeyAliasCheckStrategy check error,{} , 元素：{}， list:{}, limitStateVales:{}", columnInfo.toDesc(), o, list, limitStateVales);
                re = false;
            }
        }
        return re;
    }
}
