public class Equip_levelupConfigModel : ConfigSystem.ConfigModel {
    public int level;//等级
    public int need_exp;//需要单级经验
    public int gold;//升级消耗货币量
    public int provide_exp;//被消耗时提供经验
    public System.Collections.Generic.List<System.Collections.Generic.List<int>> reback_item_info;//分解返还道具id、数量
}