package mercuryTours.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.HashMap;

public class MailingInformationElements extends BaseElement {
    public MailingInformationElements(WebElement rootElement) {
        super(rootElement);
    }

    private String[][] rawElements =
                    {{"address1","input[name=address1]","CSS"},
                    {"address2","input[name=address2]","CSS"},
                    {"city","input[name=city]","CSS"},
                    {"state","input[name=state]","CSS"},
                    {"postalCode","input[name=postalCode]","CSS"}
            };

    public HashMap<String, WebElement> getMailingTxtElements(){
        return this.getWebElements(rawElements);
    }

    public Select getCountryDropdown() {
        return new Select(this.rootElement.findElement(By.cssSelector("select[name=country]")));
    }
}
