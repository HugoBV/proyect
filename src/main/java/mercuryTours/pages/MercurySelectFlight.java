package mercuryTours.pages;

import org.openqa.selenium.WebDriver;

public class MercurySelectFlight extends BasePage {
    public MercurySelectFlight(WebDriver driver)  {
        super(driver, driver.getCurrentUrl());
    }

    public boolean isSelectFlightAvailable(){
        return selectFlightTable.isSelectFlightVisible();
    }
}
