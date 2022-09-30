public class ActTemplateConfigModel : ConfigSystem.ConfigModel {
    public int actId;//活动id
    public int isEnable;//是否开启
    public string desc;//描述
    public string name;//活动名字
    public int type;//类型
    public string startTime;//开启时间
    public string endTime;//关闭时间
    public string rewardTime;//领奖时间
    public System.Collections.Generic.List<int> argsInt;//额外参数
    public System.Collections.Generic.List<string> argsString;//额外参数2
}