package com.htzhao.LogTest;

import com.htzhao.CommonUtils.GetLogConf;
import com.htzhao.CommonUtils.WriteLog;
import org.testng.annotations.Test;

public class LogTest {
//    final static GetLogConf log = GetLogConf.getLoggerConfig(LogTest.class);
    WriteLog log1 = new WriteLog(LogTest.class);


    @Test
    public void testLog(){
        log1.info("this is info11 log");
        log1.severe("this is severe log");
        log1.warn("this is warn log");
        log1.config("this is config log");
        log1.fine("this is fine log");
        log1.finer("this is finer log");
    }
}
