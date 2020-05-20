package mercuryTours.sections;

import org.openqa.selenium.WebDriver;

public class FlightDetailsSection extends BaseSection {


    public FlightDetailsSection(WebDriver driver) {
        super(driver);
    }

    public boolean isFightFinderHeaderVisible(){
        return (flightDetailsElement.getFlightFinderHeader().size()>0);

    }

    public void selectFlightType(String type){
        this.flightDetailsElement.getFlightDetailsNoSelElements().get(type).click();
    }

    public void selectDropdownOptionByVisibleText(String dropDownName, String value){
        this.flightDetailsElement.getFlightDetailsSelElements().get(dropDownName).selectByVisibleText(value);
    }

    public void filFlightDetailsFull(String[] values){
        this.flightDetailsElement.getFlightDetailsNoSelElements().get(values[0]).click();
        this.flightDetailsElement.getFlightDetailsSelElements().get("passengerSel").selectByVisibleText(values[1]);
        this.flightDetailsElement.getFlightDetailsSelElements().get("departingFromSel").selectByVisibleText(values[2]);
        this.flightDetailsElement.getFlightDetailsSelElements().get("onMonthSel").selectByVisibleText(values[3]);
        this.flightDetailsElement.getFlightDetailsSelElements().get("onDaySel").selectByVisibleText(values[4]);
        this.flightDetailsElement.getFlightDetailsSelElements().get("arrivingInSel").selectByVisibleText(values[5]);
        this.flightDetailsElement.getFlightDetailsSelElements().get("returningMonthSel").selectByVisibleText(values[6]);
        this.flightDetailsElement.getFlightDetailsSelElements().get("returningDaySel").selectByVisibleText(values[7]);

    }
}
