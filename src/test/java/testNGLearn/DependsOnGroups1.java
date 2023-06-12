package testNGLearn;

import org.testng.annotations.Test;

public class DependsOnGroups1 {

	@Test(groups="smoke")
	public void test1() {
		System.out.println("This is smoke test1");
	}
	@Test(groups={"smoke" , "sanity" })
	public void test2() {
		System.out.println("This is smoke test2");
	}
}


