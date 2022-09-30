package com.mobi.config.configModel;
import com.mobi.config.ConfigModel;
import com.mobi.config.wrappedArrayList.*;
public class MainScenarioConfigModel extends ConfigModel {
	public String scenarioname;//场景名称
	public int activerole;//可被点击的人物
	public ArrString showrolepre;//人物显示位置的prefab
	public ArrInt showrolepreid;//位置上对应人物的ID
	public int defaultrole;//默认显示
	public int order;//序号
	public ArrArrString animation;//待机动作
	public ArrArrString Touchanim;//点击动作
	public ArrArrString welcomeanim;//欢迎动作
}