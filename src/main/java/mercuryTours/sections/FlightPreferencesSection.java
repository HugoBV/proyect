package mercuryTours.sections;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class FlightPreferencesSection extends BaseSection {


    public FlightPreferencesSection(WebDriver driver) {
        super(driver);
    }

    public void fillFlightPrefereces(String[] values){
        this.flightPreferencesElement.getFlightPreferencesNoSelElements().get(values[0]).click();
        this.flightPreferencesElement.getFlightPreferencesSelElements().get("airlineSel").selectByVisibleText(values[1]);

    }
    public void selectServicesClass(String type){
        this.flightPreferencesElement.getFlightPreferencesNoSelElements().get(type).click();
    }

    public void selectDropdownOptionByVisibleText(String value){
        this.flightPreferencesElement.getFlightPreferencesSelElements().get("airlineSel").selectByVisibleText(value);
    }

    public boolean checkPreferencesDropdownDefaultValue(String expectedValue, String dropDownName){

        return (this.flightPreferencesElement.getFlightPreferencesSelElements().get(dropDownName).getFirstSelectedOption().getText().contains(expectedValue));
    }

    public boolean checkPreferencesDropdownOptions(String[] expectedValues,String dropDownName)
    {
        List<WebElement> dropDownOptions = this.flightPreferencesElement.getFlightPreferencesSelElements().get(dropDownName).getOptions();
        int itr = 0;
        boolean pass = false;
        if(dropDownOptions.size()==expectedValues.length){
            for (WebElement option:dropDownOptions ) {
                //System.out.println(option.getText());
                if(option.getText().contains(expectedValues[itr++])){
                    this.flightPreferencesElement.getFlightPreferencesSelElements().get(dropDownName).selectByVisibleText(option.getText());
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

    public boolean isGotDeselected(String radioValue){ //economy, business, first
        boolean originalValue = this.flightPreferencesElement.getFlightPreferencesNoSelElements().get(radioValue).isSelected();
        this.flightPreferencesElement.getFlightPreferencesNoSelElements().get(radioValue).click();
        return (originalValue!=this.flightPreferencesElement.getFlightPreferencesNoSelElements().get(radioValue).isSelected());
    }

    public boolean checkFlightPreferencesDefaultValues(String expectedServClassDefaultValue, String expectedAirlineDefaultValue){
        return (this.flightPreferencesElement.getFlightPreferencesNoSelElements().get(expectedServClassDefaultValue).isSelected()&&this.flightPreferencesElement.getFlightPreferencesSelElements().get("airlineSel").getFirstSelectedOption().getText().equals(expectedAirlineDefaultValue));

    }
}
