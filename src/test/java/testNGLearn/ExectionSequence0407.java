package testNGLearn;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ExectionSequence0407 {

	@BeforeSuite
	public void launchbrowser() {

		System.out.println("Before suite");
	}
	@BeforeTest
	public void openapp() {

		System.out.println("Before test");
	}
	@BeforeClass
	public void enterfields() {

		System.out.println("Before class");
	}
	@BeforeMethod
	public void login() {

		System.out.println("Before method");
	}

	@Test
	public void validation() {

		System.out.println("test");
	}

	@AfterMethod
	public void logout() {
		System.out.println("after method");
	}
	@AfterClass
	public void result() {
		System.out.println("after class");
	}
	@AfterTest
	public void description() {

		System.out.println("after test");

	}
	@AfterSuite
	public void close() {

		System.out.println("After suite");
	}




}
