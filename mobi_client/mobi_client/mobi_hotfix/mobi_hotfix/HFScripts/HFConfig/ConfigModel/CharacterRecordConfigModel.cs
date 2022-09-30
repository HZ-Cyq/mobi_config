public class CharacterRecordConfigModel : ConfigSystem.ConfigModel {
    public string key_alias;//字符索引
    public string name;//角色姓名
    public string headIcon;//小头像
    public string infoIcon;//详情图片
    public string modelName;//模型名称
    public string drawing;//立绘
    public string serialNum;//角色编号
    public int gender;//性别 1男 2女
    public string birthday;//生日
    public int stature;//身高
    public string experience;//经历
    public System.Collections.Generic.List<int> defaultRecord;//默认开启情报
    public System.Collections.Generic.List<string> records;//情报
}