package SidharthSelenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class Locators2 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		String name = "Kanha" ;
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		String password =getPassword(driver);
		System.out.println(password);
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.findElement(By.id("inputUsername")).sendKeys(name);
		driver.findElement(By.name("inputPassword")).sendKeys(password);
		driver.findElement(By.className("signInBtn")).click();
		Thread.sleep(1000);
		System.out.println(driver.findElement(By.tagName("p")).getText());
		WebElement verify = driver.findElement(By.xpath("//h2"));
		if (verify.getText().contains("kanha")) {
			System.out.println("Correct name is coming");
		} else {
			System.out.println("Incorrect name is coming!");
		}
		driver.findElement(By.xpath("//*[text()='Log Out']")).click();
		driver.close();
		
		
	}
	public static String getPassword(WebDriver driver) throws InterruptedException {
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.findElement(By.linkText("Forgot your password?")).click();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("button.reset-pwd-btn")).click();
		//Please use temporary password 'rahulshettyacademy' to login.
		String pass = driver.findElement(By.cssSelector("form p")).getText();
		String[] passArray= pass.split("'");
		// 0th index Please use temporary password 
		// 1st index rahulshettyacademy' to login.
		String[] passArray2 = passArray[1].split("'");
		return passArray2[0];
		// String passArray2 = passArray[1].split("'")[0];       // same as above 2 line
		
		//0th index rahulshettyacademy
		//1st index to login.
	}

}
