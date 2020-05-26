package mercuryTours.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;;
import org.openqa.selenium.support.How;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;

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

    private final String CURR_YEAR = "2020";
    private final String[] HAPPY_PATH_REG_VALS = {"Fer","Perez","22323433-3","asd@asdas.com","Ave Siempre Viva","1234","Guadalajara","Jalisco","44350","Mexico","Boot","camp"};
    private final String[] HAPPY_PATH_FLIGHTS_VALS = {"roundTrip","1 ","London","June","15","Sydney","June","25","business","Pangea Airlines"};
    private final int[] FLIGHTS_SELECTIONS = {0,3};
    private final String[] HAPPY_PATH_BOOK_VALS = {"DonC","Perez ","Kosher","Carte Blanche","4533560090991234","07","2007","Fernando","DonC","Perez",
            "check","Av. Siempre Viva 1245","Prados","Dallas","TX","90210","215","check","Robles Gil 23","La Villita","Delaware","PA","10100","215"};


    public boolean isSpecialSectionAvailable(){
        return specialsSection.isSpecialsHeaderVisible();
    }

}
