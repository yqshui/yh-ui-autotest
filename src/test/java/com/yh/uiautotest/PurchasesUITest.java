package com.yh.uiautotest;

import com.yh.uiautotest.page.HomePage;
import com.yh.uiautotest.page.LoginPage;
import com.yh.uiautotest.page.SupplierAddPage;
import com.yh.uiautotest.page.SupplierCreationAndQueryPage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.ArrayList;
import java.util.List;

public class PurchasesUITest extends BaseTest {

    WebDriver webDriver;
    List<String> windows;

    @BeforeMethod
    public void setup(){
        webDriver=openChrome();
    }

    @Test(description = "云超平台->H*->可选1-4->必填->必填")
    public void test1(){
        try {
            //打开登录页，并且登录
            LoginPage loginPage = new LoginPage(webDriver);
            loginPage.open();
            loginPage.login("80936682", "Aa123456");
            //标签选云超平台
            SupplierAddPage supplierAddPage = initSupplierAddPage(1);
            // 采购组选H
            supplierAddPage.getPurchaseOrganizationInput().click();
            supplierAddPage.inithOrganizationSelect('H');
            ((JavascriptExecutor) webDriver).executeScript("arguments[0].click();", supplierAddPage.gethOrganizationSelect());
            //点击生鲜供应商标签，判断只有1到4
            supplierAddPage.getFreshSupplierLabelCodeInput().click();
            Thread.sleep(1000);
            supplierAddPage.initFreshSupplierLabelCodeInputSelect();
            Assert.assertEquals(supplierAddPage.getFreshSupplierLabelCodeInputSelect().size(), 4);
            Assert.assertEquals(supplierAddPage.getFreshSupplierLabelCodeInputSelect().get(0).getText(), "01 产地代办/生产商直供");
            Assert.assertEquals(supplierAddPage.getFreshSupplierLabelCodeInputSelect().get(1).getText(), "02 产地合作/生产商合作");
            Assert.assertEquals(supplierAddPage.getFreshSupplierLabelCodeInputSelect().get(2).getText(), "03 合作项目");
            Assert.assertEquals(supplierAddPage.getFreshSupplierLabelCodeInputSelect().get(3).getText(), "04 全球贸（进口）");
            //判断，签约采购人，管理者必填
            String signedPurchaseNotice = supplierAddPage.getSignedPurchaseNotice().getAttribute("class");
            Assert.assertEquals(signedPurchaseNotice, "ant-form-item-required ant-form-item-no-colon");
            String managerNotice = supplierAddPage.getManagerNotice().getAttribute("class");
            Assert.assertEquals(managerNotice, "ant-form-item-required ant-form-item-no-colon");
        }catch (Exception ex){
            Assert.assertTrue(false,ex.getMessage());
        }
    }

    @Test(description = "云超平台->U*->可选1-4->置灰->必填")
    public void test2(){
        try {
            //打开登录页，并且登录
            LoginPage loginPage = new LoginPage(webDriver);
            loginPage.open();
            loginPage.login("80936682", "Aa123456");
            //标签选云超平台
            SupplierAddPage supplierAddPage = initSupplierAddPage(1);
            // 采购组选U
            ((JavascriptExecutor) webDriver).executeScript("arguments[0].click();", supplierAddPage.getPurchaseOrganizationInput());
            supplierAddPage.inithOrganizationSelect('U');
            ((JavascriptExecutor) webDriver).executeScript("arguments[0].click();", supplierAddPage.gethOrganizationSelect());
            //点击生鲜供应商标签，判断只有1到4
            supplierAddPage.getFreshSupplierLabelCodeInput().click();
            Thread.sleep(1000);
            supplierAddPage.initFreshSupplierLabelCodeInputSelect();
            Assert.assertEquals(supplierAddPage.getFreshSupplierLabelCodeInputSelect().size(), 4);
            Assert.assertEquals(supplierAddPage.getFreshSupplierLabelCodeInputSelect().get(0).getText(), "01 产地代办/生产商直供");
            Assert.assertEquals(supplierAddPage.getFreshSupplierLabelCodeInputSelect().get(1).getText(), "02 产地合作/生产商合作");
            Assert.assertEquals(supplierAddPage.getFreshSupplierLabelCodeInputSelect().get(2).getText(), "03 合作项目");
            Assert.assertEquals(supplierAddPage.getFreshSupplierLabelCodeInputSelect().get(3).getText(), "04 全球贸（进口）");
            //判断，签约采购人置灰，管理者必填
            String signedPurchaseStyle = supplierAddPage.getSignedPurchaseInput().getAttribute("disabled");
            Assert.assertEquals(signedPurchaseStyle, "true");
            String managerNotice = supplierAddPage.getManagerNotice().getAttribute("class");
            Assert.assertEquals(managerNotice, "ant-form-item-required ant-form-item-no-colon");
        }catch (Exception ex){
            Assert.assertTrue(false,ex.getMessage());
        }
    }

    @Test(description = "云超平台->A*->置灰->必填->选填")
    public void test3() throws Exception{
        try {
            //打开登录页，并且登录
            LoginPage loginPage = new LoginPage(webDriver);
            loginPage.open();
            loginPage.login("80936682", "Aa123456");
            //标签选云超平台
            SupplierAddPage supplierAddPage = initSupplierAddPage(1);
            // 采购组选A
            //supplierAddPage.getPurchaseOrganizationInput().click();
            ((JavascriptExecutor) webDriver).executeScript("arguments[0].click();", supplierAddPage.getPurchaseOrganizationInput());
            supplierAddPage.inithOrganizationSelect('A');
            ((JavascriptExecutor) webDriver).executeScript("arguments[0].click();", supplierAddPage.gethOrganizationSelect());
            //supplierAddPage.gethOrganizationSelect().click();

            //生鲜供应商标签置灰
            String freshSupplierLabelCodeStyle = supplierAddPage.getFreshSupplierLabelCodeInput().getAttribute("class");
            Assert.assertEquals(freshSupplierLabelCodeStyle, "ant-select ant-select-disabled");

            //判断，签约采购人必填，管理者选填
            String signedPurchaseNotice = supplierAddPage.getSignedPurchaseNotice().getAttribute("class");
            Assert.assertEquals(signedPurchaseNotice, "ant-form-item-required ant-form-item-no-colon");
            String managerNotice = supplierAddPage.getManagerNotice().getAttribute("class");
            Assert.assertEquals(managerNotice, "ant-form-item-no-colon");
        }catch (Exception ex){
            Assert.assertTrue(false,ex.getMessage());
        }
    }

