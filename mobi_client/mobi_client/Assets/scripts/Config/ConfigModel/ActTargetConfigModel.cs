namespace ConfigSystem
{
﻿    public class ActTargetConfigModel :ConfigModel {
        public string desc;//描述
        public int group_actId;//父活动id
        public string name;//任务名称
        public int dayNum;//任务天数
        public System.Collections.Generic.List<System.Collections.Generic.List<int>> giftIdAndCount;//奖励Id
        public int conditionTimes;//达成次数
        public int taskId;//行为id
        public int conditionType;//达成条件
        public System.Collections.Generic.List<int> conditionArgs;//达成参数
    }
}