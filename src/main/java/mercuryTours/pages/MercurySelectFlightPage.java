package mercuryTours.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.HashMap;

public class MercurySelectFlightPage extends BasePage {
    public MercurySelectFlightPage(WebDriver driver)  {
        super(driver, driver.getCurrentUrl());
    }

    @FindBy(how = How.CSS, using = "input[name=reserveFlights]")
    private WebElement continue2BookFlight;

    public boolean isSelectFlightAvailable(){
        return selectFlightTable.isSelectFlightVisible();
    }

    private String departTableXpath = "/html/body/div[1]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table[1]/tbody/tr";
    private String returnTableXpath = "/html/body/div[1]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table[2]/tbody/tr";

    public HashMap<String, String> selectDepartFlight(int idx){
        selectFlightTable.checkRadioSelectFlightPage(departTableXpath,idx);
        return selectFlightTable.getTableContentSelectFlightPage(departTableXpath);
    }

    public boolean checkDepartFlightTableColumns(int idx){
        selectFlightTable.checkRadioSelectFlightPage(departTableXpath,idx);
        HashMap<String, String> row = selectFlightTable.getTableContentSelectFlightPage(departTableXpath);
        return (!row.get("flight").isEmpty()&&!row.get("departTime").isEmpty()&&!row.get("stops").isEmpty());
    }

    public boolean checkReturnFlightTableColumns(int idx){
        selectFlightTable.checkRadioSelectFlightPage(returnTableXpath,idx);
        HashMap<String, String> row = selectFlightTable.getTableContentSelectFlightPage(returnTableXpath);
        return (!row.get("flight").isEmpty()&&!row.get("departTime").isEmpty()&&!row.get("stops").isEmpty());
    }

    public HashMap<String, String>  selectReturnFlight(int idx){
        selectFlightTable.checkRadioSelectFlightPage(returnTableXpath,idx);
        return selectFlightTable.getTableContentSelectFlightPage(returnTableXpath);
    }

    public MercuryBookFlightPage goBookFlight(){

        continue2BookFlight.click();
        return new MercuryBookFlightPage(this.driver);
    }


}
