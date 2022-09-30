package com.mobi.config.configModel;
import com.mobi.config.ConfigModel;
import com.mobi.config.wrappedArrayList.*;
public class SubQuestConfigModel extends ConfigModel {
	public String key_alias;//别名
	public String name;//任务名
	public int group_parentQuest;//所属父任务
	public int lastQuest;//是否为最后任务
	public String desc;//任务描述(详细)
	public String PanelDesc;//任务面板描述（简短）
	public ArrInt targetRoomIds;//任务所在二级场景
	public int hide;//是否是隐藏任务（0或者不填 为普通任务 1 为隐藏任务）
	public int hideUI;//是否在UI显示（0或者不填 显示 1 不显示）
	public ArrArrString roomScene;//room对应的场景
	public ArrString activeAreas;//任务开始时强制开启的Area
	public ArrString inactiveAreas;//任务开始时强制关闭的Area
	public ArrString activeRooms;//任务开始时强制开启的Rooms
	public ArrString inactiveRooms;//任务开始时强制关闭的Rooms
	public int canData;//能否进行约会
	public ArrInt Awards;//完成奖励
	public ArrString itemReq;//任务所需线索
	public int ifMainQuest;//主界面检测任务
	public String mainPicture;//显示图片
	public int valueMax;//任务数值上限
	public String conditionDesc;//任务完成条件描述
	public ArrArrString actorActive;//物体状态 (场景名;actorName,active;actorName,active|场景名;actorName,active;actorName,active...)
	public ArrInt clues;//逻辑
	public ArrInt delClues;//删除的逻辑
	public int g_sort_id;//子任务排序
	public int award;//奖励
}