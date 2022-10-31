package com.mobi.config.checkStrategy;


import com.mobi.log.GameLog;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class IntInStrategy implements ICheckStrategy {
    @Override
    //"IN:[1;2;3;4]", "int类型，并且值是1,2,3,4中的1个"
    public boolean check(List<Object> list, String limitStateUnitVal, ColumnInfo columnInfo) {
        String replace = limitStateUnitVal.replace("[", "").replace("]", "");
        Set<Integer> collect = Arrays.stream(replace.split(";")).map(Integer::parseInt).collect(Collectors.toSet());
        boolean re = list.stream().allMatch(ele -> collect.contains((int) ele));
        if (!re) {
            GameLog.LogError("IntInStrategy check error,{} , IN:{}, list:{}", columnInfo.toDesc(), limitStateUnitVal, list);
        }
        return re;
    }
}