    @Test(description = "云超平台->P*->置灰->置灰->选填")
    public void test4() throws Exception{
        try {
            //打开登录页，并且登录
            LoginPage loginPage = new LoginPage(webDriver);
            loginPage.open();
            loginPage.login("80936682", "Aa123456");
            //标签选云超平台
            SupplierAddPage supplierAddPage = initSupplierAddPage(1);
            // 采购组选A
            //supplierAddPage.getPurchaseOrganizationInput().click();
            ((JavascriptExecutor) webDriver).executeScript("arguments[0].click();", supplierAddPage.getPurchaseOrganizationInput());
            supplierAddPage.inithOrganizationSelect('P');
            ((JavascriptExecutor) webDriver).executeScript("arguments[0].click();", supplierAddPage.gethOrganizationSelect());
            //supplierAddPage.gethOrganizationSelect().click();

            //生鲜供应商标签置灰
            String freshSupplierLabelCodeStyle = supplierAddPage.getFreshSupplierLabelCodeInput().getAttribute("class");
            Assert.assertEquals(freshSupplierLabelCodeStyle, "ant-select ant-select-disabled");

            //判断，签约采购人置灰，管理者选填
            String signedPurchaseInput = supplierAddPage.getSignedPurchaseInput().getAttribute("class");
            Assert.assertEquals(signedPurchaseInput, "ant-input ant-input-disabled");
            String managerNotice = supplierAddPage.getManagerNotice().getAttribute("class");
            Assert.assertEquals(managerNotice, "ant-form-item-no-colon");
        }catch (Exception ex){
            Assert.assertTrue(false,ex.getMessage());
        }
    }

    @Test(description = "云超平台->10*->置灰->置灰->选填")
    public void test5() throws Exception{
        try {
            //打开登录页，并且登录
            LoginPage loginPage = new LoginPage(webDriver);
            loginPage.open();
            loginPage.login("80936682", "Aa123456");
            //标签选云超平台
            SupplierAddPage supplierAddPage = initSupplierAddPage(1);
            // 采购组选A
            //supplierAddPage.getPurchaseOrganizationInput().click();
            ((JavascriptExecutor) webDriver).executeScript("arguments[0].click();", supplierAddPage.getPurchaseOrganizationInput());
            supplierAddPage.inithOrganizationSelect('O');
            ((JavascriptExecutor) webDriver).executeScript("arguments[0].click();", supplierAddPage.gethOrganizationSelect());
            //supplierAddPage.gethOrganizationSelect().click();

            //生鲜供应商标签置灰
            String freshSupplierLabelCodeStyle = supplierAddPage.getFreshSupplierLabelCodeInput().getAttribute("class");
            Assert.assertEquals(freshSupplierLabelCodeStyle, "ant-select ant-select-disabled");

            //判断，签约采购人置灰，管理者选填
            String signedPurchaseInput = supplierAddPage.getSignedPurchaseInput().getAttribute("class");
            Assert.assertEquals(signedPurchaseInput, "ant-input ant-input-disabled");
            String managerNotice = supplierAddPage.getManagerNotice().getAttribute("class");
            Assert.assertEquals(managerNotice, "ant-form-item-no-colon");
        }catch (Exception ex){
            Assert.assertTrue(false,ex.getMessage());
        }
    }

    @Test(description = "云超PB->H*->5且置灰->必填->必填")
    public void test6() throws Exception{
        try {
            //打开登录页，并且登录
            LoginPage loginPage = new LoginPage(webDriver);
            loginPage.open();
            loginPage.login("80936682", "Aa123456");
            //标签选云超PB
            SupplierAddPage supplierAddPage = initSupplierAddPage(5);
            // 采购组选H
            //supplierAddPage.getPurchaseOrganizationInput().click();
            ((JavascriptExecutor) webDriver).executeScript("arguments[0].click();", supplierAddPage.getPurchaseOrganizationInput());
            supplierAddPage.inithOrganizationSelect('H');
            ((JavascriptExecutor) webDriver).executeScript("arguments[0].click();", supplierAddPage.gethOrganizationSelect());
            //supplierAddPage.gethOrganizationSelect().click();

            //生鲜供应商标签置灰且选5，现在是只有5
            supplierAddPage.getFreshSupplierLabelCodeInput().click();
            Thread.sleep(1000);
            supplierAddPage.initFreshSupplierLabelCodeInputSelect();
            Assert.assertEquals(supplierAddPage.getFreshSupplierLabelCodeInputSelect().size(), 1);
            Assert.assertEquals(supplierAddPage.getFreshSupplierLabelCodeInputSelect().get(0).getText(), "05 自有品牌");

            //判断，签约采购人，管理者必填
            String signedPurchaseNotice = supplierAddPage.getSignedPurchaseNotice().getAttribute("class");
            Assert.assertEquals(signedPurchaseNotice, "ant-form-item-required ant-form-item-no-colon");
            String managerNotice = supplierAddPage.getManagerNotice().getAttribute("class");
            Assert.assertEquals(managerNotice, "ant-form-item-required ant-form-item-no-colon");
        }catch (Exception ex){
            Assert.assertTrue(false,ex.getMessage());
        }
    }

