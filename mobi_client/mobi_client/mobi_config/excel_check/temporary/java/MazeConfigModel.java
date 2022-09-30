package com.mobi.config.configModel;
import com.mobi.config.ConfigModel;
import com.mobi.config.wrappedArrayList.*;
public class MazeConfigModel extends ConfigModel {
	public String name;//名称
	public String scene;//属于场景
	public ArrInt openType;//开启类型
	public ArrInt openParam;//开启参数
	public String jsonName;//迷宫名字
	public ArrInt questId;//包含的支线id
	public ArrArrInt reward;//进度奖励
	public String resource;//相关资源路径
}