package com.mobi.config.configModel;
import com.mobi.config.ConfigModel;
import com.mobi.config.wrappedArrayList.*;
public class Equip_suitConfigModel extends ConfigModel {
	public String suit_icon;//套装icon
	public String suit_name;//套装名称
	public ArrInt suit2_effect;//2件套效果（数据类型（1是属性2是技能）|属性id）
	public ArrInt suit2_effect_value;//2件套属性值（若是属性配数值，若
	public String suit2_effect_desc;//2件套描述
	public ArrInt suit3_effect;//3件套效果（数据类型（1是属性2是技能）|id）
	public ArrInt suit3_effect_value;//3件套属性值
	public String suit3_effect_desc;//3件套描述
}