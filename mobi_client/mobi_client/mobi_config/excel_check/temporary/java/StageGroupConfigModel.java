package com.mobi.config.configModel;
import com.mobi.config.ConfigModel;
import com.mobi.config.wrappedArrayList.*;
public class StageGroupConfigModel extends ConfigModel {
	public int group_type;//章节类型
	public String scene_name;//属于场景
	public ArrInt pre_group;//前置章节
	public String name;//章节名称
	public int open_level;//开启职级
	public ArrInt stage_id;//拥有关卡id
	public ArrArrInt target_reward;//目标奖励
}