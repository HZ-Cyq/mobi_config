package com.mobi.config.configModel;
import com.mobi.config.ConfigModel;
import com.mobi.config.wrappedArrayList.*;
public class MazeEventConfigModel extends ConfigModel {
	public int group_mazeId;//属于迷宫
	public int eventNum;//事件编号
	public int eventType;//事件类型
	public ArrString eventParam;//显示参数
	public ArrInt logicParam;//逻辑参数
	public String roomName;//房间名字
	public String background;//房间图片
	public String icon;//小地图图标
	public String touch_icon;//交互图标
	public ArrFloat touch_icon_postion;//交互图标偏移
	public ArrFloat postion;//坐标
	public ArrFloat rotation;//朝向
	public ArrInt preEvent;//前置事件id
	public ArrString avgName;//触发时avg
	public ArrString loseAvg;//失败avg
	public ArrString winAvg;//完成avg
}