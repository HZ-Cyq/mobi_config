namespace ConfigSystem
{
﻿    public class PreDatingConfigModel :ConfigModel {
        public System.Collections.Generic.List<string> roleSelectSceneNames;//角色选的地点
        public System.Collections.Generic.List<string> roleAtLocalPointAvg;//角色在本地点avg
        public System.Collections.Generic.List<string> avgWithRoleSelectedScene;//角色选地点avg
        public System.Collections.Generic.List<string> msgWithRoleSelectedScene;//角色选地点短信内容
        public string avgWithPlayerSelectedScene;//让玩家选地点avg
        public string msgWithPlayerSelectedScene;//让玩家选地点短信内容
        public System.Collections.Generic.List<string> playerSelectSceneNames;//玩家选的地点
        public System.Collections.Generic.List<string> avgAfterPlayerSelectedScene;//对应avg
        public System.Collections.Generic.List<string> msgAfterPlayerSelectedScene;//对应短信内容
        public string avgWithInvitedDating;//被动约会邀请avg
        public string msgWithInvitedDating;//被动约会短信内容
    }
}