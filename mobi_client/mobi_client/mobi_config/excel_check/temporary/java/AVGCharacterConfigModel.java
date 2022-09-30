package com.mobi.config.configModel;
import com.mobi.config.ConfigModel;
import com.mobi.config.wrappedArrayList.*;
public class AVGCharacterConfigModel extends ConfigModel {
	public String key_alias;//别名
	public int gender;//性别
	public String name;//完整名
	public String nickname;//昵称
	public String prefab;//prefab名
	public String live2dPrefab;//live2dPrefab名
	public String headImageName;//头像图片名
	public int voiceImageIndex;//声音波形图片索引
	public ArrString cannotBlinkFaceIds;//不眨眼的faceId
	public int bodyOffY;//身高垫高尺寸cm(暂不用，直接配预制体)
	public String typeWriterVoice;//打字机声音文件
	public String folderName;//资源读取文件夹名
	public String folderkey;//资源读取关键字
	public float height;//身高(m)
	public String offset;//阴影的偏移(x,y,z)(不填没有偏移)
	public int factoryId;//组装ID
	public String defaultActionInScene;//场景内默认动作
}