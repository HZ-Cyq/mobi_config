package com.mobi.config.configModel;
import com.mobi.config.ConfigModel;
import com.mobi.config.wrappedArrayList.*;
public class GachaScheduleConfigModel extends ConfigModel {
	public String name;//名称
	public String background;//背景图
	public int type;//卡池类型
	public ArrArrInt requirement;//存在条件(类型 0-等级/1-抽取次数/2-完成任务：0-大于等于/1-小于等于：数值/任务ID）
	public ArrInt inside;//卡池内容显示
	public ArrInt costOne;//单抽消耗
	public ArrInt amountType;//允许的抽卡次数
	public int group_count;//单独计数
	public int ticket;//抽卡券id
	public int unitUp;//up角色
	public String startDate;//开始时间
	public String endDate;//结束时间
	public int dailyLimit;//每日限次(单抽连抽共享）
	public int prizeRequire;//保底次数
	public ArrArrInt prizeReward;//保底奖励
}