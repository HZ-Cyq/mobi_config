namespace ConfigSystem
{
﻿    public class InteractionOptionConfigModel :ConfigModel {
        public int group_roleId;//角色id
        public int fieldId;//交流栏位
        public string optionDesc;//选项描述
        public int priority;//出现优先级
        public int isSingle;//是否一次性
        public int openCondition;//开启条件类型
        public int openParameter;//开启参数
        public string avgName;//主界面avg脚本
        public string avgGroup;//主界面组开始标记
        public string emptyDesc;//该栏位选项库为空时的显示文本
    }
}