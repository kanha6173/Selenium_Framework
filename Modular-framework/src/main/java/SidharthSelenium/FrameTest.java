package SidharthSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class FrameTest {

	public static void main(String[] args) {
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://jqueryui.com/droppable/");
		frames(driver);
	}

	public static void frames(ChromeDriver driver) {
       driver.switchTo().frame(driver.findElement(By.cssSelector("iframe.demo-frame")));
       driver.findElement(By.id("draggable")).click();
       Actions action = new Actions(driver);
       WebElement source = driver.findElement(By.id("draggable"));
       WebElement target = driver.findElement(By.id("droppable"));
       action.dragAndDrop(source, target).build().perform();
	}

}
