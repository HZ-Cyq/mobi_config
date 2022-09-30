namespace ConfigSystem
{
﻿    public class BuffConfigModel :ConfigModel {
        public string buffName;//buff名称
        public string icon;//图标
        public string effectPath;//特效预制体名
        public string bindPoint;//特效预制体绑定点
        public int activeDeltaRound;//延时激活(回合)
        public int lifeRounds;//生命长度(回合)0为技能buff
        public int srcBinding;//与释放者是否生死绑定(0或者不填为生死绑定 1 为不绑定）
        public int destroyingTiming;//销毁结算时刻0-个人回合结束 1-大回合结束
        public int attitude;//buff:1正面，0中性，-1负面
        public System.Collections.Generic.List<int> subBuffs;//子buff集
        public int buffGroupId;//buff组号
        public int buffMaxNumberByGroup;//组最大叠加层数
        public int buffPriority;//组内优先级
        public int isSingleTrigger;//相同pidbuff只触发一个
        public System.Collections.Generic.List<System.Collections.Generic.List<int>> deathTimings;//销毁时机
        public System.Collections.Generic.List<System.Collections.Generic.List<int>> triggerTiming;//触发时机
        public int condition;//触发条件
        public int c1;//触参1
        public int c2;//触参2
        public System.Collections.Generic.List<int> cx;//触参x
        public System.Collections.Generic.List<int> cy;//触参y
        public int maxTriggerTimes;//最大触发次数
        public int actionNumPerTrigger;//触发时连续触发次数(不填默认1次)
        public int buffType;//buff类型
        public int buffTypeValueAttrFactor;//buffType值属性影响因子
        public int buffTypeValueAttrPercent;//buffType值属性影响百分比
        public int buffTypeValueFixed;//buffType固定值
        public int buffTypeValueLevelUP;//buffType等级成长值（千分比）
        public System.Collections.Generic.List<System.Collections.Generic.List<int>> attrs;//改变属性
        public System.Collections.Generic.List<int> attrleveup;//改变属性等级成长
        public System.Collections.Generic.List<int> skillCycle;//替换原有普通技能循环
        public int targetSelector;//触发行为目标重选
        public int targetSelectorParam;//目标重选参数
        public int floatId;//触发飘字id
        public int animId;//触发时角色播放动作id
        public int actionId;//触发的行为类型
        public int a1;//行参1
        public int a2;//行参2
        public int a3;//行参3
        public int a4;//行参4
        public int a5;//行参5
        public int levelUp;//等级成长系数
    }
}