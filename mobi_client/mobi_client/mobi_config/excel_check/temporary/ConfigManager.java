package com.mobi.config;
import com.mobi.config.configModel.*;
import com.mobi.config.modelParser.*;
import java.util.ArrayList;
import java.util.List;

public class ConfigManager
{
	public static final List<String> refreshConfigList = new ArrayList<>();
	public static Config<QuestRecordConfigModel> QuestRecordConfigModels = new Config<QuestRecordConfigModel>();
	public static Config<SubQuestConfigModel> SubQuestConfigModels = new Config<SubQuestConfigModel>();
	public static Config<QuestConfigModel> QuestConfigModels = new Config<QuestConfigModel>();
	public static Config<PatrolPoolConfigModel> PatrolPoolConfigModels = new Config<PatrolPoolConfigModel>();

	public static boolean Init()
	{
		boolean isOk = true;
		isOk = isOk && QuestRecordConfigModels.Init(QuestRecordConfigModel.class);
		isOk = isOk && SubQuestConfigModels.Init(SubQuestConfigModel.class);
		isOk = isOk && QuestConfigModels.Init(QuestConfigModel.class);
		isOk = isOk && PatrolPoolConfigModels.Init(PatrolPoolConfigModel.class);
		return isOk;
	}
}
