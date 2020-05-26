package mercuryTours;

import mercuryTours.pages.*;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Objects;

public class E2ETest extends BaseTest {

    private final String CURR_YEAR = "2020";
    private final String[] HAPPY_PATH_REG_VALS = {"Fer", "Perez", "22323433-3", "asd@asdas.com", "Ave Siempre Viva", "1234", "Guadalajara", "Jalisco", "44350", "Mexico", "Boot", "camp"};
    private final String[] HAPPY_PATH_FLIGHTS_VALS = {"roundTrip", "1 ", "London", "June", "15", "Sydney", "June", "25", "business", "Pangea Airlines"};
    private final int[] FLIGHTS_SELECTIONS = {2, 3};
    private final String[] HAPPY_PATH_BOOK_VALS = {"DonC", "Perez ", "Kosher", "Carte Blanche", "4533560090991234", "07", "2007", "Fernando", "DonC", "Perez",
            "check", "Av. Siempre Viva 1245", "Prados", "Dallas", "TX", "90210", "215", "check", "Robles Gil 23", "La Villita", "Delaware", "PA", "10100", "215"};

    @Test(priority = 1, description = "Register Page: As a possible new user, I want to be able to create a new account with basic personal information, user name and password")
    public void TestCase_RegisterPage() {


        MercuryHomePage.open(this.myDriver);
        MercuryHomePage mercuryHomePage = new MercuryHomePage(this.myDriver);
        SoftAssert e2eSoftAssert = new SoftAssert();


        MercuryRegisterPage mercuryRegisterPage = mercuryHomePage.goRegisterPage();

        //Registration Page Asserting
        e2eSoftAssert.assertTrue(mercuryRegisterPage.checkIfContactFieldIsMandatoryAKARed("firstName"), "Register Page: Firs Name field is mandatory and should be displayed as red");
        e2eSoftAssert.assertTrue(mercuryRegisterPage.checkIfContactFieldIsMandatoryAKARed("lastName"), "Register Page: Last Name field is mandatory and should be displayed as red");
        e2eSoftAssert.assertTrue(mercuryRegisterPage.checkIfContactFieldIsMandatoryAKARed("phone"), "Register Page: Phone field is mandatory and should be displayed as red");
        e2eSoftAssert.assertTrue(mercuryRegisterPage.checkIfContactFieldIsMandatoryAKARed("email"), "Register Page: Email field is mandatory and should be displayed as red");
        e2eSoftAssert.assertTrue(mercuryRegisterPage.checkIfUserFieldIsMandatoryAKARed("userName"), "Register Page: User field is mandatory and should be displayed as red");
        e2eSoftAssert.assertTrue(mercuryRegisterPage.checkIfUserFieldIsMandatoryAKARed("password"), "Register Page: Password field is mandatory and should be displayed as red");
        e2eSoftAssert.assertTrue(mercuryRegisterPage.checkIfUserFieldIsMandatoryAKARed("confirmPassword"), "Register Page: Confirm Password field is mandatory and should be displayed as red");

        MercuryAccountCreatedPage accountCreatedPage = mercuryRegisterPage.getRegistrationDone(this.HAPPY_PATH_REG_VALS);

        e2eSoftAssert.assertTrue(accountCreatedPage.registrationMessageExpectedValue(HAPPY_PATH_REG_VALS[10]), "Account Created Page: After registering, a success message should appear as following: Dear <FristName> <Last Name>, ... Note: Your Name is <user name>");
        e2eSoftAssert.assertTrue(accountCreatedPage.isSignOffAvailable(), "Account Created Page: SIGN-ON Top Menu option is replaced by SIGN-OFF option.");
        e2eSoftAssert.assertTrue(accountCreatedPage.isSignInLinkAvailable(), "Account Created Page: Sign-in link is displayed along the success message.");
        accountCreatedPage.pressSignInLink();
        e2eSoftAssert.assertAll();



/*       HashMap<String,Boolean> myAsserts= mainPage.happyPath(mainPage);
        //Registration Page Asserting
        e2eSoftAssert.assertTrue(myAsserts.get("isFirstNameMandatory_RegPag"),"Register Page: Firs Name field is mandatory and should be displayed as red");
        e2eSoftAssert.assertTrue(myAsserts.get("isLastNameMandatory_RegPag"),"Register Page: Last Name field is mandatory and should be displayed as red");
        e2eSoftAssert.assertTrue(myAsserts.get("isPhoneMandatory_RegPag"),"Register Page: Phone field is mandatory and should be displayed as red");
        e2eSoftAssert.assertTrue(myAsserts.get("isEmailMandatory_RegPag"),"Register Page: Email field is mandatory and should be displayed as red");
        e2eSoftAssert.assertTrue(myAsserts.get("isUserNameMandatory_RegPag"),"Register Page: User field is mandatory and should be displayed as red");
        e2eSoftAssert.assertTrue(myAsserts.get("isPasswordMandatory_RegPag"),"Register Page: Password field is mandatory and should be displayed as red");
        e2eSoftAssert.assertTrue(myAsserts.get("isConfirmPasswordMandatory_RegPag"),"Register Page: Confirm Password field is mandatory and should be displayed as red");
        //Account created Page
        e2eSoftAssert.assertTrue(myAsserts.get("isExpectedSignInMsgDisplayed"),"Account Created Page: After registering, a success message should appear as following: Dear <FristName> <Last Name>, ...");
        e2eSoftAssert.assertTrue(myAsserts.get("isSignOffTopMenuOptionAvailableACP"),"Account Created Page: SIGN-ON Top Menu option is replaced by SIGN-OFF option.");
        e2eSoftAssert.assertTrue(myAsserts.get("isSignInLinkAvailable"),"Account Created Page: Sign-in link is displayed along the success message.");
        //Sign  Page
        e2eSoftAssert.assertTrue(myAsserts.get("isSignOnPageLoaded"),"Sig-ON Page: Sign-in link should take you to the Sign In Page");
        e2eSoftAssert.assertTrue(myAsserts.get("isSignOffTopMenuOptionAvailableSOP"),"Sig-ON Page: SIGN-ON Top Menu option is back.");
        e2eSoftAssert.assertTrue(myAsserts.get("isUserNameMandatory_SignOn"),"Sig-ON Page: User Name field is mandatory and should be displayed as red.");
        e2eSoftAssert.assertTrue(myAsserts.get("isPasswordMandatory_SignOn"),"Sig-ON Page: Password field is mandatory and should be displayed as red.");
        e2eSoftAssert.assertTrue(myAsserts.get("isSignOnPageLoadedWrongData"),"Sig-ON Page: Access is denied when using wrong data. Sign-On page is reloaded but showing not errors");
        //Home Page
       // e2eSoftAssert.assertTrue(myAsserts.get("isFlightsLeftMenuOptionAvailable_HOME"),"Home Page: Flights Left Menu option is available.");
        //e2eSoftAssert.assertTrue(myAsserts.get("isCruisesLeftMenuOptionAvailable_HOME"),"Home Page: Cruises Left Menu option is available.");
       // e2eSoftAssert.assertTrue(myAsserts.get("isFlightPageLoadedViaSignInLnk"),"Confirm Password field is mandatory and should be displayed as red");

       // for (Map.Entry me : myAsserts.entrySet()) { System.out.println(me.getKey() + " : " + me.getValue()); }
        e2eSoftAssert.assertAll();

*/

    }

