public class PatrolPoolConfigModel : ConfigSystem.ConfigModel {
    public string key_alias;//别名
    public int nextPoolId;//下一个池子
    public System.Collections.Generic.List<System.Collections.Generic.List<int>> questIds;//任务属性（任务id;稀有度;权重）
    public int level;//开启条件-等级
    public System.Collections.Generic.List<int> preTask;//开启条件-任务完成
    public int limitNum;//任务持有上限
    public int dailyRefresh;//每日免费刷新次数
    public int dailyIncr;//每日增加任务数
}