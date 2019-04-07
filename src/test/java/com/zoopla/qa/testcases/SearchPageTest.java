package com.zoopla.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.zoopla.qa.base.TestBase;
import com.zoopla.qa.pages.HomePage;
import com.zoopla.qa.pages.SearchPage;

public class SearchPageTest extends TestBase{
    HomePage homePage;
    SearchPage searchPage;
	
	public SearchPageTest(){
		super();
	}
	
   @BeforeMethod
   public void setUp(){
		initialization();
		homePage = new HomePage();
		
        
	   }
   
   @Test(priority = 1)
   public void searchTest() throws InterruptedException{
	   searchPage = homePage.clickonSearchButton("London");
	   searchPage.allPropertiesPrices();
       String fifthProp = searchPage.fifthPropertyPrice(4);
       System.out.println("FifthProperty Price is " + fifthProp);

	   }
   
   
   
   @AfterMethod
   public void teardown(){
	   driver.quit();
   }


}
