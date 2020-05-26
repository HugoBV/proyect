package mercuryTours;

import mercuryTours.pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class bookAFlightTest extends BaseTest{

    @Test(priority = 1, description = "TC36_BookFlightPage_Verify_Mandatory Values Presence")
    public void verifyMandatoryFields(){
        MercuryHomePage.open(this.myDriver);
        MercuryHomePage mainPage = new MercuryHomePage(this.myDriver);
        MercuryBookFlightPage bookAFlight = mainPage.goRegisterPage().getRegistrationDone().goFlightsPage("flights").continueToSelectFlight().goBookFlight();
        Assert.assertTrue(bookAFlight.verifyMandatoryFields("red"),"Mandatory Fields should be red");

    }

    @Test(priority = 2, description = "TC37_BookFlightPage_Verify_Non mandatory Values Presence")
    public void verifyNonMandatoryFields(){
        MercuryHomePage.open(this.myDriver);
        MercuryHomePage mainPage = new MercuryHomePage(this.myDriver);
        MercuryBookFlightPage bookAFlight = mainPage.goRegisterPage().getRegistrationDone().goFlightsPage("flights").continueToSelectFlight().goBookFlight();
        bookAFlight.getSummaryDepartInfo();
        bookAFlight.fillBookAFlightFormWithDefValues("QAminds");
    }



}
