package mercuryTours;

import io.qameta.allure.Feature;
import mercuryTours.pages.*;
import org.testng.Assert;
import io.qameta.allure.Epic;
import org.testng.annotations.Test;

@Epic("Home Page Testing")
@Feature("Testing Home Page basic features")
public class homeTest extends BaseTest{

    @Test(priority = 0, description = "TC12_Home Page - Left Menu(Flights)_User is redirected to Flights Page. Without sign in")

    public void usingLeftMenuToGoFlightsPageNoSignIn(){
        MercuryHomePage.open(this.myDriver);
        MercuryHomePage mainPage = new MercuryHomePage(this.myDriver);
        MercuryFlightsPage flightsPage = mainPage.goFlightsPage();
        Assert.assertFalse(flightsPage.isFlightDetailSectionAvailable(),"Access to Flights page is refused and redirected to Home page.");
    }

    @Test(priority = 1, description = "TC13_Home Page - Left Menu(Flights)_User is redirected to Flights Page. (After sign in")
    public void usingLeftMenuToGoFlightsPageSignIn(){
        MercuryHomePage.open(this.myDriver);
        MercuryHomePage mainPage = new MercuryHomePage(this.myDriver);
        MercuryRegisterPage regPage =  mainPage.goRegisterPage();
        String expectedMessage1 = "Dear ,";
        MercuryFlightsPage flightsPage = regPage.getRegistrationDone().goFlightsPage("flights");
        Assert.assertTrue(flightsPage.isFlightDetailSectionAvailable(),"Access to Flights page is granted and redirected to Flights page.");
    }

    @Test(priority = 2, description = "TC14_Home Page - Left Menu(Cruises)_User is redirected to Cruises Page")
    public void usingLeftMenuToGoCruisesPageSignIn(){
        MercuryHomePage.open(this.myDriver);
        MercuryHomePage mainPage = new MercuryHomePage(this.myDriver);
        MercuryCruisesPage cruisesPage = mainPage.goCruisesPage();
        Assert.assertTrue(cruisesPage.isCruisesHeaderAvailable(),"User is redirected to Cruises page.");
    }

    @Test(priority = 3, description = "TC15_Home Page - Top Menu(Sign-ON)_User is redirected to Sign-On Page")
    public void usingTopMenuToSignOnPage(){
        MercuryHomePage.open(this.myDriver);
        MercuryHomePage mainPage = new MercuryHomePage(this.myDriver);
        mainPage.isSigOnTopMenuOptionAvailable();
        MercurySignOnPage signOnPage = mainPage.goSignOnPage();
        Assert.assertTrue(signOnPage.verifyWelcomeMsg(),"User is redirected to Sign-On page.");
    }

    @Test(priority = 4, description = "TC16_Home Page - Top Menu(Register)_User is redirected to Register Page")
    public void usingTopMenuToRegisterPage(){
        MercuryHomePage.open(this.myDriver);
        MercuryHomePage mainPage = new MercuryHomePage(this.myDriver);
        MercuryRegisterPage regPage =  mainPage.goRegisterPage();
        Assert.assertTrue(regPage.isHeaderVisible(),"User is redirected to Register page.");
    }

    @Test(priority = 5, description = "TC17_Home Page - Top Menu(Support)_User is redirected to Under Construction page.")
    public void usingTopMenuToSupportPage(){
        MercuryHomePage.open(this.myDriver);
        MercuryHomePage mainPage = new MercuryHomePage(this.myDriver);
        MercuryUnderConstructionPage underConstructionPage =  mainPage.goSupportPage();
        Assert.assertTrue(underConstructionPage.isUnderConstructionHeaderAvailable(),"User is redirected to Under Construction page.");
    }

    @Test(priority = 6, description = "TC17_Home Page - Top Menu(Contact)_User is redirected to Under Construction page.")
    public void usingTopMenuToContactPage(){
        MercuryHomePage.open(this.myDriver);
        MercuryHomePage mainPage = new MercuryHomePage(this.myDriver);
        MercuryUnderConstructionPage underConstructionPage =  mainPage.goContactPage();
        Assert.assertTrue(underConstructionPage.isUnderConstructionHeaderAvailable(),"User is redirected to Under Construction page.");
    }
}