    @Test(priority = 2, description = "Sign-On Page: As a user, I want to be able to  Sign-in to the page entering username and password.")
    public void TestCase_SignOnPage() {
        String wrongValue = "wrong";
        SoftAssert e2eSoftAssert = new SoftAssert();

        MercurySignOnPage mercurySignOnPage = new MercurySignOnPage(this.myDriver);
        e2eSoftAssert.assertTrue(mercurySignOnPage.isSignOnHeaderAvailable(), "Sig-ON Page: Sign-in link should take you to the Sign In Page");
        e2eSoftAssert.assertTrue(!mercurySignOnPage.isSignOffAvailable(), "Sig-ON Page: SIGN-ON Top Menu option is back.");
        e2eSoftAssert.assertTrue(mercurySignOnPage.isUserMarkedAsMandatory(), "Sig-ON Page: User Name field is mandatory and should be displayed as red.");
        e2eSoftAssert.assertTrue(mercurySignOnPage.isPasswordMarkedAsMandatory(), "Sig-ON Page: Password field is mandatory and should be displayed as red.");
        mercurySignOnPage.setUserName(wrongValue);
        mercurySignOnPage.setPassword(wrongValue);
        mercurySignOnPage = mercurySignOnPage.trySubmitWrongData();
        e2eSoftAssert.assertTrue(!mercurySignOnPage.isSignOffAvailable(), "Sig-On Page: Sign in mechanism is working partially. SIGN-ON Top Menu option not is replaced by SIGN-OFF option.");
        e2eSoftAssert.assertTrue(mercurySignOnPage.isRegistrationFormLinkAvailable(), "Sig-On Page: Registration form link is available.");
        MercuryRegisterPage mercuryRegisterPage = mercurySignOnPage.checkRegisterLink();
        e2eSoftAssert.assertTrue(mercuryRegisterPage.isHeaderVisible(), "Sig-ON Page ->: Register Page is loaded via Sign-On Registration Form link.");
        e2eSoftAssert.assertAll();
    }

