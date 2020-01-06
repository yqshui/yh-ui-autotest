package com.yh.uiautotest.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

    WebDriver webDriver;

    public LoginPage(WebDriver webDriver){
        this.webDriver=webDriver;
    }


    public void open(){
        webDriver.manage().window().maximize();
        webDriver.get("http://supply-test.yonghui.cn/");
    }

    public void login(String userName,String password) throws Exception{
        WebElement userNameInput=webDriver.findElement(By.xpath("//*[@id=\"app\"]/div/div/form/div/div[2]/div[1]/input"));
        userNameInput.sendKeys(userName);
        WebElement userPasswordInput=webDriver.findElement(By.xpath("//*[@id=\"app\"]/div/div/form/div/div[2]/div[2]/input"));
        userPasswordInput.sendKeys(password);
        WebElement loginButton=webDriver.findElement(By.xpath("//*[@id=\"app\"]/div/div/form/div/div[3]/button"));
        loginButton.click();
    }

}
