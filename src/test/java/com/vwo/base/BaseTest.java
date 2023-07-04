package com.vwo.base;

import com.vwo.utils.DriverManager;
import com.vwo.utils.DriverManagerTL;
import com.vwo.utils.Log;
import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.io.ByteArrayInputStream;


public class BaseTest {

    @BeforeClass
    protected void setUp() throws Exception {
        DriverManagerTL.init();
        Log.TestExecutionStart();
    }

    @AfterClass
    protected void tearDown(){
        DriverManagerTL.tearDown();
        Log.TestExecutionEnd();
    }

    public void takeScreenShot(String name){
        Allure.addAttachment(name, new ByteArrayInputStream(((TakesScreenshot) DriverManagerTL.getDriver()).getScreenshotAs(OutputType.BYTES)));
    }

    public void navigateToURL(String url){
        DriverManagerTL.getDriver().get(url);
    }
}
