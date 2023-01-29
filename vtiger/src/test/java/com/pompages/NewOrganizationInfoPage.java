package com.pompages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewOrganizationInfoPage {
	//Declaration
		@FindBy(xpath = "//span[@class = 'dvHeaderText']") private WebElement pageHeader;
		@FindBy(xpath = "//a[text()='Organizations']") private WebElement organizationLink;
		
		//Initialization
		public NewOrganizationInfoPage(WebDriver driver) {
			PageFactory.initElements(driver, this);
		}
		
		//Utilization
		/**
		 * This method is used to fetch the page header of organization info page
		 * @return
		 */
		public String getPageHeader() {
			return pageHeader.getText();
		}
		
		/**
		 * This method is used to click on choosen organization fro organization list page
		 */
		public void clickOrganizationLink() {
			organizationLink.click();
		}
}
