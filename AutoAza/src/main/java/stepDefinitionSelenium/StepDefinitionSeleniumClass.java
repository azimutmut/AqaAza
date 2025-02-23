package stepDefinitionSelenium;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pages.AnderserPage;
import java.time.Duration;

public class StepDefinitionSeleniumClass {
    private WebDriver driver;
    private WebDriverWait wait;
    private static AnderserPage anderserPage;

    @After
    public void closeSeleniumDriver() {
        driver.quit();
    }

    @Before
    public void preconditions() {
    }

    @Given("Set up driver")
    public void set_up_driver() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    @When("open Andersen login page")
    public void openContactUsPage() {
        driver.get("https://qa-course-01.andersenlab.com/login");
    }

    @And("Set email {string}")
    public void set_email(String text1) {
        driver.findElement(By.name("email")).sendKeys(text1);
    }

    @And("Set password {string}")
    public void set_password(String text2) {
        driver.findElement(By.name("password")).sendKeys(text2);
    }

    @And("Set wrong password {string}")
    public void set_wrong_password(String text3) {
        driver.findElement(By.name("password")).sendKeys(text3);
    }


    @And("Click login button")
    public void click_login_button() {
        driver.findElement(By.xpath("//button[text()='Sign in']")).click();
    }

    @Then("Success alert message")
    public void success_alert_message() {
        String expectedUrl = "https://qa-course-01.andersenlab.com/login"; // Replace with actual homepage URL
        Assert.assertEquals(expectedUrl, driver.getCurrentUrl());
    }


    @Then("Get error password alert")
    public void getErrorPasswordAlert() {
        visibilityOfloginInvalidPasswodError();
        ErrorAlertInvalidEmailOrPassword();
    }

    @Then("Get error empty mail alert")
    public void getErrorEmptyMailAlert() {
        visibilityOfErrorEmail();
        ErrorAlertEmptyEmail();
    }

    @FindBy(xpath = "//*[@id=\"root\"]/div/div/div/form/div/div[2]/div/span")
    private static WebElement loginInvalidPasswod;
    @FindBy(xpath = "//*[@id=\"root\"]/div/div/div/form/div/div[1]/div/span")
    private static WebElement loginEmptyEmail;
    public void visibilityOfErrorEmail() {
        wait.until(ExpectedConditions.visibilityOf(loginEmptyEmail));
    }

    public void visibilityOfloginInvalidPasswodError() {
        wait.until(ExpectedConditions.visibilityOf(loginInvalidPasswod));
    }
    public void ErrorAlertInvalidEmailOrPassword() {
        String passworInvalidAssert = loginInvalidPasswod.getText();
        Assert.assertEquals(passworInvalidAssert, "Email or password is not valid");
    }
    //    negative with empty email and password
    public void ErrorAlertEmptyEmail() {
        String emptyEmailAssert = loginEmptyEmail.getText();
        Assert.assertEquals(emptyEmailAssert, "Required");
    }


}