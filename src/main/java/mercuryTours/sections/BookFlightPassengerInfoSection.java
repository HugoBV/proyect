package mercuryTours.sections;

import mercuryTours.elements.PassengerInfoDetailsElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BookFlightPassengerInfoSection extends BaseSection{
    public BookFlightPassengerInfoSection(WebDriver driver) {
        super(driver);
    }
    private String defValue = "test";

    public boolean checkMandatoryFields(String color){

        return (this.passengerInfoDetailsElement.getPassengerInfoNonSelElements().get("firstNameLbl").getAttribute("color").equals(color)&&
                this.passengerInfoDetailsElement.getPassengerInfoNonSelElements().get("lastNameLbl").getAttribute("color").equals(color)&&
                this.passengerInfoDetailsElement.getPassengerInfoNonSelElements().get("numberLbl").getAttribute("color").equals(color));

    }
    public void setDefValue(String value){
        defValue = value;
    }

    public boolean checkNonMandatoryFields(String color){

        return (!this.passengerInfoDetailsElement.getPassengerInfoNonSelElements().get("mealLbl").getAttribute("color").equals(color)&&
                !this.passengerInfoDetailsElement.getPassengerInfoNonSelElements().get("cardTypeLbl").getAttribute("color").equals(color)&&
                !this.passengerInfoDetailsElement.getPassengerInfoNonSelElements().get("expirationLbl").getAttribute("color").equals(color)&&
                !this.passengerInfoDetailsElement.getPassengerInfoNonSelElements().get("ccFirstNameLbl").getAttribute("color").equals(color)&&
                !this.passengerInfoDetailsElement.getPassengerInfoNonSelElements().get("ccMidNameLbl").getAttribute("color").equals(color)&&
                !this.passengerInfoDetailsElement.getPassengerInfoNonSelElements().get("ccLastNameLbl").getAttribute("color").equals(color)&&
                !this.passengerInfoDetailsElement.getPassengerInfoNonSelElements().get("ticketlessTravelLbl").getAttribute("color").equals(color)&&
                !this.passengerInfoDetailsElement.getPassengerInfoNonSelElements().get("sameAsBillingAddressLbl").getAttribute("color").equals(color));

    }

    public void fillPassengerPersonalDetails(String name, String lname, String meal)
    {
        this.passengerInfoDetailsElement.getPassengerInfoNonSelElements().get("firstName").sendKeys(name);
        this.passengerInfoDetailsElement.getPassengerInfoNonSelElements().get("lastName").sendKeys(lname);
        this.passengerInfoDetailsElement.getFlightDetailsSelElements().get("mealSel").selectByVisibleText(meal);
    }

    public void fillPassengerPersonalDetails()
    {

        this.passengerInfoDetailsElement.getPassengerInfoNonSelElements().get("firstName").sendKeys(defValue);
        this.passengerInfoDetailsElement.getPassengerInfoNonSelElements().get("lastName").sendKeys(defValue);
        this.passengerInfoDetailsElement.getFlightDetailsSelElements().get("mealSel").selectByIndex(0);
    }

    public void fillPassengerFullForm(String[] values){
        this.passengerInfoDetailsElement.getPassengerInfoNonSelElements().get("firstName").sendKeys(values[0]);
        this.passengerInfoDetailsElement.getPassengerInfoNonSelElements().get("lastName").sendKeys(values[1]);
        this.passengerInfoDetailsElement.getFlightDetailsSelElements().get("mealSel").selectByVisibleText(values[2]);
        this.passengerInfoDetailsElement.getFlightDetailsSelElements().get("cardTypeSel").selectByVisibleText(values[3]);
        this.passengerInfoDetailsElement.getPassengerInfoNonSelElements().get("number").sendKeys(values[4]);
        this.passengerInfoDetailsElement.getFlightDetailsSelElements().get("expirationMonthSel").selectByVisibleText(values[5]);
        this.passengerInfoDetailsElement.getFlightDetailsSelElements().get("expirationYearSel").selectByVisibleText(values[6]);
        this.passengerInfoDetailsElement.getPassengerInfoNonSelElements().get("ccFirstName").sendKeys(values[7]);
        this.passengerInfoDetailsElement.getPassengerInfoNonSelElements().get("ccMidName").sendKeys(values[8]);
        this.passengerInfoDetailsElement.getPassengerInfoNonSelElements().get("ccLastName").sendKeys(values[9]);

        this.passengerInfoDetailsElement.getPassengerInfoNonSelElements().get("billAddress1").clear();
        this.passengerInfoDetailsElement.getPassengerInfoNonSelElements().get("billAddress1").sendKeys(values[11]);
        this.passengerInfoDetailsElement.getPassengerInfoNonSelElements().get("billAddress2").sendKeys(values[12]);
        this.passengerInfoDetailsElement.getPassengerInfoNonSelElements().get("billCity").clear();
        this.passengerInfoDetailsElement.getPassengerInfoNonSelElements().get("billCity").sendKeys(values[13]);
        this.passengerInfoDetailsElement.getPassengerInfoNonSelElements().get("billState").clear();
        this.passengerInfoDetailsElement.getPassengerInfoNonSelElements().get("billState").sendKeys(values[14]);
        this.passengerInfoDetailsElement.getPassengerInfoNonSelElements().get("billZip").clear();
        this.passengerInfoDetailsElement.getPassengerInfoNonSelElements().get("billZip").sendKeys(values[15]);
        this.passengerInfoDetailsElement.getFlightDetailsSelElements().get("billCountrySel").selectByValue("207");
        this.passengerInfoDetailsElement.getFlightDetailsSelElements().get("billCountrySel").selectByValue(values[16]);

        this.passengerInfoDetailsElement.getPassengerInfoNonSelElements().get("delAddress1").clear();
        this.passengerInfoDetailsElement.getPassengerInfoNonSelElements().get("delAddress1").sendKeys(values[18]);
        this.passengerInfoDetailsElement.getPassengerInfoNonSelElements().get("delAddress2").sendKeys(values[19]);
        this.passengerInfoDetailsElement.getPassengerInfoNonSelElements().get("delCity").clear();
        this.passengerInfoDetailsElement.getPassengerInfoNonSelElements().get("delCity").sendKeys(values[20]);
        this.passengerInfoDetailsElement.getPassengerInfoNonSelElements().get("delState").clear();
        this.passengerInfoDetailsElement.getPassengerInfoNonSelElements().get("delState").sendKeys(values[21]);
        this.passengerInfoDetailsElement.getPassengerInfoNonSelElements().get("delZip").clear();
        this.passengerInfoDetailsElement.getPassengerInfoNonSelElements().get("delZip").sendKeys(values[22]);
    }

    public void fillPassengerCCDetails()
    {

        this.passengerInfoDetailsElement.getFlightDetailsSelElements().get("cardTypeSel").selectByIndex(0);
        this.passengerInfoDetailsElement.getPassengerInfoNonSelElements().get("number").sendKeys(defValue);
        this.passengerInfoDetailsElement.getFlightDetailsSelElements().get("expirationMonthSel").selectByIndex(0);
        this.passengerInfoDetailsElement.getFlightDetailsSelElements().get("expirationYearSel").selectByIndex(0);
        this.passengerInfoDetailsElement.getPassengerInfoNonSelElements().get("ccFirstName").sendKeys(defValue);
        this.passengerInfoDetailsElement.getPassengerInfoNonSelElements().get("ccMidName").sendKeys(defValue);
        this.passengerInfoDetailsElement.getPassengerInfoNonSelElements().get("ccLastName").sendKeys(defValue);
    }



    public void fillPassengerCCDetails(String card, String cardNumber, String ccMonth,String ccYear, String ccName, String ccMidName,String ccLname)
    {
        this.passengerInfoDetailsElement.getFlightDetailsSelElements().get("cardTypeSel").selectByVisibleText(card);
        this.passengerInfoDetailsElement.getPassengerInfoNonSelElements().get("number").sendKeys(cardNumber);
        this.passengerInfoDetailsElement.getFlightDetailsSelElements().get("expirationMonthSel").selectByVisibleText(ccMonth);
        this.passengerInfoDetailsElement.getFlightDetailsSelElements().get("expirationYearSel").selectByVisibleText(ccYear);
        this.passengerInfoDetailsElement.getPassengerInfoNonSelElements().get("ccFirstName").sendKeys(ccName);
        this.passengerInfoDetailsElement.getPassengerInfoNonSelElements().get("ccMidName").sendKeys(ccMidName);
        this.passengerInfoDetailsElement.getPassengerInfoNonSelElements().get("ccLastName").sendKeys(ccLname);
    }

    public void fillPassengerBillingDetails()
    {
        this.passengerInfoDetailsElement.getPassengerInfoNonSelElements().get("billAddress1").clear();
        this.passengerInfoDetailsElement.getPassengerInfoNonSelElements().get("billAddress1").sendKeys(defValue);
        this.passengerInfoDetailsElement.getPassengerInfoNonSelElements().get("billAddress2").sendKeys(defValue);
        this.passengerInfoDetailsElement.getPassengerInfoNonSelElements().get("billCity").clear();
        this.passengerInfoDetailsElement.getPassengerInfoNonSelElements().get("billCity").sendKeys(defValue);
        this.passengerInfoDetailsElement.getPassengerInfoNonSelElements().get("billState").clear();
        this.passengerInfoDetailsElement.getPassengerInfoNonSelElements().get("billState").sendKeys(defValue);
        this.passengerInfoDetailsElement.getPassengerInfoNonSelElements().get("billZip").clear();
        this.passengerInfoDetailsElement.getPassengerInfoNonSelElements().get("billZip").sendKeys(defValue);

    }

    public void fillPassengerBillingDetails(String billAdd1, String billAdd2, String billCity, String billState, String billZip,String billCountry, boolean ticketLess)
    {
        this.passengerInfoDetailsElement.getPassengerInfoNonSelElements().get("billAddress1").clear();
        this.passengerInfoDetailsElement.getPassengerInfoNonSelElements().get("billAddress1").sendKeys(billAdd1);
        this.passengerInfoDetailsElement.getPassengerInfoNonSelElements().get("billAddress2").sendKeys(billAdd2);
        this.passengerInfoDetailsElement.getPassengerInfoNonSelElements().get("billCity").clear();
        this.passengerInfoDetailsElement.getPassengerInfoNonSelElements().get("billCity").sendKeys(billCity);
        this.passengerInfoDetailsElement.getPassengerInfoNonSelElements().get("billState").clear();
        this.passengerInfoDetailsElement.getPassengerInfoNonSelElements().get("billState").sendKeys(billState);
        this.passengerInfoDetailsElement.getPassengerInfoNonSelElements().get("billZip").clear();
        this.passengerInfoDetailsElement.getPassengerInfoNonSelElements().get("billZip").sendKeys(billZip);
        this.passengerInfoDetailsElement.getFlightDetailsSelElements().get("billCountrySel").selectByVisibleText(billCountry);
    }

    public void fillPassengerDeliveryDetails()
    {
        this.passengerInfoDetailsElement.getPassengerInfoNonSelElements().get("delAddress1").clear();
        this.passengerInfoDetailsElement.getPassengerInfoNonSelElements().get("delAddress1").sendKeys(defValue);
        this.passengerInfoDetailsElement.getPassengerInfoNonSelElements().get("delAddress2").sendKeys(defValue);
        this.passengerInfoDetailsElement.getPassengerInfoNonSelElements().get("delCity").clear();
        this.passengerInfoDetailsElement.getPassengerInfoNonSelElements().get("delCity").sendKeys(defValue);
        this.passengerInfoDetailsElement.getPassengerInfoNonSelElements().get("delState").clear();
        this.passengerInfoDetailsElement.getPassengerInfoNonSelElements().get("delState").sendKeys(defValue);
        this.passengerInfoDetailsElement.getPassengerInfoNonSelElements().get("delZip").clear();
        this.passengerInfoDetailsElement.getPassengerInfoNonSelElements().get("delZip").sendKeys(defValue);
    }

    public void fillPassengerDeliveryDetails(String delAdd1, String delAdd2, String delCity, String delState, String delZip,String delCountry, boolean sameAsBilling)
    {
        this.passengerInfoDetailsElement.getPassengerInfoNonSelElements().get("delAddress1").clear();
        this.passengerInfoDetailsElement.getPassengerInfoNonSelElements().get("delAddress1").sendKeys(delAdd1);
        this.passengerInfoDetailsElement.getPassengerInfoNonSelElements().get("delAddress2").sendKeys(delAdd2);
        this.passengerInfoDetailsElement.getPassengerInfoNonSelElements().get("delCity").clear();
        this.passengerInfoDetailsElement.getPassengerInfoNonSelElements().get("delCity").sendKeys(delCity);
        this.passengerInfoDetailsElement.getPassengerInfoNonSelElements().get("delState").clear();
        this.passengerInfoDetailsElement.getPassengerInfoNonSelElements().get("delState").sendKeys(delState);
        this.passengerInfoDetailsElement.getPassengerInfoNonSelElements().get("delZip").clear();
        this.passengerInfoDetailsElement.getPassengerInfoNonSelElements().get("delZip").sendKeys(delZip);
        this.passengerInfoDetailsElement.getFlightDetailsSelElements().get("delCountrySel").selectByVisibleText(delCountry);
    }

    public boolean isFieldMarkedAsMandatory(String field){
        return this.passengerInfoDetailsElement.getPassengerInfoNonSelElements().get(field+"Lbl").getAttribute("color")!=null&&
                this.passengerInfoDetailsElement.getPassengerInfoNonSelElements().get(field+"Lbl").getAttribute("color").equals("red");
    }
}
