public class ItemConfigModel : ConfigSystem.ConfigModel {
    public string key_alias;//道具索引
    public string name;//道具名称
    public int group_Type;//道具类型（1-货币,2-道具,3-材料,4-礼物,5-物质,6-其他,7-装备,8-卡牌,9-小队成员）
    public int subtype;//道具小类
    public System.Collections.Generic.List<System.Collections.Generic.List<int>> data;//功能参数
    public string subtypeDes;//道具小类文本
    public int quality;//道具品质（1白、2绿、3蓝、4紫、5橙、6红）
    public int rank;//排序系数（数字越大越靠前；同数字，按照品质从大到小排序；同品质，按照id从大到小排序）
    public System.Collections.Generic.List<int> jump;//获取途径
    public string icon;//道具图标
    public string image;//道具图片
    public string describe;//道具描述
    public System.Collections.Generic.List<int> sell;//出售参数
    public System.Collections.Generic.List<System.Collections.Generic.List<int>> recover;//分解参数
    public int limit;//持有上限
    public int useLimit;//使用上限
}