    @Test(description = "云超PB->U*->5且置灰->置灰->必填")
    public void test7() throws Exception{
        try {
            //打开登录页，并且登录
            LoginPage loginPage = new LoginPage(webDriver);
            loginPage.open();
            loginPage.login("80936682", "Aa123456");
            //标签选云超PB
            SupplierAddPage supplierAddPage = initSupplierAddPage(5);
            // 采购组选U
            //supplierAddPage.getPurchaseOrganizationInput().click();
            ((JavascriptExecutor) webDriver).executeScript("arguments[0].click();", supplierAddPage.getPurchaseOrganizationInput());
            supplierAddPage.inithOrganizationSelect('U');
            ((JavascriptExecutor) webDriver).executeScript("arguments[0].click();", supplierAddPage.gethOrganizationSelect());
            //supplierAddPage.gethOrganizationSelect().click();

            //生鲜供应商标签置灰且选5，现在是只有5
            supplierAddPage.getFreshSupplierLabelCodeInput().click();
            Thread.sleep(1000);
            supplierAddPage.initFreshSupplierLabelCodeInputSelect();
            Assert.assertEquals(supplierAddPage.getFreshSupplierLabelCodeInputSelect().size(), 1);
            Assert.assertEquals(supplierAddPage.getFreshSupplierLabelCodeInputSelect().get(0).getText(), "05 自有品牌");

            //判断，签约采购人置灰，管理者必填
            String signedPurchaseStyle = supplierAddPage.getSignedPurchaseInput().getAttribute("disabled");
            Assert.assertEquals(signedPurchaseStyle, "true");
            String managerNotice = supplierAddPage.getManagerNotice().getAttribute("class");
            Assert.assertEquals(managerNotice, "ant-form-item-required ant-form-item-no-colon");
        }catch (Exception ex){
            Assert.assertTrue(false,ex.getMessage());
        }
    }

    @Test(description = "云超PB->A*->置灰->必填->选填")
    public void test8() throws Exception{
        try {
            //打开登录页，并且登录
            LoginPage loginPage = new LoginPage(webDriver);
            loginPage.open();
            loginPage.login("80936682", "Aa123456");
            //标签选云超PB
            SupplierAddPage supplierAddPage = initSupplierAddPage(5);
            // 采购组选A
            //supplierAddPage.getPurchaseOrganizationInput().click();
            ((JavascriptExecutor) webDriver).executeScript("arguments[0].click();", supplierAddPage.getPurchaseOrganizationInput());
            supplierAddPage.inithOrganizationSelect('A');
            ((JavascriptExecutor) webDriver).executeScript("arguments[0].click();", supplierAddPage.gethOrganizationSelect());
            //supplierAddPage.gethOrganizationSelect().click();

            //生鲜供应商标签置灰
            String freshSupplierLabelCodeStyle = supplierAddPage.getFreshSupplierLabelCodeInput().getAttribute("class");
            Assert.assertEquals(freshSupplierLabelCodeStyle, "ant-select ant-select-disabled");

            //判断，签约采购人必填，管理者选填
            String signedPurchaseNotice = supplierAddPage.getSignedPurchaseNotice().getAttribute("class");
            Assert.assertEquals(signedPurchaseNotice, "ant-form-item-required ant-form-item-no-colon");
            String managerNotice = supplierAddPage.getManagerNotice().getAttribute("class");
            Assert.assertEquals(managerNotice, "ant-form-item-no-colon");
        }catch (Exception ex){
            Assert.assertTrue(false,ex.getMessage());
        }
    }

    @Test(description = "云超PB->P*->置灰->置灰->选填")
    public void test9() throws Exception{
        try {
            //打开登录页，并且登录
            LoginPage loginPage = new LoginPage(webDriver);
            loginPage.open();
            loginPage.login("80936682", "Aa123456");
            //标签选云超PB
            SupplierAddPage supplierAddPage = initSupplierAddPage(5);
            // 采购组选P
            //supplierAddPage.getPurchaseOrganizationInput().click();
            ((JavascriptExecutor) webDriver).executeScript("arguments[0].click();", supplierAddPage.getPurchaseOrganizationInput());
            supplierAddPage.inithOrganizationSelect('P');
            ((JavascriptExecutor) webDriver).executeScript("arguments[0].click();", supplierAddPage.gethOrganizationSelect());
            //supplierAddPage.gethOrganizationSelect().click();

            //生鲜供应商标签置灰
            String freshSupplierLabelCodeStyle = supplierAddPage.getFreshSupplierLabelCodeInput().getAttribute("class");
            Assert.assertEquals(freshSupplierLabelCodeStyle, "ant-select ant-select-disabled");

            //判断，签约采购人置灰，管理者选填
            String signedPurchaseInput = supplierAddPage.getSignedPurchaseInput().getAttribute("class");
            Assert.assertEquals(signedPurchaseInput, "ant-input ant-input-disabled");
            String managerNotice = supplierAddPage.getManagerNotice().getAttribute("class");
            Assert.assertEquals(managerNotice, "ant-form-item-no-colon");
        }catch (Exception ex){
            Assert.assertTrue(false,ex.getMessage());
        }
    }

    @Test(description = "云超PB->10*->置灰->置灰->选填")
    public void test10() throws Exception{
        try {
            //打开登录页，并且登录
            LoginPage loginPage = new LoginPage(webDriver);
            loginPage.open();
            loginPage.login("80936682", "Aa123456");
            //标签选云超PB
            SupplierAddPage supplierAddPage = initSupplierAddPage(5);
            // 采购组选O
            //supplierAddPage.getPurchaseOrganizationInput().click();
            ((JavascriptExecutor) webDriver).executeScript("arguments[0].click();", supplierAddPage.getPurchaseOrganizationInput());
            supplierAddPage.inithOrganizationSelect('O');
            ((JavascriptExecutor) webDriver).executeScript("arguments[0].click();", supplierAddPage.gethOrganizationSelect());
            //supplierAddPage.gethOrganizationSelect().click();

            //生鲜供应商标签置灰
            String freshSupplierLabelCodeStyle = supplierAddPage.getFreshSupplierLabelCodeInput().getAttribute("class");
            Assert.assertEquals(freshSupplierLabelCodeStyle, "ant-select ant-select-disabled");

            //判断，签约采购人置灰，管理者选填
            String signedPurchaseInput = supplierAddPage.getSignedPurchaseInput().getAttribute("class");
            Assert.assertEquals(signedPurchaseInput, "ant-input ant-input-disabled");
            String managerNotice = supplierAddPage.getManagerNotice().getAttribute("class");
            Assert.assertEquals(managerNotice, "ant-form-item-no-colon");
        }catch (Exception ex){
            Assert.assertTrue(false,ex.getMessage());
        }
    }

