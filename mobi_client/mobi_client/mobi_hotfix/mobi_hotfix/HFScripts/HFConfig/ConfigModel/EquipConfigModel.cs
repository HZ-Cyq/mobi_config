public class EquipConfigModel : ConfigSystem.ConfigModel {
    public string name;//装备名称
    public int suit_id;//套装id
    public int part;//部位（1攻击2防御3生命）
    public int rare;//稀有度
    public int max_level;//初始等级上限
    public int maxlevel_limit_up_num;//突破次数上限
    public int limit_level_up_num;//单次突破增加等级上限
    public int base_attribute_type;//基础属性id
    public int base_attribute_num;//基础属性数值
    public int base_attribute_levelup;//升级增加基础属性数值
    public int need_exp_extra;//升级增加货币量系数千分之几
    public System.Collections.Generic.List<int> random_attribute_list;//随机属性（当前版本固定）
    public System.Collections.Generic.List<int> random_attribute_num;//随机属性数值（当前版本固定）
    public System.Collections.Generic.List<int> random_attribute_weight;//随机属性获得权重(属性顺序；千分之几）
    public int provide_exp;//升级消耗提供经验值
}