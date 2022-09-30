public class FavorConfigModel : ConfigSystem.ConfigModel {
    public int friendliness;//需要的好感度
    public System.Collections.Generic.List<int> reward;//获得的道具
    public int type;//关系程度
    public int meetingPlaceChance;//随机约会地点概率(千分比)
    public int giftChance;//收到礼物概率(千分比)
}