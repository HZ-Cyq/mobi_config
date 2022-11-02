package com.mobi.config.checkStrategy;

import com.mobi.log.GameLog;

import java.util.List;

public class StringBetweenStrategy implements ICheckStrategy{

    @Override
    //"BETWEEN:[1;10]","Sting类型，并且值在1(包括)到10之间（包括）"
    public boolean check(List<Object> list, String limitStateUnitVal, ColumnInfo columnInfo) {
        String replace = limitStateUnitVal.replace("[", "").replace("]", "");
        String[] split = replace.split(";");
        int start = Integer.parseInt(split[0]);
        int end = Integer.parseInt(split[1]);
        boolean re = list.stream().allMatch(ele -> {
            int eleVal = Integer.parseInt((String) ele);
            return eleVal >= start && eleVal <= end;
        });
        if (!re) {
            GameLog.LogError("IntBetweenStrategy check error,{} , BETWEEN:{}, list:{}", columnInfo.toDesc(), limitStateUnitVal, list);
        }
        return re;
    }
}
