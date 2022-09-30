package com.mobi.config.configModel;
import com.mobi.config.ConfigModel;
import com.mobi.config.wrappedArrayList.*;
public class TopicConfigModel extends ConfigModel {
	public int roleId;//联系角色
	public int passive;//是否是玩家发送
	public String name;//话题名称
	public int repeatCounts;//每天可重复选择次数
	public String topicScriptName;//短信内容
	public ArrInt type;//激活条件类型
	public ArrInt param;//条件参数
	public int delayType;//延迟类型
	public int delayParam;//延迟参数（S）
	public int priority;//队列优先级
	public int endTime;//判定为不回复时间（S）
	public int urgent;//是否紧急
	public String endScriptName;//长时间不回复的短信内容
}