    @Test(description = "云超战区->H*->可选6-8->必填->必填")
    public void test11(){
        try {
            //打开登录页，并且登录
            LoginPage loginPage = new LoginPage(webDriver);
            loginPage.open();
            loginPage.login("80936682", "Aa123456");
            //标签选云超战区
            SupplierAddPage supplierAddPage = initSupplierAddPage(2);
            // 采购组选H
            supplierAddPage.getPurchaseOrganizationInput().click();
            supplierAddPage.inithOrganizationSelect('H');
            ((JavascriptExecutor) webDriver).executeScript("arguments[0].click();", supplierAddPage.gethOrganizationSelect());
            //点击生鲜供应商标签，判断只有6-8
            supplierAddPage.getFreshSupplierLabelCodeInput().click();
            Thread.sleep(1000);
            supplierAddPage.initFreshSupplierLabelCodeInputSelect();
            Assert.assertEquals(supplierAddPage.getFreshSupplierLabelCodeInputSelect().size(), 3);
            Assert.assertEquals(supplierAddPage.getFreshSupplierLabelCodeInputSelect().get(0).getText(), "06 自采供应商");
            Assert.assertEquals(supplierAddPage.getFreshSupplierLabelCodeInputSelect().get(1).getText(), "07 一村一品");
            Assert.assertEquals(supplierAddPage.getFreshSupplierLabelCodeInputSelect().get(2).getText(), "08 区域供应商");
            //判断，签约采购人，管理者必填
            String signedPurchaseNotice = supplierAddPage.getSignedPurchaseNotice().getAttribute("class");
            Assert.assertEquals(signedPurchaseNotice, "ant-form-item-required ant-form-item-no-colon");
            String managerNotice = supplierAddPage.getManagerNotice().getAttribute("class");
            Assert.assertEquals(managerNotice, "ant-form-item-required ant-form-item-no-colon");
        }catch (Exception ex){
            Assert.assertTrue(false,ex.getMessage());
        }
    }

    @Test(description = "云超战区->U*->8且置灰->置灰->必填")
    public void test12(){
        try {
            //打开登录页，并且登录
            LoginPage loginPage = new LoginPage(webDriver);
            loginPage.open();
            loginPage.login("80936682", "Aa123456");
            //标签选云超平台
            SupplierAddPage supplierAddPage = initSupplierAddPage(2);
            // 采购组选U
            ((JavascriptExecutor) webDriver).executeScript("arguments[0].click();", supplierAddPage.getPurchaseOrganizationInput());
            supplierAddPage.inithOrganizationSelect('U');
            ((JavascriptExecutor) webDriver).executeScript("arguments[0].click();", supplierAddPage.gethOrganizationSelect());

            //生鲜供应商标签置灰且8
            String freshSupplierLabelCodeStyle = supplierAddPage.getFreshSupplierLabelCodeInput().getAttribute("class");
            String freshSupplierLabelCodeText = supplierAddPage.getFreshSupplierLabelCodeInput().getText();
            Assert.assertEquals(freshSupplierLabelCodeStyle, "ant-select ant-select-disabled");
            Assert.assertEquals(freshSupplierLabelCodeText, "08 区域供应商");

            //判断，签约采购人置灰，管理者必填
            String signedPurchaseStyle = supplierAddPage.getSignedPurchaseInput().getAttribute("disabled");
            Assert.assertEquals(signedPurchaseStyle, "true");
            String managerNotice = supplierAddPage.getManagerNotice().getAttribute("class");
            Assert.assertEquals(managerNotice, "ant-form-item-required ant-form-item-no-colon");
        }catch (Exception ex){
            Assert.assertTrue(false,ex.getMessage());
        }
    }

    @Test(description = "云超战区->A*->置灰->必填->选填")
    public void test13() throws Exception{
        try {
            //打开登录页，并且登录
            LoginPage loginPage = new LoginPage(webDriver);
            loginPage.open();
            loginPage.login("80936682", "Aa123456");
            //标签选云超战区
            SupplierAddPage supplierAddPage = initSupplierAddPage(2);
            // 采购组选A
            //supplierAddPage.getPurchaseOrganizationInput().click();
            ((JavascriptExecutor) webDriver).executeScript("arguments[0].click();", supplierAddPage.getPurchaseOrganizationInput());
            supplierAddPage.inithOrganizationSelect('A');
            ((JavascriptExecutor) webDriver).executeScript("arguments[0].click();", supplierAddPage.gethOrganizationSelect());
            //supplierAddPage.gethOrganizationSelect().click();

            //生鲜供应商标签置灰
            String freshSupplierLabelCodeStyle = supplierAddPage.getFreshSupplierLabelCodeInput().getAttribute("class");
            Assert.assertEquals(freshSupplierLabelCodeStyle, "ant-select ant-select-disabled");

            //判断，签约采购人必填，管理者选填
            String signedPurchaseNotice = supplierAddPage.getSignedPurchaseNotice().getAttribute("class");
            Assert.assertEquals(signedPurchaseNotice, "ant-form-item-required ant-form-item-no-colon");
            String managerNotice = supplierAddPage.getManagerNotice().getAttribute("class");
            Assert.assertEquals(managerNotice, "ant-form-item-no-colon");
        }catch (Exception ex){
            Assert.assertTrue(false,ex.getMessage());
        }
    }

