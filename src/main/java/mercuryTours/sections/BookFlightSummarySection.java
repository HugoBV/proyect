package mercuryTours.sections;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.HashMap;
import java.util.List;

public class BookFlightSummarySection extends BaseSection {
    public BookFlightSummarySection(WebDriver driver) {
        super(driver);
    }

    public HashMap<String, String> getTableContentBookFlightPage(String xpath){

        List<WebElement> rows = driver.findElements(By.xpath(xpath));
        List <WebElement> cols;
        HashMap<String, String> rowContent = new HashMap<String, String>();
        for(int i=0;i<rows.size();i++){
            cols = rows.get(i).findElements(By.tagName("td"));
            switch(i){
                case 0:
                    rowContent.put("depart", cols.get(0).getText());
                    rowContent.put("departDate", cols.get(1).getText());
                case 1:
                    rowContent.put("departFlight", "");
                    rowContent.put("departClass", "");
                    rowContent.put("departPrice", "");
                    break;
                case 2:
                    rowContent.replace("departFlight", cols.get(0).getText());
                    rowContent.replace("departClass", cols.get(1).getText());
                    rowContent.replace("departPrice", cols.get(2).getText());
                    break;
                case 3:
                    rowContent.put("return", cols.get(0).getText());
                    rowContent.put("returnDate", cols.get(1).getText());
                    break;
                case 4:
                    rowContent.put("returnFlight", "");
                    rowContent.put("returnClass", "");
                    rowContent.put("returnPrice", "");
                    break;
                case 5:
                    rowContent.replace("returnFlight", cols.get(0).getText());
                    rowContent.replace("returnClass", cols.get(1).getText());
                    rowContent.replace("returnPrice", cols.get(2).getText());
                    break;
                case 6:
                    rowContent.put("passengers",cols.get(1).getText());
                    break;
                case 7:
                    rowContent.put("taxes",cols.get(1).getText());
                    break;
                case 8:
                    rowContent.put("totalPrice",cols.get(1).getText());
                    break;
            }

        }
        return rowContent;
    }

}
