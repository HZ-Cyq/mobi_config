public class GachaSwitchConfigModel : ConfigSystem.ConfigModel {
    public int group_gachaid;//所属卡池id
    public int g_sort_times;//未出3星次数
    public System.Collections.Generic.List<int> dropsId;//掉落id（分段0:小于等于标准3星次数；1:大于标准3星次数小于等于有钱人3星次数；2：大于有钱人3星次数）
}