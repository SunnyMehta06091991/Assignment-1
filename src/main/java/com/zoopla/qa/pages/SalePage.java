package com.zoopla.qa.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.zoopla.qa.base.TestBase;

public class SalePage extends TestBase{

	public SalePage (){
		PageFactory.initElements(driver, this);
		}

	@FindBy(xpath = "//div[@class ='ui-agent__logo']/img")
	WebElement agentLogo;
	
	@FindBy(xpath = "//div[@class ='ui-agent__text']/h4")
	WebElement agentName;
	
	@FindBy(xpath = "//p[@class ='ui-agent__tel ui-agent__text']/a")
	WebElement agentNumber;
	
	
	public boolean agentLogoValidate(){
		return agentLogo.isDisplayed();
		
	}
	
	public String agentNameValidate(){
		return agentName.getText();
		
	}
	
	public String agentNumberValidate(){
		return agentNumber.getText();
		
	}
	
	public AgentNameDetails clickOnagentName(){
   	 JavascriptExecutor executor = (JavascriptExecutor) driver;
   	 executor.executeScript("arguments[0].click();", agentName);
		return new AgentNameDetails();
	}
	
	
	
	
}