    @Test(priority = 3, description = "Home Page: As a user, I want to be able to see a Right Menu to go to different type of rentals, at the top a different tabs to go to different pages.")
    public void TestCase_HomePage() {
        SoftAssert e2eSoftAssert = new SoftAssert();
        MercuryRegisterPage mercuryRegisterPage = new MercuryRegisterPage(this.myDriver);
        MercuryHomePage mercuryHomePage = mercuryRegisterPage.goHome();
        e2eSoftAssert.assertTrue(mercuryHomePage.isFlightsLeftMenuOptionAvailable(), "Home Page ->: Left Menu Flight Option is available.");
        e2eSoftAssert.assertTrue(mercuryHomePage.isCruisesLeftMenuOptionAvailable(), "Home Page ->: Left Menu Cruises Option is available.");
        MercuryFlightsPage mercuryFlightsPage = mercuryHomePage.goFlightsPage();
        e2eSoftAssert.assertTrue(mercuryFlightsPage.isFlightFinderHeaderVisible(), "Home Page -> Flights: Flight page is loaded by using Lef Menu Flights option.");
        mercuryHomePage = mercuryFlightsPage.goHome();
        MercuryCruisesPage mercuryCruisesPage = mercuryHomePage.goCruisesPage();
        e2eSoftAssert.assertTrue(mercuryCruisesPage.isCruisesHeaderAvailable(), "Home Page -> Cruises: Cruises page is loaded by using Lef Menu Cruises option.");
        mercuryHomePage = mercuryCruisesPage.goHome();
        e2eSoftAssert.assertTrue(mercuryHomePage.isSignOffAvailable(), "Home Page : Although the logging mechanism does not work. When the registration process is carried out, the SIG-ON option in the top menu is replaced by the SIGN-OFF option.");
        MercurySignOnPage mercurySignOnPage = mercuryHomePage.getSignedOff();
        e2eSoftAssert.assertTrue(mercurySignOnPage.isSignOnHeaderAvailable(), "Home Page -> Sign-ON: Sig-On page is loaded by using Top Menu SIGN_OFF option.");
        mercuryHomePage = mercurySignOnPage.goHome();
        e2eSoftAssert.assertTrue(mercuryHomePage.isSigOnTopMenuOptionAvailable(), "Home Page ->: Top Menu SIGN-ON Option is available.");
        e2eSoftAssert.assertTrue(mercuryHomePage.isRegisterTopMenuOptionAvailable(), "Home Page ->: Top Menu REGISTER Option is available.");
        e2eSoftAssert.assertTrue(mercuryHomePage.isSupportTopMenuOptionAvailable(), "Home Page ->: Top Menu SUPPORT Option is available.");
        e2eSoftAssert.assertTrue(mercuryHomePage.isContactTopMenuOptionAvailable(), "Home Page ->: Top Menu CONTACT Option is available.");
        mercurySignOnPage = mercuryHomePage.goSignOnPage();
        e2eSoftAssert.assertTrue(mercurySignOnPage.isSignOnHeaderAvailable(), "Home Page -> Sign-ON: Sig-On page is loaded by using Top Menu SIGN_ON option.");
        mercuryHomePage = mercurySignOnPage.goHome();
        mercuryRegisterPage = mercuryHomePage.goRegisterPage();
        e2eSoftAssert.assertTrue(mercuryRegisterPage.isHeaderVisible(), "Home Page -> Register: Register page is loaded by using Top Menu REGISTER option.");
        mercuryHomePage = mercuryRegisterPage.goHome();
        MercuryUnderConstructionPage mercuryUnderConstructionPage = mercuryHomePage.goSupportPage();
        e2eSoftAssert.assertTrue(mercuryUnderConstructionPage.isUnderConstructionHeaderAvailable(), "Home Page -> Support: Support page is loaded by using Top Menu SUPPORT option.");
        mercuryHomePage = mercuryUnderConstructionPage.goHome();
        mercuryUnderConstructionPage = mercuryHomePage.goContactPage();
        e2eSoftAssert.assertTrue(mercuryUnderConstructionPage.isUnderConstructionHeaderAvailable(), "Home Page -> Contact: Contact page is loaded by using Top Menu CONTACT option.");
        mercuryHomePage = mercuryUnderConstructionPage.goHome();
        e2eSoftAssert.assertTrue(mercuryHomePage.isSpecialSectionAvailable(), "Home Page: Special Section is available.");

        e2eSoftAssert.assertAll();
    }

