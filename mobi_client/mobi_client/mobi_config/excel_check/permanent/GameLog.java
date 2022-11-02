package com.mobi.log;


import cn.hutool.core.io.FileUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GameLog {
    private static final Logger logger = LoggerFactory.getLogger(GameLog.class);
    public static void LogInfo(String strLog, Object... args) {
        logger.info(strLog, args);
    }

    public static void LogError(String strLog, Object... args) {
        logger.error(strLog, args);
        String str = strLog;
        for (Object object : args) {
            // 如果object中有$符号，在compile的时候会报错.需要quoteReplacement
            String arg = Matcher.quoteReplacement(String.valueOf(object));
            str = Pattern.compile("{}", Pattern.LITERAL).matcher(
                    str).replaceFirst(arg);
        }
        str += "\n";
        File file = new File("error.log");
        FileUtil.appendString(str, file, StandardCharsets.UTF_8);
    }

    public static void LogException(String strLog, Object... args) {
        logger.error(strLog, args);
    }
}
