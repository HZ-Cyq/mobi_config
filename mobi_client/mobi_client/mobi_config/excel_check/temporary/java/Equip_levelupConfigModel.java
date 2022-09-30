package com.mobi.config.configModel;
import com.mobi.config.ConfigModel;
import com.mobi.config.wrappedArrayList.*;
public class Equip_levelupConfigModel extends ConfigModel {
	public int level;//等级
	public int need_exp;//需要单级经验
	public int gold;//升级消耗货币量
	public int provide_exp;//被消耗时提供经验
	public ArrArrInt reback_item_info;//分解返还道具id、数量
}