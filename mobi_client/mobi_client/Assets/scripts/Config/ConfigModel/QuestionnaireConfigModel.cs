namespace ConfigSystem
{
﻿    public class QuestionnaireConfigModel :ConfigModel {
        public string name;//问卷名
        public int type;//解锁类型
        public int param;//解锁条件
        public int mailId;//邮件id
        public string website;//打开网站
        public int flagsId;//关联标示物
    }
}