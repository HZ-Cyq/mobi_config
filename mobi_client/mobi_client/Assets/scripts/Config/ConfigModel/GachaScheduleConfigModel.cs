namespace ConfigSystem
{
﻿    public class GachaScheduleConfigModel :ConfigModel {
        public string name;//名称
        public string background;//背景图
        public int type;//卡池类型
        public System.Collections.Generic.List<System.Collections.Generic.List<int>> requirement;//存在条件(类型 0-等级/1-抽取次数/2-完成任务：0-大于等于/1-小于等于：数值/任务ID）
        public System.Collections.Generic.List<int> inside;//卡池内容显示
        public System.Collections.Generic.List<int> costOne;//单抽消耗
        public System.Collections.Generic.List<int> amountType;//允许的抽卡次数
        public int group_count;//单独计数
        public int ticket;//抽卡券id
        public int unitUp;//up角色
        public string startDate;//开始时间
        public string endDate;//结束时间
        public int dailyLimit;//每日限次(单抽连抽共享）
        public int prizeRequire;//保底次数
        public System.Collections.Generic.List<System.Collections.Generic.List<int>> prizeReward;//保底奖励
    }
}