package com.testng;

import org.testng.annotations.Test;

public class Enabled_Disabled {
	@Test(enabled=false)
	public void demo1() {
		System.out.println("demo1");
	}
	@Test(enabled=true)
	public void demo2() {
		System.out.println("demo2");
	}
	@Test(enabled=false)
	public void demo3() {
		System.out.println("demo3");
	}
	@Test
	public void demo4() {
		System.out.println("demo4");
	}
}
