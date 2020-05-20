package mercuryTours.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class FlightSelectFlightElement extends BaseElement {
    public FlightSelectFlightElement(WebElement rootElement) {
        super(rootElement);
    }

    public List<WebElement> getSelectFlightHeader(){
        return rootElement.findElements(By.xpath("//img[contains(@src,'mast_selectflight.gif')]"));
    }
}
