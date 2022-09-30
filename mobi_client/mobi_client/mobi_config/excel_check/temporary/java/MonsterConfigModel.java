package com.mobi.config.configModel;
import com.mobi.config.ConfigModel;
import com.mobi.config.wrappedArrayList.*;
public class MonsterConfigModel extends ConfigModel {
	public String name;//名字
	public int character_type;//类别
	public int gender;//性别(1男，2女，3妖怪)
	public ArrInt profession;//职业(0：无职业，用于队长1:输出，2:肉盾，3:辅助，4:治疗)
	public ArrInt race;//种族（1:对位,2:亡语,3:AOE,4:融合,5:刺客）
	public int model_id;//战斗模型ID
	public ArrInt skills;//技能组
	public ArrInt Skill_cycle;//技能循环顺序
	public String drawing;//立绘
	public String hero_icon;//头像
	public int dyeId;//染色id
	public ArrArrInt attribute_base;//基础属性
	public String char_script;//战斗脚本
	public int boss_type;//Boss类型0：非Boss1：Boss
}