package com.pompages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	//Declaration
		@FindBy(name = "user_name") private WebElement usernameTF;
		@FindBy(name = "user_password") private WebElement passwordTF;
		@FindBy(id = "submitButton") private WebElement loginBtn;
		
		//Initialization
		public LoginPage(WebDriver driver) {	
			PageFactory.initElements(driver, this);
		}
		/**
		 * This method is used to login to application
		 * @param username
		 * @param password
		 */
		//Utilization
		public void loginToApp(String username, String password) {
			usernameTF.sendKeys(username);
			passwordTF.sendKeys(password);
			loginBtn.click();
		}
}
