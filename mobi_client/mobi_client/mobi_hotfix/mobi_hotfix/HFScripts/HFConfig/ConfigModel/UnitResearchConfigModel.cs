public class UnitResearchConfigModel : ConfigSystem.ConfigModel {
    public int group_cardId;//异质物id
    public int group_unitStagekey;//异质物阶段键
    public int stage;//研究阶段
    public string name;//阶段命名
    public int index;//格子序列
    public int cell;//格子id
    public int type;//格子类型
    public string content;//格子内容
    public int num;//激活格子数量
    public System.Collections.Generic.List<System.Collections.Generic.List<int>> item;//消耗道具
    public System.Collections.Generic.List<int> refresh;//重新随机消耗
}