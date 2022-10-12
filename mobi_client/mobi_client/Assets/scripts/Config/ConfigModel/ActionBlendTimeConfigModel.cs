namespace ConfigSystem
{
﻿    public class ActionBlendTimeConfigModel :ConfigModel {
        public string key_name;//查询关键字
        public string alias;//角色昵称
        public string clipA;//第一动画
        public string clipB;//第二动画
        public float blendTime;//融合时间
        public float blendOffset;//融合偏移
    }
}