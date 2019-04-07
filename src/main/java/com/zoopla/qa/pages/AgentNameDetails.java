package com.zoopla.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.zoopla.qa.base.TestBase;

public class AgentNameDetails extends TestBase{
	
	public AgentNameDetails (){
		PageFactory.initElements(driver, this);
		}
      
      @FindBy(xpath = "//div[@id ='listings-agent']/div/p/strong")
      WebElement validateAgentName;
      
      @FindBy(xpath = "//div[@id ='listings-agent']/div/p/strong")
      WebElement printAgentAddress;
      
      public String  validateAgentNameDetails(){
    	 return validateAgentName.getText();
    	  
      }
      
      
      public String printAgentAddressDetails(){
    	  return printAgentAddress.getText();
      }
      
}
