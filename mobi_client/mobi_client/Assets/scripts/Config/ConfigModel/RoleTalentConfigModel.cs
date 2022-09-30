namespace ConfigSystem
{
﻿    public class RoleTalentConfigModel :ConfigModel {
        public int type;//类型
        public int param;//参数
        public System.Collections.Generic.List<System.Collections.Generic.List<int>> reward;//奖励
        public string pic;//图标
        public System.Collections.Generic.List<int> preId;//前置天赋
        public int preNum;//前置数量
        public string title;//标题
        public string dec;//描述
        public System.Collections.Generic.List<int> cost;//消耗道具及数量
    }
}