    @Test(priority = 4, description = "Flights Page: As a user, I want to select my flight configuration to then, select a price. This page is only available for Users already Signed-In")
    public void TestCase_FlightsPage() {
        SoftAssert e2eSoftAssert = new SoftAssert();
        Calendar cal = Calendar.getInstance();
        String depMonth = new SimpleDateFormat("MMMM").format(cal.getTime());
        String depDay = new SimpleDateFormat("dd").format(cal.getTime());
        cal.add(Calendar.DATE, 20);
        String[] expectedValues = {"roundtrip", "1 ", "Acapulco", depMonth, depDay, "Acapulco", depMonth, depDay};

        String[] expectedPassengersDropDownOptions = {"1", "2", "3", "4"};
        String expectedPassengersDropDownDefaultValue = "1";
        String[] expectedDropDownOptions = {"Acapulco", "Frankfurt", "London", "New York", "Paris", "Portland", "San Francisco", "Seattle", "Sydney", "Zurich"};
        String expectedDepDropDownDefaultValue = "Acapulco";
        String expectedArrDropDownDefaultValue = "Frankfurt ";
        String[] expectedDropDownOnMonthOptions = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        String[] expectedDropDownOnDayOptions = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"};
        String[] expectedAirlineDropDownOptions = {"No Preference", "Blue Skies Airlines", "Unified Airlines", "Pangea Airlines"};
        String expectedAirlineDropDownDefaultValue = "No Preference";

        MercuryHomePage mercuryHomePage = new MercuryHomePage(this.myDriver);
        MercurySignOnPage mercurySignOnPage = mercuryHomePage.goSignOnPage();
        MercuryFlightsPage mercuryFlightsPage = mercurySignOnPage.doWorkAroundSignIn();
        e2eSoftAssert.assertTrue(mercuryFlightsPage.isFlightFinderHeaderVisible(), "Flights Page: Is loaded after using workaround sign in.");
        e2eSoftAssert.assertTrue(mercuryFlightsPage.checkIfFlightDetailsDefaultValuesAreTheExpected(expectedValues), "Flights Page: Default fields match with the expected ones.");
        e2eSoftAssert.assertTrue(mercuryFlightsPage.isOneRadioDeselectedWhenOtherRadioIsSelected("oneWay"), "Flights Page: Only one 'Radio button' can be selected and 'Round Trip is the default selection.");
        e2eSoftAssert.assertTrue(mercuryFlightsPage.validateDetailsDropdowns(expectedPassengersDropDownDefaultValue, expectedPassengersDropDownOptions, "passengerSel"), "Flights Page: Passengers dropdown has 1 to 4 options available and 1 is the default selection.");
        e2eSoftAssert.assertTrue(mercuryFlightsPage.validateDetailsDropdowns(expectedDepDropDownDefaultValue, expectedDropDownOptions, "departingFromSel"), "Flights Page: Departing from dropdown works correctly and Acapulco is the default selection.");
        e2eSoftAssert.assertTrue(mercuryFlightsPage.validateDetailsDropdowns(depMonth, expectedDropDownOnMonthOptions, "onMonthSel"), "Flights Page: 'On' Month dropdown works correctly and current date is the default selection.");
        e2eSoftAssert.assertTrue(mercuryFlightsPage.validateDetailsDropdowns(depDay, expectedDropDownOnDayOptions, "onDaySel"), "Flights Page: 'On' Day dropdown works correctly and current date is the default selection");
        e2eSoftAssert.assertTrue(mercuryFlightsPage.validateDetailsDropdowns(expectedArrDropDownDefaultValue, expectedDropDownOptions, "arrivingInSel"), "Flights Page: Arriving dropdown works correctly and Frankfurt is the default selection.");
        e2eSoftAssert.assertTrue(mercuryFlightsPage.validateDetailsDropdowns(depMonth, expectedDropDownOnMonthOptions, "returningMonthSel"), "Flights Page: 'Returning' Month dropdown works correctly and current date is the default selection.");
        e2eSoftAssert.assertTrue(mercuryFlightsPage.validateDetailsDropdowns(depDay, expectedDropDownOnDayOptions, "returningDaySel"), "Flights Page: 'Returning' Day dropdown works correctly and current date is the default selection");
        e2eSoftAssert.assertTrue(mercuryFlightsPage.isOneServiceClassRadioDeselectedWhenOtherRadioIsSelected("first"), "Flights Page: Only one option is allowed to be selected, the radio button option is highlighted when the option is selected and the other options are not");
        e2eSoftAssert.assertTrue(mercuryFlightsPage.validatePreferencesDropdowns(expectedAirlineDropDownDefaultValue, expectedAirlineDropDownOptions, "airlineSel"), "Flights Page: Only one option is allowed to be selected on the dropdown field, and the option selected is displayed on the field");
        //Fill for with test data
        mercuryFlightsPage.fillFlightFinderForm(HAPPY_PATH_FLIGHTS_VALS);
        MercurySelectFlightPage mercurySelectFlightPage = mercuryFlightsPage.continueToSelectFlight();
        e2eSoftAssert.assertTrue(mercurySelectFlightPage.isSelectFlightAvailable(), "Flights Page -> Select Flight Page: Select Flight page is loaded after clicking continue button.");

        e2eSoftAssert.assertAll();
    }

