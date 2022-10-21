public class SkillConfigModel : ConfigSystem.ConfigModel {
    public string name;//技能名字
    public string skillIcon;//技能图标
    public System.Collections.Generic.List<int> TimelineGroup;//Timeline等级组
    public System.Collections.Generic.List<int> LogicTimelineGroup;//LogicTimeline等级组
    public int skillType;//技能类型(0普攻 1小技能 2终极技 3被动战斗开场前技能 4被动战斗开场后技能 5被动可触发技能 6队长光环7（装备套装技能）10没有timeline的假技能)
    public int isWave;//被动技能每波还是每场战斗触发：0每场 1:每波
    public System.Collections.Generic.List<int> subSkills;//子技能组
    public int cd;//技能cd(个人回合数)
    public int init_cd;//初始cd
    public int condition;//触发条件
    public int c1;//触参1
    public int c2;//触参2
    public System.Collections.Generic.List<System.Collections.Generic.List<int>> cx;//触参x
    public System.Collections.Generic.List<System.Collections.Generic.List<int>> cy;//触参y
    public int cost;//技能消耗
    public int selectableTargetGroup;//目标集合0无效果1,10-敌我单体2,12-敌我小队3,13-敌我全体4,14-释放者外小队(敌我换位)5，15-敌我相对前排6,16-敌我随机目标
    public int targetType;//选择目标类型
    public int targetParam;//选择目标参数
    public System.Collections.Generic.List<System.Collections.Generic.List<int>> preBattleBuffs;//开场释放buff组
    public System.Collections.Generic.List<System.Collections.Generic.List<int>> aura0;//光环0
    public System.Collections.Generic.List<System.Collections.Generic.List<int>> aura1;//光环1
    public System.Collections.Generic.List<System.Collections.Generic.List<int>> aura2;//光环2
    public System.Collections.Generic.List<string> description;//技能描述
    public System.Collections.Generic.List<System.Collections.Generic.List<string>> descparam;//技能描述数值  例： 200/10;100/50|30;2|  “200/10” 代表一个参数的基础数值和等级成长
}