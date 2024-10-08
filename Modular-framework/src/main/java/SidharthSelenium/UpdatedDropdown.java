package SidharthSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class UpdatedDropdown {

	public static void main(String[] args) throws InterruptedException {
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/#");
		/*
		 * System.out.println(driver.findElement(By.cssSelector(
		 * "input[id*='friendsandfamily']")).isSelected());
		 * 
		 * driver.findElement(By.id("divpaxinfo")).click(); Thread.sleep(2000);
		 */
		 
			/*
			 * //count the number of checkbox
			 * System.out.println(driver.findElements(By.cssSelector(
			 * "input[type='checkbox']")).size());
			 * driver.findElement(By.cssSelector("input[id*='friendsandfamily']")).click();
			 * System.out.println(driver.findElement(By.cssSelector(
			 * "input[id*='friendsandfamily']")).isSelected()); Assert.assertfalse()
			 */
		
		
		driver.findElement(By.id("divpaxinfo")).click();
		Thread.sleep(2000);
		System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
		Thread.sleep(2000);
		// click 4time
		/*
		 * int i = 1; while (i < 5) { driver.findElement(By.id("hrefIncAdt")).click();
		 * i++; }
		 */
		for(int i=1; i<5; i++) {
			driver.findElement(By.id("hrefIncAdt")).click();
		}
		driver.findElement(By.id("btnclosepaxoption")).click();
		Thread.sleep(2000);
		System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
		//Assert.ass

	}

}
