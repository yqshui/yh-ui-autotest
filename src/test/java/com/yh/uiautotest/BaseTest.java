package com.yh.uiautotest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class BaseTest {
    /**
     * 打开chrome
     */
    public WebDriver openChrome(){
        System.setProperty("webdriver.chrome.driver", "C:\\work\\code\\yh-ui-autotest\\src\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        return driver;
    }


    /**
     * 打开chrome
     */
    public void closeChrome(WebDriver driver, List<String> windows) {
        if(windows!=null){
            for (String window:windows) {
                driver.switchTo().window(window);
                driver.close();
            }
        }else {
            driver.close();
        }

    }

    public void closeChrome(WebDriver driver) {
                driver.close();
    }

}
