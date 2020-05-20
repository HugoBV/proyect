package mercuryTours.elements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.HashMap;

public class FlightPreferencesElement extends BaseElement {

    public FlightPreferencesElement(WebElement rootElement) {
        super(rootElement);
    }

    private final String[][] rawElements =
            {{"economy","//input[@value='Coach']","XPATH"},
                    {"business","//input[@value='Business']","XPATH"},
                    {"first","//input[@value='First']","XPATH"},
            };

    private final String[][] selElements =
            {{"passengerSel","//select[@name='airline']","XPATH"},

            };

    public HashMap<String, WebElement> getFlightPreferencesNoSelElements(){

        return this.getWebElements(rawElements);
    }

    public HashMap<String, Select> getFlightPreferencesSelElements(){

        return this.getSelElements(selElements);
    }
}
