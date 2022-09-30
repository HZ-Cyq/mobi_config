public class SCPRecordConfigModel : ConfigSystem.ConfigModel {
    public string key_alias;//字符索引
    public int hide;//是否隐藏（不配和0为显示 1为隐藏）
    public int noTip;//是否隐藏初次获得时的tip(不配和0为不隐藏，1为隐藏)
    public string name;//角色姓名
    public string headIcon;//小头像（废弃）
    public string infoIcon;//详情图片（当没有配海报时读取）
    public string drawing;//异质物海报图
    public string serialNum;//角色编号
    public string quality;//等级
    public string date;//收容时间
    public string savingMeasures;//特殊收容措施
    public string describe;//描述
    public string warningText;//警告文本
    public System.Collections.Generic.List<int> defaultRecord;//默认开启情报
    public System.Collections.Generic.List<string> records;//情报列表
}