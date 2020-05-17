package mercuryTours.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class MercurySignOnPage extends BasePage{
    public MercurySignOnPage(WebDriver driver) {
        super(driver, driver.getCurrentUrl());
    }

    @FindBy(how = How.CSS, using = "input[name=userName]")
    private WebElement userName;

    @FindBy(how = How.CSS, using = "input[name=password]")
    private WebElement password;

    @FindBy(how = How.CSS, using = "input[name=login]")
    private WebElement submit;

    public boolean pageReady(){
        if(userName.isDisplayed())
            return true;
        else
            return false;
    }
}
