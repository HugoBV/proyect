package mercuryTours.sections;

import mercuryTours.elements.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

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
    protected Logger log;

    public BaseSection(WebDriver driver) {
        this.driver = driver;
        this.initElements();

    }

    private void initElements() {
        WebElement rootElement = this.driver.findElement(By.xpath("//body/div/table"));
        this.topMenuElement = new TopMenuElement(rootElement);
        this.leftMenuElement = new LeftMenuElement(rootElement);
        this.contactInformationElements = new ContactInformationElement(rootElement);
        this.mailingInformationElements = new MailingInformationElement(rootElement);
        this.userInformationElements = new UserInformationElement(rootElement);
        this.specialsElements = new SpecialsElements(rootElement);
        this.flightDetailsElement = new FlightDetailsElement(rootElement);
        this.flightPreferencesElement = new FlightPreferencesElement(rootElement);
        this.flightSelectFlightElement = new FlightSelectFlightElement(rootElement);
        this.log = LogManager.getLogger(BaseSection.class.getName());
    }

}
