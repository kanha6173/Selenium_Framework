package Streams;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class SortTable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		start(driver);

	}

	public static void start(WebDriver driver) {
		// click on column
		driver.findElement(By.xpath("//tr/th[1]")).click();
		// capture all webelement into list
		List<WebElement> elementList = driver.findElements(By.xpath("//tr/td[1]"));
		// capture all the text of Webelement into new original list
		List<String> originalList = elementList.stream().map(s -> s.getText()).collect(Collectors.toList());
		// sort the original list
		List<String> sortedLiist = originalList.stream().sorted().collect(Collectors.toList());
		Assert.assertEquals(originalList, sortedLiist);

		// find the price of rice in list
		List<String> price;
		do {
			
			List<WebElement> rows = driver.findElements(By.xpath("//tr/td[1]"));
		
		price = rows.stream().filter(s -> s.getText().contains("Rice")).map(SortTable::getPriceVeg)
				.collect(Collectors.toList());

		price.forEach(System.out::println);
		if(price.size()<1) {
			driver.findElement(By.cssSelector("[aria-label='Next']")).click();
		}
		}while(price.size()<1);
	}

	private static String getPriceVeg(WebElement s) {
        // Find the price element that is a sibling of the provided element
        WebElement priceValue = s.findElement(By.xpath("following-sibling::td[1]"));
        return priceValue.getText();
        // if Rice is not present in First page then go to another page
        
        
	}

}
