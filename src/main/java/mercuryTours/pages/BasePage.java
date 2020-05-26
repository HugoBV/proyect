package mercuryTours.pages;

import mercuryTours.sections.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.Calendar;
import java.util.HashMap;

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
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return true;

    }

    public boolean isFlightsLeftMenuOptionAvailable(){ return leftSection.isFlightsAvailable(); }
    public boolean isCruisesLeftMenuOptionAvailable(){ return leftSection.isCruisesAvailable(); }

    public boolean isSigOnTopMenuOptionAvailable(){ return topSection.isSignOnAvailable(); }
    public boolean isRegisterTopMenuOptionAvailable(){ return topSection.isRegisterAvailable(); }
    public boolean isSupportTopMenuOptionAvailable(){ return topSection.isSupportAvailable(); }
    public boolean isContactTopMenuOptionAvailable(){ return topSection.isContactAvailable(); }

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

    public boolean isSignOffAvailable(){
        return this.topSection.isSignOffAvailable();
    }

    public MercurySignOnPage getSignedOff(){
        this.topSection.goSignOff();
        return new MercurySignOnPage(driver);
    }

    public MercuryHomePage goHome(){
        this.leftSection.clickOnMenuOption("home");
        return new MercuryHomePage(this.driver);
    }

    public MercuryRegisterPage goRegisterPage(){
        this.topSection.clickOnMenuOption("register");
        return new MercuryRegisterPage(this.driver);
    }

    public MercurySignOnPage goSignOnPage(){
        this.topSection.clickOnMenuOption("signOn");
        return new MercurySignOnPage(this.driver);
    }

    public MercuryFlightsPage goFlightsPage(){
        this.leftSection.clickOnMenuOption("flights");
        return new MercuryFlightsPage(this.driver);
    }

    public MercuryCruisesPage goCruisesPage(){
        this.leftSection.clickOnMenuOption("cruises");
        return new MercuryCruisesPage(this.driver);
    }

    public MercuryUnderConstructionPage goSupportPage(){
        this.topSection.clickOnMenuOption("support");
        return new MercuryUnderConstructionPage(this.driver);
    }

    public MercuryUnderConstructionPage goContactPage(){
        this.topSection.clickOnMenuOption("contact");
        return new MercuryUnderConstructionPage(this.driver);
    }
}
