namespace ConfigSystem
{
﻿    public class GlobalParamConfigModel :ConfigModel {
        public string key_variable;//键
        public string value;//变量值
        public string type;//变量类型
        public System.Collections.Generic.List<System.Collections.Generic.List<string>> multi_params;//复杂参数集
    }
}