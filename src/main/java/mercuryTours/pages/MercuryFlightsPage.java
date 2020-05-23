package mercuryTours.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.HashMap;

public class MercuryFlightsPage extends BasePage{
    public MercuryFlightsPage(WebDriver driver) {
        super(driver, driver.getCurrentUrl());
    }

    @FindBy(how = How.XPATH, using = "//input[@name='findFlights']")
    private WebElement flightContinue;

    public boolean isFlightDetailSectionAvailable(){
        return flightDetailsSection.isFightFinderHeaderVisible();
    }
    public void setFlightDetails(String[] values){
        this.flightDetailsSection.fillFlightDetailsFull(values);
    }

    public void setFlightPreferences(String[] values){
        this.flightPreferencesSection.fillFlightPrefereces(values);
    }

    public void fillFlightFinderForm(String[] values){
        String[] pref = {values[values.length-2],values[values.length-1]};
        this.setFlightDetails(values);

        this.setFlightPreferences(pref);
    }

    public MercurySelectFlightPage continueToSelectFlight(){
        this.flightContinue.click();
        return new MercurySelectFlightPage(this.driver);
    }

    public boolean isContinueButtonVisible(){
        return  this.flightContinue.isDisplayed();
    }

    public MercurySelectFlightPage flightFinderFull(String[] fDetails, String sClass, String airline){
        this.flightDetailsSection.fillFlightDetailsFull(fDetails);
        this.flightPreferencesSection.selectServicesClass(sClass);
        this.flightPreferencesSection.selectDropdownOptionByVisibleText(airline);
        this.flightContinue.click();
        return new MercurySelectFlightPage(this.driver);
    }

    public boolean isExpectedRadioChecked(String expected){
        return this.flightDetailsSection.getSelectedRadio().equals(expected);
    }

    public boolean checkIfFlightDetailsDefaultValuesAreTheExpected(String[] expectedValues){ //type,passengers,departing,onMonth,onDay,returning,returningMonth,returningDay
        HashMap<String, String> selectedValues = this.flightDetailsSection.getFlightDetailsValues();
        return (expectedValues[0].equals(selectedValues.get("type"))&&
                expectedValues[1].contains(selectedValues.get("passengers"))&&
                expectedValues[2].equals(selectedValues.get("departing"))&&
                expectedValues[3].equals(selectedValues.get("onMonth"))&&
                expectedValues[4].contains(selectedValues.get("onDay"))&&
                expectedValues[5].equals(selectedValues.get("arriving"))&&
                expectedValues[6].equals(selectedValues.get("returningMonth"))&&
                expectedValues[7].contains(selectedValues.get("returningDay")));
    }

    public boolean isOneRadioDeselectedWhenOtherRadioIsSelected(String radioValue){

        return this.flightDetailsSection.isGotDeselected(radioValue);
    }

    public boolean validateDetailsDropdowns(String expectedDefault, String[] expectedOptions, String dropDownName){

        return (this.flightDetailsSection.checkDetailsDropdownDefaultValue(expectedDefault,dropDownName) && this.flightDetailsSection.checkDetailsDropdownOptions(expectedOptions,dropDownName));

    }

    public boolean validatePreferencesDropdowns(String expectedDefault, String[] expectedOptions, String dropDownName){

        return (this.flightPreferencesSection.checkPreferencesDropdownDefaultValue(expectedDefault,dropDownName) && this.flightPreferencesSection.checkPreferencesDropdownOptions(expectedOptions,dropDownName));

    }

    public boolean isOneServiceClassRadioDeselectedWhenOtherRadioIsSelected(String radioValue){

        return this.flightPreferencesSection.isGotDeselected(radioValue);
    }

    public boolean checkIfFlightPreferencesDefaultValuesAreTheExpected(String expectedServClassDefaultValue, String expectedAirlineDefaultValue){
        String servClass = "";
        if(expectedServClassDefaultValue.toLowerCase().contains("economy"))
        {
            servClass = "economy";
        }else {
            servClass = expectedServClassDefaultValue;
        }
        return this.flightPreferencesSection.checkFlightPreferencesDefaultValues(servClass,expectedAirlineDefaultValue);
    }

}
