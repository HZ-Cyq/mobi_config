namespace ConfigSystem
{
﻿    public class MazeResourceConfigModel :ConfigModel {
        public int type;//类型
        public System.Collections.Generic.List<string> prefab;//对应的场景资源
        public string icon;//对应的小地图资源
        public int towards;//房间朝向
    }
}