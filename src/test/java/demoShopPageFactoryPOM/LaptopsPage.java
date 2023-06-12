package demoShopPageFactoryPOM;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class LaptopsPage {

	WebDriver driver;
	WebDriverWait wait;

	@FindBy(xpath = "//input[@value='Add to cart']") WebElement addtocartbtn;
	@FindBy(xpath="//span[text()='Shopping cart']") WebElement shoppingcartlink;
	@FindBy(id="termsofservice") WebElement termsckbox;
	@FindBy(id="checkout") WebElement checkoutbtn;

	@FindBy(xpath="//div[@id='billing-buttons-container']/input") WebElement  billingbtn;
	@FindBy(xpath="//*[@id='shipping-buttons-container']/input") WebElement shippingbtn;
	@FindBy(xpath="//*[@id='shipping-method-buttons-container']/input") WebElement shipmethodbtn;
	@FindBy(xpath="//*[@id='payment-method-buttons-container']/input") WebElement paymethbtn;
	@FindBy(xpath="//*[@id='payment-info-buttons-container']/input") WebElement payinfobtn;
	@FindBy(xpath="//*[@id='confirm-order-buttons-container']/input") WebElement confirmbtn;

	@FindBy(xpath="//a[contains(text(),'order details')]") WebElement orderdetail;
	@FindBy(xpath="//li[contains(text(),'Order number')]") WebElement orderno;


	public LaptopsPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements( driver,this);
		//wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	}

	public void clickaddtocart() {

		addtocartbtn.click();
	}

	public void clickshoppcartlink() {
		shoppingcartlink.click();
	}

	public void clicktermsckbx() {
		termsckbox.click();
	}

	public void clickcheckout() {
		checkoutbtn.click();
	}

	public void clickbilling() throws InterruptedException {
		// WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(30));
		// wait.until(ExpectedConditions.elementToBeClickable(billingbtn));
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		//Thread.sleep(2000);

		boolean displayed = billingbtn.isDisplayed();
		System.out.println(displayed);
		// wait.until(ExpectedConditions.elementToBeClickable(billingbtn));
		billingbtn.click();
	}	

	public void clickshipping() {
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		shippingbtn.click();
	}

	public void clickshipmethbtn() {
		shipmethodbtn.click();
	}

	public void clickpaymethodbtn() {
		paymethbtn.click();
	}

	public void clickpayinfobtn() {
		payinfobtn.click();
	}

	public void clickconfirmbtn() {
		confirmbtn.click();
	}

	public void checkorder() {

		boolean displayed = orderdetail.isDisplayed();
		Assert.assertTrue(displayed);
		String text = orderno.getText();
		System.out.println("Order is placed successfully  -  "+text);
		
		driver.quit();

	}



}
