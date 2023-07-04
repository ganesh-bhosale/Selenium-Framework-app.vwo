package com.vwo.tests;

import com.vwo.base.BaseTest;
import com.vwo.pages.Dashboard;
import com.vwo.pages.LoginPage;
import com.vwo.utils.Log;
import com.vwo.utils.PropertyReader;
import io.qameta.allure.Description;
import org.apache.log4j.xml.DOMConfigurator;
import org.testng.Assert;
import org.testng.annotations.Test;


public class LoginTest extends BaseTest {

    public LoginTest(){
        super();
    }



    @Test
    @Description("Enter the username and Wrong Password and Click on Sign In. Verify that the Dashboard is Not visible and Error Message is displayed")
    public void testWithInvalidCredentials() throws Exception {
        Log.startTestCase("TC01_testWithInvalidCredentials");
        navigateToURL(PropertyReader.readKey("url"));
        LoginPage loginPage = new LoginPage();
        String errMsg = loginPage.failLogin(PropertyReader.readKey("username"), "Pass@123");
        Log.info(errMsg);
        // Verify Error msg for failed login;
        Assert.assertEquals(errMsg, "Your email, password, IP address or location did not match");
        Log.endTestCase("TC01_testWithInvalidCredentials");
    }

    @Test
    @Description("Enter the valid Email and Password and Click on Submit and Verify that the Dashboard is visible")
    public void testWithValidCredentials() throws Exception {
        try{
        Log.startTestCase("TC02_testWithValidCredentials");
        navigateToURL(PropertyReader.readKey("url"));
        LoginPage loginPage = new LoginPage();
        Dashboard dashboardPage = loginPage.
                loginToVWO(PropertyReader.readKey("username"), PropertyReader.readKey("password"))
                .afterSuccessfulLogin();

        // Verify loggedIn username
        Log.info("Verify logged in username");
        String loggedUsername =dashboardPage.loggedInUserName();
        Log.info("Logged in user : "+loggedUsername);
        Assert.assertEquals(loggedUsername, PropertyReader.readKey("expectedUserName"));
        String dashboardPageTitle = dashboardPage.getDashboardPageTitle();

        // Verify Dashboard page title after successful login
        Assert.assertEquals(dashboardPageTitle, "Dashboard");
        Log.endTestCase("TC02_testWithValidCredentials");
        }
        catch (Exception e){
            e.printStackTrace();
            Log.error("Failed to login");
        }
    }

}
