package mercuryTours.sections;

import org.openqa.selenium.WebDriver;

public class ContactInformationSection extends BaseSection{

    public ContactInformationSection(WebDriver driver) {
        super(driver);
    }

    public void fillContactInfo(String fName, String lName,String phone, String email){

        this.contactInformationElements.getContactInfoElements().get("firstName").sendKeys(fName);
        this.contactInformationElements.getContactInfoElements().get("lastName").sendKeys(lName);
        this.contactInformationElements.getContactInfoElements().get("phone").sendKeys(phone);
        this.contactInformationElements.getContactInfoElements().get("email").sendKeys(email);
    }

    public boolean isFieldMarkedAsMandatory(String field){
        return this.contactInformationElements.getContactInfoElements().get(field+"LblColor").getAttribute("color")!=null&&
                this.contactInformationElements.getContactInfoElements().get(field+"LblColor").getAttribute("color").equals("red");
    }
}
