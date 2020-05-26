package mercuryTours.sections;

import org.openqa.selenium.WebDriver;

public class LeftSection extends BaseSection{
    public LeftSection(WebDriver driver) {
        super(driver);
    }

    public void clickOnMenuOption(String option) {
        this.leftMenuElement.leftMenu().get(option).click();

    }


}
