package SidharthSelenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ScrollFlipkart {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.flipkart.com/");
		WebElement search = driver.findElement(By.name("q"));
		search.sendKeys("shirts");
		search.submit();
		Thread.sleep(5000);
		List<WebElement> lists = driver.findElements(By.xpath("//div[@class='_75nlfW']/div"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		for (WebElement product : lists) {
			js.executeScript("arguments[0].scrollIntoView(true);", product);
		}

		//driver.close();

	}

}
