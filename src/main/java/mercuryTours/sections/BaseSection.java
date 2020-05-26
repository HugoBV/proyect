package mercuryTours.sections;

import mercuryTours.elements.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;


public class BaseSection {
    protected WebDriver driver;
    protected TopMenuElement topMenuElement;
    protected LeftMenuElement leftMenuElement;
    protected ContactInformationElement contactInformationElements;
    protected MailingInformationElement mailingInformationElements;
    protected UserInformationElement userInformationElements;
    protected SpecialsElements specialsElements;
    protected FlightDetailsElement flightDetailsElement;
    protected FlightPreferencesElement flightPreferencesElement;
    protected FlightSelectFlightElement flightSelectFlightElement;
    protected PassengerInfoDetailsElement passengerInfoDetailsElement;
    protected FlightConfirmationElement flightConfirmationElement;
    protected Logger log;
    protected String fromMonth;
    protected String fromDay;
    protected String toMonth;
    protected String toDay;
    protected Calendar cal = Calendar.getInstance();

    public BaseSection(WebDriver driver) {

        this.driver = driver;
        this.initElements();



    }


    private void initElements() {
        WebElement rootElement = this.driver.findElement(By.xpath("//body"));
        this.topMenuElement = new TopMenuElement(rootElement);
        this.leftMenuElement = new LeftMenuElement(rootElement);
        this.contactInformationElements = new ContactInformationElement(rootElement);
        this.mailingInformationElements = new MailingInformationElement(rootElement);
        this.userInformationElements = new UserInformationElement(rootElement);
        this.specialsElements = new SpecialsElements(rootElement);
        this.flightDetailsElement = new FlightDetailsElement(rootElement);
        this.flightPreferencesElement = new FlightPreferencesElement(rootElement);
        this.flightSelectFlightElement = new FlightSelectFlightElement(rootElement);
        this.passengerInfoDetailsElement = new PassengerInfoDetailsElement(rootElement);
        this.flightConfirmationElement = new FlightConfirmationElement(rootElement);
        this.log = LogManager.getLogger(BaseSection.class.getName());
        this.fromMonth = new SimpleDateFormat("MMMM").format(cal.getTime());
        this.fromDay = new SimpleDateFormat("dd").format(cal.getTime());
        cal.add(Calendar.DATE, 20);
        this.toMonth = new SimpleDateFormat("MMMM").format(cal.getTime());
        this.toDay = new SimpleDateFormat("dd").format(cal.getTime());
    }


    public boolean isSignOnAvailable(){return this.topMenuElement.topMenu().get("signOn").isDisplayed();}
    public boolean isRegisterAvailable(){return this.topMenuElement.topMenu().get("register").isDisplayed();}
    public boolean isSupportAvailable(){return this.topMenuElement.topMenu().get("support").isDisplayed();}
    public boolean isContactAvailable(){return this.topMenuElement.topMenu().get("contact").isDisplayed();}
    public boolean isFlightsAvailable(){return this.leftMenuElement.leftMenu().get("flights").isDisplayed();}
    public boolean isCruisesAvailable(){return this.leftMenuElement.leftMenu().get("cruises").isDisplayed();}
}
