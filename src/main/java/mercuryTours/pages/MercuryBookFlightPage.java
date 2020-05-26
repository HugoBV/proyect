package mercuryTours.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.HashMap;

public class MercuryBookFlightPage extends BasePage{
    public MercuryBookFlightPage(WebDriver driver) {
        super(driver, driver.getCurrentUrl());
    }

    @FindBy(how = How.XPATH, using = "//img[contains(@src,'mast_book.gif')]")
    private WebElement bookAFlightHeader;

    @FindBy(how = How.XPATH, using = "//input[@name ='buyFlights']")
    private WebElement securePurchaseButton;

    protected String summaryTableXpath = "/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[2]/td/table/tbody/tr";


    public boolean verifyMandatoryFields(String color){
        return bookFlightPassengerInfoSection.checkMandatoryFields(color);
    }

    public boolean verifyNonMandatoryFields(String color){
        return bookFlightPassengerInfoSection.checkNonMandatoryFields(color);
    }

    public void enterPassengerInfo(String name, String lname, String meal){
        bookFlightPassengerInfoSection.fillPassengerPersonalDetails(name, lname, meal);
    }

    public void fillBookAFlightFormWithDefValues(String defValue){
        bookFlightPassengerInfoSection.setDefValue(defValue);
        bookFlightPassengerInfoSection.fillPassengerPersonalDetails();
        bookFlightPassengerInfoSection.fillPassengerCCDetails();
        bookFlightPassengerInfoSection.fillPassengerBillingDetails();
        bookFlightPassengerInfoSection.fillPassengerDeliveryDetails();
    }

    public void fillBookAFlightFormFullForm(String[] values){
        this.bookFlightPassengerInfoSection.fillPassengerFullForm(values);
    }

    public boolean getSummaryDepartInfo(){
        return bookFlightSummarySection.getTableContentBookFlightPage(summaryTableXpath).get("depart").isEmpty();
    }

    public boolean isBookFlightPageLoaded(){
        return this.bookAFlightHeader.isDisplayed();
    }

    public HashMap<String, String> getSummaryFlightTable(){
        return bookFlightSummarySection.getTableContentBookFlightPage(summaryTableXpath);
    }

    public boolean checkIfFieldIsMandatoryAKARed(String field){
        return this.bookFlightPassengerInfoSection.isFieldMarkedAsMandatory(field);
    }

    public MercuryFlightConfirmationPage completeFlightBooking(){
        this.securePurchaseButton.click();
        return new MercuryFlightConfirmationPage(driver);
    }
}
