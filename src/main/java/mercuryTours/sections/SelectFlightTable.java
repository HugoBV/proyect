package mercuryTours.sections;

import org.openqa.selenium.WebDriver;

public class SelectFlightTable extends BaseSection {
    public SelectFlightTable(WebDriver driver) {
        super(driver);
    }

    public boolean isSelectFlightVisible(){
        return (this.flightSelectFlightElement.getSelectFlightHeader().size()>0);

    }
}
