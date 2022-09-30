public class RpgSceneConfigModel : ConfigSystem.ConfigModel {
    public int group_roomId;//roomId
    public int sceneLogicType;//场景类型0-普通 1-箱庭 2-迷宫
    public System.Collections.Generic.List<System.Collections.Generic.List<string>> default_npc;//槽位x;固定npc别名;前置任务Id(完成则出现);后置任务Id(完成则不出现)
    public string key_name;//可能出现的场景名
    public string scenePic;//场景图片
    public System.Collections.Generic.List<int> button;//左下角默认功能按钮
    public int dataLvLimit;//约会羁绊等级限制
    public string desc;//房间描述
}