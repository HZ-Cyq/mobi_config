package com.mobi.log;


import cn.hutool.core.io.FileUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.util.regex.Pattern;

public class GameLog {
    private static final Logger logger = LoggerFactory.getLogger(GameLog.class);
    public static void LogInfo(String strLog, Object... args) {
        logger.info(strLog, args);
    }

    public static void LogError(String strLog, Object... args) {
        logger.error(strLog, args);
        String str = strLog;
        if(args != null) {
            for (Object object : args) {
                str = Pattern.compile("{}", Pattern.LITERAL).matcher(
                        str).replaceFirst((String.valueOf(object)));
            }
        }
        str += "\n";
        File file = new File("error.log");
        FileUtil.appendString(str, file, StandardCharsets.UTF_8);
    }

    public static void LogException(String strLog, Object... args) {
        logger.error(strLog, args);
    }
}
