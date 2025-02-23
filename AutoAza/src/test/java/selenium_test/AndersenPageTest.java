package selenium_test;

import driver_init.DriverSetUpMain;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.AnderserPage;
import utils.listeners.MyAllureListeners;

@Listeners({MyAllureListeners.class})
public class AndersenPageTest {

    private static WebDriver driver;
    private static AnderserPage anderserPage;

    @BeforeClass
    public void setUp() {
        driver = DriverSetUpMain.startDriver();
        anderserPage = new AnderserPage(driver);
    }

    @AfterClass
    public void close(){
        driver.quit();
    }

    @Test
    public void checkElementsLoginPage() {
        anderserPage.openAndersenLoginPageLink();
        anderserPage.visibilityOfElementsLoginEmail();
        anderserPage.visibilityOfElementsLoginPassword();
        anderserPage.visibilityOfElementsRegistrationLinkButton();
        anderserPage.visibilityOfElementsLoginClickButton();
        anderserPage.titleOfPage();
    }

    @Test
    public void loginPositiveCase() {
        anderserPage.openAndersenLoginPageLink();
        anderserPage.visibilityOfElementsLoginEmail();
        anderserPage.setLoginEmail("S.Iaffwnfeffdsorv@gmail.com");
        anderserPage.setLoginPassword("string123");
        anderserPage.setLoginSubmitButton();
    }

    @Test
    public void loginNegativeCaseIncorrectEmail() throws InterruptedException {
        anderserPage.openAndersenLoginPageLink();
        anderserPage.visibilityOfElementsLoginEmail();
        anderserPage.setLoginEmail("S.Iaffwnfeffdsorv@gmail.");
        anderserPage.setLoginPassword("string123");
        anderserPage.ErrorAlertInvalidEmail();
    }

    @Test
    public void loginNegativeCaseIncorrectPassword() throws InterruptedException {
        anderserPage.openAndersenLoginPageLink();
        anderserPage.visibilityOfElementsLoginEmail();
        anderserPage.setLoginEmail("S.Iaffwnfeffdsorv@gmail.com");
        anderserPage.setLoginPassword("string123brf");
        anderserPage.setLoginSubmitButton();
        anderserPage.visibilityOfloginInvalidPasswodError();
        anderserPage.ErrorAlertInvalidEmailOrPassword();
    }

    @Test
    public void loginNegativeEmptyEmail() throws InterruptedException {
        anderserPage.openAndersenLoginPageLink();
        anderserPage.visibilityOfElementsLoginPassword();
        anderserPage.setLoginEmail("");
        anderserPage.setLoginPassword("goierjgiejogi");
        anderserPage.visibilityOfErrorEmail();
        anderserPage.ErrorAlertEmptyEmail();
    }

    @Test
    public void loginNegativeEmptyPassword() throws InterruptedException {
        anderserPage.openAndersenLoginPageLink();
        anderserPage.visibilityOfElementsLoginPassword();
        anderserPage.setLoginPassword("");
        anderserPage.setLoginEmail("qwer@qwe.com");
        anderserPage.ErrorAlertEmptyPassword();
    }

    @Test
    public void placeHolders() {
        anderserPage.openAndersenLoginPageLink();
        anderserPage.visibilityOfElementsLoginPassword();
        anderserPage.setPlaceholder();
    }

    @Test
    public void goToRegistrationPage() {
        anderserPage.openAndersenLoginPageLink();
        anderserPage.visibilityOfElementsRegistrationLinkButton();
        anderserPage.rigistrationButtonClick();
        anderserPage.visibilityRegistrationPageElement();
    }

    @Test
    public void loginMinPasswordCharacter() throws InterruptedException {
        anderserPage.openAndersenLoginPageLink();
        anderserPage.visibilityOfElementsLoginEmail();
        anderserPage.setLoginPassword("s");
        anderserPage.setLoginEmail("S.Iaffwnfeffdsorv@gmail.com");
        anderserPage.ErrorAlertPasswordMinCharacters();
    }

    @Test
    public void loginMaxPasswordCharacter() throws InterruptedException {
        anderserPage.openAndersenLoginPageLink();
        anderserPage.visibilityOfElementsLoginEmail();
        anderserPage.setLoginPassword("sfiowejfowiejfowijfiowjfiowjiofjoiefiwejiowjifwewfwefw");
        anderserPage.setLoginEmail("S.Iaffwnfeffdsorv@gmail.com");
        anderserPage.ErrorAlertPasswordMaxCharacters();
    }
}
