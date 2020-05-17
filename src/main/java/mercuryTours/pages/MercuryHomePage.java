package mercuryTours.pages;

import org.openqa.selenium.WebDriver;

public class MercuryHomePage extends BasePage{

    private static final String MERCURY_MAIN_PAGE = "http://newtours.demoaut.com/";

    public MercuryHomePage(WebDriver driver) {
        super(driver, driver.getCurrentUrl());
    }

    public static void open(WebDriver driver) {
        driver.get(MERCURY_MAIN_PAGE);
    }

    public MercuryRegisterPage goDesiredPage(String option){
        this.topSection.clickOnMenuOption(option);
        return new MercuryRegisterPage(this.driver);
    }

    public void other(){
        this.topSection.other();
    }

}
