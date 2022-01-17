package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {

    final WebDriver driver;

    //Constructor, as every page needs a Webdriver to find elements
    public LoginPage(WebDriver driver){
        this.driver=driver;
    }

    //Locating the username text box
    @FindBy(id="username")
    WebElement username;

    //Locating the password text box
    @FindBy(id="password")
    WebElement pswd;

    //Locating Login Button
    @FindBy(id="login")
    WebElement loginBtn;


    //Method that performs login action using the web elements
    public void LogIn_Action(String uName, String pwd){
        username.sendKeys(uName);
        pswd.sendKeys(pwd);
        loginBtn.click();
    }
}
