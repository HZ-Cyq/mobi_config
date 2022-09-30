package com.mobi.config.configModel;
import com.mobi.config.ConfigModel;
import com.mobi.config.wrappedArrayList.*;
public class ActTemplateConfigModel extends ConfigModel {
	public int actId;//活动id
	public int isEnable;//是否开启
	public String desc;//描述
	public String name;//活动名字
	public int type;//类型
	public String startTime;//开启时间
	public String endTime;//关闭时间
	public String rewardTime;//领奖时间
	public ArrInt argsInt;//额外参数
	public ArrString argsString;//额外参数2
}