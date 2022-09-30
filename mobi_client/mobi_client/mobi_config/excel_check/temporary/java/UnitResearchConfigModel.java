package com.mobi.config.configModel;
import com.mobi.config.ConfigModel;
import com.mobi.config.wrappedArrayList.*;
public class UnitResearchConfigModel extends ConfigModel {
	public int group_cardId;//异质物id
	public int group_unitStagekey;//异质物阶段键
	public int stage;//研究阶段
	public String name;//阶段命名
	public int index;//格子序列
	public int cell;//格子id
	public int type;//格子类型
	public String content;//格子内容
	public int num;//激活格子数量
	public ArrArrInt item;//消耗道具
	public ArrInt refresh;//重新随机消耗
}