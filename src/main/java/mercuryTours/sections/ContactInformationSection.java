package mercuryTours.sections;

import org.openqa.selenium.WebDriver;

public class ContactInformationSection extends BaseSection{

    public ContactInformationSection(WebDriver driver) {
        super(driver);
    }

    public void fillContactInfo(String fName, String lName,String phone, String email){
        this.log.debug("Filling Contact Information....");
        this.contactInformationElements.getContactInfoElements().get("firstName").sendKeys(fName);
        this.log.debug("firstName: "+fName);
        this.contactInformationElements.getContactInfoElements().get("lastName").sendKeys(lName);
        this.log.debug("lastName: "+lName);
        this.contactInformationElements.getContactInfoElements().get("phone").sendKeys(phone);
        this.log.debug("phone: "+phone);
        this.contactInformationElements.getContactInfoElements().get("email").sendKeys(email);
        this.log.debug("email: "+email);
    }
}
