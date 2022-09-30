public class AreasConfigModel : ConfigSystem.ConfigModel {
    public string key_alias;//地点别名
    public string areaName;//地点名字
    public string areaIcon;//区域图标
    public string icon;//区域图片
    public string subMapName;//二级地图prefab名
    public int openLv;//解锁等级
    public int openQuest;//需完的任务
    public int type;//地点缩放显示
    public int areaType;//地点类型
    public int playType;//玩法类型
    public System.Collections.Generic.List<int> stageId;//关卡id
    public int group_area;//大地图地点位置Id
    public string showRewardsTitle;//显示掉落标题文本
    public System.Collections.Generic.List<int> showRewards;//显示掉落奖励
    public string desc;//区域描述
    public int entranceRoom;//入口room
}