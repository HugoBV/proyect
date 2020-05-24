package mercuryTours.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class MercuryRegisterPage extends BasePage {

    @FindBy(how = How.CSS, using = "input[name=register]")
    private WebElement submit;

    @FindBy(how = How.CSS, using = "img[src$='register.gif']")
    private WebElement registerHeader;

    public MercuryRegisterPage(WebDriver driver) {
        super(driver, driver.getCurrentUrl());
    }

    public boolean isHeaderVisible(){
        if(registerHeader.isDisplayed())
            return true;
        else
            return false;
    }

    public void fillContactInformation(String fName, String lName,String phone, String email){
            this.contactInformationSection.fillContactInfo(fName,lName,phone,email);
    }

    public void fillMailingInformation(String address1, String address2,String city, String state, String postalCode, String country){
        this.mailingInformationSection.fillMailingInfo(address1,address2,city,state,postalCode,  country);
    }

    public void fillUserInformation(String uName, String password){
        this.userInformationSection.fillUserInfo(uName,password);
    }

    public void fillFullForm(String[] values){
        this.contactInformationSection.fillContactInfo(values[0],values[1],values[2],values[3]);
        this.mailingInformationSection.fillMailingInfo(values[4],values[5],values[6],values[7],values[8],values[9]);
        this.userInformationSection.fillUserInfo(values[10],values[11]);

    }

    public boolean checkIsFieldIsMandatory(String field)
    {
        if(userInformationSection.isMandatoryField(field))
            return true;
        else
            return false;
    }

    public MercuryAccountCreatedPage getRegistrationDone(String[] values){
        this.fillFullForm(values);
        this.submit.click();
        return new MercuryAccountCreatedPage(this.driver);
    }

    public MercuryAccountCreatedPage getRegistrationDone(){
        this.submit.click();
        return new MercuryAccountCreatedPage(this.driver);
    }

    public boolean checkIfContactFieldIsMandatoryAKARed(String field){
        return this.contactInformationSection.isFieldMarkedAsMandatory(field);
    }

    public boolean checkIfMailingFieldIsMandatoryAKARed(String field){
        return this.mailingInformationSection.isFieldMarkedAsMandatory(field);
    }

    public boolean checkIfUserFieldIsMandatoryAKARed(String field){
        return this.userInformationSection.isFieldMarkedAsMandatory(field);
    }
}
