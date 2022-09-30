public class TeamLevelConfigModel : ConfigSystem.ConfigModel {
    public string levelName;//主角职级
    public string picture;//职级图标
    public int prestige;//所需声望
    public int mainQuestId;//需要完成的任务id
    public int stageId;//需要完成的关卡id
    public System.Collections.Generic.List<string> desc;//晋升奖励文本
    public System.Collections.Generic.List<int> rewardItem;//升职道具奖励
    public System.Collections.Generic.List<int> rewardNum;//道具奖励对应数量
    public int maxStamina;//体力上限
    public int recoverStamina;//体力恢复
    public int receiveStamina;//领取体力值
}