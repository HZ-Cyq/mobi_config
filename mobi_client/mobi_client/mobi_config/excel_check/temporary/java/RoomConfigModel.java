package com.mobi.config.configModel;
import com.mobi.config.ConfigModel;
import com.mobi.config.wrappedArrayList.*;
public class RoomConfigModel extends ConfigModel {
	public String key_alias;//关卡别名
	public int group_areaId;//所属区域id
	public int openLv;//开启等级
	public String name;//关卡名字
	public String scene_name;//默认场景名
	public String scene_bgm;//场景背景音乐
	public String bgm_volumeLevel;//场景背景音乐音量比例
	public int back_room;//返回roomid
	public String back_name;//返回按钮名称
	public ArrInt openClues;//解锁所需线索
}