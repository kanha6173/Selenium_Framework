package SidharthSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class Actions1 {

	public static void main(String[] args) throws InterruptedException {
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(
				"https://www.amazon.in/b/?ie=UTF8&node=976419031&ext=6880-31904&ref=pd_sl_7hz2t19t5c_e&tag=googhydrabk1-21&hvpos=&hvnetw=g&hvrand=5835382698423889047&hvpone=&hvptwo=&hvqmt=e&hvdev=c&hvdvcmdl=&hvlocint=&hvlocphy=9302026&hvtargid=kwd-10573980&tag=googhydrabk1-21&ref=pd_sl_7hz2t19t5c_e&adgrpid=155259815513&hvpone=&hvptwo=&hvadid=674842289437&hvpos=&hvnetw=g&hvrand=5835382698423889047&hvqmt=e&hvdev=c&hvdvcmdl=&hvlocint=&hvlocphy=9302026&hvtargid=kwd-10573980&hydadcr=14453_2316415&gad_source=1");
		action(driver);
	}

	public static void action(WebDriver driver) throws InterruptedException {

		Actions a = new Actions(driver);
		WebElement obj = driver.findElement(By.cssSelector("a[id='nav-link-accountList']"));
		
		// Move to specific element
		a.moveToElement(obj).build().perform();
		WebElement search = driver.findElement(By.name("field-keywords"));
		
		// Write something in small convert it to captital
		a.moveToElement(search).click().keyDown(Keys.SHIFT).sendKeys("phones").build().perform();
		
		// double click
		a.moveToElement(search).doubleClick().build().perform();
		
		//right click
		a.moveToElement(obj).contextClick().build().perform();
		Thread.sleep(3000);
		driver.close();

	}

}
