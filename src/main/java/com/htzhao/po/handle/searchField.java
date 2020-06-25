package com.htzhao.po.handle;

import com.htzhao.po.page.baiduPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class searchField {
    public static void searchTheField(WebDriver driver, String field) throws InterruptedException {
//        baiduPage baidu = new baiduPage();

        driver.findElement(baiduPage.searchInput).sendKeys("selenium");
        driver.findElement(baiduPage.searchButton).click();

        Thread.sleep(5000);
        driver.quit();
    }
}
