package mercuryTours.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.HashMap;

public class MercurySelectFlight extends BasePage {
    public MercurySelectFlight(WebDriver driver)  {
        super(driver, driver.getCurrentUrl());
    }

    @FindBy(how = How.CSS, using = "input[name=reserveFlights]")
    private WebElement continue2BookFlight;

    public boolean isSelectFlightAvailable(){
        return selectFlightTable.isSelectFlightVisible();
    }

    protected String departTableXpath = "/html/body/div[1]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table[1]/tbody/tr";
    protected String returnTableXpath = "/html/body/div[1]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table[2]/tbody/tr";

    public HashMap selectDepartFlight(int idx){
        selectFlightTable.checkRadioSelectFlightPage(departTableXpath,idx);
        return selectFlightTable.getTableContentSelectFlightPage(departTableXpath);
    }

    public HashMap selectReturnFlight(int idx){
        selectFlightTable.checkRadioSelectFlightPage(returnTableXpath,idx);
        return selectFlightTable.getTableContentSelectFlightPage(returnTableXpath);
    }

    public void goBookFlight(){
        continue2BookFlight.click();
    }
}
