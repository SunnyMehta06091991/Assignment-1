package com.zoopla.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.zoopla.qa.util.TestUtils;

public class TestBase {
    public static WebDriver driver;
    public static Properties prop;

	
	public TestBase(){
		try {
			prop = new Properties();
			FileInputStream fis = new FileInputStream("G:\\Automation\\ZooplaQATest\\src\\main\\java\\com\\zoopla\\qa\\config\\config.properties");
			prop.load(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

    public static void initialization(){
    	String webBrowser = prop.getProperty("browser");
    	System.out.println("browser used for execution is "+ webBrowser);
    	
    	
    	if (webBrowser.equals("chrome")){
    	System.setProperty("webdriver.chrome.driver", "G:\\Automation\\WebDriver\\ChromeDriver\\chromedriver.exe");
    	driver = new ChromeDriver();
    	}else if (webBrowser.equals("FireFox")){
    	System.setProperty("webdriver.gecko.driver", "G:\\Automation\\WebDriver\\GheckoDriver\\geckodriver.exe");	
		driver = new FirefoxDriver(); 
        }
    	
    	driver.manage().window().maximize();
    	driver.manage().deleteAllCookies();
    	driver.manage().timeouts().pageLoadTimeout(TestUtils.pageLoadTimeout, TimeUnit.SECONDS);
    	driver.manage().timeouts().implicitlyWait(TestUtils.implicitWautTimeout, TimeUnit.SECONDS);
    	driver.get(prop.getProperty("url"));
    }


}
