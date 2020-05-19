package mercuryTours.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.HashMap;
import java.util.List;

public class SpecialsElements extends BaseElement{
    public SpecialsElements(WebElement rootElement) {
        super(rootElement);
    }

    private String[][] rawElements =
            {{}
            };


    public List<WebElement> getSpecialHeader(){
        return rootElement.findElements(By.xpath("//img[@alt='Specials']"));
    }
}
