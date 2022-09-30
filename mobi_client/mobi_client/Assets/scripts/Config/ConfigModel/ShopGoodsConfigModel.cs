namespace ConfigSystem
{
﻿    public class ShopGoodsConfigModel :ConfigModel {
        public int goodsID;//道具ID
        public int amount;//数量
        public int group_shopid;//所属商店ID
        public int currencyType;//出售货币类型
        public int price;//价格
        public System.Collections.Generic.List<System.Collections.Generic.List<int>> discount;//折扣后价格及概率（折扣后价格;千分概率）
        public int stock;//库存（0表示无限）
        public int g_sort_order;//所在格子
        public int weight;//组内权重
        public System.Collections.Generic.List<System.Collections.Generic.List<int>> requirement;//刷新条件(类型 0-等级/2-完成任务：0-大于等于/1-小于等于：数值/任务ID）
        public System.Collections.Generic.List<string> tags;//显示标签（促销类）
    }
}