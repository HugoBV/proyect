package mercuryTours.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class MercuryFlightsPage extends BasePage{
    public MercuryFlightsPage(WebDriver driver) {
        super(driver, driver.getCurrentUrl());
    }

    @FindBy(how = How.CSS, using = "img[src$='flightfinder.gif']")
    private WebElement flightFinderHeader;

    public boolean isFlightDetailSectionAvailable(){
        return flightDetailsSection.isFightFinderHeaderVisible();
    }
}
