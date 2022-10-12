namespace ConfigSystem
{
﻿    public class TopicConfigModel :ConfigModel {
        public int roleId;//联系角色
        public int passive;//是否是玩家发送
        public string name;//话题名称
        public int repeatCounts;//每天可重复选择次数
        public string topicScriptName;//短信内容
        public System.Collections.Generic.List<int> type;//激活条件类型
        public System.Collections.Generic.List<int> param;//条件参数
        public int delayType;//延迟类型
        public int delayParam;//延迟参数（S）
        public int priority;//队列优先级
        public int endTime;//判定为不回复时间（S）
        public int quest;//完成短信后获得的任务
        public int urgent;//是否紧急
        public string endScriptName;//长时间不回复的短信内容
    }
}