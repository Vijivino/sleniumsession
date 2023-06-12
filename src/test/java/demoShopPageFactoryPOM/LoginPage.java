package demoShopPageFactoryPOM;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver driver;

	@FindBy(xpath = "//input[@value='Search store']") WebElement searchbox;
	

	public  LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);

	}


	public void entersearchbox() {

		searchbox.sendKeys("laptop",Keys.ENTER);

	}

	
}
