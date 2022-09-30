package com.mobi.config.configModel;
import com.mobi.config.ConfigModel;
import com.mobi.config.wrappedArrayList.*;
public class RoleTalentConfigModel extends ConfigModel {
	public int type;//类型
	public int param;//参数
	public ArrArrInt reward;//奖励
	public String pic;//图标
	public ArrInt preId;//前置天赋
	public int preNum;//前置数量
	public String title;//标题
	public String dec;//描述
	public ArrInt cost;//消耗道具及数量
}