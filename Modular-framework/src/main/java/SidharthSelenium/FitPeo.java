package SidharthSelenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FitPeo {
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.fitpeo.com/");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		navigate(driver, wait);
		scroll(driver, wait);
		adjustSlider(driver, wait);
		slider(driver, wait, 820);

	}

	public static void navigate(WebDriver driver, WebDriverWait wait) {
		WebElement revenueCalculatorLink = wait
				.until(ExpectedConditions.elementToBeClickable(By.linkText("Revenue Calculator")));
		revenueCalculatorLink.click();
		wait.until(ExpectedConditions.urlToBe("https://www.fitpeo.com/revenue-calculator"));
		String expectedUrl = "https://www.fitpeo.com/revenue-calculator";
		String actualUrl = driver.getCurrentUrl();
		if (expectedUrl.equals(actualUrl)) {
			System.out.println("Navigation to Revenue Calculator page successful.");
		} else {
			System.out.println("Failed to navigate to Revenue Calculator page.");
		}
	}

	public static void scroll(WebDriver driver, WebDriverWait wait) {
		WebElement revenueCalculatorSlider = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//h4[text()=\"Medicare Eligible Patients\"]")));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", revenueCalculatorSlider);
		if (revenueCalculatorSlider.isDisplayed()) {
			System.out.println("Revenue calculator slider is visible.");
		} else {
			System.out.println("Failed to make the revenue calculator slider visible.");
		}
	}

	public static void slider(WebDriver driver, WebDriverWait wait, int targetValue) throws InterruptedException {
		WebElement slider = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.id("revenue-calculator-slider")));
		WebElement textField = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.id("slider-value-text-field")));
		int sliderWidth = slider.getSize().getWidth();
		int minValue = 0;
		int maxValue = 1000;
		int valueRange = maxValue - minValue;
		int pixelRange = sliderWidth;
		int pixelValueRatio = pixelRange / valueRange;
		int targetOffset = (targetValue - minValue) * pixelValueRatio;
		Actions actions = new Actions(driver);
		actions.clickAndHold(slider).moveByOffset(targetOffset, 0).release().perform();
		wait.until(ExpectedConditions.textToBePresentInElementValue(textField, String.valueOf(targetValue)));
		String actualValue = textField.getAttribute("value");
		if (actualValue.equals(String.valueOf(targetValue))) {
			System.out.println("Slider adjusted successfully to " + targetValue + ". Text field updated.");
		} else {
			System.out.println("Failed to adjust slider or update text field.");
		}
		Thread.sleep(5000);
	}

	public static void adjustSlider(WebDriver driver, WebDriverWait wait) {
		WebElement textField = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id=':r0:']")));
		Actions actions = new Actions(driver);
		actions.click(textField).keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).sendKeys(Keys.BACK_SPACE)
				.sendKeys("560").perform();
	}
}
