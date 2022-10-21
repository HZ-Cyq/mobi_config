public class NPCConfigModel : ConfigSystem.ConfigModel {
    public string key_alias;//别名
    public string avg_alias;//avg模板别名/obj资源名
    public string showName;//AVG显示名
    public int npc_type;//npc类型0：标准型1：纯路人游荡npc2：obj
    public int obj_icon;//OBJ图标启用0：走NPC图标逻辑1：走固定图标配置
    public string icon_name;//图标名称
    public System.Collections.Generic.List<float> NPC_pos_offset;//NPC偏移
    public System.Collections.Generic.List<float> NPC_scale_offset;//NPC缩放
    public System.Collections.Generic.List<string> greetings;//箱庭-问候avg
    public System.Collections.Generic.List<string> scene;//对话框显示的场景名称
    public System.Collections.Generic.List<int> level;//对话框开启等级
    public System.Collections.Generic.List<int> preQuest;//对话框开启前置父任务（完成后显示）
    public System.Collections.Generic.List<int> postQuest;//对话框开启后置父任务（完成后消失）
    public System.Collections.Generic.List<System.Collections.Generic.List<string>> game_functions;//功能性(纯客户端)组对话框文本;对话框icon;功能类型Id;参数1;参数2
}