public class ModelSkillConfigModel : ConfigSystem.ConfigModel {
    public System.Collections.Generic.List<int> skills;//技能
    public string model_qversion;//战斗prefab
    public string init_scale;//初始缩放比例
    public System.Collections.Generic.List<string> dead_audio;//死亡音效
    public System.Collections.Generic.List<string> onhit_audio1;//普通受击音效
    public System.Collections.Generic.List<string> onhit_audio2;//受重击音效
}