    @Test(priority = 5, description = "Select Flight Page: In this page, the user should see 2 tables:")
    public void TestCase_SelectFlightPage() {
        SoftAssert e2eSoftAssert = new SoftAssert();
        HashMap<String, String> tblDepContent;
        HashMap<String, String> tblRtnContent;
        MercurySelectFlightPage mercurySelectFlightPage = new MercurySelectFlightPage(this.myDriver);

        tblDepContent = mercurySelectFlightPage.selectDepartFlight(FLIGHTS_SELECTIONS[0]);
        e2eSoftAssert.assertTrue(tblDepContent.get("Title").contains("DEPART"), "Select Flight Page: Depart table title is correct.");
        e2eSoftAssert.assertTrue(tblDepContent.get("fromTo").contains(HAPPY_PATH_FLIGHTS_VALS[2] + " to " + HAPPY_PATH_FLIGHTS_VALS[5]), "Select Flight Page: 'From to' values match with the ones entered in Flight Page");
        e2eSoftAssert.assertTrue(tblDepContent.get("date").contains(mercurySelectFlightPage.monthNameToNumber(HAPPY_PATH_FLIGHTS_VALS[3]) + "/" + HAPPY_PATH_FLIGHTS_VALS[4] + "/" + CURR_YEAR), "Select Flight Page: 'From to Date' value match with the ones entered in Flight Page");
        tblRtnContent = mercurySelectFlightPage.selectReturnFlight(FLIGHTS_SELECTIONS[1]);
        e2eSoftAssert.assertTrue(tblRtnContent.get("Title").contains("RETURN"), "Select Flight Page: Return table title is correct.");
        e2eSoftAssert.assertTrue(tblRtnContent.get("fromTo").contains(HAPPY_PATH_FLIGHTS_VALS[5] + " to " + HAPPY_PATH_FLIGHTS_VALS[2]), "Select Flight Page: 'From to' values match with the ones entered in Flight Page");
        e2eSoftAssert.assertTrue(tblRtnContent.get("date").contains(mercurySelectFlightPage.monthNameToNumber(HAPPY_PATH_FLIGHTS_VALS[6]) + "/" + HAPPY_PATH_FLIGHTS_VALS[7] + "/" + CURR_YEAR), "Select Flight Page: 'From to Date' value match with the ones entered in Flight Page");

        e2eSoftAssert.assertAll();
    }

