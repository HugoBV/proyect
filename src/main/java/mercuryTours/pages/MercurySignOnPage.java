package mercuryTours.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class MercurySignOnPage extends BasePage{
    public MercurySignOnPage(WebDriver driver) {
        super(driver, driver.getCurrentUrl());
    }

    @FindBy(how = How.XPATH, using = "//b[contains(text(),'Welcome')]")
    private WebElement welcomeMessage;

    @FindBy(how = How.XPATH, using = "//a[contains(text(),'registration')]")
    private WebElement registerLink;

    @FindBy(how = How.CSS, using = "input[name=userName]")
    private WebElement userName;

    @FindBy(how = How.CSS, using = "input[name=password]")
    private WebElement password;

    @FindBy(how = How.CSS, using = "input[name=login]")
    private WebElement submit;

    @FindBy(how = How.CSS, using = "div[class=footer]")
    private WebElement copyright;

    public boolean pageReady(){
        if(userName.isDisplayed())
            return true;
        else
            return false;
    }

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

    public boolean signIn(){
        submit.click();
        return verifyWelcomeMsg();
    }

}
