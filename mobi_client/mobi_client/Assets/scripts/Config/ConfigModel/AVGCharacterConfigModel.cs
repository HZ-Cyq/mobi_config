namespace ConfigSystem
{
﻿    public class AVGCharacterConfigModel :ConfigModel {
        public string key_alias;//别名
        public int gender;//性别
        public string name;//完整名
        public string nickname;//昵称
        public string prefab;//prefab名
        public string live2dPrefab;//live2dPrefab名
        public string headImageName;//头像图片名
        public int voiceImageIndex;//声音波形图片索引
        public System.Collections.Generic.List<string> cannotBlinkFaceIds;//不眨眼的faceId
        public int bodyOffY;//身高垫高尺寸cm(暂不用，直接配预制体)
        public string typeWriterVoice;//打字机声音文件
        public string folderName;//资源读取文件夹名
        public string folderkey;//资源读取关键字
        public float height;//身高(m)
        public string offset;//阴影的偏移(x,y,z)(不填没有偏移)
        public int factoryId;//组装ID
        public string defaultActionInScene;//场景内默认动作
    }
}