    @Test(description = "云超战区->P*->置灰->置灰->选填")
    public void test14() throws Exception{
        try {
            //打开登录页，并且登录
            LoginPage loginPage = new LoginPage(webDriver);
            loginPage.open();
            loginPage.login("80936682", "Aa123456");
            //标签选云超战区
            SupplierAddPage supplierAddPage = initSupplierAddPage(2);
            // 采购组选P
            //supplierAddPage.getPurchaseOrganizationInput().click();
            ((JavascriptExecutor) webDriver).executeScript("arguments[0].click();", supplierAddPage.getPurchaseOrganizationInput());
            supplierAddPage.inithOrganizationSelect('P');
            ((JavascriptExecutor) webDriver).executeScript("arguments[0].click();", supplierAddPage.gethOrganizationSelect());
            //supplierAddPage.gethOrganizationSelect().click();

            //生鲜供应商标签置灰
            String freshSupplierLabelCodeStyle = supplierAddPage.getFreshSupplierLabelCodeInput().getAttribute("class");
            Assert.assertEquals(freshSupplierLabelCodeStyle, "ant-select ant-select-disabled");

            //判断，签约采购人置灰，管理者选填
            String signedPurchaseInput = supplierAddPage.getSignedPurchaseInput().getAttribute("class");
            Assert.assertEquals(signedPurchaseInput, "ant-input ant-input-disabled");
            String managerNotice = supplierAddPage.getManagerNotice().getAttribute("class");
            Assert.assertEquals(managerNotice, "ant-form-item-no-colon");
        }catch (Exception ex){
            Assert.assertTrue(false,ex.getMessage());
        }
    }

    @Test(description = "云超战区->10*->置灰->置灰->选填")
    public void test15() throws Exception{
        try {
            //打开登录页，并且登录
            LoginPage loginPage = new LoginPage(webDriver);
            loginPage.open();
            loginPage.login("80936682", "Aa123456");
            //标签选云超战区
            SupplierAddPage supplierAddPage = initSupplierAddPage(2);
            // 采购组选O
            //supplierAddPage.getPurchaseOrganizationInput().click();
            ((JavascriptExecutor) webDriver).executeScript("arguments[0].click();", supplierAddPage.getPurchaseOrganizationInput());
            supplierAddPage.inithOrganizationSelect('O');
            ((JavascriptExecutor) webDriver).executeScript("arguments[0].click();", supplierAddPage.gethOrganizationSelect());
            //supplierAddPage.gethOrganizationSelect().click();

            //生鲜供应商标签置灰
            String freshSupplierLabelCodeStyle = supplierAddPage.getFreshSupplierLabelCodeInput().getAttribute("class");
            Assert.assertEquals(freshSupplierLabelCodeStyle, "ant-select ant-select-disabled");

            //判断，签约采购人置灰，管理者选填
            String signedPurchaseInput = supplierAddPage.getSignedPurchaseInput().getAttribute("class");
            Assert.assertEquals(signedPurchaseInput, "ant-input ant-input-disabled");
            String managerNotice = supplierAddPage.getManagerNotice().getAttribute("class");
            Assert.assertEquals(managerNotice, "ant-form-item-no-colon");
        }catch (Exception ex){
            Assert.assertTrue(false,ex.getMessage());
        }
    }


    @Test(description = "彩食鲜->H*->可选1-8->必填->必填")
    public void test16(){
        try {
            //打开登录页，并且登录
            LoginPage loginPage = new LoginPage(webDriver);
            loginPage.open();
            loginPage.login("80936682", "Aa123456");
            //标签选彩食鲜
            SupplierAddPage supplierAddPage = initSupplierAddPage(4);
            // 采购组选H
            supplierAddPage.getPurchaseOrganizationInput().click();
            supplierAddPage.inithOrganizationSelect('H');
            ((JavascriptExecutor) webDriver).executeScript("arguments[0].click();", supplierAddPage.gethOrganizationSelect());
            //点击生鲜供应商标签，判断只有1-8
            supplierAddPage.getFreshSupplierLabelCodeInput().click();
            Thread.sleep(1000);
            supplierAddPage.initFreshSupplierLabelCodeInputSelect();
            Assert.assertEquals(supplierAddPage.getFreshSupplierLabelCodeInputSelect().size(), 8);
            Assert.assertEquals(supplierAddPage.getFreshSupplierLabelCodeInputSelect().get(0).getText(), "01 产地代办/生产商直供");
            Assert.assertEquals(supplierAddPage.getFreshSupplierLabelCodeInputSelect().get(1).getText(), "02 产地合作/生产商合作");
            Assert.assertEquals(supplierAddPage.getFreshSupplierLabelCodeInputSelect().get(2).getText(), "03 合作项目");
            Assert.assertEquals(supplierAddPage.getFreshSupplierLabelCodeInputSelect().get(3).getText(), "04 全球贸（进口）");
            Assert.assertEquals(supplierAddPage.getFreshSupplierLabelCodeInputSelect().get(4).getText(), "05 自有品牌");
            Assert.assertEquals(supplierAddPage.getFreshSupplierLabelCodeInputSelect().get(5).getText(), "06 自采供应商");
            Assert.assertEquals(supplierAddPage.getFreshSupplierLabelCodeInputSelect().get(6).getText(), "07 一村一品");
            Assert.assertEquals(supplierAddPage.getFreshSupplierLabelCodeInputSelect().get(7).getText(), "08 区域供应商");
            //判断，签约采购人，管理者必填
            String signedPurchaseNotice = supplierAddPage.getSignedPurchaseNotice().getAttribute("class");
            Assert.assertEquals(signedPurchaseNotice, "ant-form-item-required ant-form-item-no-colon");
            String managerNotice = supplierAddPage.getManagerNotice().getAttribute("class");
            Assert.assertEquals(managerNotice, "ant-form-item-required ant-form-item-no-colon");
        }catch (Exception ex){
            Assert.assertTrue(false,ex.getMessage());
        }
    }

