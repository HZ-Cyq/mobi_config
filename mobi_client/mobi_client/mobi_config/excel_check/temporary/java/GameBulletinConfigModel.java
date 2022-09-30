package com.mobi.config.configModel;
import com.mobi.config.ConfigModel;
import com.mobi.config.wrappedArrayList.*;
public class GameBulletinConfigModel extends ConfigModel {
	public String title;//页签名称
	public String content;//正文（banner、标题、正文）
	public int type;//公告类型（0系统、1活动）
	public int priority;//优先级
	public String img;//活动图片
	public int jump;//跳转id
	public String startDate;//开始时间
	public String endDate;//结束时间
}