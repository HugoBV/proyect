package mercuryTours.sections;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;



public class TopSection extends BaseSection{


    public TopSection(WebDriver driver) {
        super(driver);
    }



    public void clickOnMenuOption(String option) {
        this.topMenuElement.topMenu().get(option).click();

    }

    public boolean isSignOffAvailable(){
        //System.out.println(this.topMenuElement.getSignOff().size()!=0);
        return this.topMenuElement.getSignOff().size()!=0;
    }

    public void goSignOff(){

        this.topMenuElement.getSignOff().get(0).click();
    }




}
