package com.vwo.pages;

import com.vwo.base.BasePage;
import com.vwo.utils.DriverManagerTL;
import com.vwo.utils.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class ProfileDetails extends BasePage {

    public ProfileDetails(){
    }

    // Page Locators
    By profileDetailsHeader = By.xpath("//h2[text()='Profile Details']");
    By phoneNumber = By.id("pd-phone-number");
    By country = By.xpath("//div[@data-qa='pudutubeli']");
    By countryInput = By.xpath("//input[@data-qa='suveleceyo']");
    By countrySearchResult = By.xpath("/html/body/vwo-transclude[2]/menu-content/div[2]/div/div[3]/div/ul/li");
    By department = By.xpath("//div[@data-qa='buyuhabamo']");
    By departmentList = By.xpath("//html/body/vwo-transclude[2]/menu-content/div[2]/div/div[2]/div/ul/li");
    By departmentName = By.xpath("/html/body/vwo-transclude[2]/menu-content/div[2]/div/div[2]/div/ul/li[2]/div/vwo-transclude/option-slot");
    By roleList = By.xpath("/html/body/vwo-transclude[1]/menu-content/div[2]/div/div[2]/div/ul/li");
    By roleName = By.xpath("/html/body/vwo-transclude/menu-content/div[2]/div/div[2]/div/ul/li[4]/div/vwo-transclude/option-slot");
    By role = By.xpath("//div[@data-qa='monorolono']");
    By saveButton = By.xpath("//button[@data-qa='fovecisuhi']");
    By uploadImage = By.id("profile-picture-upload");
    By uploadButton = By.xpath("/html/body/vwo-modal-component/div/div[3]/div[4]/modal-footer/div/button[2]");
    By profilePicturePreview = By.xpath("//img[@alt='Profile Picture Preview']");

    // Page Actions

    public void editPhoneNo(String phoneNo){
        waitForVisibilityOfElement(profileDetailsHeader);
        inputText(phoneNumber, phoneNo);
        Log.info("PhoneNo edited successfully");
    }

    public void selectCountry(String searchKey, String countryValue) throws Exception {
        try{
            click(country);
            waitForVisibilityOfElement(countryInput);
            moveToElementAndSendKeys(countryInput, searchKey);
            selectOptionFromDropdown(countrySearchResult, countryValue);
            Log.info("Country edited successfully");
        }
        catch (Exception e){
            e.printStackTrace();
            Log.error("Failed to edit country");
        }
    }

    public void selectDepartment(String departmentValue) throws InterruptedException {
        try{
            click(department);
            click(departmentName);
            // waitForVisibiltiyOfElementAllElements(departmentList);
            // selectOptionFromDropdown(departmentList, departmentValue);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public void selectRole(String roleValue) throws InterruptedException {
        try{
            click(role);
            click(roleName);
            // waitForVisibiltiyOfElementAllElements(departmentList);
            // selectOptionFromDropdown(roleList, roleValue);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public void uploadProfileImage(String filePath){
        try{
            uploadFile(uploadImage, filePath);
            waitForVisibilityOfElement(uploadButton);
            click(uploadButton);
            waitForVisibilityOfElement(profilePicturePreview);
            Log.info("Profile Picture Edited successfully");
        }
        catch (Exception e){
            e.printStackTrace();
            Log.error("Failed to Upload/Save Profile picture");
        }
    }

    public void saveProfile(){
        try{
            waitForPresenceOfElement(saveButton);
            click(saveButton);
            waitForInvisibilityOfElement(saveButton);
            Log.info("Profile Edit saved !");
        }
        catch (Exception e){
            e.printStackTrace();
            Assert.fail("Failed to save profile");
        }
    }

}
