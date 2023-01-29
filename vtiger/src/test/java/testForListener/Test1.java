package testForListener;

import org.testng.Assert;
import org.testng.annotations.Test;

import genericlibraries.BaseClass;
//@Listeners(genericLibraries.ListenerImplementation.class)
public class Test1 extends BaseClass{
	
	@Test(retryAnalyzer = genericlibraries.RetryImplementation.class)
	public void test1() {
		System.out.println("Test1");
		Assert.fail();
	}

}
