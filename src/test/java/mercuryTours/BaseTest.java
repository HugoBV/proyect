package mercuryTours;

import mercuryTours.sections.BaseSection;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import utils.WebDriverFactory;

public class BaseTest {

    protected WebDriver myDriver;
    protected WebDriverWait myWait;
    protected Logger log;

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        // Define which browser to use
        String browser = "chrome";

        // Get correct driver for desire browser
        myDriver = WebDriverFactory.getDriver(browser);
        this.log = LogManager.getLogger(BaseTest.class.getName());
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        myDriver.close();
        myDriver.quit();
    }

}
