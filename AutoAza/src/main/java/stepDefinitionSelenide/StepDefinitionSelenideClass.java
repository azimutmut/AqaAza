package stepDefinitionSelenide;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class StepDefinitionSelenideClass {
    private static final SelenideElement loginEmail = $(By.name("email"));
    private static final SelenideElement loginPassword = $(By.name("password"));
    private static final SelenideElement loginSubmitButton = $(By.xpath("//button[text()='Sign in']"));
    private static final SelenideElement successloginElement = $(By.xpath("//div[contains(text(),'Contact us')]"));

    @Given("Set up driver Selenide")
    public void setUpDriverSelenide() {
        WebDriverManager.chromedriver().setup();
        Configuration.browser = "chrome";
        Configuration.headless = false;
        Configuration.browserSize = "1920x1080";
    }

    @When("open Andersen login page Selenide")
    public void openAndersenLoginPageSelenide() {
        open("https://qa-course-01.andersenlab.com/login");
        loginEmail.should(Condition.visible);
    }

    @When("Set email Selenide {string}")
    public void setEmailSelenide(String text1) {
        loginEmail.should(Condition.visible);
        loginEmail.setValue(text1);
    }

    @And("Set password  Selenide {string}")
    public void setPasswordSelenide(String text2) {
        loginPassword.setValue(text2);
    }

    @And("Click login button Selenide")
    public void clickLoginButtonSelenide() {
        loginSubmitButton.click();
    }

    @Then("Success alert message Selenide")
    public void successAlertMessageSelenide() {
        successloginElement.shouldBe(Condition.text("Contact us"));
    }
}