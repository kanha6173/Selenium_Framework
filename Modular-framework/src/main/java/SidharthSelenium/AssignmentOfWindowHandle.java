package SidharthSelenium;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class AssignmentOfWindowHandle {

	public static void main(String[] args) {
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5 , TimeUnit.SECONDS);
		driver.get("http://the-internet.herokuapp.com/");	
		ass(driver);

	}
	public static void ass(ChromeDriver driver) {
		driver.findElement(By.xpath("//a[text()='Multiple Windows']")).click();
		driver.findElement(By.linkText("Click Here")).click();
		Set<String> windows = driver.getWindowHandles();	
		Iterator<String> index =windows.iterator();
		String parent = index.next();
		String child = index.next();
		driver.switchTo().window(child);
		System.out.println(driver.findElement(By.xpath("//div[@class='example']/h3")).getText());
		driver.switchTo().window(parent);
		System.out.println(driver.findElement(By.xpath("//div[@class='example']/h3")).getText());
		driver.close();
	}

}
