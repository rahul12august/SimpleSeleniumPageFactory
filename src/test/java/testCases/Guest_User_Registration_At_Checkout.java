package testCases;
import org.testng.annotations.Test;
import pages.HomePage;
import utility.Constant;
import utility.TestSetUp;
import utility.Utils;

public class Guest_User_Registration_At_Checkout extends TestSetUp{
  @Test
  public void guestUserRegistrationAtCheckout(){
	  String email=Utils.generateRandomEmail();
	  reportStep("Validation of successful Checkout for Guest User Started", "INFO");
	  new HomePage(driver, logger).
	  enterItemtoSearch("Diaper").
	  clickSearchButton().
	  clickFirstProduct().
	  clickAddToCart().
	  clickCartLink().
	  increaseQuantity(Constant.QUANTITY).
	  clickProceedToCheckout().
	  clickCreateAccountButton().
	  enterFirstName(Constant.FIRSTNAME).
	  enterLastName(Constant.LASTNAME).
	  enterEmailId(email).
	  enterPassword(Constant.PASSWORD).
	  clickCreateAccount();
	  reportStep("Validation of successful Checkout for Guest User Completed", "PASS");
  }
}
