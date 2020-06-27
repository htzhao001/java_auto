package com.htzhao.CommonUtils;

import org.apache.log4j.PropertyConfigurator;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Logger;


/**
 * 较早版本的使用log4j.jar方式来写日志,此工程内不适用
 */
public class GetLogConf {
    private static Logger logger = null;
    private static GetLogConf logg = null;

    public static GetLogConf getLoggerConfig(Class<?> T) {
        if (logger == null) {
            // 实例化properties类，处理properties格式文件
            Properties prop = new Properties();
            try {
                String path = System.getProperty("user.dir");
                String filepath = path + "\\conf\\log4j.properties";
                InputStream is = new FileInputStream(filepath);
                prop.load(is);
                PropertyConfigurator.configure(prop);
                logger = Logger.getLogger(String.valueOf(T));
                logg = new GetLogConf();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return logg;
    }

    // 信息
    public void info(String msg) {
        logger.info(msg);
    }

    // 信息，但更详细
    public void config(String msg) {
        logger.config(msg);
    }

    // debug信息
    public void fine(String msg) {
        logger.fine(msg);
    }

    // debug信息，但更详细
    public void finer(String msg) {
        logger.finer(msg);
    }

    // 严重
    public void severe(String msg) {
        logger.severe(msg);
    }

    // 警告
    public void warn(String msg) {
        logger.warning(msg);
    }
}