    @Test(priority = 6, description = "Book a Flight Page: ....")
    public void TestCase_BookAFlightPage() {
        SoftAssert e2eSoftAssert = new SoftAssert();
        HashMap<String, String> tblDepContent;
        HashMap<String, String> tblRtnContent;
        HashMap<String, String> tblBookFlightSummary;

        MercurySelectFlightPage mercurySelectFlightPage = new MercurySelectFlightPage(this.myDriver);
        tblDepContent = mercurySelectFlightPage.selectDepartFlight(FLIGHTS_SELECTIONS[0]);
        tblRtnContent = mercurySelectFlightPage.selectReturnFlight(FLIGHTS_SELECTIONS[1]);
        MercuryBookFlightPage mercuryBookFlightPage = mercurySelectFlightPage.goBookFlight();
        e2eSoftAssert.assertTrue(mercuryBookFlightPage.isBookFlightPageLoaded(), "Select Flight Page -> Book a Flight Page: Book a Flight Page is loaded after clicking continue button.");
        tblBookFlightSummary = mercuryBookFlightPage.getSummaryFlightTable();

        e2eSoftAssert.assertTrue(Objects.equals(tblBookFlightSummary.get("depart"), tblDepContent.get("fromTo")), "Book a Flight Page: Summary table is listing the expected 'Depart from to' ");
        e2eSoftAssert.assertTrue(Objects.equals(tblBookFlightSummary.get("departDate"), tblDepContent.get("date")), "Book a Flight Page: Summary table is listing the expected 'Depart Date' ");
        e2eSoftAssert.assertTrue(Objects.equals(tblBookFlightSummary.get("departFlight"), tblDepContent.get("flight")), "Book a Flight Page: Summary table is listing the expected 'Depart flight' ");
        e2eSoftAssert.assertTrue(Objects.equals(tblBookFlightSummary.get("departClass").toLowerCase(), HAPPY_PATH_FLIGHTS_VALS[8]), "Book a Flight Page: Summary table is listing the expected 'Depart class' ");
        e2eSoftAssert.assertTrue(tblDepContent.get("price").contains(tblBookFlightSummary.get("departPrice")), "Book a Flight Page: Summary table is listing the expected 'Depart price' ");

        e2eSoftAssert.assertTrue(Objects.equals(tblBookFlightSummary.get("return"), tblRtnContent.get("fromTo")), "Book a Flight Page: Summary table is listing the expected 'Return from to' ");
        e2eSoftAssert.assertTrue(Objects.equals(tblBookFlightSummary.get("returnDate"), tblRtnContent.get("date")), "Book a Flight Page: Summary table is listing the expected 'Return Date' ");
        e2eSoftAssert.assertTrue(Objects.equals(tblBookFlightSummary.get("returnFlight"), tblRtnContent.get("flight")), "Book a Flight Page: Summary table is listing the expected 'Return flight' ");
        e2eSoftAssert.assertTrue(Objects.equals(tblBookFlightSummary.get("returnClass").toLowerCase(), HAPPY_PATH_FLIGHTS_VALS[8]), "Book a Flight Page: Summary table is listing the expected 'Return class' ");
        e2eSoftAssert.assertTrue(tblRtnContent.get("price").contains(tblBookFlightSummary.get("returnPrice")), "Book a Flight Page: Summary table is listing the expected 'Return price' ");

      /*  System.out.println(tblBookFlightSummary.get("depart") + " <> " + tblDepContent.get("fromTo"));
        System.out.println(tblBookFlightSummary.get("departDate") + " <> " + tblDepContent.get("date"));
        System.out.println(tblBookFlightSummary.get("departFlight") + " <> " + tblDepContent.get("flight"));
        System.out.println(tblBookFlightSummary.get("departClass") + " <> " + HAPPY_PATH_FLIGHTS_VALS[8]);
        System.out.println(tblBookFlightSummary.get("departPrice") + " <> " + tblDepContent.get("price"));
        System.out.println(tblBookFlightSummary.get("return") + " <> " + tblRtnContent.get("fromTo"));
        System.out.println(tblBookFlightSummary.get("returnDate") + " <> " + tblRtnContent.get("date"));
        System.out.println(tblBookFlightSummary.get("returnFlight") + " <> " + tblRtnContent.get("flight"));
        System.out.println(tblBookFlightSummary.get("returnClass") + " <> " + HAPPY_PATH_FLIGHTS_VALS[8]);
        System.out.println(tblBookFlightSummary.get("returnPrice") + " <> " + tblRtnContent.get("price"));*/

        e2eSoftAssert.assertTrue(mercuryBookFlightPage.checkIfFieldIsMandatoryAKARed("firstName"), "Book a Flight Page: Firs Name field is mandatory and should be displayed as red");
        e2eSoftAssert.assertTrue(mercuryBookFlightPage.checkIfFieldIsMandatoryAKARed("lastName"), "Book a Flight Page: Last Name field is mandatory and should be displayed as red");
        e2eSoftAssert.assertTrue(mercuryBookFlightPage.checkIfFieldIsMandatoryAKARed("number"), "Book a Flight Page: Number field is mandatory and should be displayed as red");

        mercuryBookFlightPage.fillBookAFlightFormFullForm(HAPPY_PATH_BOOK_VALS);
        MercuryFlightConfirmationPage mercuryFlightConfirmationPage = mercuryBookFlightPage.completeFlightBooking();
        e2eSoftAssert.assertTrue(mercuryFlightConfirmationPage.isPageLoaded(), "Flight Confirmation Page: Flight Confirmation Page is loaded after clicking continue button.");

        e2eSoftAssert.assertAll();
    }

}