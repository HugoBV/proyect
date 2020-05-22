package mercuryTours;

import mercuryTours.pages.MercuryFlightsPage;
import mercuryTours.pages.MercuryHomePage;
import mercuryTours.pages.MercuryRegisterPage;
import mercuryTours.pages.MercurySelectFlightPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Map;

public class SelectFlightTest extends BaseTest{

    @Test(priority = 0, description = "TC31_Home Page - Select Flight_Depart table columns and default values")
    public void checkDepartTable(){
        MercuryHomePage.open(this.myDriver);
        MercuryHomePage mainPage = new MercuryHomePage(this.myDriver);
        MercuryRegisterPage regPage =  mainPage.goRegisterPage("register");
        MercuryFlightsPage flightsPage = regPage.getRegistrationDone().goFlightsPage("flights");
        MercurySelectFlightPage selectFlightPage = flightsPage.continueToSelectFlight();
        Assert.assertTrue(selectFlightPage.checkDepartFlightTableColumns(0), "Depart table columns and default values are the expected ones");
    }

    @Test(priority = 1, description = "TC32_Home Page - Select Flight_Return table columns and default values")
    public void checkReturnTable(){
        MercuryHomePage.open(this.myDriver);
        MercuryHomePage mainPage = new MercuryHomePage(this.myDriver);
        MercuryRegisterPage regPage =  mainPage.goRegisterPage("register");
        MercuryFlightsPage flightsPage = regPage.getRegistrationDone().goFlightsPage("flights");
        MercurySelectFlightPage selectFlightPage = flightsPage.continueToSelectFlight();
        Assert.assertTrue(selectFlightPage.checkReturnFlightTableColumns(0), "Return table columns and default values are the expected ones");
    }
}

