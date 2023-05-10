package com.inetbanking.testCases;

import com.inetbanking.pageObjects.AddCustomerPage;
import com.inetbanking.pageObjects.LoginPage;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class Tc_AddCustomerTest_003 extends BaseClass{

    @Test
    public void addNewCustomer() throws InterruptedException, IOException {
        LoginPage lp=new LoginPage(driver);
        lp.setUserName(username);
        logger.info("user name is provided");
        lp.setPassword(password);
        logger.info("password is provided");
        lp.clickSubmit();

        Thread.sleep(3000);

        AddCustomerPage addcust=new AddCustomerPage(driver);
        addcust.clickAddNewCustomer();
        logger.info("providing customer details.....");

        addcust.custName("Pavan");
        addcust.custgender("male");
        addcust.custdob("10","15","1985");
        Thread.sleep(3000);
        addcust.custaddress("India");
        addcust.custcity("HYD");
        addcust.custstate("AP");
        addcust.custpinno("5000074");
        addcust.custtelephoneno("987890091");

        String email=randomestring()+"@gmail.com";
        addcust.custemailid(email);

        addcust.custpassword("adcdef");
        addcust.custsubmit();

        Thread.sleep(3000);

        boolean res=driver.getPageSource().contains("Customer Register Successfully!!!");

        if(res==true){
            Assert.assertTrue(true);
        }
        else {
            captureScreen(driver,"addNewCustomer");
            Assert.assertTrue(false);
        }
    }

    public String randomestring(){
        String generatedstring= RandomStringUtils.randomAlphabetic(8);
        return (generatedstring);
    }

    public String randomeNum(){
        String generatedstring2= RandomStringUtils.randomNumeric(4);
        return (generatedstring2);
    }
}
