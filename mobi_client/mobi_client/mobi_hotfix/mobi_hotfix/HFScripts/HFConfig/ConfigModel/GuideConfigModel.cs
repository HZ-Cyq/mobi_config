public class GuideConfigModel : ConfigSystem.ConfigModel {
    public string key_trigger;//触发值
    public int trigger;//触发类型
    public int group;//组
    public int order;//组内引导步骤的顺序
    public int mandatory;//是否是强制引导
    public int action;//操作类型
    public float swaittime;//引导开始的等待时间
    public int attachactivation;//被激活组件属于哪里的
    public string activation;//被激活组件
    public string rectanglesize;//方块控件区域
    public int attachactivationdragend;//被激活组件属于哪里的
    public string dragend;//拖动目标控件
    public int keypoint;//是否是关键步骤
    public int effecttype;//特殊显示效果
    public int specialclose;//特殊关闭条件
    public int waitnet;//需要等待网络
    public int end;//引导是否结束
    public string playavg;//引导后播放AVG
    public string tips;//引导tips
    public string tipsoffpos;//引导tips偏移量
}