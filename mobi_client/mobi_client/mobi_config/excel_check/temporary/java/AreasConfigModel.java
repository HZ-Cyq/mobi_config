package com.mobi.config.configModel;
import com.mobi.config.ConfigModel;
import com.mobi.config.wrappedArrayList.*;
public class AreasConfigModel extends ConfigModel {
	public String key_alias;//地点别名
	public String areaName;//地点名字
	public String areaIcon;//区域图标
	public String icon;//区域图片
	public String subMapName;//二级地图prefab名
	public int openLv;//解锁等级
	public int openQuest;//需完的任务
	public int type;//地点缩放显示
	public int areaType;//地点类型
	public int playType;//玩法类型
	public ArrInt stageId;//关卡id
	public int group_area;//大地图地点位置Id
	public String showRewardsTitle;//显示掉落标题文本
	public ArrInt showRewards;//显示掉落奖励
	public String desc;//区域描述
	public int entranceRoom;//入口room
}