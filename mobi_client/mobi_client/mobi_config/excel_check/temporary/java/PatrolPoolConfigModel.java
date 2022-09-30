package com.mobi.config.configModel;
import com.mobi.config.ConfigModel;
import com.mobi.config.wrappedArrayList.*;
public class PatrolPoolConfigModel extends ConfigModel {
	public String key_alias;//别名
	public int nextPoolId;//下一个池子
	public ArrArrInt questIds;//任务属性（任务id;稀有度;权重）
	public int level;//开启条件-等级
	public ArrInt preTask;//开启条件-任务完成
	public int limitNum;//任务持有上限
	public int dailyRefresh;//每日免费刷新次数
	public int dailyIncr;//每日增加任务数
}