namespace ConfigSystem
{
﻿    public class VSCourtConfigModel :ConfigModel {
        public string avgScriptName;//avg脚本名字
        public string ownSideRoleAlias;//己方角色昵称
        public string otherSideRoleAlias;//对方角色昵称
        public System.Collections.Generic.List<int> playerHPParts;//玩家舌战值分量
        public System.Collections.Generic.List<int> roleHPParts;//角色舌战值分量
        public int group_id;//组id
        public string courtName;//推理名字
        public string courtDesc;//推理描述
        public int courtpart;//推理阶段
        public System.Collections.Generic.List<string> responeGroup;//回应组
        public System.Collections.Generic.List<string> responeLabel;//回应AVG标记
        public string correctRespone;//正确回应
        public string clueQuestion;//出示线索问题
        public System.Collections.Generic.List<string> clueGroup;//线索组
        public System.Collections.Generic.List<string> clueLabel;//线索标签
        public int correctClueId;//正确线索
        public System.Collections.Generic.List<string> dialogGroup;//对话组
        public System.Collections.Generic.List<string> dialogLabel;//对话标签
        public string correctDialog;//正确对话
        public string avgOnFinished;//结束跳入的AVG
        public string avgLabelOnFinished;//结束跳入的AVG标签
        public string startShowVideo;//开场动画视频（测试功能）
        public string winShowVideo;//胜利动画视频（测试功能）
    }
}