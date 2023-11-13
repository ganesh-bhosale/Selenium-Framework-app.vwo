package com.vwo.pages;

import com.vwo.base.BasePage;
import com.vwo.utils.Log;
import com.vwo.utils.PropertyReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
    WebDriver driver;

    // Setting up or passing driver to the BasePage constructor
    public LoginPage(){
        super();
    }

    // 1) Page Locators
    By userName = By.id("login-username");
    By passWord = By.id("login-password");
    By signInButton = By.id("js-login-btn");
    By errorMsg = By.id("js-notification-box-msg");

    // 2) Page Actions
    public void inputUsername(String username){
        inputText(userName, username);
    }

    public void inputPassword(String password){
        inputText(passWord, password);
    }

    public void clickSignInButton(){
        click(signInButton);
    }

    public LoginPage loginToVWO() throws Exception {
        Log.info("Logging into application");
        inputUsername(PropertyReader.readKey("username"));
        inputPassword(PropertyReader.readKey("password"));
        clickSignInButton();
        Log.info("Logged in successfully");
        return this;
    }

    public Dashboard afterSuccessfulLogin(){
        return new Dashboard();
    }

    public String failLogin() throws Exception {
        Log.info("Logging into application");
        inputUsername(PropertyReader.readKey("username"));
        inputPassword(PropertyReader.readKey("incorrectPass"));
        clickSignInButton();
        waitForVisibilityOfElement(errorMsg);
        Log.error("Failed to Login into application");
        return getText(errorMsg);
    }


}
