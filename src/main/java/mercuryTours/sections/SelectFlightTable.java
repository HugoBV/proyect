package mercuryTours.sections;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.HashMap;
import java.util.List;

public class SelectFlightTable extends BaseSection {
    public SelectFlightTable(WebDriver driver) {
        super(driver);
    }

    public boolean isSelectFlightVisible(){
        return (this.flightSelectFlightElement.getSelectFlightHeader().size()>0);

    }

    public HashMap getTableContentSelectFlightPage(String xpath){

        List<WebElement> rows = driver.findElements(By.xpath(xpath));
        List <WebElement> cols;
        HashMap<String, String> rowContent = new HashMap<String, String>();

        boolean done = false;
        int countDown = 2;
        for(int i=0;i<rows.size();i++){
            cols = rows.get(i).findElements(By.tagName("td"));
            if(i==0){
                rowContent.put("Title", cols.get(1).getText());
                rowContent.put("fromTo", cols.get(3).getText());
                rowContent.put("date", cols.get(4).getText());
            }
            if(i==1){
                rowContent.put("selectRow", "");
                rowContent.put("flight", "");
                rowContent.put("departTime", "");
                rowContent.put("stops", "");
            }

            if(cols.get(0).getAttribute("class").equals("frame_action_xrows") && cols.get(0).findElement(By.tagName("input")).isSelected())
            {
                rowContent.replace("selectRow", Integer.toString(i));
                rowContent.replace("flight", cols.get(1).getText());
                rowContent.replace("departTime", cols.get(2).getText());
                rowContent.replace("stops", cols.get(3).getText());
                done = true;
            }
            if(done) {
                rowContent.put("price", cols.get(0).getText());
                countDown--;
            }
            if(countDown==0) break;

        }
        return rowContent;
    }

    public boolean checkRadioSelectFlightPage(String xpath, int option){
        List <WebElement> rows = driver.findElements(By.xpath(xpath));
        List <WebElement> cols;
        int idx =0;

        for(int i=0;i<rows.size();i++){
            cols = rows.get(i).findElements(By.tagName("td"));
            if(cols.get(0).getAttribute("class").equals("frame_action_xrows"))
            {
                if(idx== option){
                    cols.get(0).findElement(By.tagName("input")).click();
                    break;
                }
                idx++;
            }
        }

        return true;
    }
}
