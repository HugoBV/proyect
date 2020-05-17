package mercuryTours.sections;

import mercuryTours.elements.TopMenuElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import javax.swing.plaf.basic.BasicTabbedPaneUI;
import java.util.HashMap;

public class TopSection extends BaseSection{


    public TopSection(WebDriver driver) {
        super(driver);
    }



    public void clickOnMenuOption(String option) {
        this.topMenuElement.topMenu().get(option).click();
      /*  HashMap<String, WebElement> topMenu = new HashMap<String, WebElement>();

        topMenu.put("signOn", this.driver.findElement(By.xpath("//a[contains(text() ,'SIGN-ON')]")));
        topMenu.put("register",this.driver.findElement(By.xpath("//a[contains(text() ,'REGISTER')]")));
        topMenu.put("support",this.driver.findElement(By.xpath("//a[contains(text() ,'SUPPORT')]")));
        topMenu.put("contact",this.driver.findElement(By.xpath("//a[contains(text() ,'CONTACT')]")));

       */

        //topMenu.get(option).click();
    }


    public void other() {

        System.out.println("pi");
        WebElement root = driver.findElement(By.xpath("//body/div/table"));
        root.findElement(By.xpath("//a[contains(text() ,'SIGN-ON')]")).click();

    }


}
