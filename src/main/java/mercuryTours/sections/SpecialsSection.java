package mercuryTours.sections;

import org.openqa.selenium.WebDriver;

public class SpecialsSection extends BaseSection {
    public SpecialsSection(WebDriver driver) {
        super(driver);
    }

    public boolean isSpecialsHeaderVisible(){
        if(specialsElemets.getSpecialHeader().size()>0){
            return true;
        }else
            return false;

    }
}
