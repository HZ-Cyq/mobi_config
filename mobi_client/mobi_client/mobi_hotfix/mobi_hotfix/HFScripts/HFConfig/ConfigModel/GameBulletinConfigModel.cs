public class GameBulletinConfigModel : ConfigSystem.ConfigModel {
    public string title;//页签名称
    public string content;//正文（banner、标题、正文）
    public int type;//公告类型（0系统、1活动）
    public int priority;//优先级
    public string img;//活动图片
    public int jump;//跳转id
    public string startDate;//开始时间
    public string endDate;//结束时间
}