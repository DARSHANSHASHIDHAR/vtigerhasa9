package com.pompages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericlibraries.WebDriverUtility;

public class CreateOrganizationPage {
	//Declaration
		@FindBy(xpath = "//span[@class='lvtHeaderText']") private WebElement pageHeader;
		@FindBy(name="accountname") private WebElement organizationNameTF;
		@FindBy(name="industry") private WebElement industryDropdown;
		@FindBy(name="accounttype") private WebElement typeDropdown;
		@FindBy(xpath = "(//input[contains(@value,'Save')])[1]") private WebElement saveButton;
		
		//Initialization
		public CreateOrganizationPage(WebDriver driver) {
			PageFactory.initElements(driver,this);
		}
		
		//Utilization
		/**
		 * This method is used to fetch the page header
		 * @return
		 */
		public String getPageHeader() {
			return pageHeader.getText();
		}
		/**
		 * This method is used to set the organization name in its Text Field
		 * @param organizationName
		 */
		public void setOrganizationName(String organizationName) {
			organizationNameTF.sendKeys(organizationName);
		}
		/**
		 * This method is used to select an industry from its dropdown 
		 * @param web
		 * @param value
		 */
		public void selectIndustry(WebDriverUtility web, String value) {
			web.dropdown(value, industryDropdown);
		}
		/**
		 * This method is used to choose the account type from its dropdown
		 * @param web
		 * @param value
		 */
		public void selectType(WebDriverUtility web, String value) {
			web.dropdown(value, typeDropdown);
		}
		
		public void clickOnSaveButton() {
			saveButton.click();
		}
}
