package mercuryTours;

import mercuryTours.pages.*;
import net.bytebuddy.implementation.bytecode.assign.TypeCasting;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Map;

public class SelectFlightTest extends BaseTest{

    @Test(priority = 0, description = "TC31_Home Page - Select Flight_Depart table columns and default values")
    public void checkDepartTable(){
        MercuryHomePage.open(this.myDriver);
        MercuryHomePage mainPage = new MercuryHomePage(this.myDriver);
        MercuryRegisterPage regPage =  mainPage.goRegisterPage();
        MercuryFlightsPage flightsPage = regPage.getRegistrationDone().goFlightsPage("flights");
        MercurySelectFlightPage selectFlightPage = flightsPage.continueToSelectFlight();
        Assert.assertTrue(selectFlightPage.checkDepartFlightTableColumns(0), "Depart table columns and default values are the expected ones");
    }

    @Test(priority = 1, description = "TC32_Home Page - Select Flight_Return table columns and default values")
    public void checkReturnTable(){
        MercuryHomePage.open(this.myDriver);
        MercuryHomePage mainPage = new MercuryHomePage(this.myDriver);
        MercuryRegisterPage regPage =  mainPage.goRegisterPage();
        MercuryFlightsPage flightsPage = regPage.getRegistrationDone().goFlightsPage("flights");
        MercurySelectFlightPage selectFlightPage = flightsPage.continueToSelectFlight();
        Assert.assertTrue(selectFlightPage.checkReturnFlightTableColumns(0), "Return table columns and default values are the expected ones");
    }

    @Test(priority = 3, description = "TC37_BookFlightPage_Verify_Non mandatory Values Presence")
    public void verifyDepartTable(){
        MercuryHomePage.open(this.myDriver);
        MercuryHomePage mainPage = new MercuryHomePage(this.myDriver);

        Calendar cal = Calendar.getInstance();
        String depMonth = new SimpleDateFormat("MMMM").format(cal.getTime());
        String depDay = new SimpleDateFormat("dd").format(cal.getTime());
        cal.add(Calendar.DATE, 20);
        String retMonth = new SimpleDateFormat("MMMM").format(cal.getTime());
        String retDay = new SimpleDateFormat("dd").format(cal.getTime());
        String[] flightDetailsValues = {"roundTrip","1 ","London",depMonth,depDay,"Sydney",retMonth,retDay,"business","Pangea Airlines"};
        MercuryFlightsPage flightsFinder = mainPage.goRegisterPage().getRegistrationDone().goFlightsPage("flights");
        flightsFinder.fillFlightFinderForm(flightDetailsValues);
        MercurySelectFlightPage selectFlightPage = flightsFinder.continueToSelectFlight();
        selectFlightPage.selectDepartFlight(2);
        selectFlightPage.selectReturnFlight(3);

    }


}

