public class Equip_limitConfigModel : ConfigSystem.ConfigModel {
    public int level;//突破次数
    public int gold;//突破消耗货币量
    public System.Collections.Generic.List<System.Collections.Generic.List<int>> reback_item_info;//分解返还道具id、数量
}