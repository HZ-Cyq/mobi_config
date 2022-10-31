package com.mobi.config.checkStrategy;

import com.mobi.log.GameLog;

public enum CheckStrategyEnum {
    //"ID:Hero","int类型，并且值是Hero这张表的id",
    INT_ID(Integer.class,"ID", new IntIdCheckStrategy()),
    // TUPLE:[[type],[1:ID:Hero,2:ID:Monster,3:ID:MonsterGroup]]
    INT_TUPLE(Integer.class, "TUPLE", new IntTupleStrategy()),
    //"BETWEEN:[1;10]","int类型，并且值在1(包括)到10之间（包括）"
    INT_BETWEEN(Integer.class, "BETWEEN", new IntBetweenStrategy()),
    //"IN:[1;2;3;4]", "int类型，并且值是1,2,3,4中的1个"
    INT_IN(Integer.class, "IN", new IntInStrategy()),
    // "IN:[男;女]", "String类型，并且值是 男、女 中的1个"
    STRING_IN(String.class, "IN", new StringInStrategy()),

    STRING_KEY_ALIAS(String.class, "KEY_ALIAS", new StringKeyAliasStrategy()),
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

    public final ICheckStrategy checkStrategy;
    private final Class<?> clazz;
    private final String limitStateKey;
};




