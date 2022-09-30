package com.mobi.config.configModel;
import com.mobi.config.ConfigModel;
import com.mobi.config.wrappedArrayList.*;
public class StageConfigModel extends ConfigModel {
	public int monster_group_id;//怪组ID
	public String name;//名称
	public String subtitle;//副标题
	public String scene;//场景
	public String battle_anim_time;//开场动画延时（秒）
	public String scene_bgm;//场景背景音乐
	public int belong_area;//所属地点
	public ArrInt heros;//英雄库（临时）
	public ArrInt heroLocation;//队长站位
	public ArrInt cards;//牌库（临时）
	public int cardLevel;//我方等级（临时）
	public int cardStar;//我方星级（临时）
	public int cardSkillLevel;//技能等级（临时）
	public int cardSkillStep;//技能阶段（临时）
	public int cardResearch;//我方开发（临时）
	public ArrInt cardLocation;//卡牌站位
	public int type;//关卡类型
	public int layoutHideClose;//上阵界面隐藏返回
	public int layoutType;//上阵类型
	public int group;//关卡组
	public int round;//关卡最大回合数
	public int victory;//特殊胜利选项
	public int recommend_lv;//推荐等级
	public int team_lv;//开启职级
	public int stam_win;//胜利体力消耗
	public int stam_fail;//失败体力消耗
	public ArrArrInt ticket;//消耗道具
	public int pre_stage;//前置关卡
	public int unit_exp;//获胜经验
	public int favor;//获胜好感度
	public int trust;//获胜信任度
	public int drop;//获胜掉落
	public int first_drop;//首通额外掉落
	public ArrArrInt pt_first_drop;//首次达到指定pt额外掉落
	public int sweep_drop;//扫荡额外掉落
	public ArrInt sp_challenge;//特殊挑战
	public ArrInt base_challenge;//挑战
	public ArrArrInt pt_rewards;//得分奖励
	public int sweep_pt;//扫荡积分
	public String stage_icon;//关卡图片
	public String stage_draw;//关卡背景
	public String stage_enemy;//关卡敌人图片
	public String stage_boss;//特殊遮罩
	public String stage_des;//关卡描述
	public ArrString quest_key;//触发avg需要的子任务
	public String win_avg;//胜利后播放的AVG
	public String battle_layout_avg;//进入布阵播放的AVG
	public int auto_type;//战斗中自动显示状态
	public int hide_pause;//战斗中暂停显示模式
}