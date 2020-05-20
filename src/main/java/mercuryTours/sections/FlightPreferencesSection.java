package mercuryTours.sections;

import org.openqa.selenium.WebDriver;

public class FlightPreferencesSection extends BaseSection {


    public FlightPreferencesSection(WebDriver driver) {
        super(driver);
    }

    public void selectServicesClass(String type){
        this.flightPreferencesElement.getFlightPreferencesNoSelElements().get(type).click();
    }

    public void selectDropdownOptionByVisibleText(String value){
        this.flightPreferencesElement.getFlightPreferencesSelElements().get("passengerSel").selectByVisibleText(value);
    }
}
