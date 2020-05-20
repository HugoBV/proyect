package mercuryTours.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class MercuryFlightsPage extends BasePage{
    public MercuryFlightsPage(WebDriver driver) {
        super(driver, driver.getCurrentUrl());
    }

    @FindBy(how = How.XPATH, using = "//input[@name='findFlights']")
    private WebElement flightContinue;

    public boolean isFlightDetailSectionAvailable(){
        return flightDetailsSection.isFightFinderHeaderVisible();
    }
    public void setFlightDetails(String[] values){
        this.flightDetailsSection.filFlightDetailsFull(values);
    }

    public void setFlightPreferences(String[] values){
        this.flightPreferencesSection.selectServicesClass(values[0]);
        this.flightPreferencesSection.selectDropdownOptionByVisibleText(values[1]);
    }

    public MercurySelectFlight continueToSelectFlight(){
        this.flightContinue.click();
        return new MercurySelectFlight(this.driver);
    }

    public MercurySelectFlight flightFinderFull(String[] fDetails, String sClass, String airline){
        this.flightDetailsSection.filFlightDetailsFull(fDetails);
        this.flightPreferencesSection.selectServicesClass(sClass);
        this.flightPreferencesSection.selectDropdownOptionByVisibleText(airline);
        this.flightContinue.click();
        return new MercurySelectFlight(this.driver);
    }
}
