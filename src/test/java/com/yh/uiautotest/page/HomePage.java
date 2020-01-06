package com.yh.uiautotest.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {

    WebDriver webDriver;

    WebElement findSourceManagement;

    public HomePage(WebDriver webDriver){
        this.webDriver=webDriver;
        findSourceManagement=webDriver.findElement(By.xpath("//*[@id=\"app\"]/section/header/div[2]/div[3]"));
    }


    public void open(){
        webDriver.get("http://supply-test.yonghui.cn/home");
    }

    public WebElement getFindSourceManagement() {
        return findSourceManagement;
    }
}
