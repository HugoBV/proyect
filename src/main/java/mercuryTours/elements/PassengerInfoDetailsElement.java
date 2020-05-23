package mercuryTours.elements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.HashMap;

public class PassengerInfoDetailsElement extends BaseElement{
    public PassengerInfoDetailsElement(WebElement rootElement) {
        super(rootElement);
    }
    private final String[][] rawElements =
            {{"passengerHeader","//font[contains(text(),'Passengers ')]","XPATH"},
                    {"firstName","//input[@name='passFirst0']","XPATH"},
                    {"lastName","//input[@name='passLast0']","XPATH"},
                    {"firstNameLbl","//font[contains(text(),'First Name:')]","XPATH"},
                    {"lastNameLbl","//font[contains(text(),'Last Name:')]","XPATH"},
                    {"mealLbl","//font[contains(text(),'Meal:')]","XPATH"},
                    {"creditCardHeader","//font[contains(text(),'Credit ')]","XPATH"},
                    {"cardTypeLbl","//font[contains(text(),' Type:')]","XPATH"},
                    {"numberLbl","//font[contains(text(),'Number:')]","XPATH"},
                    {"expirationLbl","//font[contains(text(),'Expiration:')]","XPATH"},
                    {"number","//input[@name='creditnumber']","XPATH"},
                    {"ccFirstNameLbl","//font[contains(text(),'  Name')]","XPATH"},
                    {"ccMidNameLbl","//font[contains(text(),'Middle:')]","XPATH"},
                    {"ccLastNameLbl","//font[contains(text(),'Last:')]","XPATH"},
                    {"ccFirstName","//input[@name='cc_frst_name']","XPATH"},
                    {"ccMidName","//input[@name='cc_mid_name']","XPATH"},
                    {"ccLastName","//input[@name='cc_last_name']","XPATH"},
                    {"billlingAddressHeader","//font/b[contains(text(),'Billing Address')]","XPATH"},
                    {"ticketlessTravelLbl","//font[contains(text(),'Ticketless')]","XPATH"},
                    {"ticketlessTravelCheck","//font[contains(text(),'Ticketless')]/preceding-sibling::input","XPATH"},
                    {"billAddress1","//input[@name='billAddress1']","XPATH"},
                    {"billAddress2","//input[@name='billAddress2']","XPATH"},
                    {"billCity","//input[@name='billCity']","XPATH"},
                    {"billState","//input[@name='billState']","XPATH"},
                    {"billZip","//input[@name='billZip']","XPATH"},
                    {"deliveryAddressHeader","//font/b[contains(text(),'Delivery Address')]","XPATH"},
                    {"sameAsBillingAddressLbl","//font[contains(text(),'Same as')]","XPATH"},
                    {"sameAsBillingAddressCheck","//font[contains(text(),'Same as')]/preceding-sibling::input","XPATH"},
                    {"delAddress1","//input[@name='delAddress1']","XPATH"},
                    {"delAddress2","//input[@name='delAddress2']","XPATH"},
                    {"delCity","//input[@name='delCity']","XPATH"},
                    {"delState","//input[@name='delState']","XPATH"},
                    {"delZip","//input[@name='delZip']","XPATH"},
            };

    private final String[][] rawSelElements = {
            {"mealSel","//select[@name='pass.0.meal']","XPATH"},
            {"cardTypeSel","//select[@name='creditCard']","XPATH"},
            {"expirationMonthSel","//select[@name='cc_exp_dt_mn']","XPATH"},
            {"expirationYearSel","//select[@name='cc_exp_dt_yr']","XPATH"},
            {"billCountrySel","//select[@name='billCountry']","XPATH"},
            {"delCountrySel","//select[@name='delCountry']","XPATH"},
    };

    public HashMap<String, WebElement> getPassengerInfoNonSelElements(){

        return this.getWebElements(rawElements);
    }

    public HashMap<String, Select> getFlightDetailsSelElements(){

        return this.getSelElements(rawSelElements);
    }
}
