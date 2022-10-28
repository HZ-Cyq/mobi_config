namespace ConfigSystem
{
﻿    public class Group2ConfigModel :ConfigModel {
        public string name;//名字
        public int gender;//性别(1男，2女，3妖怪)
        public int model_id;//战斗模型ID
        public System.Collections.Generic.List<int> skills;//技能组
        public string drawing;//立绘
        public string icon;//头像
        public string char_script;//战斗脚本
        public int boss_type;//Boss类型0：非Boss1：Boss
    }
}