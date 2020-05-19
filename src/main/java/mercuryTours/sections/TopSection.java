package mercuryTours.sections;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;



public class TopSection extends BaseSection{


    public TopSection(WebDriver driver) {
        super(driver);
    }



    public void clickOnMenuOption(String option) {
        this.topMenuElement.topMenu().get(option).click();

    }


    public void other() {

        System.out.println("pi");
        WebElement root = driver.findElement(By.xpath("//body/div/table"));
        root.findElement(By.xpath("//a[contains(text() ,'SIGN-ON')]")).click();

    }


}
