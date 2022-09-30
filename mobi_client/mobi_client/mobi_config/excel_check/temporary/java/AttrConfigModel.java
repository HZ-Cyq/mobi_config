package com.mobi.config.configModel;
import com.mobi.config.ConfigModel;
import com.mobi.config.wrappedArrayList.*;
public class AttrConfigModel extends ConfigModel {
	public String attribute_ID_b;//英文名字（主要属性字段定义时使用）
	public String attribute_name_b;//属性中文名
	public int isPermillage;//是否千分比
	public int max_num;//最大值
	public int min_num;//最小值
	public int type;//属性类型
	public int affected;//受其他属性影响
	public String describe;//属性说明
	public int noInherit;//召唤不继承（0继承 1不继承）
}