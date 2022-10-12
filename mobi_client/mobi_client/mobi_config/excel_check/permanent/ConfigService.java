package com.mobi.config;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import com.mobi.log.GameLog;

/**
 * 这个文件，mobi项目和表格解析项目不一样，因为mobi项目在解析表之后，会有一些后续的数据处理逻辑，这里不需要。
 */
public class ConfigService {

    public static boolean init(boolean check) {
        boolean initOk = ConfigManager.Init();
        boolean checkOk = !check || check();
        return initOk && checkOk;
    }

    public static boolean check() {
        // ConfigManager里所有Config类
        GameLog.LogInfo("开始根据LimitState检查表格文件");
        List<Field> modelFields = Arrays.stream(ConfigManager.class.getDeclaredFields()).filter(field -> Config.class.equals(field.getType())).collect(Collectors.toList());
        boolean result = true;
        for (Field modelField : modelFields) {
            try {
                Config<? extends ConfigModel> attribute = (Config<? extends ConfigModel>) modelField.get(null);
                Type genericType = modelField.getGenericType();
                Type actualTypeArgument = ((ParameterizedType) genericType).getActualTypeArguments()[0];
                if(!attribute.check((Class<? extends ConfigModel>) actualTypeArgument)) {
                    result = false;
                }
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }
        GameLog.LogInfo("根据LimitState检查表格文件结束，结果：" + result);
        return result;
    };
}
