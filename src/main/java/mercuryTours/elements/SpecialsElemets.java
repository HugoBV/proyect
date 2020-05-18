package mercuryTours.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.HashMap;
import java.util.List;

public class SpecialsElemets extends BaseElement{
    public SpecialsElemets(WebElement rootElement) {
        super(rootElement);
    }

    private String[][] rawElements =
            {{"specialsHeader","img[alt='Specials']","CSS"}
            };


    public List<WebElement> getSpecialHeader(){
        return rootElement.findElements(By.xpath("//img[@alt ='Featured Destination: Aruba']"));
    }
}
