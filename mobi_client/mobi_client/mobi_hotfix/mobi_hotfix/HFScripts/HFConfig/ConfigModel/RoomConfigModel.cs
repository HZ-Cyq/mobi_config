public class RoomConfigModel : ConfigSystem.ConfigModel {
    public string key_alias;//关卡别名
    public int group_areaId;//所属区域id
    public int openLv;//开启等级
    public string name;//关卡名字
    public string scene_name;//默认场景名
    public string scene_bgm;//场景背景音乐
    public string bgm_volumeLevel;//场景背景音乐音量比例
    public int back_room;//返回roomid
    public string back_name;//返回按钮名称
    public System.Collections.Generic.List<int> openClues;//解锁所需线索
}