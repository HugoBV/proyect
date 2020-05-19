package mercuryTours.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class MercuryAccountCreatedPage extends BasePage{
    public MercuryAccountCreatedPage(WebDriver driver) {
        super(driver, driver.getCurrentUrl());
    }

    @FindBy(how = How.XPATH, using = "//b[contains(text(),'Dear')]")
    private WebElement msg1;

    @FindBy(how = How.XPATH, using = "//a[contains(text(),' sign-in ')]")
    private WebElement singInLnk;

    public boolean registrationMessageIsVisible(String expectedMessage){

        if(msg1.getText().equals(expectedMessage))
        return true;
        else return false;
    }

    public MercurySignOnPage pressSignInLink(){
        singInLnk.click();
        return new MercurySignOnPage(this.driver);
    }

    public MercuryFlightsPage goFlightsPage(String option){
        this.leftSection.clickOnMenuOption(option);
        return new MercuryFlightsPage(this.driver);
    }
}
