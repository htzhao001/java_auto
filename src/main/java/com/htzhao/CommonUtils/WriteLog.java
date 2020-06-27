package com.htzhao.CommonUtils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.*;

public class WriteLog {
    //设置日期格式
    private static final String DATE_PATTERN = "yyyy-MM-dd HH:mm:SS";

    private static Logger log = null;

    public WriteLog(Class<?> T) {
        log = Logger.getLogger(String.valueOf(T));
        //设置日志级别
        log.setLevel(Level.FINER);
        try {
            ConsoleHandler consoleHandler = new ConsoleHandler();
            consoleHandler.setLevel(Level.INFO);
            log.addHandler(consoleHandler);

            String path = System.getProperty("user.dir");
            FileHandler fileHandler = new FileHandler(path + "\\logs\\logtest.log", true);
            //设置日志级别
            fileHandler.setLevel(Level.FINER);
            // 设置日志记录格式
            fileHandler.setFormatter(new Formatter() {
                @Override
                public String format(LogRecord record) {
                    return "[" + getCurrentDateStr(DATE_PATTERN)
                            + " - Level:" + record.getLevel() + " - "
                            + record.getLoggerName() + "] -> "
                            + record.getMessage() + "\r\n";
                }
            });

            // 将该日志添加
            log.addHandler(fileHandler);
            // 设置是否在控制台输出
            log.setUseParentHandlers(false);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 得到当前日期时间
     *
     * @param datePattern 日期格式
     * @return 日期字符串
     */
    private static String getCurrentDateStr(String datePattern) {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat(datePattern);
        return sdf.format(date);
    }

    /**
     * 记录异常
     *
     * @param e 抛出的异常信息
     */
    public void read(Exception e) {
        StringBuffer emsg = new StringBuffer();
        if (e != null) {
            StackTraceElement st = e.getStackTrace()[0];
            String exclass = st.getClassName();
            String method = st.getMethodName();
            int line = st.getLineNumber();

            emsg.append("[类：" + exclass + "]调用 " + method + " 时在第 " + line + " 行处发生异常！一场类型：" + e.toString() + "\r\n");
        }
        log.info(emsg.toString());
    }

    /**
     * 记录错误
     *
     * @param e 抛出的错误（断言）信息
     */
    public void readAssert(AssertionError e) {
        StringBuffer emsg = new StringBuffer();
        if (e != null) {
            StackTraceElement st = e.getStackTrace()[0];
            String exclass = st.getClassName();
            String method = st.getMethodName();
            int line = st.getLineNumber();

            emsg.append("[类：" + exclass + "]调用 " + method + " 时在第 " + line + " 行处发生错误！一场类型：" + e.toString() + "\r\n");
        }
        log.info(emsg.toString());
    }


    public void info(String str) {
        log.info(str);
    }

    public void fine(String str) {
        log.fine(str);
    }

    public void finer(String str) {
        log.finer(str);
    }

    public void finest(String str) {
        log.finest(str);
    }

    public void severe(String str) {
        log.severe(str);
    }

    public void warn(String str) {
        log.warning(str);
    }

    public void config(String str) {
        log.config(str);
    }
}
