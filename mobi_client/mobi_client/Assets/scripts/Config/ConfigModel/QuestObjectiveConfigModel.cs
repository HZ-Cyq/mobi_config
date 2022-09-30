namespace ConfigSystem
{
﻿    public class QuestObjectiveConfigModel :ConfigModel {
        public int group_questId;//所属父任务
        public System.Collections.Generic.List<int> objectiveGroup;//并联集完成本条目标后，发放一个任务群，任务群都完成后，才执行下一步任务。
        public System.Collections.Generic.List<int> nextObjective;//下一步任务（可填多个任务，但只能完成一个）
        public System.Collections.Generic.List<System.Collections.Generic.List<string>> publisherOperations;//NPC控制(rpgscene名字;npcavg模板别名;控制参数;)控制参数：-1为清npc，1为加npc，0为清理操作
        public int minLv;//可完成条件最小等级
        public int preQuest;//可完成条件前置任务
        public int favorLevel;//（未实现）完成所需发布员好感度等级
        public int publisherType;//发布员类型0:无1：NPC2：obj（物品）3：迷宫
        public System.Collections.Generic.List<string> rpgSceneGroup;//发布员(npc)所在地点scene集合(配合后面参数使用)
        public string publisherAlias;//该子任务发布员别名(npc-avg模板别名 obj-gameobjectName)
        public string optionBoxText;//选项框文字
        public System.Collections.Generic.List<string> keyAvgs;//avgsheet|条件满足对话label|条件不满足label|后续对话label
        public int targetNum;//目标值
        public int eventTaskDefine;//事件类型
        public string s0;//字符串参数0
        public string s1;//字符串参数1
        public int p2;//参数1
        public int p3;//参数2
        public int p4;//参数3
    }
}