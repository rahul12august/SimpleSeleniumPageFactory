package pages;

import utility.TestSetUp;
import utility.Utils;

import java.time.Duration;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.relevantcodes.extentreports.ExtentTest;

public class SignInRegistrationPage extends TestSetUp{
	public static final Logger log = LogManager.getLogger(SignInRegistrationPage.class);
	public SignInRegistrationPage(WebDriver driver, ExtentTest logger) {
		this.driver = driver;
		this.logger = logger;
		PageFactory.initElements(driver, this);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		reportStep("Waiting for the cart Page", "INFO");
		try {
			wait.until(ExpectedConditions.visibilityOf(btnCreateAccount));
			reportStep("Successfully landed on the Cart Page ", "PASS");
		} catch (Exception e) {
			reportStep(e.getMessage(), "INFO");
			reportStep("Not able to land on the Cart Page", "FAIL");
		}
	}
	
	@FindBy(id="create_account_button")
	private WebElement btnCreateAccount;
	
	public SignInRegistrationPage clickCreateAccountButton() {
		try {
			reportStep("Trying to locate Create Account Button on Sign In and Registration Page.", "INFO");
			Utils.click(btnCreateAccount);
			reportStep("Successfully click Create Account Button on  Sign In and Registration Page.", "PASS");
		} catch (Exception e) {
			reportStep("Unable to click Create Account Button on  Sign In and Registration Page.", "FAIL");
		}
		return this;
	}
	
	@FindBy(xpath="//*[@id='firstname' or @id='create_account_page_firstname']")
	private WebElement txtBxFirstName;
	public SignInRegistrationPage enterFirstName(String firstName) {
		try {
			reportStep("Trying to locate first name text box on Registration Page.", "INFO");
			txtBxFirstName.sendKeys(firstName);
			reportStep("Successfully entered first name text box on Registration Page.", "PASS");
		} catch (Exception e) {
			reportStep("Unable to enter first name text box on Registration Page.", "FAIL");
		}
		return this;
	}
	
	@FindBy(xpath="//*[@id='lastname' or @id='create_account_page_lastname']")
	private WebElement txtBxLastName;
	public SignInRegistrationPage enterLastName(String lastName) {
		try {
			reportStep("Trying to locate last name in text box on Registration Page.", "INFO");
			txtBxLastName.sendKeys(lastName);
			reportStep("Successfully entered last name text box on Registration Page.", "PASS");
		} catch (Exception e) {
			reportStep("Unable to enter last name in text box on Registration Page.", "FAIL");
		}
		return this;
	}
	
	@FindBy(xpath="//*[@id='email' or @id='create_account_page_email']")
	private WebElement txtBxEmail;
	public SignInRegistrationPage enterEmailId(String email) {
		try {
			reportStep("Trying to locate email text box on Registration Page.", "INFO");
			txtBxEmail.sendKeys(email);
			reportStep("Successfully entered email text box on Registration Page.", "PASS");
		} catch (Exception e) {
			reportStep("Unable to enter email in text box on Registration Page.", "FAIL");
		}
		return this;
	}
	
	@FindBy(xpath="//*[@id='password' or @id='create_account_page_password']")
	private WebElement txtBxPassword;
	public SignInRegistrationPage enterPassword(String password) {
		try {
			reportStep("Trying to locate password text box on Registration Page.", "INFO");
			txtBxEmail.sendKeys(password);
			reportStep("Successfully entered password on text box on Registration Page.", "PASS");
		} catch (Exception e) {
			reportStep("Unable to enter password on text box on Registration Page.", "FAIL");
		}
		return this;
	}
	
	@FindBy(xpath="register_btn")
	private WebElement btnCreateAccountRegister;
	public CheckoutPage clickCreateAccount() {
		try {
			reportStep("Trying to locate Create Account Button on Registration Page.", "INFO");
			Utils.click(btnCreateAccountRegister);
			reportStep("Successfully click Create Account Button on Registration Page.", "PASS");
		} catch (Exception e) {
			reportStep("Unable to click Create Account Button on Registration Page.", "FAIL");
		}
		return new CheckoutPage(driver, logger);
	}

}
