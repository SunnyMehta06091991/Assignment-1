package com.zoopla.qa.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.zoopla.qa.base.TestBase;

public class HomePage extends TestBase{
    //Object Repo for home page
	
	
	@FindBy(id = "search-input-location")
	WebElement searchStation;

	@FindBy (xpath = "//button[@id ='search-submit']")
	WebElement submitBtn;
	
	public HomePage (){
		PageFactory.initElements(driver, this);
		}
	
	
	// Function to enter countryNAme and click on Submit button.
	
	public SearchPage clickonSearchButton(String country) throws InterruptedException{
		//Thread.sleep(1000);
        JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", searchStation);
		searchStation.sendKeys(country);
		submitBtn.click();
		return new SearchPage();

	}
	
	
	
	
	
}
