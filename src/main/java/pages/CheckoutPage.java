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

public class CheckoutPage extends TestSetUp{
	public static final Logger log = LogManager.getLogger(CheckoutPage.class);
	public CheckoutPage(WebDriver driver, ExtentTest logger) {
		this.driver = driver;
		this.logger = logger;
		PageFactory.initElements(driver, this);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		reportStep("Waiting for the Checkout Page", "INFO");
		try {
			wait.until(ExpectedConditions.visibilityOf(txtBxCity));
			reportStep("Successfully landed on the Checkout Page ", "PASS");
		} catch (Exception e) {
			reportStep(e.getMessage(), "INFO");
			reportStep("Not able to land on the Checkout Page", "FAIL");
		}
	}
	
	@FindBy(id="customer_city")
	private WebElement txtBxCity;

}
