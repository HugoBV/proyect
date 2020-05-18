package mercuryTours;

import mercuryTours.pages.MercuryHomePage;
import mercuryTours.pages.MercurySignOnPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class signOnTest extends BaseTest{

    @Test(priority = 0, description = "TC06_Sing-In_Validate \"Welcome Message\"")
    public void validateWelcomeMessage(){
        MercuryHomePage.open(this.myDriver);
        MercuryHomePage mainPage = new MercuryHomePage(this.myDriver);
        MercurySignOnPage signOnPage = mainPage.goSignOnPage("signOn");
        Assert.assertTrue(signOnPage.verifyWelcomeMsg(),"Welcome message is shown");
    }

    @Test(priority = 1, description = "TC07_Sing-In_Validate the \"registration form\" link")
    public void goRegisterPageByClickingRegisterLink(){
        MercuryHomePage.open(this.myDriver);
        MercuryHomePage mainPage = new MercuryHomePage(this.myDriver);
        MercurySignOnPage signOnPage = mainPage.goSignOnPage("signOn");
        Assert.assertTrue(signOnPage.checkRegisterLink().isHeaderVisible(),"User should be redirected to the \"Registration Page\"");

    }

    @Test(priority = 2, description = "TC08_Validate that the user can log-in with valid user and password")
    public void registerUsingValidData(){
        MercuryHomePage.open(this.myDriver);
        MercuryHomePage mainPage = new MercuryHomePage(this.myDriver);
        MercurySignOnPage signOnPage = mainPage.goSignOnPage("signOn");
        Assert.assertTrue(signOnPage.signIn("User","Pass").isSpecialSectionAvailable(),"User should be logged in correctly and redirected to the \"HOME PAGE\"");
    }

    @Test(priority = 3, description = "TC09_Validate that the user can't log-in with invalid username and password")
    public void registerUsingInvalidData(){
        MercuryHomePage.open(this.myDriver);
        MercuryHomePage mainPage = new MercuryHomePage(this.myDriver);
        MercurySignOnPage signOnPage = mainPage.goSignOnPage("signOn");
        Assert.assertFalse(signOnPage.signIn(),"Error message \"Invalid username or password\" should be displayed");
    }

    @Test(priority = 4, description = "TC10_Validate that \"User Name\" field is mandatory")
    public void validateThatUserNameIsMandatory(){
        MercuryHomePage.open(this.myDriver);
        MercuryHomePage mainPage = new MercuryHomePage(this.myDriver);
        MercurySignOnPage signOnPage = mainPage.goSignOnPage("signOn");
        Assert.assertTrue(signOnPage.signIn("","Pass").isSpecialSectionAvailable(),"\"Mandatory field 'User Name' is missing \" error message should be displayed");
    }

    @Test(priority = 5, description = "TC11_Validate that \"Password\" field is mandatory")
    public void validateThatPasswordIsMandatory(){
        MercuryHomePage.open(this.myDriver);
        MercuryHomePage mainPage = new MercuryHomePage(this.myDriver);
        MercurySignOnPage signOnPage = mainPage.goSignOnPage("signOn");
        Assert.assertTrue(signOnPage.signIn("User","").isSpecialSectionAvailable(),"\"Mandatory field 'Password' is missing \" error message should be displayed");
    }

    @Test(priority = 6, description = "TC12_Validate copyright Message")
    public void validateCopyrightMessage(){
        MercuryHomePage.open(this.myDriver);
        MercuryHomePage mainPage = new MercuryHomePage(this.myDriver);
        MercurySignOnPage signOnPage = mainPage.goSignOnPage("signOn");
        Assert.assertTrue(signOnPage.verifyCopyright(),"Copyright message should match");

    }
}
