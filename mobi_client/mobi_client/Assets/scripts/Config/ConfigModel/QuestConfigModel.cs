namespace ConfigSystem
{
﻿    public class QuestConfigModel :ConfigModel {
        public string key_alias;//别名
        public string name;//任务名
        public int type;//任务类型1=主线任务 2=支线任务 3=巡逻任务
        public int patrolType;//巡逻任务类型1=战斗任务 2=思考任务 3=寻物任务
        public int wayOfGetting;//获取方式0-正常1-自动获取2-紧急视频
        public int level;//开放等级
        public int preQuest;//前置任务id
        public int isXT;//是否箱庭任务
        public System.Collections.Generic.List<int> favorLvReq;//所需小队成员好感度
        public int vis_lv;//可见性-角色等级
        public System.Collections.Generic.List<int> vis_preQuests;//可见性-前置任务集
        public System.Collections.Generic.List<int> vis_favorReq;//可见性-目标好感度等级
        public System.Collections.Generic.List<string> npc_publisher;//发布员所在场景和对话scene|NPC任务发布员|对话框文本|任务发布avgSheet|条件满足label|条件不满足label
        public System.Collections.Generic.List<System.Collections.Generic.List<string>> npc_greetings;//处在任务过程中，npc问候控制|场景名;npc别名;AVGSheet;avgLabel名
        public int urgentPriority;//紧急任务优先级
        public string urgentRole;//紧急任务角色
        public string urgentBg;//紧急任务背景
        public string urgentAvg;//紧急任务avg
        public string desc;//任务描述
        public System.Collections.Generic.List<string> questScene;//下属场景（影响存档）
        public System.Collections.Generic.List<System.Collections.Generic.List<string>> roomScene;//room对应的场景
        public System.Collections.Generic.List<string> activeAreas;//任务开始时强制开启的Area
        public System.Collections.Generic.List<string> inactiveAreas;//任务开始时强制关闭的Area
        public System.Collections.Generic.List<string> activeRooms;//任务开始时强制开启的Rooms
        public System.Collections.Generic.List<string> inactiveRooms;//任务开始时强制关闭的Rooms
        public int awards;//完成奖励
        public System.Collections.Generic.List<string> awardCompleteDesc;//任务完成后弹出面板的内容
    }
}