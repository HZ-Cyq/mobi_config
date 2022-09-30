namespace ConfigSystem
{
﻿    public class MazeConfigModel :ConfigModel {
        public string name;//名称
        public string scene;//属于场景
        public System.Collections.Generic.List<int> openType;//开启类型
        public System.Collections.Generic.List<int> openParam;//开启参数
        public string jsonName;//迷宫名字
        public System.Collections.Generic.List<int> questId;//包含的支线id
        public System.Collections.Generic.List<System.Collections.Generic.List<int>> reward;//进度奖励
        public string resource;//相关资源路径
    }
}