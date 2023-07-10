package com.vwo.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class WaitForHelper {

    public WebDriver driver;
    public WaitForHelper(WebDriver driver){
        this.driver = driver;
    }

    public void implicitlyWait(){
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public WebElement presenceOfElement(By elementLocation){
        return new WebDriverWait(driver, Duration.ofSeconds(3000)).until(ExpectedConditions.presenceOfElementLocated(elementLocation));
    }

    public WebElement elementToBeClickable( By elementIdentifier){
        WebElement element = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(elementIdentifier));
        return element;
    }

    public WebElement visibiltiyOfElement(By element){
        return new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(element));
    }

    public Boolean inVisibiltiyOfElement(By element){
        return new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.invisibilityOfElementLocated(element));
    }

    public Boolean textToBePresentInElement(By element, String text){
        return new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.textToBePresentInElementLocated(element, text));
    }

    public List<WebElement> visibiltiyOfElementAllElements(By element){
        return new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(element));
    }
}
