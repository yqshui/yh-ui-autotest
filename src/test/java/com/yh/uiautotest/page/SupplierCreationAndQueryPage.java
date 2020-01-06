package com.yh.uiautotest.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SupplierCreationAndQueryPage {

    WebDriver webDriver;

    WebElement findSourceManagement;

    WebElement addSupplier;

    public SupplierCreationAndQueryPage(WebDriver webDriver){
        this.webDriver=webDriver;
        findSourceManagement=webDriver.findElement(By.xpath("//*[@id=\"app\"]/section/header/div[2]/div[3]"));
        addSupplier=webDriver.findElement(By.xpath("//*[@id=\"global-layout\"]/div/div/div/section/div/button[3]"));
    }

    public void open(){
        webDriver.get("http://supply-test.yonghui.cn/");
    }

    public WebElement getFindSourceManagement() {
        return findSourceManagement;
    }

    public WebElement getAddSupplier() {
        return addSupplier;
    }

}
