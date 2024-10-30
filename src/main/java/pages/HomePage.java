package pages;

import org.openqa.selenium.Keys;
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
import utility.TestSetUp;
import utility.Utils;

public class HomePage extends TestSetUp{
	public static final Logger log = LogManager.getLogger(HomePage.class);

	public HomePage(WebDriver driver, ExtentTest logger) {
		this.driver = driver;
		this.logger = logger;
		PageFactory.initElements(driver, this);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		reportStep("Waiting for the Home Page", "INFO");
		try {
			wait.until(ExpectedConditions.visibilityOf(txtBxSearchBar));
			reportStep("Successfully landed on the Home Page ", "PASS");
		} catch (Exception e) {
			reportStep(e.getMessage(), "INFO");
			reportStep("Not able to land on the Home Page", "FAIL");
		}
	}
	
	@FindBy(xpath="//input[@type='search']")
	private WebElement txtBxSearchBar;
	
	public HomePage enterItemtoSearch(String searchItem) {
		try {
			reportStep("Trying to locate search item for searching on Home Page.", "INFO");
			txtBxSearchBar.clear();
			txtBxSearchBar.sendKeys(searchItem);
			Utils.sleep(2000);
			reportStep("Successfully entered search Item for Searching on Home Page.", "PASS");
		} catch (Exception e) {
			reportStep("Unable to enter search item on search Bar on Home Page.", "FAIL");
		}
		return this;
	}
	
	@FindBy(xpath="//input[@type='search']")
	private WebElement lnkFirstOptionInSearchAjax;
	
	public PLPPage clickFirstOptionInSearchAjax() {
		try {
			reportStep("Trying to locate First Option is search result on Home Page.", "INFO");
			Utils.jsClick(driver, lnkFirstOptionInSearchAjax);
			reportStep("Successfully click First Option is search result on Home Page.", "PASS");
		} catch (Exception e) {
			reportStep("Unable to click First Option is search result on Home Page.", "FAIL");
		}
		return new PLPPage(driver,logger);
	}
	
	@FindBy(xpath="//a[@title='Shop All']")
	private WebElement lnkShopAll;
	
	public PLPPage clickShopAll() {
		try {
			reportStep("Trying to locate Shop All on search result on Home Page.", "INFO");
			Utils.jsClick(driver, lnkShopAll);
			reportStep("Successfully click Shop All on  search result on Home Page.", "PASS");
		} catch (Exception e) {
			reportStep("Unable to click Shop All on  search result on Home Page.", "FAIL");
		}
		return new PLPPage(driver,logger);
	}
	
	@FindBy(xpath="//*[@id='search_btn' or @title='Submit your search query']")
	private WebElement btnSearch;
	
	public PLPPage clickSearchButton() {
		try {
			reportStep("Trying to locate Search Button on Home Page.", "INFO");
			Utils.jsClick(driver, btnSearch);
			reportStep("Successfully click Search Button on Home Page.", "PASS");
		} catch (Exception e) {
			reportStep("Unable to click Search Button on Home Page.", "FAIL");
		}
		return new PLPPage(driver,logger);
	}
	

}
