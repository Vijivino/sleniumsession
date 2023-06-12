package demoShopPageFactoryPOM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {

	WebDriver driver;
	
	//Store the locators in pagefactory
	@FindBy(linkText="Register") WebElement registerlink;
	@FindBy(how = How.XPATH, using = "//label[text()='Female']") WebElement femalebutton;
	@FindBy(name="FirstName") WebElement firstname;
	@FindBy(name="LastName") WebElement lastname;
	@FindBy(name="Email") WebElement email;
	@FindBy(name="Password") WebElement password;
	@FindBy(name="ConfirmPassword") WebElement confirmpassword;
	@FindBy(xpath="//input[@value='Register']") WebElement registerbutton;
	@FindBy(xpath="//li[contains(text(),'already')]") WebElement registeralready;

	
	
	public RegisterPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	public void clickreglink() {
		
	    registerlink.click();
	}
	
    public void clickfemalebtn() {
		
    	femalebutton.click();
	}
    
    public void enterfirstname(String fname) {
    	
		firstname.sendKeys(fname);
	}

    public void enterlastname(String lname) {
	
        lastname.sendKeys(lname);
    }
    
    public void enteremail(String em) {
    	
        email.sendKeys(em);
    }
    

    public void enterpassword(String pw) {
    	
        password.sendKeys(pw);
    }

    public void enterconfirmpassword(String pw) {
    	
        confirmpassword.sendKeys(pw);
    }
    
    public void clickregbtn() {
    	
        registerbutton.click();
    }
    
    public void checkregistration() {
    	
    	String text = registeralready.getText();
    	if (text.contains("already exists"))
		{
		   System.out.println("This email id exists already!!");	
		}
		else 
		{
			System.out.println("Registered successfully!");

		}
    	
    }
    
    public void close() 
	{
		driver.quit();
	}
    

}
    
    
    


