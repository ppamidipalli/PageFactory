package stepDefinitions;

import java.time.Duration;

import Pages.LoginPage;
import Pages.ProfilePage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class Login {
    static WebDriver driver;
    public String URL;


    ProfilePage profilePg = PageFactory.initElements(driver, ProfilePage.class);

    @Before()
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

//        URL= loginPage.getURL();
        URL = "http://10.105.72.182:12100/JesieWeb/v2/?l=1#/login";
    }

    @After()
    public void tearDown() {
        if (driver!=null) {
            driver.close();
            driver.quit();
        }

    }

    @Given("^user navigates to psp login page$")
    public void user_navigates_to_psp_login_page() {
        driver.get(URL);
        System.out.println(driver.getTitle());

    }

    @When("^user logs in with valid credentials$")
    public void user_logs_in_with_valid_credentials() {
        driver.findElement(By.id("username")).sendKeys("ppamidi");
        driver.findElement(By.id("password")).sendKeys("ElijahMyLove#1234567");
        driver.findElement(By.xpath("/html/body/div/form/div[3]/div/button")).click();

    }

    @Then("^user lands on home page$")
    public void user_lands_on_home_page() {
        WebElement LogOut = driver.findElement(By.linkText("LOG OUT"));
        assertThat(LogOut.isDisplayed(),is(true));

    }

    @When("^user logs in with invalid credentials$")
    public void user_logs_in_with_invalid_credentials() {
        LoginPage loginPg = PageFactory.initElements(driver, LoginPage.class);
        loginPg.LogIn_Action("ppamidi", "1234567");

    }

    @Then("^login is unsuccessful$")
    public void login_is_unsuccessful() {
        String actualMessage = driver.findElement(By.className("ng-scope")).getText();
//        assertThat(actualMessage.trim(), is("JESIE\\nLog Into JESIE\\nUsername\\nPassword\\nLog In"));

    }
}
