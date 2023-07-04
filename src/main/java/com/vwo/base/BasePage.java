package com.vwo.base;

import com.vwo.utils.DriverManagerTL;
import com.vwo.utils.WaitForHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.sql.Driver;

public class BasePage {

    protected BasePage(){
    }
    

    // Navigate
    public void navigateToURL(String url){
        DriverManagerTL.getDriver().get(url);
    }

    // Get Title
    public String getPageTitle(){
        return DriverManagerTL.getDriver().getTitle();
    }

    // Click a WebElement
    public void click(By element){
        DriverManagerTL.getDriver().findElement(element).click();
    }

    public void click(WebElement element){
        element.click();
    }

    // Write a text
    public void inputText(By element, String text){
        DriverManagerTL.getDriver().findElement(element).clear();
        DriverManagerTL.getDriver().findElement(element).sendKeys(text);
    }

    public void inputText(WebElement element, String text){
        element.clear();
        element.sendKeys(text);
    }

    // Read/Get Text
    public String getText(By element){
        return DriverManagerTL.getDriver().findElement(element).getText();
    }

    // Wait for element to appear
    public void waitForPresenceOfElement(By element){
        new WaitForHelper(DriverManagerTL.getDriver()).presenceOfElement(element);
    }

    public void waitForVisibilityOfElement(By element){
        new WaitForHelper(DriverManagerTL.getDriver()).visibiltiyOfElement(element);
    }

}
