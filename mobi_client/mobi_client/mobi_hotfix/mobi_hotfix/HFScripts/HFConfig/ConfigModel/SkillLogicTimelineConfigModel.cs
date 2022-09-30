public class SkillLogicTimelineConfigModel : ConfigSystem.ConfigModel {
    public int group_nodes;//timeline组
    public int frame;//帧号(30/s)
    public System.Collections.Generic.List<int> step;//所属阶段
    public int targetSelector;//目标重选
    public int targetSelectorParam;//目标重选参数
    public int condition;//触发条件
    public int c1;//触参1
    public int c2;//触参2
    public System.Collections.Generic.List<int> cx;//触参x
    public System.Collections.Generic.List<int> cy;//触参y
    public int floatId;//触发飘字id
    public int actionType;//行为类型
    public int a1;//行参1
    public int a2;//行参2
    public int a3;//行参3
    public int a4;//行参4
    public int a5;//行参5
    public int levelUp;//等级成长系数
}