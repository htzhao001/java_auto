package com.htzhao.po.page;

import com.htzhao.CommonUtils.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TestPage extends BasePage {
    public WebElement keyInput() {
        WebElement ele = this.find(By.id("kw"));
        return ele;
    }

    public WebElement searchButton() {
        WebElement ele = this.find(By.id("su"));
        return ele;
    }
}
