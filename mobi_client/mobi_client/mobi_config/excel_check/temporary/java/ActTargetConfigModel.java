package com.mobi.config.configModel;
import com.mobi.config.ConfigModel;
import com.mobi.config.wrappedArrayList.*;
public class ActTargetConfigModel extends ConfigModel {
	public String desc;//描述
	public int group_actId;//父活动id
	public String name;//任务名称
	public int dayNum;//任务天数
	public ArrArrInt giftIdAndCount;//奖励Id
	public int conditionTimes;//达成次数
	public int taskId;//行为id
	public int conditionType;//达成条件
	public ArrInt conditionArgs;//达成参数
}