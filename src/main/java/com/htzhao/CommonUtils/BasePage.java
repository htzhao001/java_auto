package com.htzhao.CommonUtils;

import com.htzhao.driver.CommonDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    WebDriver driver;
    static WriteLog log = new WriteLog(BasePage.class);

    public BasePage() {
        this.driver = CommonDriver.openBrowser("chrome");
        log.info("成功打开浏览器 : Chrome");
    }

    public BasePage(String browserName) {
        this.driver = CommonDriver.openBrowser(browserName);
        log.info("成功打开浏览器 : "+browserName);
    }

    public WebElement find(By by) {
        WebElement ele = null;
        try {
            WebDriverWait wait = new WebDriverWait(this.driver, 30);
            wait.until(ExpectedConditions.presenceOfElementLocated(by));
            ele = this.driver.findElement(by);
            log.info("元素 "+ele.getText()+"成功找到！");
            return ele;
        } catch (Exception e) {
            log.warn("元素" + by + "查找超时！");
            e.printStackTrace();
        }
        return ele;
    }

    public void click(By by) {
        this.find(by).click();
        log.info("元素 "+this.find(by).getText()+" 被成功点击");
    }

    public void quit() {
        this.driver.quit();
        log.info("浏览器退出！");
    }

    public void get(String url) {
        this.driver.get(url);
        log.info("成功访问： "+url);
    }
}
