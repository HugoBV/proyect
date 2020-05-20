package mercuryTours;

import mercuryTours.pages.MercuryFlightsPage;
import mercuryTours.pages.MercuryHomePage;
import mercuryTours.pages.MercuryRegisterPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FlightsTest extends BaseTest {

    @Test(description = "TC13_Home Page - Left Menu(Flights)_User is redirected to Flights Page. (After sign in")
    public void selectFlight(){
        MercuryHomePage.open(this.myDriver);
        MercuryHomePage mainPage = new MercuryHomePage(this.myDriver);
        MercuryRegisterPage regPage =  mainPage.goRegisterPage("register");
        String[] flightDetails = {"oneWay","2","Paris","June","2","London","June","25"};
        String[] flightPreferences = {"first","Unified Airlines"};
        MercuryFlightsPage flightsPage = regPage.getRegistrationDone().goFlightsPage("flights");
        Assert.assertTrue(flightsPage.flightFinderFull(flightDetails,"first","Unified Airlines").isSelectFlightAvailable(),"Select Flight screen is ");
    }
}
