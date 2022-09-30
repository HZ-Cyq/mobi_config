package com.mobi.config.configModel;
import com.mobi.config.ConfigModel;
import com.mobi.config.wrappedArrayList.*;
public class RoleConfigModel extends ConfigModel {
	public String name;//名字
	public int appear;//是否显示
	public String alias;//别名
	public String english;//英文名称
	public String nickname;//讯息昵称
	public String icon;//头像
	public String modelName;//模型名称
	public String drawing;//立绘
	public int fight;//加入战斗需要的羁绊等级
	public int heroid;//对应的heroid
	public int recordid;//对应的档案id
	public String site1;//看板位置1
	public String site2;//看板位置2
	public ArrString standbyAct;//主界面待机动作
	public String leisureAct;//主界面休闲动作
	public ArrArrString leisureTalk;//主界面休闲对话
	public String interactAct;//主界面互动动作
	public ArrArrString interactTalk;//主界面互动对话
	public ArrString talkAvg;//交流avg
}