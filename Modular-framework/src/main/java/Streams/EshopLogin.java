package Streams;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.Assert;

public class EshopLogin {
	WebDriver driver;

	@BeforeClass
	public void setUp() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
		driver.get("https://localhost:44315/");
	}

	@Test
	public void login() {
		driver.findElement(By.xpath("//a[@class='esh-identity-name esh-identity-name--upper']")).click();
		String firstuname = driver.findElement(By.xpath("//form/p[2]/b[2]']")).getText();
		String pass = driver.findElement(By.xpath("//b[text()='Pass@word1']")).getText();
		driver.findElement(By.id("Input_Email")).sendKeys(firstuname);
		driver.findElement(By.name("Input.Password")).sendKeys(pass);
		driver.findElement(By.id("Input_RememberMe")).click();
		driver.findElement(By.className("btn")).click();

		try {
			String user = driver.findElement(By.xpath("//section[@class='esh-identity-section']/div")).getText();
			Assert.assertEquals(user, firstuname, "Login failed - username does not match");
			System.out.println("Successfully logged in with user: " + user);
		} catch (Exception e) {
			System.out.println("Failed to log in: " + e.getMessage());
		}

	}

	@Test
	public void dropDown() {
		driver.get("https://localhost:44315/"); 
		WebElement drop = driver.findElement(By.id("CatalogModel_BrandFilterApplied"));
		Select select = new Select(drop);
		select.selectByValue("2");


	}

}