    @Test(description = "彩食鲜->U*->可选1-8->置灰->必填")
    public void test17(){
        try {
            //打开登录页，并且登录
            LoginPage loginPage = new LoginPage(webDriver);
            loginPage.open();
            loginPage.login("80936682", "Aa123456");
            //标签选彩食鲜
            SupplierAddPage supplierAddPage = initSupplierAddPage(4);
            // 采购组选U
            ((JavascriptExecutor) webDriver).executeScript("arguments[0].click();", supplierAddPage.getPurchaseOrganizationInput());
            supplierAddPage.inithOrganizationSelect('U');
            ((JavascriptExecutor) webDriver).executeScript("arguments[0].click();", supplierAddPage.gethOrganizationSelect());

            //点击生鲜供应商标签，判断只有1-8
            supplierAddPage.getFreshSupplierLabelCodeInput().click();
            Thread.sleep(1000);
            supplierAddPage.initFreshSupplierLabelCodeInputSelect();
            Assert.assertEquals(supplierAddPage.getFreshSupplierLabelCodeInputSelect().size(), 8);
            Assert.assertEquals(supplierAddPage.getFreshSupplierLabelCodeInputSelect().get(0).getText(), "01 产地代办/生产商直供");
            Assert.assertEquals(supplierAddPage.getFreshSupplierLabelCodeInputSelect().get(1).getText(), "02 产地合作/生产商合作");
            Assert.assertEquals(supplierAddPage.getFreshSupplierLabelCodeInputSelect().get(2).getText(), "03 合作项目");
            Assert.assertEquals(supplierAddPage.getFreshSupplierLabelCodeInputSelect().get(3).getText(), "04 全球贸（进口）");
            Assert.assertEquals(supplierAddPage.getFreshSupplierLabelCodeInputSelect().get(4).getText(), "05 自有品牌");
            Assert.assertEquals(supplierAddPage.getFreshSupplierLabelCodeInputSelect().get(5).getText(), "06 自采供应商");
            Assert.assertEquals(supplierAddPage.getFreshSupplierLabelCodeInputSelect().get(6).getText(), "07 一村一品");
            Assert.assertEquals(supplierAddPage.getFreshSupplierLabelCodeInputSelect().get(7).getText(), "08 区域供应商");

            //判断，签约采购人置灰，管理者必填
            String signedPurchaseStyle = supplierAddPage.getSignedPurchaseInput().getAttribute("disabled");
            Assert.assertEquals(signedPurchaseStyle, "true");
            String managerNotice = supplierAddPage.getManagerNotice().getAttribute("class");
            Assert.assertEquals(managerNotice, "ant-form-item-required ant-form-item-no-colon");
        }catch (Exception ex){
            Assert.assertTrue(false,ex.getMessage());
        }
    }

    @Test(description = "彩食鲜->A*->置灰->必填->选填")
    public void test18() throws Exception{
        try {
            //打开登录页，并且登录
            LoginPage loginPage = new LoginPage(webDriver);
            loginPage.open();
            loginPage.login("80936682", "Aa123456");
            //标签选彩食鲜
            SupplierAddPage supplierAddPage = initSupplierAddPage(4);
            // 采购组选A
            //supplierAddPage.getPurchaseOrganizationInput().click();
            ((JavascriptExecutor) webDriver).executeScript("arguments[0].click();", supplierAddPage.getPurchaseOrganizationInput());
            supplierAddPage.inithOrganizationSelect('A');
            ((JavascriptExecutor) webDriver).executeScript("arguments[0].click();", supplierAddPage.gethOrganizationSelect());
            //supplierAddPage.gethOrganizationSelect().click();

            //生鲜供应商标签置灰
            String freshSupplierLabelCodeStyle = supplierAddPage.getFreshSupplierLabelCodeInput().getAttribute("class");
            Assert.assertEquals(freshSupplierLabelCodeStyle, "ant-select ant-select-disabled");

            //判断，签约采购人必填，管理者选填
            String signedPurchaseNotice = supplierAddPage.getSignedPurchaseNotice().getAttribute("class");
            Assert.assertEquals(signedPurchaseNotice, "ant-form-item-required ant-form-item-no-colon");
            String managerNotice = supplierAddPage.getManagerNotice().getAttribute("class");
            Assert.assertEquals(managerNotice, "ant-form-item-no-colon");
        }catch (Exception ex){
            Assert.assertTrue(false,ex.getMessage());
        }
    }

    @Test(description = "彩食鲜->P*->置灰->置灰->选填")
    public void test19() throws Exception{
        try {
            //打开登录页，并且登录
            LoginPage loginPage = new LoginPage(webDriver);
            loginPage.open();
            loginPage.login("80936682", "Aa123456");
            //标签选彩食鲜
            SupplierAddPage supplierAddPage = initSupplierAddPage(4);
            // 采购组选P
            //supplierAddPage.getPurchaseOrganizationInput().click();
            ((JavascriptExecutor) webDriver).executeScript("arguments[0].click();", supplierAddPage.getPurchaseOrganizationInput());
            supplierAddPage.inithOrganizationSelect('P');
            ((JavascriptExecutor) webDriver).executeScript("arguments[0].click();", supplierAddPage.gethOrganizationSelect());
            //supplierAddPage.gethOrganizationSelect().click();

            //生鲜供应商标签置灰
            String freshSupplierLabelCodeStyle = supplierAddPage.getFreshSupplierLabelCodeInput().getAttribute("class");
            Assert.assertEquals(freshSupplierLabelCodeStyle, "ant-select ant-select-disabled");

            //判断，签约采购人置灰，管理者选填
            String signedPurchaseInput = supplierAddPage.getSignedPurchaseInput().getAttribute("class");
            Assert.assertEquals(signedPurchaseInput, "ant-input ant-input-disabled");
            String managerNotice = supplierAddPage.getManagerNotice().getAttribute("class");
            Assert.assertEquals(managerNotice, "ant-form-item-no-colon");
        }catch (Exception ex){
            Assert.assertTrue(false,ex.getMessage());
        }
    }

