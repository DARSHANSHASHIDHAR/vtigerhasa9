package com.testng;

import org.testng.annotations.Test;

public class InvocationCount {

	@Test(invocationCount = 2, priority = 1)
	public void demo1() {
		System.out.println("demo1");
	}
	@Test(invocationCount = 2, priority = 0)
	public void demo2() {
		System.out.println("demo2");
	}
	@Test(invocationCount = 2, priority = -1)
	public void demo3() {
		System.out.println("demo3");
	}
	@Test(enabled = false)
	public void demo4() {
		System.out.println("demo4");
	}
}
