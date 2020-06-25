package com.htzhao.testcase;

import com.htzhao.po.handle.searchField;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class baiduSearchTest {
    private WebDriver dr;
    @BeforeMethod
    public void openBrowser(){
        dr = new ChromeDriver();
        dr.manage().window().maximize();
    }

    @Test
    public void searchTest() throws InterruptedException {
        searchField.searchTheField(dr, "selenium");
    }

    @AfterMethod
    public void quitBrowser(){
        dr.quit();
    }
}
