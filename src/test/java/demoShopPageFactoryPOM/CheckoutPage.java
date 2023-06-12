package demoShopPageFactoryPOM;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckoutPage {
	
	WebDriver driver;
	WebDriverWait wait;
	
	@FindBy(xpath="//div[@id='billing-buttons-container']") WebElement  billingbtn;
	@FindBy(xpath="//*[@id='shipping-buttons-container']/input") WebElement shippingbtn;

	public CheckoutPage(WebDriver driver) {
		this.driver=driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		PageFactory.initElements(driver, this);
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		//PageFactory.initElements(new AjaxElementLocatorFactory(driver, 20), this);
		
	}
	
	
	public void clickbilling() throws InterruptedException {
	   // WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(30));
	   // wait.until(ExpectedConditions.elementToBeClickable(billingbtn));
	    //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		//Thread.sleep(2000);
		
	    boolean displayed = billingbtn.isDisplayed();
	    System.out.println(displayed);
	    wait.until(ExpectedConditions.elementToBeClickable(billingbtn));
	    billingbtn.click();
	}
	
	public void clickshipping() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		shippingbtn.click();
	}



}
