public class MazeEventConfigModel : ConfigSystem.ConfigModel {
    public int group_mazeId;//属于迷宫
    public int eventNum;//事件编号
    public int eventType;//事件类型
    public System.Collections.Generic.List<string> eventParam;//显示参数
    public System.Collections.Generic.List<int> logicParam;//逻辑参数
    public string roomName;//房间名字
    public string background;//房间图片
    public string icon;//小地图图标
    public string touch_icon;//交互图标
    public System.Collections.Generic.List<float> touch_icon_postion;//交互图标偏移
    public System.Collections.Generic.List<float> postion;//坐标
    public System.Collections.Generic.List<float> rotation;//朝向
    public System.Collections.Generic.List<int> preEvent;//前置事件id
    public System.Collections.Generic.List<string> avgName;//触发时avg
    public System.Collections.Generic.List<string> loseAvg;//失败avg
    public System.Collections.Generic.List<string> winAvg;//完成avg
}