package VerifyLoginTestNG;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class VerifyLoginTest {
	
  WebDriver driver;
  
  @BeforeMethod
  public void launch() {
	  System.setProperty("webdriver.chrome.driver","//home//edureka//SelVerifyLogin//chromedriver");
	  ChromeOptions options = new ChromeOptions();
	  options.setExperimentalOption("useAutomationExtension", false);
	  //options.setHeadless(true);
	  //options.addArguments("start-maximized"); // open Browser in maximized mode
	  //options.addArguments("disable-infobars"); // disabling infobars
	  options.addArguments("--disable-extensions"); // disabling extensions
	  options.addArguments("--disable-dev-shm-usage"); // overcome limited resource problems
	  options.addArguments("--no-sandbox"); 
	  driver = new ChromeDriver(options);
	  driver.get("https://github.com/login");
	  driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
  }
  
  @Test
  public void userLogin() {
	  driver.manage().window().maximize();
	  driver.findElement(By.id("login_field")).sendKeys("RavinderYeruva");
	  driver.findElement(By.id("password")).sendKeys("rrYo07git>");
	  driver.findElement(By.xpath("//div[@class='auth-form-body mt-3']//input[@class='btn btn-primary btn-block']")).click();
  }
  
  @AfterMethod
  public void userLogout() {
	  driver.close();
  }
}
