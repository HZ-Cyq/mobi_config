package com.mobi.config.configModel;
import com.mobi.config.ConfigModel;
import com.mobi.config.wrappedArrayList.*;
public class SCPRecordConfigModel extends ConfigModel {
	public String key_alias;//字符索引
	public int hide;//是否隐藏（不配和0为显示 1为隐藏）
	public int noTip;//是否隐藏初次获得时的tip(不配和0为不隐藏，1为隐藏)
	public String name;//角色姓名
	public String headIcon;//小头像（废弃）
	public String infoIcon;//详情图片（当没有配海报时读取）
	public String drawing;//异质物海报图
	public String serialNum;//角色编号
	public String quality;//等级
	public String date;//收容时间
	public String savingMeasures;//特殊收容措施
	public String describe;//描述
	public String warningText;//警告文本
	public ArrInt defaultRecord;//默认开启情报
	public ArrString records;//情报列表
}