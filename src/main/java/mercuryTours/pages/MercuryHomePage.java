package mercuryTours.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;;
import org.openqa.selenium.support.How;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MercuryHomePage extends BasePage{

    private static final String MERCURY_MAIN_PAGE = "http://newtours.demoaut.com/";

    public MercuryHomePage(WebDriver driver) {
        super(driver, driver.getCurrentUrl());
    }

    public static void open(WebDriver driver) {
        driver.get(MERCURY_MAIN_PAGE);
    }

    @FindBy(how = How.CSS, using = "img[src$='destination.gif']")
    private WebElement featuredHeader;

    public MercuryRegisterPage goRegisterPage(String option){
        this.topSection.clickOnMenuOption(option);
        return new MercuryRegisterPage(this.driver);
    }

    public MercurySignOnPage goSignOnPage(String option){
        this.topSection.clickOnMenuOption(option);
        return new MercurySignOnPage(this.driver);
    }

    public MercuryFlightsPage goFlightsPage(String option){
        this.leftSection.clickOnMenuOption(option);
        return new MercuryFlightsPage(this.driver);
    }

    public MercuryCruisesPage goCruisesPage(String option){
        this.leftSection.clickOnMenuOption(option);
        return new MercuryCruisesPage(this.driver);
    }

    public MercuryUnderConstructionPage goSupportPage(String option){
        this.topSection.clickOnMenuOption(option);
        return new MercuryUnderConstructionPage(this.driver);
    }

    public MercuryUnderConstructionPage goContactPage(String option){
        this.topSection.clickOnMenuOption(option);
        return new MercuryUnderConstructionPage(this.driver);
    }

    public boolean isSpecialSectionAvailable(){
        return specialsSection.isSpecialsHeaderVisible();
    }


}
