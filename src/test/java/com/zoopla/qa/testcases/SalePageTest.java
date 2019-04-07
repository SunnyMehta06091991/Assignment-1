package com.zoopla.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.zoopla.qa.base.TestBase;
import com.zoopla.qa.pages.HomePage;
import com.zoopla.qa.pages.SalePage;
import com.zoopla.qa.pages.SearchPage;

public class SalePageTest extends TestBase {
    HomePage homePage;
    SearchPage searchPage;
    SalePage salePage;

	public SalePageTest(){
		super();
	}
	
	   @BeforeMethod
	   public void setUp() throws InterruptedException{
			initialization();
			homePage = new HomePage();
			searchPage = homePage.clickonSearchButton("London");
		//earchPage.allPropertiesPrices();
			salePage =searchPage.clickOnFifthProperty();
		
	   }

	   @Test(priority = 1)
	   public void printAgentPhoneName(){
		   String phoneNumberAgent = salePage.agentNumberValidate();
		   System.out.println("Agent Phone Number for 5th property is " + phoneNumberAgent);
	   }

	   @Test(priority = 2)
	   public void printAgentName(){
		   String agentName = salePage.agentNameValidate();
	   System.out.println("Agent Name for 5th property is " + agentName);
	   }
	   
	   @Test(priority = 3)
	   public void printAgentLogoDisplayed(){
		   boolean agentLogoPresent = salePage.agentLogoValidate();
		   System.out.println("Agent Logo for 5th property present or not  " + agentLogoPresent);
	   }
	   
	   @AfterMethod
	   public void teardown(){
		   driver.quit();
	   }

	   
}
