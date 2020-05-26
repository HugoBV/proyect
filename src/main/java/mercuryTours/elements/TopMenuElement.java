package mercuryTours.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.HashMap;
import java.util.List;

public class TopMenuElement extends BaseElement{

    public TopMenuElement(WebElement rootElement) {
        super(rootElement);
    }

    private String[][] rawElements =
            {{"signOn","//a[contains(text() ,'SIGN-ON')]","XPATH"},
            {"register","//a[contains(text() ,'REGISTER')]","XPATH"},
            {"support","//a[contains(text() ,'SUPPORT')]","XPATH"},
            {"contact","//a[contains(text() ,'CONTACT')]","XPATH"},
            };

    public List<WebElement> getSignOff(){
        return this.rootElement.findElements(By.xpath("//a[contains(text() ,'SIGN-OFF')]"));
    }

    public HashMap<String, WebElement> topMenu(){

        return this.getWebElements(rawElements);
    }


}
