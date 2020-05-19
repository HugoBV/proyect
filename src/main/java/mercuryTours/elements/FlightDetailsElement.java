package mercuryTours.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class FlightDetailsElement extends BaseElement {

    public FlightDetailsElement(WebElement rootElement) {
        super(rootElement);
    }

    private String[][] rawElements =
            {{}
            };


    public List<WebElement> getSpecialHeader(){
        return rootElement.findElements(By.xpath("//img[contains(@src,'flightfinder.gif')]"));
    }
}
