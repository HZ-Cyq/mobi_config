package com.mobi.config.configModel;
import com.mobi.config.ConfigModel;
import com.mobi.config.wrappedArrayList.*;
public class VSCourtConfigModel extends ConfigModel {
	public String avgScriptName;//avg脚本名字
	public String ownSideRoleAlias;//己方角色昵称
	public String otherSideRoleAlias;//对方角色昵称
	public ArrInt playerHPParts;//玩家舌战值分量
	public ArrInt roleHPParts;//角色舌战值分量
	public int group_id;//组id
	public String courtName;//推理名字
	public String courtDesc;//推理描述
	public int courtpart;//推理阶段
	public ArrString responeGroup;//回应组
	public ArrString responeLabel;//回应AVG标记
	public String correctRespone;//正确回应
	public String clueQuestion;//出示线索问题
	public ArrString clueGroup;//线索组
	public ArrString clueLabel;//线索标签
	public int correctClueId;//正确线索
	public ArrString dialogGroup;//对话组
	public ArrString dialogLabel;//对话标签
	public String correctDialog;//正确对话
	public String avgOnFinished;//结束跳入的AVG
	public String avgLabelOnFinished;//结束跳入的AVG标签
	public String startShowVideo;//开场动画视频（测试功能）
	public String winShowVideo;//胜利动画视频（测试功能）
}