package mercuryTours;

import mercuryTours.pages.MercuryHomePage;
import mercuryTours.pages.MercuryRegisterPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class registerTest extends BaseTest{

    private String[] regInfo = {"Fer","Perez","22323433-3","asd@asdas.com","Ave Siempre Viva","1234","Guadalajara","Jalisco","44350","Mexico","Boot","camp"};

    @Test(priority = 0, description = "TC01_Registration Page_User Registration Mandatory Field")
    public void verifyMandatoryFields(){
        log.info("Starting TC01 - Registration Page_User Registration Mandatory Field");
        MercuryHomePage.open(this.myDriver);
        MercuryHomePage mainPage = new MercuryHomePage(this.myDriver);
        MercuryRegisterPage regPage =  mainPage.goDesiredPage("register");
        String[] fieldsToVerify = {"firstName","lastName","phone","email","userName","password","confirmPassword"};
        for(int i=0; i<fieldsToVerify.length;i++) {
            if (i < 4) {
                Assert.assertFalse(regPage.checkIsFieldIsMandatory(fieldsToVerify[i]), fieldsToVerify[i] + " is not mandatory and displayed in black");
            } else {
                Assert.assertTrue(regPage.checkIsFieldIsMandatory(fieldsToVerify[i]), fieldsToVerify[i] + " is mandatory and must be red");
            }
        }
    }

    @Test(priority = 1, description = "TC02_Registration Page_User Mandadory Fields_Submit Formulary-No Information Provide")
    public void verifyBlankRegistrationIsPossible(){
        MercuryHomePage.open(this.myDriver);
        MercuryHomePage mainPage = new MercuryHomePage(this.myDriver);
        MercuryRegisterPage regPage =  mainPage.goDesiredPage("register");
        String expectedMessage1 = "Dear ,";
        Assert.assertTrue(regPage.getRegistrationDone().registrationMessageIsVisible(expectedMessage1),"User Name displayed with the register name that you provide at the formulary");
    }

    @Test(priority = 2, description = "TC04_Registration Page_User Mandadory Fields and Not Mandatory-Submit")
    public void registrationDoneUsingFullData(){
        MercuryHomePage.open(this.myDriver);
        String expectedMessage1 = "Dear "+regInfo[0]+" "+regInfo[1]+",";
        MercuryHomePage mainPage = new MercuryHomePage(this.myDriver);
        MercuryRegisterPage regPage =  mainPage.goDesiredPage("register");
        Assert.assertTrue(regPage.getRegistrationDone(regInfo).registrationMessageIsVisible(expectedMessage1),"User Name displayed with the register name that you provide at the formulary");
    }

    @Test(priority = 3, description = "TC05_Registration Page_Sign In Link")
    public void goSignInPageAfterRegistrationDone(){
        MercuryHomePage.open(this.myDriver);
        String expectedMessage1 = "Dear "+regInfo[0]+" "+regInfo[1]+",";
        MercuryHomePage mainPage = new MercuryHomePage(this.myDriver);
        MercuryRegisterPage regPage =  mainPage.goDesiredPage("register");
        Assert.assertTrue(regPage.getRegistrationDone(regInfo).pressSignInLink().pageReady(),"Sign-in Page should be displayed");
    }
}
