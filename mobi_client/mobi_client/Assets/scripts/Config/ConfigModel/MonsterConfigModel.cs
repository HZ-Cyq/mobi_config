namespace ConfigSystem
{
﻿    public class MonsterConfigModel :ConfigModel {
        public string name;//名字
        public int character_type;//类别
        public int gender;//性别(1男，2女，3妖怪)
        public System.Collections.Generic.List<int> profession;//职业(0：无职业，用于队长1:输出，2:肉盾，3:辅助，4:治疗)
        public System.Collections.Generic.List<int> race;//种族（1:对位,2:亡语,3:AOE,4:融合,5:刺客）
        public int model_id;//战斗模型ID
        public System.Collections.Generic.List<int> skills;//技能组
        public System.Collections.Generic.List<int> Skill_cycle;//技能循环顺序
        public string drawing;//立绘
        public string hero_icon;//头像
        public int dyeId;//染色id
        public System.Collections.Generic.List<System.Collections.Generic.List<int>> attribute_base;//基础属性
        public string char_script;//战斗脚本
        public int boss_type;//Boss类型0：非Boss1：Boss
    }
}