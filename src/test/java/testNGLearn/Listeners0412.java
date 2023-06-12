package testNGLearn;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listeners0412 implements ITestListener {

	public void onTestStart(ITestResult result) {
		System.out.println("Test case started and the test name is "+result.getName());
			}

	public void onTestSuccess(ITestResult result) {
		System.out.println("Test case success and the test name is "+result.getName());
	}

	public void onTestFailure(ITestResult result) {
		System.out.println("Test case failed and the test name is "+result.getName());
	}

	public void onTestSkipped(ITestResult result) {
		System.out.println("Test case skipped and the test name is "+result.getName());
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println("Test case failed with success percentage and the test name is "+result.getName());
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		System.out.println("Test case failed with timeout and the test name is "+result.getName());
	}

	public void onStart(ITestContext context) {
		System.out.println("Test case begin and the test name is "+context.getName());
	}

	public void onFinish(ITestContext context) {
		System.out.println("Test case finish and the test name is "+context.getName());	
	}
	

}
