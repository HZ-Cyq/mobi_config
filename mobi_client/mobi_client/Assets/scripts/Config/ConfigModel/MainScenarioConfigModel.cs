namespace ConfigSystem
{
﻿    public class MainScenarioConfigModel :ConfigModel {
        public string scenarioname;//场景名称
        public int activerole;//可被点击的人物
        public System.Collections.Generic.List<string> showrolepre;//人物显示位置的prefab
        public System.Collections.Generic.List<int> showrolepreid;//位置上对应人物的ID
        public int defaultrole;//默认显示
        public int order;//序号
        public System.Collections.Generic.List<System.Collections.Generic.List<string>> animation;//待机动作
        public System.Collections.Generic.List<System.Collections.Generic.List<string>> Touchanim;//点击动作
        public System.Collections.Generic.List<System.Collections.Generic.List<string>> welcomeanim;//欢迎动作
    }
}