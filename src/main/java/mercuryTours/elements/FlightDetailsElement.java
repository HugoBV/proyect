package mercuryTours.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.HashMap;
import java.util.List;

public class FlightDetailsElement extends BaseElement {

    public FlightDetailsElement(WebElement rootElement) {
        super(rootElement);
    }

    private final String[][] rawElements =
            {{"roundTrip","//input[@value='roundtrip']","XPATH"},
                    {"oneWay","//input[@value='oneway']","XPATH"},
            };

    private final String[][] selElements =
            {{"passengerSel","//select[@name='passCount']","XPATH"},
                    {"departingFromSel","//select[@name='fromPort']","XPATH"},
                    {"onMonthSel","//select[@name='fromMonth']","XPATH"},
                    {"onDaySel","//select[@name='fromDay']","XPATH"},
                    {"arrivingInSel","//select[@name='toPort']","XPATH"},
                    {"returningMonthSel","//select[@name='toMonth']","XPATH"},
                    {"returningDaySel","//select[@name='toDay']","XPATH"},
            };


    public List<WebElement> getFlightFinderHeader(){
        return rootElement.findElements(By.xpath("//img[contains(@src,'flightfinder.gif')]"));
    }

    public HashMap<String, WebElement> getFlightDetailsNoSelElements(){

        return this.getWebElements(rawElements);
    }

    public HashMap<String, Select> getFlightDetailsSelElements(){

        return this.getSelElements(selElements);
    }
}
