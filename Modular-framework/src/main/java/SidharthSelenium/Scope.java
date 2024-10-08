package SidharthSelenium;

import java.util.concurrent.TimeUnit;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Scope {

	public static void main(String[] args) throws InterruptedException {
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		count(driver);
		footerCount(driver);
		fcolumn(driver);
	}

	public static void count(ChromeDriver driver) {
		// count the link of the page
		System.out.println(driver.findElements(By.tagName("a")).size());
	}

	// count the footer link of the page
	public static void footerCount(ChromeDriver driver) {
		WebElement footerdriver = driver.findElement(By.id("gf-BIG")); // limiting webdriver scope
		System.out.println(footerdriver.findElements(By.tagName("a")).size());
	}

	// count link on only first column
	public static void fcolumn(ChromeDriver driver) throws InterruptedException {
		WebElement columndriver = driver.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
		System.out.println(columndriver.findElements(By.tagName("a")).size());
		// click on everylink of this column and check pages are opening or not
		for (int i = 1; i < columndriver.findElements(By.tagName("a")).size(); i++) {

			String clicklink = Keys.chord(Keys.CONTROL, Keys.ENTER);

			columndriver.findElements(By.tagName("a")).get(i).sendKeys(clicklink);
			Thread.sleep(5000);
		}
		Set<String> win = driver.getWindowHandles();

		Iterator<String> index = win.iterator(); // It help move one tab to another

		while (index.hasNext()) { // hasNext - wheather next index is present or not
			driver.switchTo().window(index.next()); // . next - move to next index
			System.out.println(driver.getTitle());

		}

	}
}
