package com.zoopla.qa.pages;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.zoopla.qa.base.TestBase;

public class SearchPage extends TestBase {
	public static String[] propertyPrice;
	public SearchPage(){
		PageFactory.initElements(driver, this);
		
	}
	@FindBy(xpath = "//ul[@data-role ='listview']/li[6]/div/div[2]/a")
	WebElement fifthProperty;
	
	public void allPropertiesPrices(){
		List<WebElement> allpropertyprice = driver.findElements(By.xpath("//ul[@data-role ='listview']/li/div/div[2]/a[contains(@class,'listing-results-price text-price')]"));
        propertyPrice = new String[allpropertyprice.size()];							
		int	i = 0;					
		for (WebElement e : allpropertyprice) {							
			propertyPrice[i] = e.getText();							
            i++;
        	}
		System.out.println("Sorting an Array in Descending order");
		Arrays.sort(propertyPrice,Collections.reverseOrder());
		
		System.out.println("Printing the Property Prices in Descending Order");
		for (int j = 0 ; j < propertyPrice.length ; j++ ){
			System.out.println(propertyPrice[j]);
			
		}
	}		
	 public String fifthPropertyPrice(int number){
	          
		 String fifthPrice = propertyPrice[number];
		 return fifthPrice;
		 
		 }

	 
     public SalePage clickOnFifthProperty(){
    	 JavascriptExecutor executor = (JavascriptExecutor) driver;
    	 executor.executeScript("arguments[0].click();", fifthProperty);
    	 
    	 
    	 //fifthProperty.click();
    	 return new SalePage();
    	 
    	 
     }
	 
	 
	 
	 
}