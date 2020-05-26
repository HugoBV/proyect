package mercuryTours.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class MercurySignOnPage extends BasePage{
    public MercurySignOnPage(WebDriver driver) {
        super(driver, driver.getCurrentUrl());
    }

    @FindBy(how = How.XPATH, using = "//img[contains(@src,'mast_signon.gif')]")
    private WebElement signOntHeader;

    @FindBy(how = How.XPATH, using = "//b[contains(text(),'Welcome')]")
    private WebElement welcomeMessage;

    @FindBy(how = How.XPATH, using = "//a[contains(text(),'registration')]")
    private WebElement registerLink;

    @FindBy(how = How.XPATH, using = "//b[contains(text(),'User')]/parent::font")
    private WebElement userNameLbl;

    @FindBy(how = How.XPATH, using = "//b[contains(text(),'Password')]/parent::font")
    private WebElement passwordLbl;

    @FindBy(how = How.CSS, using = "input[name=userName]")
    private WebElement userName;

    @FindBy(how = How.CSS, using = "input[name=password]")
    private WebElement password;

    @FindBy(how = How.CSS, using = "input[name=login]")
    private WebElement submit;

    @FindBy(how = How.CSS, using = "div[class=footer]")
    private WebElement copyright;

    public boolean isSignOnHeaderAvailable(){
        return this.signOntHeader.isDisplayed();
    }

    @FindBy(how = How.XPATH, using = "//a[contains(text(),'registration')]")
    private WebElement registrationFormLink;

    public boolean verifyWelcomeMsg(){
        return welcomeMessage.isDisplayed();
    }

    public boolean verifyCopyright(){
        return copyright.isDisplayed();
    }

    public MercuryRegisterPage checkRegisterLink(){
        registerLink.click();
        return new MercuryRegisterPage(this.driver);
    }

    public MercuryHomePage signIn(String user, String pass){
        userName.sendKeys(user);
        password.sendKeys(pass);
        submit.click();
        return new MercuryHomePage(this.driver);
    }

    public void trySignIn(String user, String pass){
        userName.sendKeys(user);
        password.sendKeys(pass);
        submit.click();
    }

    public MercuryFlightsPage doWorkAroundSignIn(){
        userName.sendKeys("a");
        password.sendKeys("a");
        submit.click();
        return new MercuryFlightsPage(this.driver);
    }

    public void setUserName(String uName){
        userName.sendKeys(uName);
    }

    public void setPassword(String pass){
        password.sendKeys(pass);
    }

    public MercurySignOnPage trySubmitWrongData(){
        submit.click();
        return new MercurySignOnPage(driver);
    }

    public boolean signIn(){
        submit.click();
        return verifyWelcomeMsg();
    }

    public boolean isUserMarkedAsMandatory(){
        return userNameLbl.getAttribute("color")!=null&&
                userNameLbl.getAttribute("color").equals("red");
    }

    public boolean isPasswordMarkedAsMandatory(){
        return passwordLbl.getAttribute("color")!=null&&
                passwordLbl.getAttribute("color").equals("red");
    }

    public MercuryRegisterPage tryRegistrationFormLink()
    {
        this.registerLink.click();
        return new MercuryRegisterPage(driver);
    }

    public boolean isRegistrationFormLinkAvailable(){
        return registrationFormLink.isDisplayed();
    }


}
