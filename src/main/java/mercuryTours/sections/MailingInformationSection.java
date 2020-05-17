package mercuryTours.sections;

import mercuryTours.elements.BaseElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MailingInformationSection extends BaseSection {
    public MailingInformationSection(WebDriver driver) {
        super(driver);
    }

    public void fillMailingInfo(String address1, String address2,String city, String state, String postalCode, String country){
        this.mailingInformationElements.getMailingTxtElements().get("address1").sendKeys(address1);
        this.mailingInformationElements.getMailingTxtElements().get("address2").sendKeys(address2);
        this.mailingInformationElements.getMailingTxtElements().get("city").sendKeys(city);
        this.mailingInformationElements.getMailingTxtElements().get("state").sendKeys(state);
        this.mailingInformationElements.getMailingTxtElements().get("postalCode").sendKeys(postalCode);
        this.mailingInformationElements.getCountryDropdown().selectByVisibleText(country.toUpperCase());
    }

}
