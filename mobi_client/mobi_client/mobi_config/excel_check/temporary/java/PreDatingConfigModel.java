package com.mobi.config.configModel;
import com.mobi.config.ConfigModel;
import com.mobi.config.wrappedArrayList.*;
public class PreDatingConfigModel extends ConfigModel {
	public ArrString roleSelectSceneNames;//角色选的地点
	public ArrString roleAtLocalPointAvg;//角色在本地点avg
	public ArrString avgWithRoleSelectedScene;//角色选地点avg
	public ArrString msgWithRoleSelectedScene;//角色选地点短信内容
	public String avgWithPlayerSelectedScene;//让玩家选地点avg
	public String msgWithPlayerSelectedScene;//让玩家选地点短信内容
	public ArrString playerSelectSceneNames;//玩家选的地点
	public ArrString avgAfterPlayerSelectedScene;//对应avg
	public ArrString msgAfterPlayerSelectedScene;//对应短信内容
	public String avgWithInvitedDating;//被动约会邀请avg
	public String msgWithInvitedDating;//被动约会短信内容
}