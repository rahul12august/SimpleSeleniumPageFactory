package utility;

import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Utils extends TestSetUp{
	//wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	public static void click(WebElement element) {
		element.click();
	}
	
	public static void jsClick(WebDriver driver,WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(element));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", element);

	}
	

	public static boolean verifyElementPresence(WebElement element) {
		if (element.isDisplayed()) {
			return true;
		} else {
			return false;
		}
	}

	public static void sendKeys(WebElement element, String text) {
		element.sendKeys(text);
	}
	
	
	public static String generateRandomEmail() {
        // Characters allowed in the email username
        String chars = "abcdefghijklmnopqrstuvwxyz1234567890";
        StringBuilder email = new StringBuilder();
        Random random = new Random();

        // Generate a random username (length between 6 and 12 characters)
        int usernameLength = random.nextInt(7) + 6; // Random length between 6 and 12

        for (int i = 0; i < usernameLength; i++) {
            email.append(chars.charAt(random.nextInt(chars.length())));
        }

        // Add the domain to the email
        email.append("@example.com"); // You can replace "example.com" with any domain you want

        return email.toString();
    }

	public static void sleep(int i) {
		try {
			Thread.sleep(i);
		} catch (InterruptedException e) {
	
		}
	}

}
