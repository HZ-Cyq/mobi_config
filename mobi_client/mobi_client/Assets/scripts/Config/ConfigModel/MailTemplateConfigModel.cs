namespace ConfigSystem
{
﻿    public class MailTemplateConfigModel :ConfigModel {
        public string title;//标题
        public string sender;//发件人
        public string content;//正文
        public System.Collections.Generic.List<System.Collections.Generic.List<int>> attachment;//附件（动态邮件不需要附件）
    }
}