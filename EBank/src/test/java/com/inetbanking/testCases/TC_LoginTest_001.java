package com.inetbanking.testCases;

import com.inetbanking.pageObjects.LoginPage;
import com.inetbanking.testCases.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.logging.Logger;

public class TC_LoginTest_001 extends BaseClass {

    @Test
    public void loginTest(){
        driver.get(baseURL);

        logger.info("URL is opened");

        LoginPage lp=new LoginPage(driver);
        lp.setUserName(username);
        logger.info("Entered username");
        lp.setPassword(password);
        logger.info("Entered password");
        lp.clickSubmit();

//        List<WebElement> message=
//                driver.findElements(By.xpath("//*[text()='Guru99 Bank']"));
//        String actualHomePageMessage=message.get(2).getText();
//
//        Assert.assertEquals(actualHomePageMessage,"Guru99 Bank","Failed to Login");


        if(driver.getTitle().equals("Guru99 Bank")){
            Assert.assertTrue(true);
            logger.info("Login test passed");
        }
        else{
            Assert.assertTrue(false);
            logger.info("Login test failed");
        }
    }

}
