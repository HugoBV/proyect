package mercuryTours.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class MercuryFlightConfirmationPage extends BasePage {
    public MercuryFlightConfirmationPage(WebDriver driver) {
        super(driver, driver.getCurrentUrl());
    }

    @FindBy(how = How.XPATH, using = "//img[contains(@src,'mast_confirmation.gif')]")
    private WebElement flightConfirmationHeader;

    public boolean isPageLoaded() {
        return this.flightConfirmationHeader.isDisplayed();
    }
}
