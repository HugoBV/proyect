package mercuryTours.sections;

import mercuryTours.pages.BasePage;
import org.openqa.selenium.WebDriver;

public class FlightDetailsSection extends BaseSection {


    public FlightDetailsSection(WebDriver driver) {
        super(driver);
    }

    public boolean isFightFinderHeaderVisible(){
        if(flightDetailsElement.getSpecialHeader().size()>0){
            return true;
        }else
            return false;

    }
}
