package mercuryTours.sections;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    public String getSelectedRadio(){
        String checked = "";
        if(this.flightDetailsElement.getFlightDetailsNoSelElements().get("roundTrip").isSelected()){
            checked = "roundtrip";
        }else if(this.flightDetailsElement.getFlightDetailsNoSelElements().get("oneWay").isSelected()){
            checked = "oneway";
        }
        return checked;
    }

    public HashMap<String, String> getFlightDetailsValues(){
        HashMap<String, String> selectedValues = new HashMap<String, String>();
        selectedValues.put("type", this.getSelectedRadio());
        selectedValues.put("passengers", this.flightDetailsElement.getFlightDetailsSelElements().get("passengerSel").getFirstSelectedOption().getText());
        selectedValues.put("departing", this.flightDetailsElement.getFlightDetailsSelElements().get("departingFromSel").getFirstSelectedOption().getText());
        selectedValues.put("onMonth", this.flightDetailsElement.getFlightDetailsSelElements().get("onMonthSel").getFirstSelectedOption().getText());
        selectedValues.put("onDay", this.flightDetailsElement.getFlightDetailsSelElements().get("onDaySel").getFirstSelectedOption().getText());
        selectedValues.put("arriving", this.flightDetailsElement.getFlightDetailsSelElements().get("arrivingInSel").getFirstSelectedOption().getText());
        selectedValues.put("returningMonth", this.flightDetailsElement.getFlightDetailsSelElements().get("returningMonthSel").getFirstSelectedOption().getText());
        selectedValues.put("returningDay", this.flightDetailsElement.getFlightDetailsSelElements().get("returningDaySel").getFirstSelectedOption().getText());
       /* System.out.println(this.getSelectedRadio());
        System.out.println(this.flightDetailsElement.getFlightDetailsSelElements().get("passengerSel").getFirstSelectedOption().getText());
        System.out.println(this.flightDetailsElement.getFlightDetailsSelElements().get("departingFromSel").getFirstSelectedOption().getText());
        System.out.println(this.flightDetailsElement.getFlightDetailsSelElements().get("onMonthSel").getFirstSelectedOption().getText());
        System.out.println(this.flightDetailsElement.getFlightDetailsSelElements().get("onDaySel").getFirstSelectedOption().getText());
        System.out.println(this.flightDetailsElement.getFlightDetailsSelElements().get("arrivingInSel").getFirstSelectedOption().getText());
        System.out.println(this.flightDetailsElement.getFlightDetailsSelElements().get("returningMonthSel").getFirstSelectedOption().getText());
        System.out.println(this.flightDetailsElement.getFlightDetailsSelElements().get("returningDaySel").getFirstSelectedOption().getText());

*/
        return  selectedValues;
    }

    public boolean isGotDeselected(String radioValue){ //roundTrip, oneWay
        boolean originalValue = this.flightDetailsElement.getFlightDetailsNoSelElements().get(radioValue).isSelected();
        this.flightDetailsElement.getFlightDetailsNoSelElements().get(radioValue).click();
        return (originalValue!=this.flightDetailsElement.getFlightDetailsNoSelElements().get(radioValue).isSelected());
    }

    public boolean checkDetailsDropdownDefaultValue(String expectedValue, String dropDownName){

        return (this.flightDetailsElement.getFlightDetailsSelElements().get(dropDownName).getFirstSelectedOption().getText().contains(expectedValue));
    }

    public boolean checkDetailsDropdownOptions(String[] expectedValues, String dropDownName)
    {
        List<WebElement> dropDownOptions = this.flightDetailsElement.getFlightDetailsSelElements().get(dropDownName).getOptions();
        int itr = 0;
        boolean pass = false;
        if(dropDownOptions.size()==expectedValues.length){
            for (WebElement option:dropDownOptions ) {
                //System.out.println(option.getText());
                if(option.getText().contains(expectedValues[itr++])){
                    this.flightDetailsElement.getFlightDetailsSelElements().get(dropDownName).selectByVisibleText(option.getText());
                    pass = true;
                }
                else{
                    pass = false;
                    break;
                }

            }
        }
        return pass;

    }

}
