package mercuryTours.sections;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class UserInformationSection extends BaseSection {
    public UserInformationSection(WebDriver driver) {
        super(driver);
    }

    public void fillUserInfo(String uName, String password){
        this.userInformationElements.getUserTxtElements().get("userName").sendKeys(uName);
        this.userInformationElements.getUserTxtElements().get("password").sendKeys(password);
        this.userInformationElements.getUserTxtElements().get("confirmPassword").sendKeys(password);

    }

    public boolean isMandatoryField(String field){
        String contactFields= "firstNamelastNamephoneemail";
        WebElement label;

        if(contactFields.contains(field)){
            label = this.contactInformationElements.getContactInfoElements().get(field+"LblColor");
        }else{
            label  = this.userInformationElements.getUserTxtElements().get(field+"LblColor");
        }
        if(label.getAttribute("color")!=null&&label.getAttribute("color").toString().equals("red")){
            return true;
        }
        else
            return false;
    }
}
