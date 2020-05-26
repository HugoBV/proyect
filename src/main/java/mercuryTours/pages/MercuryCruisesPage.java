package mercuryTours.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class MercuryCruisesPage extends BasePage {
    public MercuryCruisesPage(WebDriver driver) {
        super(driver, driver.getCurrentUrl());
    }

    @FindBy(how = How.XPATH, using = "//img[contains(@src,'cruise_special.gif')]")
    private WebElement cruisesSpecialHeader;

    public boolean isCruisesHeaderAvailable(){
        return cruisesSpecialHeader.isDisplayed();
    }
}
