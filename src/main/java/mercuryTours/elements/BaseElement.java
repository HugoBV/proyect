package mercuryTours.elements;

import mercuryTours.sections.TopSection;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.HashMap;

public class BaseElement {
    protected WebElement rootElement;

    public BaseElement(WebElement rootElement) {
        this.rootElement = rootElement;
    }

    public HashMap<String, WebElement> getWebElements(String[][] locators){
        HashMap<String, WebElement> webElementMap = new HashMap<String, WebElement>();
        if(locators.length>0){
            for(int i=0;i<locators.length;i++){
                if(locators[i][2].equals("XPATH")){
                    webElementMap.put(locators[i][0], this.rootElement.findElement(By.xpath(locators[i][1])));
                }else if (locators[i][2].equals("CSS")){
                    webElementMap.put(locators[i][0], this.rootElement.findElement(By.cssSelector(locators[i][1])));
                }
            }
            return webElementMap;
        }else
            return null;

    }

}
