package com.yh.uiautotest.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SupplierAddPage {

    WebDriver webDriver;

    WebElement labelInput;

    WebElement tagCodeSelect;

    WebElement purchaseOrganizationInput;

    WebElement hOrganizationSelect;

    WebElement addInfoTab;

    WebElement freshSupplierLabelCodeInput;

    List<WebElement> freshSupplierLabelCodeInputSelect;

    WebElement signedPurchaseNotice;

    WebElement signedPurchaseInput;

    WebElement managerNotice;


    public SupplierAddPage(WebDriver webDriver){
        this.webDriver=webDriver;
        labelInput=webDriver.findElement(By.xpath("//*[@id=\"tagCode\"]/div/div/div"));
        addInfoTab=webDriver.findElement(By.xpath("//*[@id=\"global-layout\"]/div[1]/div/div/form/div/div/div/div[1]/div[2]/div/div/div/div[1]/div[2]"));
        purchaseOrganizationInput=webDriver.findElement(By.xpath("//*[@id=\"purchaseGroupCodes\"]/div/div/div"));
        freshSupplierLabelCodeInput=webDriver.findElement(By.xpath("//*[@id=\"freshSupplierLabelCode\"]"));
        signedPurchaseNotice=webDriver.findElement(By.cssSelector("label[for='signedPurchase']"));
        managerNotice=webDriver.findElement(By.cssSelector("label[for='manager']"));
        signedPurchaseInput=webDriver.findElement(By.id("signedPurchase"));
    }

    public void open(){
        webDriver.get("http://supply-test.yonghui.cn/supplierCenter/supplierAdd");
    }

    public WebElement getLabelInput() {
        return labelInput;
    }

    public WebElement getTagCodeSelect() {
        return tagCodeSelect;
    }

    public WebElement getPurchaseOrganizationInput() {
        return purchaseOrganizationInput;
    }

    public WebElement gethOrganizationSelect() {
        return hOrganizationSelect;
    }

    public WebElement getSignedPurchaseInput() {
        return signedPurchaseInput;
    }

    public WebElement getAddInfoTab() {
        return addInfoTab;
    }

    public WebElement getFreshSupplierLabelCodeInput() {
        return freshSupplierLabelCodeInput;
    }

    public List<WebElement> getFreshSupplierLabelCodeInputSelect() {
        return freshSupplierLabelCodeInputSelect;
    }

    public WebElement getSignedPurchaseNotice() {
        return signedPurchaseNotice;
    }

    public WebElement getManagerNotice() {
        return managerNotice;
    }

    public void initTagCodeSelect(int type) {
        switch (type) {
            //云超平台
            case 1:this.tagCodeSelect = webDriver.findElement(By.xpath("//*[@id=\"test-uuid\"]/ul/li[1]"));break;
            //云超战区
            case 2:this.tagCodeSelect = webDriver.findElement(By.xpath("//*[@id=\"test-uuid\"]/ul/li[2]"));break;
            //云创
            case 3:this.tagCodeSelect = webDriver.findElement(By.xpath("//*[@id=\"test-uuid\"]/ul/li[3]"));break;
            //彩食鲜
            case 4:this.tagCodeSelect = webDriver.findElement(By.xpath("//*[@id=\"test-uuid\"]/ul/li[4]"));break;
            //云超PB
            case 5:this.tagCodeSelect = webDriver.findElement(By.xpath("//*[@id=\"test-uuid\"]/ul/li[5]"));break;
        }
    }

    public void inithOrganizationSelect(char type) {
        switch (type) {
            case 'H':this.hOrganizationSelect=webDriver.findElement(By.xpath("//*[@id=\"test-uuid\"]/ul/li[24]"));break;
            case 'U':this.hOrganizationSelect=webDriver.findElement(By.xpath("//*[@id=\"test-uuid\"]/ul/li[54]"));break;
            case 'A':this.hOrganizationSelect=webDriver.findElement(By.xpath("//*[@id=\"test-uuid\"]/ul/li[13]"));break;
            case 'P':this.hOrganizationSelect=webDriver.findElement(By.xpath("//*[@id=\"test-uuid\"]/ul/li[43]"));break;
            //这个O代表的是10
            case 'O':this.hOrganizationSelect=webDriver.findElement(By.xpath("//*[@id=\"test-uuid\"]/ul/li[10]"));break;

        }

    }

    public void initFreshSupplierLabelCodeInputSelect() {
        this.freshSupplierLabelCodeInputSelect = webDriver.findElements(By.cssSelector("div[class='ant-select-dropdown ant-select-dropdown--single ant-select-dropdown-placement-bottomLeft']>div>ul>li"));
    }
}
