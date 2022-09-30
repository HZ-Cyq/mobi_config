package com.mobi.config.configModel;
import com.mobi.config.ConfigModel;
import com.mobi.config.wrappedArrayList.*;
public class GuideConfigModel extends ConfigModel {
	public String key_trigger;//触发值
	public int trigger;//触发类型
	public int group;//组
	public int order;//组内引导步骤的顺序
	public int mandatory;//是否是强制引导
	public int action;//操作类型
	public float swaittime;//引导开始的等待时间
	public int attachactivation;//被激活组件属于哪里的
	public String activation;//被激活组件
	public int attachactivationdragend;//被激活组件属于哪里的
	public String dragend;//拖动目标控件
	public int keypoint;//是否是关键步骤
	public int effecttype;//特殊显示效果
	public int specialclose;//特殊关闭条件
	public int waitnet;//需要等待网络
	public int end;//引导是否结束
	public String playavg;//引导后播放AVG
	public String tips;//引导tips
	public String tipsoffpos;//引导tips偏移量
}