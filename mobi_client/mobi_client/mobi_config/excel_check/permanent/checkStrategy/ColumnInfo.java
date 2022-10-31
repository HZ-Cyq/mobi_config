package com.mobi.config.checkStrategy;

/**
 * 根据这个结构可以找到一列数据
 *
 */
public class ColumnInfo {
    /**
     * 页签名
     */
    private String className;
    /**
     * 字段名
     */
    private String fieldName;
    /**
     * 如果是二维的话，找到该列的第index（从1开始）位置的元素集合
     */
    private int index;
    /**
     * 如果是三维的话，找到第indexInMap行的第index位置的元素集合
     */
    private int indexInMap;

    /**
     * 如果是一维，但是需要返回指定数量的数组，添加repeatNum
     */
    private int repeatNum;

    public ColumnInfo(String className, String fieldName, int index, int indexInMap) {
        this.className = className;
        this.fieldName = fieldName;
        this.index = index;
        this.indexInMap = indexInMap;
    }

    public ColumnInfo(ColumnInfo columnInfo) {
        this.className = columnInfo.className;
        this.fieldName = columnInfo.fieldName;
        this.index = columnInfo.index;
        this.indexInMap = columnInfo.indexInMap;
    }

    public String toDesc() {
        String sheetName = CheckStrategyService.findSheetNameBySimpleClassName(className);
        return sheetName + "页签的" + fieldName + "列";
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public int getIndexInMap() {
        return indexInMap;
    }

    public void setIndexInMap(int indexInMap) {
        this.indexInMap = indexInMap;
    }

    public int getRepeatNum() {
        return repeatNum;
    }

    public void setRepeatNum(int repeatNum) {
        this.repeatNum = repeatNum;
    }
}
