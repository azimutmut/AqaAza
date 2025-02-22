package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

import java.time.Duration;

public class AnderserPage {
    static final Logger logger = LoggerFactory.getLogger(AnderserPage.class);

    private WebDriver driver;
    private WebDriverWait wait;

    public AnderserPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    @FindBy(linkText = "Registration")
    private static WebElement registrationLink;
    public void visibilityOfElementsRegistrationLinkButton(){
        wait.until(ExpectedConditions.visibilityOf(registrationLink));
    }
    @FindBy(name = "email")
    private static WebElement loginEmail;
    @FindBy(name = "password")
    private static WebElement loginPassword;
    @FindBy(xpath = "//button[text()='Sign in']")
    private static WebElement loginSubmitButton;
    @FindBy(xpath = "//span[text()='Invalid email address']")
    private static WebElement loginInvalidEmail;
    @FindBy(xpath = "//*[@id=\"root\"]/div/div/div/form/div/div[2]/div/span")
    private static WebElement loginInvalidPasswod;
    @FindBy(xpath = "//*[@id=\"root\"]/div/div/div/form/div/div[1]/div/span")
    private static WebElement loginEmptyEmail;
    @FindBy(xpath = "//*[@id=\"root\"]/div/div/div/form/div/div[2]/div/span")
    private static WebElement loginEmptyPassword;
    @FindBy(xpath = "//span[text()='Minimum 8 characters']")
    private static WebElement minCharacters;
    @FindBy(xpath = "//span[text()='Maximum 20 characters']")
    private static WebElement maxCharacters;

    //    registration link
    @FindBy(linkText = "Registration")
    private static WebElement getRegistrationLink;
    @FindBy(name = "firstName")
    private static WebElement registrationFirstName;

    public void openAndersenLoginPageLink(){
        driver.get("https://qa-course-01.andersenlab.com/login");
    }
    public void visibilityOfErrorEmail(){
        wait.until(ExpectedConditions.visibilityOf(loginEmptyEmail));
    }
    public void visibilityOfloginInvalidPasswodError(){
        wait.until(ExpectedConditions.visibilityOf(loginInvalidPasswod));
    }
    public void visibilityOfElementsLoginEmail(){
        wait.until(ExpectedConditions.visibilityOf(loginEmail));
        logger.info("visibility of email element ");
    }
    public void visibilityOfElementsLoginPassword(){
        wait.until(ExpectedConditions.visibilityOf(loginPassword));
        logger.info("visibility of element password");
    }
    public void visibilityOfElementsLoginClickButton(){
        wait.until(ExpectedConditions.visibilityOf(loginSubmitButton));
        logger.info("checking login submit button visibility");
    }
    public void visibilityRegistrationPageElement(){
        wait.until(ExpectedConditions.visibilityOf(registrationFirstName));
        logger.info("checking visibility ob firstname box");
    }
    public void titleOfPage(){
        String titleOfPage = driver.getTitle();
        logger.info("Opening the Main page");
        Assert.assertEquals(titleOfPage, "QA Course 01");
    }

//    nagativ case with invalid email and password
    public void ErrorAlertInvalidEmail(){
        String emailInvalidAssert = loginInvalidEmail.getText();
        logger.info("geting text from email");
        Assert.assertEquals(emailInvalidAssert, "Invalid email address");
    }
    public void ErrorAlertInvalidEmailOrPassword(){
        String passworInvalidAssert = loginInvalidPasswod.getText();
        logger.info("Error about invalid email or rassword");
        Assert.assertEquals(passworInvalidAssert, "Email or password is not valid");
    }
//    "Minimum 8 characters" changed
    public void ErrorAlertPasswordMinCharacters(){
        String passwordMinCharacter = minCharacters.getText();
        logger.info("Error about min characters");
        Assert.assertEquals(passwordMinCharacter, "Minimum 8 characters!");
    }
    public void ErrorAlertPasswordMaxCharacters(){
        String passwordMaxCharacter = maxCharacters.getText();
        logger.info("error about max character for password");
        Assert.assertEquals(passwordMaxCharacter, "Maximum 20 characters");
    }

//    negative with empty email and password
    public void ErrorAlertEmptyEmail(){
        String emptyEmailAssert = loginEmptyEmail.getText();
        logger.info("error about empty email");
        Assert.assertEquals(emptyEmailAssert, "Required");
    }
    public void ErrorAlertEmptyPassword(){
        String emptyPasswordAssert = loginEmptyPassword.getText();
        logger.info("error about empty passwor");
        Assert.assertEquals(emptyPasswordAssert, "Required");
    }

//    checking placeholders
    public void setPlaceholder(){
        String placeholderTextEmail = loginEmail.getAttribute("placeholder");
        Assert.assertEquals(placeholderTextEmail, "Enter email", "Placeholder некорректный!");
        String placeholderTextPassword = loginPassword.getAttribute("placeholder");
        logger.info("checking placeholders");
        Assert.assertEquals(placeholderTextPassword, "Enter password", "Placeholder некорректный!");
    }

//    go to registation page button
    public void rigistrationButtonClick(){
        logger.info("checking registration button");
        registrationLink.click();
    }
    public void setLoginEmail(String email){
        loginEmail.sendKeys(email);
        logger.info("setting login email");
    }
    public void setLoginPassword(String password){
        loginPassword.sendKeys(password);
        logger.info("setting login password");
    }

    public void setLoginSubmitButton(){
        loginSubmitButton.click();
        logger.info("login button ");
    }
}