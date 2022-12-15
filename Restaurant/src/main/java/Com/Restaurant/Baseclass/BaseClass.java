package Com.Restaurant.Baseclass;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import org.apache.log4j.*;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import Com.Restaurant.Action.ActionClass;
import Com.Restaurant.Utilities.ExtentReport;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public static Properties prop;
	public static WebDriver driver;
	public static ActionClass action;
	//loadConfig method is to load the configuration
	
	@BeforeSuite
	public void beoreSuite() {
		ExtentReport.setExtent();
		DOMConfigurator.configure("log4j.xml");
	}
	@BeforeTest
	public void loadConfig() {

		try {
			 prop = new Properties();
			FileInputStream ip = new FileInputStream(
					System.getProperty("user.dir") + "\\Configurations\\config.properties");
			prop.load(ip);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void launchApp() {
		
	   String browserName = prop.getProperty("Broswer");
		if (browserName.equalsIgnoreCase("Chrome")) {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("FireFox")) {
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		} else if (browserName.equalsIgnoreCase("IE")) {
			WebDriverManager.iedriver().setup();
			driver=new InternetExplorerDriver();
		}
		//Maximize the screen
		driver.manage().window().maximize();
		action = new ActionClass();
		//Implicit TimeOuts
	    action.implicitWait(driver, 10);
		//PageLoad TimeOuts
		 action.pageLoadTimeOut(driver, 30);   
		 driver.get(prop.getProperty("url"));
		 
	}
	
	@DataProvider
	public Object[][] InvalidLoginDatas()
	{
		Object[][] data= new Object[3][2];
		data[0][0]="uname";
		data[0][1]="password";
		data[1][0]="uname";
		data[1][1]="pword";
		data[2][0]="admin";
		data[2][1]="pasword";
		return data;
		
	}
	
	@AfterSuite
	public void AfterSuit() {
		ExtentReport.endReport();
		driver.close();
	}

}
 