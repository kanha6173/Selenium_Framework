package SidharthSelenium;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Vegetables {

	public static void main(String[] args) throws InterruptedException {
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5 , TimeUnit.SECONDS);
		String []itemNeeded = {"Cucumber" , "Brocolli" , "Beetroot" , "Tomato" , "Capsicum"}; 
		driver.get("https://rahulshettyacademy.com/seleniumPractise/");
		//Thread.sleep(3000);
		addItems(driver, itemNeeded);
		applyCuppon(driver);
		
		
	}
	
	public static void addItems(WebDriver driver , String []itemNeeded) {
		int j=0;
		List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));
		for(int i = 0; i<products.size(); i++) {
			String []name = products.get(i).getText().split("-");
			String formattedName = name[0].trim();
			List itemNeededList = Arrays.asList(itemNeeded);
			if(itemNeededList.contains(formattedName)) {
				j++;
				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
				if(j == itemNeeded.length) {
					break;
				}
			}
		}
	}
	public static void applyCuppon(WebDriver driver) {
		driver.findElement(By.cssSelector("img[alt='Cart']")).click();
		//Thread.sleep(2000);
		driver.findElement(By.xpath("//button[text()='PROCEED TO CHECKOUT']")).click();
		//driver.findElement(By.xpath("//input[@class='promoCode']")).sendKeys("");
		//Thread.sleep(2000);
		driver.findElement(By.cssSelector("input.PromoCode")).sendKeys("rahulshettyacademy");
		driver.findElement(By.cssSelector("button.promoBtn")).click();
		//Explicit wait
		/*
		 * WebDriverWait w = WebDriverWait(driver, 5);
		 * w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(
		 * "span.promoInfo")));
		 */
		System.out.println(driver.findElement(By.cssSelector("span.promoInfo")).getText());
	}

	
	}


