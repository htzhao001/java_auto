package com.htzhao.driver;

import com.htzhao.CommonUtils.WriteLog;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.util.logging.Handler;

public class CommonDriver {

    public static WebDriver driver;

    public static WebDriver openBrowser(String browserName) {
        String path = System.getProperty("user.dir");

        if (browserName.equals("chrome")) {
            System.setProperty("webdriver.chrome.driver", path + "/drivers/chromedriver.exe");
            driver = new ChromeDriver();
        } else if (browserName.equals("firefox")) {
            System.setProperty("webdriver.ie.driver", path + "/drivers/iedriver.exe");
            driver = new FirefoxDriver();
        } else if (browserName.equals("ie")) {
            // 火狐不用设置路径，默认的
            driver = new InternetExplorerDriver();
        } else {
            System.out.println("传入浏览器名称" + browserName + "有误!请注意浏览器名均为小写。");
        }
        return driver;
    }

    public static void closeBrowser() {
        driver.close();
    }

    public void closeAllBrowser() {
        driver.quit();
    }
}
