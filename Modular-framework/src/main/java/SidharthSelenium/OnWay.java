package SidharthSelenium;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.openqa.selenium.chrome.ChromeDriver;

public class OnWay {

	public static void main(String[] args) {
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/#");
		//System.out.println(driver.findElement(By.id("ctl00_mainContent_view_date2")).isEnabled());
		System.out.println(driver.findElement(By.id("Div1")).getAttribute("style"));
		if(driver.findElement(By.id("Div1")).getAttribute("style").contains("1")) {
			System.out.println("It is enable");
			Assert.assertTrue(true);	
		}
		else {
			Assert.assertTrue(false);
		}
		driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();
		//System.out.println(driver.findElement(By.id("ctl00_mainContent_view_date2")).isEnabled());
		System.out.println(driver.findElement(By.id("Div1")).getAttribute("style"));
	//	driver
		
		
	}

}