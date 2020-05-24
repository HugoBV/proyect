package mercuryTours.pages;

import mercuryTours.sections.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Objects;

public class BasePage {

    protected WebDriver driver;
    protected String baseURL;
    protected TopSection topSection;
    protected LeftSection leftSection;
    protected ContactInformationSection contactInformationSection;
    protected MailingInformationSection mailingInformationSection;
    protected UserInformationSection userInformationSection;
    protected SpecialsSection specialsSection;
    protected FlightDetailsSection flightDetailsSection;
    protected FlightPreferencesSection flightPreferencesSection;
    protected SelectFlightTable selectFlightTable;
    protected BookFlightPassengerInfoSection bookFlightPassengerInfoSection;
    protected BookFlightSummarySection bookFlightSummarySection;
    protected Calendar cal = Calendar.getInstance();
    private final String CURR_YEAR = "2020";
    private final String[] HAPPY_PATH_REG_VALS = {"Fer","Perez","22323433-3","asd@asdas.com","Ave Siempre Viva","1234","Guadalajara","Jalisco","44350","Mexico","Boot","camp"};
    private final String[] HAPPY_PATH_FLIGHTS_VALS = {"roundTrip","1 ","London","June","15","Sydney","June","25","business","Pangea Airlines"};
    private final int[] FLIGHTS_SELECTIONS = {0,3};
    public BasePage(WebDriver driver, String baseURL) {
        this.driver = driver;
        this.baseURL = baseURL;
        initSections();
        PageFactory.initElements(driver, this);
    }

    private void initSections() {
        if (this.isLoaded()) {
            this.topSection = new TopSection(driver);
            this.leftSection = new LeftSection(driver);
            this.contactInformationSection = new ContactInformationSection(driver);
            this.mailingInformationSection = new MailingInformationSection(driver);
            this.userInformationSection = new UserInformationSection(driver);
            this.specialsSection = new SpecialsSection(driver);
            this.flightPreferencesSection = new FlightPreferencesSection(driver);
            this.flightDetailsSection = new FlightDetailsSection(driver);
            this.selectFlightTable = new SelectFlightTable(driver);
            this.bookFlightPassengerInfoSection = new BookFlightPassengerInfoSection(driver);
            this.bookFlightSummarySection = new BookFlightSummarySection(driver);
        }
    }


    public boolean isLoaded() {

            return true;

    }

