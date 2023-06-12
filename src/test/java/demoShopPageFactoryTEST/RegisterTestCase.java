package demoShopPageFactoryTEST;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import demoShopPageFactoryPOM.RegisterPage;

public class RegisterTestCase extends BaseClass{

	
	@Test
	public void register() {
		
		RegisterPage register=PageFactory.initElements(driver,RegisterPage.class );
		register.clickreglink();
		register.clickfemalebtn();
		register.enterfirstname("Viji");
		register.enterlastname("V");
		register.enteremail("vijaya@gmail.com");
		register.enterpassword("vijaya123");
		register.enterconfirmpassword("vijaya123");
		register.clickregbtn();
		register.checkregistration();
		register.close();
		
		
	}
}
