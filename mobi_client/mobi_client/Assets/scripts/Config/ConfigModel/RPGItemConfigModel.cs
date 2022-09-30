namespace ConfigSystem
{
﻿    public class RPGItemConfigModel :ConfigModel {
        public string key_alias;//别名
        public string name;//显示名
        public int group_quest;//隶属父任务
        public string desc;//描述
        public string icon;//图标
        public System.Collections.Generic.List<string> thumb;//缩略图路径
        public int type;//类型（0：线索，1：逻辑）
        public System.Collections.Generic.List<string> clues;//所带内容
        public int hide;//是否是隐藏线索 （0或者不填 为普通线索 1 为隐藏线索）
        public int hideTips;//获得时是否隐藏获得提示 0和默认为显示1为隐藏提示
        public int Updataid;//更新线索id
        public int isUpdata;//是否是更新线索
        public int clueType;//线索内容类型(0没有详情 1：图片 2：证物L3  3：音频)
        public System.Collections.Generic.List<string> texture;//详细图片
        public string evidence;//证物（Level3查看用）
        public string audio;//音频路径
        public int getType;//线索层级
    }
}