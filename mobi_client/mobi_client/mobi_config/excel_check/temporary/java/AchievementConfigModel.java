package com.mobi.config.configModel;
import com.mobi.config.ConfigModel;
import com.mobi.config.wrappedArrayList.*;
public class AchievementConfigModel extends ConfigModel {
	public int group_objType;//成就类型
	public int objParam;//目标值
	public ArrArrInt objRewards;//阶段奖励
	public int mode;//成就模式(0:累计数值，1：达到指定值）
	public int showType;//界面类型（0：成就，1：待定义）
}