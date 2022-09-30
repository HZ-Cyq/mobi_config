package com.mobi.config.configModel;
import com.mobi.config.ConfigModel;
import com.mobi.config.wrappedArrayList.*;
public class MapAnimConfigModel extends ConfigModel {
	public int group_id;//动画组ID
	public int sub_quest_id;//条件子任务id
	public int type;//事件类型
	public String param;//参数
	public float callback_delay;//回调延迟时间
	public String remark;//备注
}