namespace ConfigSystem
{
﻿    public class BuffTypeConfigModel :ConfigModel {
        public string buffTypeAlias;//别名
        public string name;//说明
        public string effectPath;//特效预制体路径
        public string bindPoint;//特效预制体绑定位置
        public int animID;//动作ID
        public int animPriority;//动作优先级（越大越高）
        public int silenceNormalSkill;//是否无法释放普攻
        public int silenceSpecialSkill;//是否无法释放大招
        public int silentUltimateSkill;//是否无法释放终极技
        public int cannotBeSelectedAsTarget;//是否无法被敌选为目标
        public int clearBuffOnHurt;//是否受伤buff消失
        public int noEnergyGained;//无法获取个人怒气
        public int reserved;//备用
    }
}