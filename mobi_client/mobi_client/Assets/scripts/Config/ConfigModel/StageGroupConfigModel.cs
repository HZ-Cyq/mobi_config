namespace ConfigSystem
{
﻿    public class StageGroupConfigModel :ConfigModel {
        public int group_type;//章节类型
        public string scene_name;//属于场景
        public System.Collections.Generic.List<int> pre_group;//前置章节
        public string name;//章节名称
        public int open_level;//开启职级
        public System.Collections.Generic.List<int> stage_id;//拥有关卡id
        public System.Collections.Generic.List<System.Collections.Generic.List<int>> target_reward;//目标奖励
    }
}