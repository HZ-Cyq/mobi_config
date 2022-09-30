package com.mobi.config.configModel;
import com.mobi.config.ConfigModel;
import com.mobi.config.wrappedArrayList.*;
public class DatingGiftConfigModel extends ConfigModel {
	public ArrInt veryLike;//非常喜欢的礼物
	public String veryLikeResponeAvg;//非常喜欢的回应avg
	public ArrInt like;//喜欢的礼物
	public String LikeResponeAvg;//喜欢的回应avg
	public String normalResponeAvg;//一般的回应avg
	public ArrInt dislike;//不喜欢的礼物
	public String dislikeResponeAvg;//不喜欢的回应avg
	public ArrInt returnGift;//回礼道具id
	public ArrInt giftCount;//回礼道具数量
	public ArrInt giftWeight;//回礼道具权重
	public String giftAvg;//回礼avg
}