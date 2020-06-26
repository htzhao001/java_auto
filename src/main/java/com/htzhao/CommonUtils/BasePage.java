package com.htzhao.CommonUtils;

import com.htzhao.driver.CommonDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    WebDriver driver;

    public BasePage() {
        this.driver = CommonDriver.openBrowser("chrome");
    }

    public BasePage(String browserName) {
        this.driver = CommonDriver.openBrowser(browserName);
    }

    public WebElement find(By by) {
        WebElement ele = null;
        try {
            WebDriverWait wait = new WebDriverWait(this.driver, 30);
            wait.until(ExpectedConditions.presenceOfElementLocated(by));
            return this.driver.findElement(by);
        } catch (Exception e) {
            System.out.println("元素" + by + "查找超时！");
            e.printStackTrace();
        }
//        WebElement ele = driver.findElement(by);
        return ele;
    }

    public void click(By by) {
        this.find(by).click();
    }

    public void quit() {
        this.driver.quit();
    }

    public void get(String url) {
        this.driver.get(url);
    }
}
