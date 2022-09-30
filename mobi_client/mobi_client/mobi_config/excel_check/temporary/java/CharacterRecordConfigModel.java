package com.mobi.config.configModel;
import com.mobi.config.ConfigModel;
import com.mobi.config.wrappedArrayList.*;
public class CharacterRecordConfigModel extends ConfigModel {
	public String key_alias;//字符索引
	public String name;//角色姓名
	public String headIcon;//小头像
	public String infoIcon;//详情图片
	public String modelName;//模型名称
	public String drawing;//立绘
	public String serialNum;//角色编号
	public int gender;//性别 1男 2女
	public String birthday;//生日
	public int stature;//身高
	public String experience;//经历
	public ArrInt defaultRecord;//默认开启情报
	public ArrString records;//情报
}