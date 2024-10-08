package SidharthSelenium;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WindowHandle {

	public static void main(String[] args) throws InterruptedException {
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		handle(driver);
	}

	public static void handle(WebDriver driver) throws InterruptedException {
		driver.findElement(By.cssSelector("a[class='blinkingText']")).click();
		/*
		 * WebDriverWait w = WebDriverWait(driver, 5);
		 * w.until(ExpectedConditions.visibilityOfElementLocated(By.
		 * xpath("//p[@class='im-para red']")));
		 */

		// handle window
		Set<String> windows = driver.getWindowHandles(); // [parent id , child id]
		Iterator<String> index = windows.iterator();
		String parent = index.next();
		String child = index.next();
		driver.switchTo().window(child);
		System.out.println(driver.findElement(By.cssSelector(".im-para.red")).getText());
		//Please email us at mentor@rahulshettyacademy.com with below template to receive response
		String email = driver.findElement(By.cssSelector(".im-para.red")).getText().split("at")[1].trim().split(" ")[0];
		System.out.println(email);
		driver.switchTo().window(parent);
		driver.findElement(By.name("username")).sendKeys(email);
		Thread.sleep(3000);
		driver.close();
	}

}
