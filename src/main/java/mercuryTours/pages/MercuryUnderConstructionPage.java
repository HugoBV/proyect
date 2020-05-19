package mercuryTours.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class MercuryUnderConstructionPage extends BasePage{
    public MercuryUnderConstructionPage(WebDriver driver) {
        super(driver, driver.getCurrentUrl());
    }

    @FindBy(how = How.XPATH, using = "//img[contains(@src,'construction.gif')]")
    private WebElement underConstructionHeader;

    public boolean isUnderConstructionHeaderAvailable(){
        return underConstructionHeader.isDisplayed();
    }
}
