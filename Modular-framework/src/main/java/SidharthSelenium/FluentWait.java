package SidharthSelenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FluentWait {

	public static void main(String[] args) {
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
		start(driver);

	}

	public static void start(WebDriver driver) {
		driver.findElement(By.xpath("//div[@id='start']/button")).click();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(7000));
		WebElement revenueCalculatorSlider = driver
				.findElement(By.xpath("//*[contains(@id, 'revenueCalculatorSlider')]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", revenueCalculatorSlider);

	}

}
