package com.mobi.config.configModel;
import com.mobi.config.ConfigModel;
import com.mobi.config.wrappedArrayList.*;
public class NPCConfigModel extends ConfigModel {
	public String key_alias;//别名
	public String avg_alias;//avg模板别名/obj资源名
	public String showName;//AVG显示名
	public int npc_type;//npc类型0：标准型1：纯路人游荡npc2：obj
	public String icon_name;//图标名称
	public ArrString greetings;//箱庭-问候avg
	public ArrString scene;//对话框显示的场景名称
	public ArrInt level;//对话框开启等级
	public ArrInt preQuest;//对话框开启前置主任务（完成后显示）
	public ArrInt postQuest;//对话框开启后置主任务（完成后消失）
	public ArrArrString game_functions;//功能性(纯客户端)组对话框文本;对话框icon;功能类型Id;参数1;参数2
}