    @Test(description = "彩食鲜->10*->置灰->置灰->选填")
    public void test20() throws Exception{
        try {
            //打开登录页，并且登录
            LoginPage loginPage = new LoginPage(webDriver);
            loginPage.open();
            loginPage.login("80936682", "Aa123456");
            //标签选彩食鲜
            SupplierAddPage supplierAddPage = initSupplierAddPage(4);
            // 采购组选O
            //supplierAddPage.getPurchaseOrganizationInput().click();
            ((JavascriptExecutor) webDriver).executeScript("arguments[0].click();", supplierAddPage.getPurchaseOrganizationInput());
            supplierAddPage.inithOrganizationSelect('O');
            ((JavascriptExecutor) webDriver).executeScript("arguments[0].click();", supplierAddPage.gethOrganizationSelect());
            //supplierAddPage.gethOrganizationSelect().click();

            //生鲜供应商标签置灰
            String freshSupplierLabelCodeStyle = supplierAddPage.getFreshSupplierLabelCodeInput().getAttribute("class");
            Assert.assertEquals(freshSupplierLabelCodeStyle, "ant-select ant-select-disabled");

            //判断，签约采购人置灰，管理者选填
            String signedPurchaseInput = supplierAddPage.getSignedPurchaseInput().getAttribute("class");
            Assert.assertEquals(signedPurchaseInput, "ant-input ant-input-disabled");
            String managerNotice = supplierAddPage.getManagerNotice().getAttribute("class");
            Assert.assertEquals(managerNotice, "ant-form-item-no-colon");
        }catch (Exception ex){
            Assert.assertTrue(false,ex.getMessage());
        }
    }

    @Test(description = "云创->H*->可选1-8->必填->必填")
    public void test21(){
        try {
            //打开登录页，并且登录
            LoginPage loginPage = new LoginPage(webDriver);
            loginPage.open();
            loginPage.login("80936682", "Aa123456");
            //标签选云创
            SupplierAddPage supplierAddPage = initSupplierAddPage(3);
            // 采购组选H
            supplierAddPage.getPurchaseOrganizationInput().click();
            supplierAddPage.inithOrganizationSelect('H');
            ((JavascriptExecutor) webDriver).executeScript("arguments[0].click();", supplierAddPage.gethOrganizationSelect());
            //点击生鲜供应商标签，判断只有1-8
            supplierAddPage.getFreshSupplierLabelCodeInput().click();
            Thread.sleep(1000);
            supplierAddPage.initFreshSupplierLabelCodeInputSelect();
            Assert.assertEquals(supplierAddPage.getFreshSupplierLabelCodeInputSelect().size(), 8);
            Assert.assertEquals(supplierAddPage.getFreshSupplierLabelCodeInputSelect().get(0).getText(), "01 产地代办/生产商直供");
            Assert.assertEquals(supplierAddPage.getFreshSupplierLabelCodeInputSelect().get(1).getText(), "02 产地合作/生产商合作");
            Assert.assertEquals(supplierAddPage.getFreshSupplierLabelCodeInputSelect().get(2).getText(), "03 合作项目");
            Assert.assertEquals(supplierAddPage.getFreshSupplierLabelCodeInputSelect().get(3).getText(), "04 全球贸（进口）");
            Assert.assertEquals(supplierAddPage.getFreshSupplierLabelCodeInputSelect().get(4).getText(), "05 自有品牌");
            Assert.assertEquals(supplierAddPage.getFreshSupplierLabelCodeInputSelect().get(5).getText(), "06 自采供应商");
            Assert.assertEquals(supplierAddPage.getFreshSupplierLabelCodeInputSelect().get(6).getText(), "07 一村一品");
            Assert.assertEquals(supplierAddPage.getFreshSupplierLabelCodeInputSelect().get(7).getText(), "08 区域供应商");
            //判断，签约采购人，管理者必填
            String signedPurchaseNotice = supplierAddPage.getSignedPurchaseNotice().getAttribute("class");
            Assert.assertEquals(signedPurchaseNotice, "ant-form-item-required ant-form-item-no-colon");
            String managerNotice = supplierAddPage.getManagerNotice().getAttribute("class");
            Assert.assertEquals(managerNotice, "ant-form-item-required ant-form-item-no-colon");
        }catch (Exception ex){
            Assert.assertTrue(false,ex.getMessage());
        }
    }

    @Test(description = "云创->U*->可选1-8->置灰->必填")
    public void test22(){
        try {
            //打开登录页，并且登录
            LoginPage loginPage = new LoginPage(webDriver);
            loginPage.open();
            loginPage.login("80936682", "Aa123456");
            //标签选云创
            SupplierAddPage supplierAddPage = initSupplierAddPage(3);
            // 采购组选U
            ((JavascriptExecutor) webDriver).executeScript("arguments[0].click();", supplierAddPage.getPurchaseOrganizationInput());
            supplierAddPage.inithOrganizationSelect('U');
            ((JavascriptExecutor) webDriver).executeScript("arguments[0].click();", supplierAddPage.gethOrganizationSelect());

            //点击生鲜供应商标签，判断只有1-8
            supplierAddPage.getFreshSupplierLabelCodeInput().click();
            Thread.sleep(1000);
            supplierAddPage.initFreshSupplierLabelCodeInputSelect();
            Assert.assertEquals(supplierAddPage.getFreshSupplierLabelCodeInputSelect().size(), 8);
            Assert.assertEquals(supplierAddPage.getFreshSupplierLabelCodeInputSelect().get(0).getText(), "01 产地代办/生产商直供");
            Assert.assertEquals(supplierAddPage.getFreshSupplierLabelCodeInputSelect().get(1).getText(), "02 产地合作/生产商合作");
            Assert.assertEquals(supplierAddPage.getFreshSupplierLabelCodeInputSelect().get(2).getText(), "03 合作项目");
            Assert.assertEquals(supplierAddPage.getFreshSupplierLabelCodeInputSelect().get(3).getText(), "04 全球贸（进口）");
            Assert.assertEquals(supplierAddPage.getFreshSupplierLabelCodeInputSelect().get(4).getText(), "05 自有品牌");
            Assert.assertEquals(supplierAddPage.getFreshSupplierLabelCodeInputSelect().get(5).getText(), "06 自采供应商");
            Assert.assertEquals(supplierAddPage.getFreshSupplierLabelCodeInputSelect().get(6).getText(), "07 一村一品");
            Assert.assertEquals(supplierAddPage.getFreshSupplierLabelCodeInputSelect().get(7).getText(), "08 区域供应商");

            //判断，签约采购人置灰，管理者必填
            String signedPurchaseStyle = supplierAddPage.getSignedPurchaseInput().getAttribute("disabled");
            Assert.assertEquals(signedPurchaseStyle, "true");
            String managerNotice = supplierAddPage.getManagerNotice().getAttribute("class");
            Assert.assertEquals(managerNotice, "ant-form-item-required ant-form-item-no-colon");
        }catch (Exception ex){
            Assert.assertTrue(false,ex.getMessage());
        }
    }

