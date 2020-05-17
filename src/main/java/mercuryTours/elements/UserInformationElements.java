package mercuryTours.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.HashMap;

public class UserInformationElements extends BaseElement{
    public UserInformationElements(WebElement rootElement) {
        super(rootElement);
    }
    private String[][] rawElements =
                    {{"userName","input[name=email]","CSS"},
                    {"password","input[name=password]","CSS"},
                    {"confirmPassword","input[name=confirmPassword]","CSS"},
                    {"userNameLblColor","//b[contains(text(),'User')]/parent::font","XPATH"},
                    {"passwordLblColor","//b[contains(text(),'Password')]/parent::font","XPATH"},
                    {"confirmPasswordLblColor","//b[contains(text(),'Confirm')]/parent::font","XPATH"}
            };

    public HashMap<String, WebElement> getUserTxtElements(){
        return this.getWebElements(rawElements);
    }
}
