package com.usecase1.hcl;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test1 {

	public static WebDriver driver;
	Properties prop ;
	ExtentReports extentreports;
	ExtentHtmlReporter htmlReport;
	ExtentTest testcase;
	
	
	

	@BeforeTest
	public void inIt() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.get("https://www.hcltech.com");
		WebElement target = driver.findElement(By.id("onetrust-accept-btn-handler"));
		Actions act = new Actions(driver);
		act.moveToElement(target).click().build().perform();

	}

	@Test(priority=1)
	public void useCase1_countLinks_nameOfTheLinks() throws IOException {

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		testcase = extentreports.createTest("Test the links available on home page ");
		List<WebElement> links = driver.findElements(By.tagName("a"));		
		int totalCount = links.size();		
		System.out.println(" Total links count " + totalCount);		
		testcase.log(Status.INFO, "Total counts of links are now available ");
		List<WebElement> activeLinks = new ArrayList<WebElement>();
		for (int i = 0; i < links.size(); i++) {

			if (links.get(i).getAttribute("href")!=null) {
				
				System.out.println("Total active link count" + activeLinks.add(links.get(i)));
				
				System.out.println(activeLinks.get(i).getText());
				
				
			}
		}
		testcase.log(Status.INFO,"Printed all the links available on the page ");
		
		

		/*
		 * WebElement logo = driver.findElement(By.xpath("//img[@title='HCLTech']"));
		 * 
		 * Screenshot logoimage = new AShot().takeScreenshot(driver, logo);
		 * 
		 * ImageIO.write(logoimage.getImage(), "png" , new File(
		 * "C://Users//abhishek_c//eclipse-workspace//com.testingpractice.hcl//LogoImage//HCLIMAGE.png"
		 * ));
		 * 
		 * File f = new File(
		 * "C://Users//abhishek_c//eclipse-workspace//com.testingpractice.hcl//LogoImage//HCLIMAGE.png"
		 * );
		 * 
		 * if(f.exists()) { System.out.println(" Image file is captured "); } else
		 * System.out.println("Image file not captured");
		 */

	}

	@Test(priority=2, enabled=false)

	public void useCase1_contactUsPage() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		testcase.log(Status.INFO,"Check the fields and status on Contact us page");
		WebElement contactUs = driver.findElement(By.xpath("//a[contains(text(),'Contact us')]"));
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("scroll(0,750)");
		contactUs.click();
		Thread.sleep(20000);
		Boolean checkFullName_txtbox = driver.findElement(By.xpath("//label[contains(text(),'Full Name')]"))
				.isDisplayed();
		if (checkFullName_txtbox) {
			System.out.println(" FullName TextBox is present on Contact us page ");
		} else
			System.out.println("FullName textbox field is missing ");

		Boolean BusinessEmailAddress = driver
				.findElement(By.xpath("//label[contains(text(),'Business Email Address')]")).isDisplayed();
		if (BusinessEmailAddress) {
			System.out.println(" BusinessEmailAddress textbox is present");
		} else
			System.out.println("BusinessEmailAddress textbox field is missing ");

		Boolean OrganizationInstitution = driver
				.findElement(By.xpath("//label[contains(text(),'Organization/ Institution')]")).isDisplayed();
		if (OrganizationInstitution) {
			System.out.println(" OrganizationInstitution textbox is present");
		} else
			System.out.println("OrganizationInstitution textbox field is missing ");

		Boolean PhoneMobile = driver.findElement(By.xpath("//label[contains(text(),'Phone/ Mobile')]"))
				.isDisplayed(); 
		if (PhoneMobile) {
			System.out.println(" PhoneMobile textbox is present");
		} else
			System.out.println("PhoneMobile textbox field is missing ");
		Boolean Country = driver.findElement(By.xpath("//label[contains(text(),'Country')]")).isDisplayed();
		if (Country) {
			System.out.println(" Country textbox is present");
		} else
			System.out.println("Country textbox field is missing ");

		Boolean RelationshiptoHCLTech = driver
				.findElement(By.xpath("//label[contains(text(),'Relationship to HCLTech')]")).isDisplayed();
		if (RelationshiptoHCLTech) {
			System.out.println(" RelationshiptoHCLTech textbox is present");
		} else
			System.out.println("RelationshiptoHCLTech textbox field is missing ");
		Boolean HowCanWeHelp = driver.findElement(By.xpath("//label[contains(text(),'How can we help you?')]"))
				.isDisplayed();
		if (HowCanWeHelp) {
			System.out.println(" HowCanWeHelp textbox is present");
		} else
			System.out.println("HowCanWeHelp textbox field is missing ");

		Boolean Browse = driver.findElement(By.xpath("//label[contains(text(),'Upload file (RFP, RFI & Others)')]"))
				.isDisplayed();
		if (Browse) {
			System.out.println(" Browse textbox is present");
		} else
			System.out.println("Browse textbox field is missing ");

		Boolean checkbox = driver.findElement(By.name("privacy_policy")).isDisplayed();
		if (checkbox) {
			System.out.println(" checkbox  is present");
		} else
			System.out.println("checkbox is missing ");
         Boolean Submit = driver.findElement(By.xpath("//*[@value='Submit']")).isDisplayed();
         if (Submit) {
 			System.out.println(" Submit is present");
 		} else
 			System.out.println("Submit is missing ");

	}
	
	@Test(priority=3)
	public void dataEntry_ContactUS() throws IOException {
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebElement target = driver.findElement(By.id("onetrust-accept-btn-handler"));
		Actions act = new Actions(driver);
		act.moveToElement(target).click().build().perform();
		WebElement contactUs = driver.findElement(By.xpath("//a[contains(text(),'Contact us')]"));
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("scroll(0,750)");
		contactUs.click();
		prop = new Properties();
		FileInputStream fis = new FileInputStream("C://Users//abhishek_c//eclipse-workspace//com.testingpractice.hcl//src//test//resources//config.properties");
		prop.load(fis);
		driver.findElement(By.name("full_name")).sendKeys(prop.getProperty("FullName"));
		driver.findElement(By.name("email_address")).sendKeys(prop.getProperty("BusinessEmailAddress"));
		driver.findElement(By.name("organization")).sendKeys(prop.getProperty("Organization"));
		driver.findElement(By.name("phone")).sendKeys(prop.getProperty("Phone"));
		Select country = new Select(driver.findElement(By.name("country")));
		country.selectByVisibleText(prop.getProperty("Country"));
		Select relationship = new Select(driver.findElement(By.name("query_type")));
		relationship.selectByVisibleText(prop.getProperty("Relationship"));
		Select jobTitle = new Select(driver.findElement(By.name("designation")));
		jobTitle.selectByVisibleText(prop.getProperty("jobTitle"));
		driver.findElement(By.name("message_comments")).sendKeys(prop.getProperty("Help"));
		
		
		
		
		
		
	}

	@AfterTest
	public void tearDown() {

		driver.quit();
	}
}