package com.vwo.base;

import com.vwo.utils.DriverManagerTL;
import com.vwo.utils.Log;
import com.vwo.utils.WaitForHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import javax.swing.*;
import java.sql.Driver;
import java.util.List;

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
    public void inputText(By locator, String text){
        DriverManagerTL.getDriver().findElement(locator).clear();
        DriverManagerTL.getDriver().findElement(locator).sendKeys(text);
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

    public void selectOptionFromDropdown(By element, String option) throws InterruptedException {
        Thread.sleep(3000);
        List<WebElement> list = DriverManagerTL.getDriver().findElements(element);
        for(WebElement elements : list){
            if (elements.getText().equalsIgnoreCase(option)){
                elements.click();
                Thread.sleep(1000);
                Log.info("Option selected from dropdown - "+elements.getText());
                break;
            }
        }
    }

    public void dropdownSelectByValue(By element, String value){
        WebElement Element = DriverManagerTL.getDriver().findElement(element);
        Select dropdown = new Select(Element);
        dropdown.selectByValue(value);
    }

    public void moveToElement(By element){
        Actions actions = new Actions(DriverManagerTL.getDriver());
        WebElement Element = DriverManagerTL.getDriver().findElement(element);
        actions.moveToElement(Element).build().perform();
    }

    public void uploadFile(By element, String filepath){
        DriverManagerTL.getDriver().findElement(element).sendKeys(filepath);
    }

    public void moveToElementAndSendKeys(By element, String text){
        Actions actions = new Actions(DriverManagerTL.getDriver());
        WebElement Element = DriverManagerTL.getDriver().findElement(element);
        actions.moveToElement(Element).click().sendKeys(text).build().perform();
    }


    public void waitForVisibilityOfElement(By element){
        new WaitForHelper(DriverManagerTL.getDriver()).visibiltiyOfElement(element);
    }

    public void waitForInvisibilityOfElement(By element){
        new WaitForHelper(DriverManagerTL.getDriver()).inVisibiltiyOfElement(element);
    }

    public void waitForElementToBeClickable(By element){
        new WaitForHelper(DriverManagerTL.getDriver()).elementToBeClickable(element);
    }

    public void waitForTextToBePresentInElement(By element, String text){
        new WaitForHelper(DriverManagerTL.getDriver()).textToBePresentInElement(element, text);
    }

    public void waitForVisibiltiyOfElementAllElements(By element){
        new WaitForHelper(DriverManagerTL.getDriver()).visibiltiyOfElementAllElements(element);
    }
}
