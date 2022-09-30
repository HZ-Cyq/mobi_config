namespace ConfigSystem
{
﻿    public class StageChallengeConfigModel :ConfigModel {
        public int type;//类型
        public System.Collections.Generic.List<int> param;//条件参数
        public int point;//得分
        public string description;//条件描述
    }
}