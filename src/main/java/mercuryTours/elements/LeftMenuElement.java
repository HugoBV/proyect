package mercuryTours.elements;

import org.openqa.selenium.WebElement;

import java.util.HashMap;

public class LeftMenuElement extends BaseElement{
    public LeftMenuElement(WebElement rootElement) {
        super(rootElement);
    }
    private String[][] rawElements =
            {{"home","//a[contains(text() ,'Home')]","XPATH"},
            {"flights","//a[contains(text() ,'Flights')]","XPATH"},
            {"hotels","//a[contains(text() ,'Hotels')]","XPATH"},
            {"carRentals","//a[contains(text() ,'Rentals')]","XPATH"},
            {"cruises","//a[contains(text() ,'Cruises')]","XPATH"},
            {"destinations","//a[contains(text() ,'Destinations')]","XPATH"},
            {"vacations","//a[contains(text() ,'Vacations')]","XPATH"},
            };

    public HashMap<String, WebElement> leftMenu(){

        return this.getWebElements(rawElements);
    }
}
