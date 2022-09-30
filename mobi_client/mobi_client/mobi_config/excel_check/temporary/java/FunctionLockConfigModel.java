package com.mobi.config.configModel;
import com.mobi.config.ConfigModel;
import com.mobi.config.wrappedArrayList.*;
public class FunctionLockConfigModel extends ConfigModel {
	public String key_function;//对应的功能模块
	public String annotation;//注释
	public int group;//同一组标识
	public String uiname;//ui界面
	public int into;//强制进入
	public int conditions;//开启条件
	public int conditionsValue;//开启条件对应的值
	public int showType;//满足条件显示状态
	public String icon;//展示icon
	public String describe;//描述
	public String jump;//跳转
	public int window;//是否弹窗
}