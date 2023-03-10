package com.testng;

import org.testng.annotations.Test;

public class GroupExecutionExample {

	@Test(groups = "Regression")
	public void test0() {
		System.out.println("test0");
	}
	@Test(groups = "Smoke")
	public void test1() {
		System.out.println("test1");
	}
	@Test(groups = {"Smoke","Regression"})
	public void test2() {
		System.out.println("test2");
	}
	@Test
	public void test3() {
		System.out.println("test3");
	}
}
