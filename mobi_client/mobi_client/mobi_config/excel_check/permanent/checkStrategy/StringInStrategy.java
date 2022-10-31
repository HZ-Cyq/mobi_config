package com.mobi.config.checkStrategy;


import com.mobi.log.GameLog;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class StringInStrategy implements ICheckStrategy {
    @Override
    // "IN:[男;女]", "String类型，并且值是 男、女 中的1个"
    public boolean check(List<Object> list, String limitStateUnitVal, ColumnInfo columnInfo) {
        String replace = limitStateUnitVal.replace("[", "").replace("]", "");
        Set<String> collect = Arrays.stream(replace.split(";")).collect(Collectors.toSet());
        boolean re = list.stream().allMatch(ele -> collect.contains((String) ele));
        if (!re) {
            GameLog.LogError("StringInStrategy check error,{} , IN:{}, list:{}", columnInfo.toDesc(), limitStateUnitVal, limitStateUnitVal);
        }
        return re;
    }
}
