package mercuryTours;

import mercuryTours.pages.MercuryFlightsPage;
import mercuryTours.pages.MercuryHomePage;
import mercuryTours.pages.MercuryRegisterPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class FlightsTest extends BaseTest {

   /* @Test(description = "TC13_Home Page - Left Menu(Flights)_User is redirected to Flights Page. (After sign in")
    public void selectFlight(){
        MercuryHomePage.open(this.myDriver);
        MercuryHomePage mainPage = new MercuryHomePage(this.myDriver);
        MercuryRegisterPage regPage =  mainPage.goRegisterPage("register");
        String[] flightDetails = {"oneWay","2","Paris","June","2","London","June","25"};
        String[] flightPreferences = {"first","Unified Airlines"};
        MercuryFlightsPage flightsPage = regPage.getRegistrationDone().goFlightsPage("flights");
        MercurySelectFlight selectFlight = flightsPage.flightFinderFull(flightDetails,"first","Unified Airlines");
        Assert.assertTrue(selectFlight.isSelectFlightAvailable(),"Select Flight screen is ");
        selectFlight.selectDepartFlight(2);
        selectFlight.selectReturnFlight(1);
        selectFlight.goBookFlight();

    }*/

    @Test(priority = 0, description = "TC21_Home Page - Flights Page_Flight Details_Default fields")
    public void checkDefaultValues(){
        MercuryHomePage.open(this.myDriver);
        MercuryHomePage mainPage = new MercuryHomePage(this.myDriver);
        Calendar cal = Calendar.getInstance();
        String MonthDefaultValue = new SimpleDateFormat("MMM").format(cal.getTime());
        String DayDefaultValue = new SimpleDateFormat("dd").format(cal.getTime());
        MercuryRegisterPage regPage =  mainPage.goRegisterPage("register");
        String[] expectedValues = {"roundtrip","1 ","Acapulco",MonthDefaultValue,DayDefaultValue,"Acapulco",MonthDefaultValue,DayDefaultValue};
        MercuryFlightsPage flightsPage = regPage.getRegistrationDone().goFlightsPage("flights");
        Assert.assertTrue(flightsPage.checkIfFlightDetailsDefaultValuesAreTheExpected(expectedValues), "Default fields are correctly selected when user access to 'flight page'");
    }

    @Test(priority = 1, description = "TC22_Home Page - Flights Page_Flight Details_Radio button")
    public void checkTypeRadioButton(){
        MercuryHomePage.open(this.myDriver);
        MercuryHomePage mainPage = new MercuryHomePage(this.myDriver);
        MercuryRegisterPage regPage =  mainPage.goRegisterPage("register");
        MercuryFlightsPage flightsPage = regPage.getRegistrationDone().goFlightsPage("flights");
        Assert.assertTrue(flightsPage.isOneRadioDeselectedWhenOtherRadioIsSelected("oneWay"), "Only one 'Radio button' can be selected and 'Round Trip is the default selection");
    }

    @Test(priority = 2, description = "TC23_Home Page - Flights Page_Flight Details_Passengers dropdown")
    public void validatePassengersDropdown(){
        MercuryHomePage.open(this.myDriver);
        MercuryHomePage mainPage = new MercuryHomePage(this.myDriver);
        String[] expectedDropDownOptions = {"1","2","3","4"};
        String expectedDropDownDefaultValue = "1";
        MercuryRegisterPage regPage =  mainPage.goRegisterPage("register");
        MercuryFlightsPage flightsPage = regPage.getRegistrationDone().goFlightsPage("flights");
        //flightsPage.checkPassengers(expectedDropDownDefaultValue,expectedDropDownOptions);
        Assert.assertTrue(flightsPage.validateDetailsDropdowns(expectedDropDownDefaultValue,expectedDropDownOptions,"passengerSel"), "Passengers dropdown has 1 to 4 options available and 1 is the default selection");
    }

    @Test(priority = 3, description = "TC24_Home Page - Flights Page_Flight Details_Departing from dropdown")
    public void validateDepartingDropdown(){
        MercuryHomePage.open(this.myDriver);
        MercuryHomePage mainPage = new MercuryHomePage(this.myDriver);
        String[] expectedDropDownOptions = {"Acapulco","Frankfurt","London","New York","Paris","Portland","San Francisco","Seattle","Sydney","Zurich"};
        String expectedDropDownDefaultValue = "Acapulco";
        MercuryRegisterPage regPage =  mainPage.goRegisterPage("register");
        MercuryFlightsPage flightsPage = regPage.getRegistrationDone().goFlightsPage("flights");

        Assert.assertTrue(flightsPage.validateDetailsDropdowns(expectedDropDownDefaultValue,expectedDropDownOptions,"departingFromSel"), "Departing from dropdown works correctly and Acapulco is the default selection");
    }

    @Test(priority = 4, description = "TC25_Home Page - Flights Page_Flight Details_On' dropdowns")
    public void validateOnDropdown(){
        MercuryHomePage.open(this.myDriver);
        MercuryHomePage mainPage = new MercuryHomePage(this.myDriver);
        Calendar cal = Calendar.getInstance();
        System.out.println(new SimpleDateFormat("MMM").format(cal.getTime()));
        String[] expectedDropDownOnMonthOptions = {"January","February","March","April","May","June","July","August","September","October","November","December"};
        String[] expectedDropDownOnDayOptions = {"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
        String expectedDropDownOnMonthDefaultValue = new SimpleDateFormat("MMM").format(cal.getTime());
        String expectedDropDownOnDayDefaultValue = new SimpleDateFormat("dd").format(cal.getTime());
        MercuryRegisterPage regPage =  mainPage.goRegisterPage("register");
        MercuryFlightsPage flightsPage = regPage.getRegistrationDone().goFlightsPage("flights");
        Assert.assertTrue(flightsPage.validateDetailsDropdowns(expectedDropDownOnMonthDefaultValue,expectedDropDownOnMonthOptions,"onMonthSel"), " 'On' Month dropdown works correctly and current date is the default selection");
        Assert.assertTrue(flightsPage.validateDetailsDropdowns(expectedDropDownOnDayDefaultValue,expectedDropDownOnDayOptions,"onDaySel"), " 'On' Day dropdown works correctly and current date is the default selection");
    }

    @Test(priority = 5, description = "TC26_Home Page - Flights Page_Flight Details_Arriving In' dropdown")
    public void validateArrivingDropdown(){
        MercuryHomePage.open(this.myDriver);
        MercuryHomePage mainPage = new MercuryHomePage(this.myDriver);
        String[] expectedDropDownOptions = {"Acapulco","Frankfurt","London","New York","Paris","Portland","San Francisco","Seattle","Sydney","Zurich"};
        String expectedDropDownDefaultValue = "Frankfurt";
        MercuryRegisterPage regPage =  mainPage.goRegisterPage("register");
        MercuryFlightsPage flightsPage = regPage.getRegistrationDone().goFlightsPage("flights");

        Assert.assertTrue(flightsPage.validateDetailsDropdowns(expectedDropDownDefaultValue,expectedDropDownOptions,"arrivingInSel"), "Arriving dropdown works correctly and Frankfurt is the default selection");
    }

    @Test(priority = 6, description = "TC27_Home Page - Flights Page_Flight Details_Returning' dropdowns")
    public void validateReturningDropdown(){
        MercuryHomePage.open(this.myDriver);
        MercuryHomePage mainPage = new MercuryHomePage(this.myDriver);
        Calendar cal = Calendar.getInstance();
        System.out.println(new SimpleDateFormat("MMM").format(cal.getTime()));
        String[] expectedDropDownOnMonthOptions = {"January","February","March","April","May","June","July","August","September","October","November","December"};
        String[] expectedDropDownOnDayOptions = {"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
        String expectedDropDownOnMonthDefaultValue = new SimpleDateFormat("MMM").format(cal.getTime());
        String expectedDropDownOnDayDefaultValue = new SimpleDateFormat("dd").format(cal.getTime());
        MercuryRegisterPage regPage =  mainPage.goRegisterPage("register");
        MercuryFlightsPage flightsPage = regPage.getRegistrationDone().goFlightsPage("flights");
        Assert.assertTrue(flightsPage.validateDetailsDropdowns(expectedDropDownOnMonthDefaultValue,expectedDropDownOnMonthOptions,"returningMonthSel"), " 'Returning' Month dropdown works correctly and current date is the default selection");
        Assert.assertTrue(flightsPage.validateDetailsDropdowns(expectedDropDownOnDayDefaultValue,expectedDropDownOnDayOptions,"returningDaySel"), " 'Returning' Day dropdown works correctly and current date is the default selection");
    }

    @Test(priority = 7, description = "TC28_Home Page - Preferences_Only one option is allowed to select on Service Class section")
    public void validateServiceClassRadio(){
        MercuryHomePage.open(this.myDriver);
        MercuryHomePage mainPage = new MercuryHomePage(this.myDriver);
        MercuryRegisterPage regPage =  mainPage.goRegisterPage("register");
        MercuryFlightsPage flightsPage = regPage.getRegistrationDone().goFlightsPage("flights");
        Assert.assertTrue(flightsPage.isOneServiceClassRadioDeselectedWhenOtherRadioIsSelected("first"), "Only one option is allowed to be selected, the radio button option is highlighted when the option is selected and the other options are not");
    }

    @Test(priority = 8, description = "TC29_Home Page - Preferences_Only one option is allowed to select on Airline dropdown")
    public void validateAirlineDropdown(){
        MercuryHomePage.open(this.myDriver);
        MercuryHomePage mainPage = new MercuryHomePage(this.myDriver);
        String[] expectedDropDownOptions = {"No Preference","Blue Skies Airlines","Unified Airlines","Pangea Airlines"};
        String expectedDropDownDefaultValue = "No Preference";
        MercuryRegisterPage regPage =  mainPage.goRegisterPage("register");
        MercuryFlightsPage flightsPage = regPage.getRegistrationDone().goFlightsPage("flights");

        Assert.assertTrue(flightsPage.validatePreferencesDropdowns(expectedDropDownDefaultValue,expectedDropDownOptions,"airlineSel"), "Only one option is allowed to be selected on the dropdown field, and the option selected is displayen on the field");
    }

    @Test(priority = 9, description = "TC29_Home Page - Preferences_Preferences default options")
    public void validateFlightPreferencesDefaultValues(){
        MercuryHomePage.open(this.myDriver);
        MercuryHomePage mainPage = new MercuryHomePage(this.myDriver);
        String expectedServiceClassDefaultValue = "Economy Class";
        String expectedAirlineDefaultValue = "No Preference";
        MercuryRegisterPage regPage =  mainPage.goRegisterPage("register");
        MercuryFlightsPage flightsPage = regPage.getRegistrationDone().goFlightsPage("flights");
        Assert.assertTrue(flightsPage.checkIfFlightPreferencesDefaultValuesAreTheExpected(expectedServiceClassDefaultValue,expectedAirlineDefaultValue), "Preferences has default options selected");
    }

    @Test(priority = 10, description = "TC30_Home Page - Preferences_Select Continue button")
    public void validateIfContinueButtonIsDisplayed(){
        MercuryHomePage.open(this.myDriver);
        MercuryHomePage mainPage = new MercuryHomePage(this.myDriver);
        MercuryRegisterPage regPage =  mainPage.goRegisterPage("register");
        MercuryFlightsPage flightsPage = regPage.getRegistrationDone().goFlightsPage("flights");
        Assert.assertTrue(flightsPage.isContinueButtonVisible(), "\"Continue\" button, \"Select flight\" page is displayed");
    }
}
