package com.vwo.tests;

import com.vwo.base.BaseTest;
import com.vwo.pages.Dashboard;
import com.vwo.pages.LoginPage;
import com.vwo.pages.ProfileDetails;
import com.vwo.utils.Log;
import com.vwo.utils.PropertyReader;
import org.testng.annotations.Test;

public class EditProfileTest extends BaseTest {

    public EditProfileTest(){
        super();
    }


    @Test
    public void TC02_testEditUserProfile() throws Exception {
        Log.startTestCase("TC02_testEditUserProfile");
        navigateToURL(PropertyReader.readKey("url"));
        ProfileDetails profileDetails = new LoginPage().loginToVWO().afterSuccessfulLogin().openEditProfile();
        Log.info("Edit Profile page opened");
        profileDetails.editPhoneNo(PropertyReader.readKey("phoneNo"));
        profileDetails.selectCountry(PropertyReader.readKey("countrySearchKeyword"),PropertyReader.readKey("country"));
        // profileDetails.selectDepartment("IT/Technical");
        // profileDetails.selectRole("Manager");
        profileDetails.uploadProfileImage(PropertyReader.readKey("profilePicPath"));
        profileDetails.saveProfile();
        Thread.sleep(3000);
        Log.endTestCase("TC02_testEditUserProfile");
    }
}
