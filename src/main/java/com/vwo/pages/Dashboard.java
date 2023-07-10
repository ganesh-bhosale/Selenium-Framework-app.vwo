package com.vwo.pages;

import com.vwo.base.BasePage;
import com.vwo.utils.DriverManagerTL;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Dashboard extends BasePage {

    public Dashboard(){
    }

    // Page Locators
    By userNameOnDashboard = By.cssSelector("[data-qa=\"lufexuloga\"]");
    By userMenu = By.cssSelector("[data-qa='user-image']");
    By editProfileOption = By.xpath("//li[text()='Edit Profile']");

    // Page Actions
    public String loggedInUserName(){
        waitForVisibilityOfElement(userNameOnDashboard);
        return getText(userNameOnDashboard);
    }

    public String getDashboardPageTitle(){
        return getPageTitle();
    }

    public void editProfile(){
        waitForVisibilityOfElement(userNameOnDashboard);
        click(userMenu);
        click(editProfileOption);
    }

    public ProfileDetails openEditProfile(){
        editProfile();
        return new ProfileDetails();
    }
}
