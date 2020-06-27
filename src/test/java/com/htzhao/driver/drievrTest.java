package com.htzhao.driver;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.htzhao.driver.CommonDriver;

public class drievrTest {

    @Test
    public void openTest() throws InterruptedException {
        WebDriver driver = CommonDriver.openBrowser("chrome");
        driver.get("http://www.baidu.com/");
        Thread.sleep(5000);
        CommonDriver.closeBrowser();
    }
}
