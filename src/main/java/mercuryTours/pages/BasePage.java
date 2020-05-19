package mercuryTours.pages;

import mercuryTours.sections.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

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

    public BasePage(WebDriver driver, String baseURL) {
        this.driver = driver;
        this.baseURL = baseURL;
        initSections();
        PageFactory.initElements(driver, this);
    }

    private void initSections() {
        if (this.isLoaded()) {
            topSection = new TopSection(driver);
            leftSection = new LeftSection(driver);
            contactInformationSection = new ContactInformationSection(driver);
            mailingInformationSection = new MailingInformationSection(driver);
            userInformationSection = new UserInformationSection(driver);
            specialsSection = new SpecialsSection(driver);
            flightDetailsSection = new FlightDetailsSection(driver);
        }
    }

    public boolean isLoaded() {

            return true;

    }
}
