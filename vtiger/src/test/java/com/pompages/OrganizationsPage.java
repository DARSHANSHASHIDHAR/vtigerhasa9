package com.pompages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationsPage {
	//Declaration
		@FindBy(xpath = "//img[@alt='Create Organization...']") private WebElement newOrganization;
		@FindBy(xpath = "//table[@class='lvt small']/descendant::tr[last()]/td[3]/a") private WebElement getOrganization;
		
		//Initialization
		public OrganizationsPage(WebDriver driver) {
			PageFactory.initElements(driver, this);
		}
		
		//Utilization
		/**
		 * This method is used to click on plus button in organizations page
		 */
		public void clickPlusButton() {
			newOrganization.click();
		}
		/**
		 * This method is used to get the organization from organizations page
		 */
		public void getNewOrganization() {
			getOrganization.click();
		}
}
