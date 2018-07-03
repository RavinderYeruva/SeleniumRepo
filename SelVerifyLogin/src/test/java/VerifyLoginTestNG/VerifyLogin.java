package VerifyLoginTestNG;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class VerifyLogin {
	
  WebDriver driver;
  
  @BeforeMethod
  public void launch() {
	  System.setProperty("webdriver.chrome.driver","chromedriver");
	  driver = new ChromeDriver();
	  driver.get("https://github.com/login");
  }
  
  @Test
  public void userLogin() {
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  driver.findElement(By.id("login_field")).sendKeys("RavinderYeruva");
	  driver.findElement(By.id("password")).sendKeys("rrYo07git>");
	  //WebElement mainClass = driver.findElement(By.className("auth-form-body mt-3"));
	  //mainClass.findElement(By.className("btn btn-primary btn-block")).click();
	  driver.findElement(By.xpath("//div[@class='auth-form-body mt-3']//input[@class='btn btn-primary btn-block']")).click();
  }
  
  @AfterMethod
  public void userLogout() {
	  driver.close();
  }
}