    public HashMap <String, Boolean> happyPath(MercuryHomePage mainPage){
        HashMap <String, Boolean> assertResults = new HashMap<>();
        HashMap <String,String> tblDepContent;
        HashMap <String,String> tblRtnContent;

        MercuryRegisterPage mercuryRegisterPage = mainPage.goRegisterPage("register");

        assertResults.put("isFirstNameMandatory_RegPag",mercuryRegisterPage.checkIfContactFieldIsMandatoryAKARed("firstName"));
        assertResults.put("isLastNameMandatory_RegPag",mercuryRegisterPage.checkIfContactFieldIsMandatoryAKARed("lastName"));
        assertResults.put("isPhoneMandatory_RegPag",mercuryRegisterPage.checkIfContactFieldIsMandatoryAKARed("phone"));
        assertResults.put("isEmailMandatory_RegPag",mercuryRegisterPage.checkIfContactFieldIsMandatoryAKARed("email"));

        assertResults.put("isAddressMandatory_RegPag",mercuryRegisterPage.checkIfMailingFieldIsMandatoryAKARed("address1"));
        assertResults.put("isCityMandatory_RegPag",mercuryRegisterPage.checkIfMailingFieldIsMandatoryAKARed("city"));
        assertResults.put("isStateMandatory_RegPag",mercuryRegisterPage.checkIfMailingFieldIsMandatoryAKARed("state"));
        assertResults.put("isZipMandatory_RegPag",mercuryRegisterPage.checkIfMailingFieldIsMandatoryAKARed("postalCode"));
        assertResults.put("isCountryMandatory_RegPag",mercuryRegisterPage.checkIfMailingFieldIsMandatoryAKARed("country"));

        assertResults.put("isUserNameMandatory_RegPag",mercuryRegisterPage.checkIfUserFieldIsMandatoryAKARed("userName"));
        assertResults.put("isPasswordMandatory_RegPag",mercuryRegisterPage.checkIfUserFieldIsMandatoryAKARed("password"));
        assertResults.put("isConfirmPasswordMandatory_RegPag",mercuryRegisterPage.checkIfUserFieldIsMandatoryAKARed("confirmPassword"));

        MercuryAccountCreatedPage accountCreatedPage = mercuryRegisterPage.getRegistrationDone(this.HAPPY_PATH_REG_VALS);
        assertResults.put("isRegistrationSuccessful",accountCreatedPage.registrationMessageIsVisible());
        assertResults.put("isExpectedSignInMsgDisplayed",accountCreatedPage.registrationMessageExpectedValue("Dear " + HAPPY_PATH_REG_VALS[0] + " " + HAPPY_PATH_REG_VALS[1] + ","));
        MercuryFlightsPage mercuryFlightsPage = accountCreatedPage.goFlightsPage("flights");
        assertResults.put("isFlightPageLoaded",mercuryFlightsPage.isFlightDetailSectionAvailable());
        mercuryFlightsPage.fillFlightFinderForm(this.HAPPY_PATH_FLIGHTS_VALS);
        MercurySelectFlightPage mercurySelectFlightPage = mercuryFlightsPage.continueToSelectFlight();
        assertResults.put("isSelectFlightPageLoaded",mercurySelectFlightPage.isSelectFlightAvailable());
        tblDepContent = mercurySelectFlightPage.selectDepartFlight(FLIGHTS_SELECTIONS[0]);
        assertResults.put("isDepartTitleRight", Objects.equals(tblDepContent.get("Title"), "DEPART"));
            System.out.println(tblDepContent.get("Title")+ " <> " +"DEPART"+" - Assert = "+ assertResults.get("isDepartTitleRight"));
        assertResults.put("isDepartFromToRight", Objects.equals(tblDepContent.get("fromTo"), HAPPY_PATH_FLIGHTS_VALS[2]+" to "+HAPPY_PATH_FLIGHTS_VALS[5]));
            System.out.println(tblDepContent.get("fromTo")+ " <> " + HAPPY_PATH_FLIGHTS_VALS[2]+" to "+HAPPY_PATH_FLIGHTS_VALS[5] +" - Assert = "+ assertResults.get("isDepartFromToRight"));
        assertResults.put("isDepartDateRight", Objects.equals(tblDepContent.get("date"), this.monthNameToNumber(HAPPY_PATH_FLIGHTS_VALS[3])+"/"+HAPPY_PATH_FLIGHTS_VALS[4]+"/"+CURR_YEAR));
            System.out.println(tblDepContent.get("date")+ " <> " + this.monthNameToNumber(HAPPY_PATH_FLIGHTS_VALS[3])+"/"+HAPPY_PATH_FLIGHTS_VALS[4]+"/"+CURR_YEAR+" - Assert = "+ assertResults.get("isDepartDateRight"));
            System.out.println(tblDepContent.get("selectRow")+ " <> " +(FLIGHTS_SELECTIONS[1]+1)*2);
        tblRtnContent = mercurySelectFlightPage.selectReturnFlight(FLIGHTS_SELECTIONS[1]);
        assertResults.put("isReturnTitleRight", Objects.equals(tblRtnContent.get("Title"), "RETURN"));
            System.out.println(tblRtnContent.get("Title")+ " <> " +"RETURN"+" - Assert = "+ assertResults.get("isReturnTitleRight"));
        assertResults.put("isReturnFromToRight", Objects.equals(tblRtnContent.get("fromTo"), HAPPY_PATH_FLIGHTS_VALS[5]+" to "+HAPPY_PATH_FLIGHTS_VALS[2]));
            System.out.println(tblRtnContent.get("fromTo")+ " <> " + HAPPY_PATH_FLIGHTS_VALS[5]+" to "+HAPPY_PATH_FLIGHTS_VALS[2] +" - Assert = "+ assertResults.get("isReturnFromToRight"));
        assertResults.put("isReturnDateRight", Objects.equals(tblRtnContent.get("date"), this.monthNameToNumber(HAPPY_PATH_FLIGHTS_VALS[6])+"/"+HAPPY_PATH_FLIGHTS_VALS[7]+"/"+CURR_YEAR));
            System.out.println(tblRtnContent.get("date")+ " <> " + this.monthNameToNumber(HAPPY_PATH_FLIGHTS_VALS[6])+"/"+HAPPY_PATH_FLIGHTS_VALS[7]+"/"+CURR_YEAR+" - Assert = "+ assertResults.get("isReturnDateRight"));
            System.out.println(tblRtnContent.get("selectRow")+ " <> " +(FLIGHTS_SELECTIONS[1]+1)*2);
        MercuryBookFlightPage mercuryBookFlightPage =  mercurySelectFlightPage.goBookFlight();
        assertResults.put("isBookFlightPageLoaded",mercuryBookFlightPage.isBookFlightPageLoaded());
        // mercurySelectFlightPage.goBookFlight().fillBookAFlightFormWithDefValues("QAminds");
        return assertResults;
    }

    public String monthNameToNumber(String monthName){
        String[] months = {"January","February","March","April","May","June","July","August","September","October","November","December"};
        String monthNumber = null;
        for(int i = 0; i<months.length; i++ ){
            if(months[i].equals(monthName)){
                monthNumber = Integer.toString(i+1);
                break;
            }
        }
        return monthNumber;
    }
}
