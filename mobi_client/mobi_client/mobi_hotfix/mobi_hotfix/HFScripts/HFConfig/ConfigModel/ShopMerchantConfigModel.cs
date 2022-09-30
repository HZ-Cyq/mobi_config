public class ShopMerchantConfigModel : ConfigSystem.ConfigModel {
    public int type;//商店类型（0静态，1动态）
    public System.Collections.Generic.List<string> autoRefreshTime;//自然刷新时间
    public System.Collections.Generic.List<int> cycleRefreshTime;//周期刷新时间(0:周期天，从开启日期开始算，1每月起始天，2每周起始天）
    public int refreshLimit;//手动刷新上限
    public System.Collections.Generic.List<System.Collections.Generic.List<int>> refreshCost;//手动刷新消耗（货币：金额）
    public System.Collections.Generic.List<System.Collections.Generic.List<int>> storage;//上架物品栏位条件
    public System.Collections.Generic.List<int> costShow;//资源栏
    public int order;//显示排序
    public string name;//商店名
    public string icon;//商店图标
    public System.Collections.Generic.List<System.Collections.Generic.List<int>> requirement;//开启条件(类型 0-等级/2-完成任务：0-大于等于/1-小于等于：数值/任务ID）
    public string startDate;//开启日期
    public string endDate;//关闭日期
}