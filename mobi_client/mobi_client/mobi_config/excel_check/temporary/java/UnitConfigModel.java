package com.mobi.config.configModel;
import com.mobi.config.ConfigModel;
import com.mobi.config.wrappedArrayList.*;
public class UnitConfigModel extends ConfigModel {
	public String name;//名字
	public int appear;//是否显示
	public int gender;//性别(1男，2女，3妖怪)
	public ArrInt race;//种族（1:对位,2:亡语,3:AOE,4:融合,5:刺客）
	public ArrInt profession;//职业(1:输出，2:肉盾，3:辅助，4:治疗)
	public int energyLevel;//初始分级
	public ArrArrInt disintegrate;//同名卡牌分解粒子数量
	public ArrInt compose;//合成需要道具及数量
	public int particle;//每个碎片需要的微粒
	public int model_id;//战斗模型ID
	public ArrInt skills;//技能组
	public ArrInt initial_skills;//初始技能
	public ArrInt Skill_cycle;//技能循环顺序
	public int fusion_skill;//首次融合解锁技能
	public String drawing;//立绘
	public String icon;//头像
	public String picture;//卡牌图片
	public int level_max;//卡牌初始等级上限
	public ArrArrInt attribute_base;//基础属性
	public ArrArrInt attribute_trust;//信任属性
	public ArrArrFloat attribute_level;//升级系数
	public ArrArrFloat attribute_rare;//稀有度系数
	public String char_script;//战斗脚本
	public int scpRecord;//异质物档案（获得异质物时，该档案阶段数若为0，则+1）
	public int column4_part;//第4格子部位id（1攻击2防御3生命）
	public int column5_part;//第5格子部位id（1攻击2防御3生命）
	public int best_suit1;//推荐套装1(套装id)
	public int best_suit2;//推荐套装2(套装id)
}