namespace ConfigSystem
{
﻿    public class NPC_FactoryConfigModel :ConfigModel {
        public string key_alias;//昵称
        public System.Collections.Generic.List<System.Collections.Generic.List<float>> clothColor;//衣服色值
        public System.Collections.Generic.List<float> hairColor;//头发色值
        public System.Collections.Generic.List<float> hatColor;//帽子色值
        public System.Collections.Generic.List<float> glassesColor;//眼镜色值
        public string body;//身体
        public string hair;//头发
        public string hat;//帽子
        public string glasses;//眼镜
        public string left_shoulder_ornament;//左肩饰品
        public string right_shoulder_ornament;//右肩饰品
        public string chest_ornament;//胸饰品
    }
}