package com.pompages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	//Declaration
		@FindBy(xpath = "//a[text()='Organizations']") private WebElement organizationTab;
		@FindBy(xpath = "//img[@src = 'themes/softed/images/user.png']") private WebElement administratorIcon;
		@FindBy(xpath = "//a[text() = 'sign Out']") private WebElement signOutButton;
		
		//Initialization
		public HomePage(WebDriver driver) {
			PageFactory.initElements(driver, this);
		}
		
		//Utilization
		/**
		 * This method will click on organizations tab
		 */
		public void clickOnOrganizationTab() {
			organizationTab.click();
		}
		
		public void signOutOfApplication() {
			signOutButton.click();
		}
}
