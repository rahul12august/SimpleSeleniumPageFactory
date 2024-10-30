package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
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

public class PLPPage extends TestSetUp{
	public static final Logger log = LogManager.getLogger(PLPPage.class);
	public PLPPage(WebDriver driver, ExtentTest logger) {
		this.driver = driver;
		this.logger = logger;
		PageFactory.initElements(driver, this);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		reportStep("Waiting for the Product Listing Page", "INFO");
		try {
			wait.until(ExpectedConditions.visibilityOf(lblSearchResult));
			reportStep("Successfully landed on the Product Listing Page ", "PASS");
		} catch (Exception e) {
			reportStep("Not able to land on the Product Listing Page", "FAIL");
		}
	}
	
	@FindBy(xpath="//*[text()='Search results for ']")
	private WebElement lblSearchResult;
	
	@FindBy(xpath="(//img)[1]")
	private WebElement lnkFirstProductInPLPThroughShowAll;
	
	public PDPPage clickProductInPLPToNavigateTOPDPPage() {
		try {
			reportStep("Trying to locate First Searched product on Product Listing Page.", "INFO");
			Utils.click(lnkFirstProductInPLPThroughShowAll);
			reportStep("Successfully clicked First Searched product on Product Listing Page.", "PASS");
		} catch (Exception e) {
			reportStep("Unable to locate First Searched product on Product Listing Page.", "FAIL");
		}
		return new PDPPage(driver,logger);
	}
	
	@FindBy(xpath="//picture/img | //img")
	private List<WebElement> lnkFirstProductInPLPThroughSearchButton;
	
	public PDPPage clickFirstProduct() {
		try {
			reportStep("Trying to locate First Searched product on Product Listing Page.", "INFO");
			for (int i = 0; i < lnkFirstProductInPLPThroughSearchButton.size(); i++) {
			    try {
			        WebElement element = lnkFirstProductInPLPThroughSearchButton.get(i);
			        
			        // Re-locate the element before clicking to avoid stale references
			        if (element.isDisplayed()) {
			            Utils.click(element);
			            reportStep("Successfully clicked First Searched product on Product Listing Page.", "PASS");
			            break; // Stop after the first visible product is clicked
			        }
			    } catch (StaleElementReferenceException e) {
			       
			    } catch (Exception e) {
			        
			    }
			}
			
			reportStep("Successfully clicked First Searched product on Product Listing Page.", "PASS");
		} catch (Exception e) {
			reportStep("Unable to locate First Searched product on Product Listing Page.", "FAIL");
		}
		return new PDPPage(driver,logger);
	}
	

}
