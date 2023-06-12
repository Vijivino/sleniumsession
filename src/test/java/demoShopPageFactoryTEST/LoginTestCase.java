package demoShopPageFactoryTEST;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import demoShopPageFactoryPOM.HomePage;

public class LoginTestCase extends BaseClass{
	
	
	@Test
	public void login() {
	
		HomePage login=PageFactory.initElements(driver,HomePage.class);
		
		login.clickloginlink();
		login.enteremail("vijiraja@gmail.com");
		login.enterpassword("viji123");
		login.clickloginbtn();
	
	}
	
	
}
