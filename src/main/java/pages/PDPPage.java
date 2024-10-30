package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.relevantcodes.extentreports.ExtentTest;
import java.time.Duration;
import java.util.List;

import utility.TestSetUp;
import utility.Utils;

public class PDPPage extends TestSetUp {
	public static final Logger log = LogManager.getLogger(PDPPage.class);

	public PDPPage(WebDriver driver, ExtentTest logger) {
		this.driver = driver;
		this.logger = logger;
		PageFactory.initElements(driver, this);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		reportStep("Waiting for the PDP Page", "INFO");
		try {
			wait.until(ExpectedConditions.visibilityOf(btnAddToCart));
			reportStep("Successfully landed on the Product Display Page ", "PASS");
		} catch (Exception e) {
			reportStep(e.getMessage(), "INFO");
			reportStep("Not able to land on the Product Display Page", "FAIL");
		}
	}

	@FindBy(xpath = "//*[contains(text(),'Add to bag') or text()='Add to Cart']")
	private WebElement btnAddToCart;

	public PDPPage clickAddToCart() {
		try {
			reportStep("Trying to locate add to cart button on Product Display Page.", "INFO");
			Utils.click(btnAddToCart);
			reportStep("Successfully click add to cart button on Product Display Page.", "PASS");
		} catch (Exception e) {
			reportStep("Unable to click add to cart button on Product Display Page.", "FAIL");
		}
		return this;
	}

	@FindBy(xpath = "//a[contains(@href,'cart')]")
	private List<WebElement> lnkCart;

	public CartPage clickCartLink() {
		try {
			reportStep("Trying to locate cart Link on Product Display Page.", "INFO");
			WebElement cartLink = lnkCart.stream().filter(WebElement::isDisplayed).findFirst().orElseThrow();
			Utils.jsClick(driver, cartLink);
		} catch (Exception e) {
			reportStep("Unable to click cart Link on Product Display∑œœ Page.", "FAIL");
		}
		return new CartPage(driver, logger);
	}

	@FindBy(xpath = "//a[text()='View Cart']")
	private WebElement lnkViewCart;

	public CartPage clickViewCartLink() {
		try {
			reportStep("Trying to locate view cart Link on Product Display Page.", "INFO");
			Utils.click(lnkViewCart);
			reportStep("Successfully click view cart Link on Product Display Page.", "PASS");
		} catch (Exception e) {
			reportStep("Unable to click view cart Link on Product Display Page.", "FAIL");
		}
		return new CartPage(driver, logger);
	}
}
