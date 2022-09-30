namespace ConfigSystem
{
﻿    public class RoleConfigModel :ConfigModel {
        public string name;//名字
        public int appear;//是否显示
        public string alias;//别名
        public string english;//英文名称
        public string nickname;//讯息昵称
        public string icon;//头像
        public string modelName;//模型名称
        public string drawing;//立绘
        public int fight;//加入战斗需要的羁绊等级
        public int heroid;//对应的heroid
        public int recordid;//对应的档案id
        public string site1;//看板位置1
        public string site2;//看板位置2
        public System.Collections.Generic.List<string> standbyAct;//主界面待机动作
        public string leisureAct;//主界面休闲动作
        public System.Collections.Generic.List<System.Collections.Generic.List<string>> leisureTalk;//主界面休闲对话
        public string interactAct;//主界面互动动作
        public System.Collections.Generic.List<System.Collections.Generic.List<string>> interactTalk;//主界面互动对话
        public System.Collections.Generic.List<string> talkAvg;//交流avg
    }
}