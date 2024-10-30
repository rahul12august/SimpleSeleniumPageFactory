package pages;

import java.time.Duration;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.relevantcodes.extentreports.ExtentTest;

import utility.TestSetUp;
import utility.Utils;

public class CartPage extends TestSetUp{
	public static final Logger log = LogManager.getLogger(CartPage.class);
	public CartPage(WebDriver driver, ExtentTest logger) {
		this.driver = driver;
		this.logger = logger;
		PageFactory.initElements(driver, this);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		reportStep("Waiting for the cart Page", "INFO");
		try {
			wait.until(ExpectedConditions.visibilityOf(btnIncreaseQuantity));
			reportStep("Successfully landed on the Cart Page ", "PASS");
		} catch (Exception e) {
			reportStep(e.getMessage(), "INFO");
			reportStep("Not able to land on the Cart Page", "FAIL");
		}
	}
	
	@FindBy(xpath="//button[@title='Increase Quantity']")
	private WebElement btnIncreaseQuantity;
	
	public CartPage increaseQuantity(int qty) {
		try {
			reportStep("Trying to locate increase quantity button on Cart Page.", "INFO");
			for(int i=0;i<qty;i++) {
				Utils.click(btnIncreaseQuantity);
				Utils.sleep(1000);
			}
			
			reportStep("Successfully click increase quantity button on Cart Page.", "PASS");
		} catch (Exception e) {
			reportStep("Unable to enter search item on search Bar on Cart Page.", "FAIL");
		}
		return this;
	} 
	
	@FindBy(xpath="//button[@title='Proceed to Checkout']")
	private WebElement btnProceedToCheckout;
	
	public SignInRegistrationPage clickProceedToCheckout() {
		try {
			reportStep("Trying to locate Proceed To Checkout button on Cart Page.", "INFO");
				Utils.click(btnProceedToCheckout);		
			reportStep("Successfully click Proceed To Checkout button on Cart Page.", "PASS");
		} catch (Exception e) {
			reportStep("Unable to enter Proceed To Checkout on Cart Page.", "FAIL");
		}
		return new SignInRegistrationPage(driver, logger);
	} 
	

}
