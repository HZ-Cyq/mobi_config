namespace ConfigSystem
{
﻿    public class DatingGiftConfigModel :ConfigModel {
        public System.Collections.Generic.List<int> veryLike;//非常喜欢的礼物
        public string veryLikeResponeAvg;//非常喜欢的回应avg
        public System.Collections.Generic.List<int> like;//喜欢的礼物
        public string LikeResponeAvg;//喜欢的回应avg
        public string normalResponeAvg;//一般的回应avg
        public System.Collections.Generic.List<int> dislike;//不喜欢的礼物
        public string dislikeResponeAvg;//不喜欢的回应avg
        public System.Collections.Generic.List<int> returnGift;//回礼道具id
        public System.Collections.Generic.List<int> giftCount;//回礼道具数量
        public System.Collections.Generic.List<int> giftWeight;//回礼道具权重
        public string giftAvg;//回礼avg
    }
}