package com.testng;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class PracticeTest {

	@Test
	public void demoTest() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://google.co.in");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
}
