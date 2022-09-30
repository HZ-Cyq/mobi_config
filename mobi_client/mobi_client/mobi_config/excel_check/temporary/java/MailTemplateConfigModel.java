package com.mobi.config.configModel;
import com.mobi.config.ConfigModel;
import com.mobi.config.wrappedArrayList.*;
public class MailTemplateConfigModel extends ConfigModel {
	public String title;//标题
	public String sender;//发件人
	public String content;//正文
	public ArrArrInt attachment;//附件（动态邮件不需要附件）
}