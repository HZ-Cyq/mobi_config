public class FunctionLockConfigModel : ConfigSystem.ConfigModel {
    public string key_function;//对应的功能模块
    public string annotation;//注释
    public int group;//同一组标识
    public string uiname;//ui界面
    public int into;//强制进入
    public int conditions;//开启条件
    public int conditionsValue;//开启条件对应的值
    public int showType;//满足条件显示状态
    public string icon;//展示icon
    public string describe;//描述
    public string jump;//跳转
    public int window;//是否弹窗
}