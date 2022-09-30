package com.mobi.config.configModel;
import com.mobi.config.ConfigModel;
import com.mobi.config.wrappedArrayList.*;
public class ModelSkillConfigModel extends ConfigModel {
	public ArrInt skills;//技能
	public String model_qversion;//战斗prefab
	public String init_scale;//初始缩放比例
	public ArrString dead_audio;//死亡音效
	public ArrString onhit_audio1;//普通受击音效
	public ArrString onhit_audio2;//受重击音效
}