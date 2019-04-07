package com.zoopla.qa.testcases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.zoopla.qa.base.TestBase;
import com.zoopla.qa.pages.AgentNameDetails;
import com.zoopla.qa.pages.HomePage;
import com.zoopla.qa.pages.SalePage;
import com.zoopla.qa.pages.SearchPage;

public class AgentNameDetailsTest extends TestBase{
    HomePage homePage;
    SearchPage searchPage;
    SalePage salePage;
    String expectedAgentName;
     AgentNameDetails agentNameDetails;
	public AgentNameDetailsTest(){
		super();
	}

	   @BeforeMethod
	   public void setUp() throws InterruptedException{
			initialization();
			homePage = new HomePage();
			searchPage = homePage.clickonSearchButton("London");
			salePage =searchPage.clickOnFifthProperty();
			expectedAgentName = salePage.agentNameValidate();
			System.out.println("Expected Agent NAme is " + expectedAgentName);
			agentNameDetails = salePage.clickOnagentName();
	   }
	   
       @Test(priority = 1)
       public void validateAgentNameTest(){
    	   String actualAgentName = agentNameDetails.validateAgentNameDetails();
           System.out.println("Actual Agent Name is " + actualAgentName);
    	   Assert.assertEquals(actualAgentName, expectedAgentName,"Agent Name does not match");
    	   
       }
       
       @Test(priority = 2)
       public void printAgentAddressDetails(){
    	   String AgentAddressDetails = agentNameDetails.printAgentAddressDetails();
    	   System.out.println("Agent Address is " + AgentAddressDetails);
       }
			

	   @AfterMethod
	   public void teardown(){
		   driver.quit();
	   }

	
}
