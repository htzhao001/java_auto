package com.htzhao.PageTest;

import com.htzhao.po.page.TestPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class OldPageTest {
    TestPage page;

    @BeforeMethod
    public void openBrowser() {
        page = new TestPage();
        page.get("http://www.baidu.com/");
    }

    @Test
    public void testOld() throws InterruptedException {
        page.keyInput().sendKeys("selenium");
        page.searchButton().click();
        Assert.assertEquals(1, 1);
        Thread.sleep(5000);
    }

    @AfterMethod
    public void closeBrowser() {
        page.quit();
    }
}
