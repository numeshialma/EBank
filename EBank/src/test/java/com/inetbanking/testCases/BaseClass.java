package com.inetbanking.testCases;

import com.inetbanking.utilities.ReadConfig;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public class BaseClass {

    ReadConfig readconfig=new ReadConfig();
    //public String baseURL="https://demo.guru99.com/v4";
    //public String username="mngr164225";
    //public String password="jahetAp";

    public String baseURL=readconfig.getApplicationURL();
    public String username=readconfig.getUserName();
    public String password= readconfig.getPassword();

    public static WebDriver driver;
    public static Logger logger;

    @BeforeMethod
    public void setUp() {
        //System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
        System.setProperty("webdriver.chrome.driver",readconfig.getChromePath());
        driver=new ChromeDriver();

        Logger logger=Logger.getLogger("ebanking");
        PropertyConfigurator.configure("Log4j.properties");

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(baseURL);
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }

    public void captureScreen(WebDriver driver,String tname) throws IOException{
        TakesScreenshot ts=(TakesScreenshot) driver;
        File source= ts.getScreenshotAs(OutputType.FILE);
        File target=new File(System.getProperty("user.dir")+"/Screenshots/"+tname+".png");
        FileUtils.copyFile(source,target);
        System.out.println("screenshot taken");
    }
}
