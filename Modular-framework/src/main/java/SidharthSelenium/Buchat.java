package SidharthSelenium;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Buchat {

	public static void main(String[] args) throws InterruptedException {
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		String[] itemNeed = {"Baby Corn", "Beans"};
		driver.get("https://healthybuddha.in/fruits-vegetables/vegetables");
		Thread.sleep(3000);
		addItems(driver, itemNeed);
	}
	public static void addItems(WebDriver driver, String[] itemNeed) {
		int j=0;
		List<WebElement> products =driver.findElements(By.cssSelector(".products li"));
		for(int i=0; i<products.size();i++) {
			String[] name = products.get(i).getText().split("-");
			String formattedName = name[0].trim();
			
			List itemsNeededList = Arrays.asList(itemNeed);
			
			if(itemsNeededList.contains(formattedName)) {
				j++;
				driver.findElements(By.xpath("//i[@class='fa fa-plus']")).get(i).click();
				
				if(j==itemNeed.length) {
					break;
				}
			}
		}
	}

}
