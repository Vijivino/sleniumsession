package demoShopPageFactoryTEST;

import java.time.Duration;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import demoShopPageFactoryPOM.CheckoutPage;
import demoShopPageFactoryPOM.HomePage;
import demoShopPageFactoryPOM.LaptopsPage;
import demoShopPageFactoryPOM.LoginPage;

public class LaptopOrderTestCase extends BaseClass{

		
	@Test
	public void laptoporder() throws InterruptedException {
		
      
		HomePage home=PageFactory.initElements(driver,HomePage.class);
		home.clickloginlink();
		home.enteremail("vijiraja@gmail.com");
		home.enterpassword("viji123");
		home.clickloginbtn();
		
		LoginPage login=PageFactory.initElements(driver,LoginPage.class);
		login.entersearchbox();
		
		LaptopsPage laptop=PageFactory.initElements(driver,LaptopsPage.class);
		laptop.clickaddtocart();
		laptop.clickshoppcartlink();
		laptop.clicktermsckbx();
		laptop.clickcheckout();
		laptop.clickbilling();
		laptop.clickshipping();
		laptop.clickshipmethbtn();
		laptop.clickpaymethodbtn();
		laptop.clickpayinfobtn();
		laptop.clickconfirmbtn();
		laptop.checkorder();
		
//		CheckoutPage checkout = PageFactory.initElements(driver,CheckoutPage.class );
//		checkout.clickbilling();
//		checkout.clickshipping();
		
		
		
		
		
		
	}
	
}
