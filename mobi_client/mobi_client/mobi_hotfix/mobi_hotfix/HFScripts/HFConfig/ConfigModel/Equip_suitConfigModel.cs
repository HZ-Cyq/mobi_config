public class Equip_suitConfigModel : ConfigSystem.ConfigModel {
    public string suit_icon;//套装icon
    public string suit_name;//套装名称
    public System.Collections.Generic.List<int> suit2_effect;//2件套效果（数据类型（1是属性2是技能）|属性id）
    public System.Collections.Generic.List<int> suit2_effect_value;//2件套属性值（若是属性配数值，若
    public string suit2_effect_desc;//2件套描述
    public System.Collections.Generic.List<int> suit3_effect;//3件套效果（数据类型（1是属性2是技能）|id）
    public System.Collections.Generic.List<int> suit3_effect_value;//3件套属性值
    public string suit3_effect_desc;//3件套描述
}