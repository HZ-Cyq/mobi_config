﻿public class Hero2ConfigModel : ConfigSystem.ConfigModel {
    public string name;//名字
    public string key_alias;//索引
    public int gender;//性别(1男，2女，3妖怪)
    public int model_id;//战斗模型ID
    public System.Collections.Generic.List<int> skills;//技能组
    public string drawing;//立绘
}