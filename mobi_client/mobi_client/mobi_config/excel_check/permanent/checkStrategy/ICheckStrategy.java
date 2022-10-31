package com.mobi.config.checkStrategy;


import java.util.List;

interface ICheckStrategy {
    boolean check(List<Object> list, String limitStateUnitVal, ColumnInfo columnInfo);
}