    @Test(description = "云创->A*->置灰->必填->选填")
    public void test23() throws Exception{
        try {
            //打开登录页，并且登录
            LoginPage loginPage = new LoginPage(webDriver);
            loginPage.open();
            loginPage.login("80936682", "Aa123456");
            //标签选云创
            SupplierAddPage supplierAddPage = initSupplierAddPage(3);
            // 采购组选A
            //supplierAddPage.getPurchaseOrganizationInput().click();
            ((JavascriptExecutor) webDriver).executeScript("arguments[0].click();", supplierAddPage.getPurchaseOrganizationInput());
            supplierAddPage.inithOrganizationSelect('A');
            ((JavascriptExecutor) webDriver).executeScript("arguments[0].click();", supplierAddPage.gethOrganizationSelect());
            //supplierAddPage.gethOrganizationSelect().click();

            //生鲜供应商标签置灰
            String freshSupplierLabelCodeStyle = supplierAddPage.getFreshSupplierLabelCodeInput().getAttribute("class");
            Assert.assertEquals(freshSupplierLabelCodeStyle, "ant-select ant-select-disabled");

            //判断，签约采购人必填，管理者选填
            String signedPurchaseNotice = supplierAddPage.getSignedPurchaseNotice().getAttribute("class");
            Assert.assertEquals(signedPurchaseNotice, "ant-form-item-required ant-form-item-no-colon");
            String managerNotice = supplierAddPage.getManagerNotice().getAttribute("class");
            Assert.assertEquals(managerNotice, "ant-form-item-no-colon");
        }catch (Exception ex){
            Assert.assertTrue(false,ex.getMessage());
        }
    }

    @Test(description = "云创->P*->置灰->置灰->选填")
    public void test24() throws Exception{
        try {
            //打开登录页，并且登录
            LoginPage loginPage = new LoginPage(webDriver);
            loginPage.open();
            loginPage.login("80936682", "Aa123456");
            //标签选云创
            SupplierAddPage supplierAddPage = initSupplierAddPage(3);
            // 采购组选P
            //supplierAddPage.getPurchaseOrganizationInput().click();
            ((JavascriptExecutor) webDriver).executeScript("arguments[0].click();", supplierAddPage.getPurchaseOrganizationInput());
            supplierAddPage.inithOrganizationSelect('P');
            ((JavascriptExecutor) webDriver).executeScript("arguments[0].click();", supplierAddPage.gethOrganizationSelect());
            //supplierAddPage.gethOrganizationSelect().click();

            //生鲜供应商标签置灰
            String freshSupplierLabelCodeStyle = supplierAddPage.getFreshSupplierLabelCodeInput().getAttribute("class");
            Assert.assertEquals(freshSupplierLabelCodeStyle, "ant-select ant-select-disabled");

            //判断，签约采购人置灰，管理者选填
            String signedPurchaseInput = supplierAddPage.getSignedPurchaseInput().getAttribute("class");
            Assert.assertEquals(signedPurchaseInput, "ant-input ant-input-disabled");
            String managerNotice = supplierAddPage.getManagerNotice().getAttribute("class");
            Assert.assertEquals(managerNotice, "ant-form-item-no-colon");
        }catch (Exception ex){
            Assert.assertTrue(false,ex.getMessage());
        }
    }

    @Test(description = "云创->10*->置灰->置灰->选填")
    public void test25() throws Exception{
        try {
            //打开登录页，并且登录
            LoginPage loginPage = new LoginPage(webDriver);
            loginPage.open();
            loginPage.login("80936682", "Aa123456");
            //标签选云创
            SupplierAddPage supplierAddPage = initSupplierAddPage(3);
            // 采购组选O
            //supplierAddPage.getPurchaseOrganizationInput().click();
            ((JavascriptExecutor) webDriver).executeScript("arguments[0].click();", supplierAddPage.getPurchaseOrganizationInput());
            supplierAddPage.inithOrganizationSelect('O');
            ((JavascriptExecutor) webDriver).executeScript("arguments[0].click();", supplierAddPage.gethOrganizationSelect());
            //supplierAddPage.gethOrganizationSelect().click();

            //生鲜供应商标签置灰
            String freshSupplierLabelCodeStyle = supplierAddPage.getFreshSupplierLabelCodeInput().getAttribute("class");
            Assert.assertEquals(freshSupplierLabelCodeStyle, "ant-select ant-select-disabled");

            //判断，签约采购人置灰，管理者选填
            String signedPurchaseInput = supplierAddPage.getSignedPurchaseInput().getAttribute("class");
            Assert.assertEquals(signedPurchaseInput, "ant-input ant-input-disabled");
            String managerNotice = supplierAddPage.getManagerNotice().getAttribute("class");
            Assert.assertEquals(managerNotice, "ant-form-item-no-colon");
        }catch (Exception ex){
            Assert.assertTrue(false,ex.getMessage());
        }
    }



    @AfterMethod
    public void after(){
        closeChrome(webDriver,windows);
    }

    public SupplierAddPage initSupplierAddPage(int type)throws Exception{
        //首页点击寻源管理
        HomePage homePage=new HomePage(webDriver);
        homePage.getFindSourceManagement().click();

        //点击寻源管理，点击新增，切换页面
        SupplierCreationAndQueryPage supplierCreationAndQueryPage=new SupplierCreationAndQueryPage(webDriver);
        supplierCreationAndQueryPage.getAddSupplier().click();
        windows =new ArrayList<String>(webDriver.getWindowHandles());
        webDriver.switchTo().window(windows.get(windows.size()-1));

        //标签选择云超
        SupplierAddPage supplierAddPage=new SupplierAddPage(webDriver);
        supplierAddPage.getLabelInput().click();
        Thread.sleep(1000);
        supplierAddPage.initTagCodeSelect(type);
        supplierAddPage.getTagCodeSelect().click();
        Thread.sleep(1000);
        supplierAddPage.getAddInfoTab().click();
        return supplierAddPage;
    }


}
