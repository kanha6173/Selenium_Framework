package SidharthSelenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Calender {

	public static void main(String[] args) {
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");	
        String month = "3";
        String day = "29";
        String year = "2030"; 
        String[] expectedlist = {month,day,year};
        cal(driver, year , month , day,expectedlist);
	}
	public static void cal(ChromeDriver driver, String year , String month ,String day , String[] expectedlist) {
		driver.findElement(By.cssSelector(".react-date-picker__inputGroup")).click();
		driver.findElement(By.cssSelector(".react-calendar__navigation__label")).click();
		driver.findElement(By.cssSelector(".react-calendar__navigation__label")).click();
		driver.findElement(By.xpath("//button[text()='"+year+"']")).click();
		driver.findElements(By.cssSelector(".react-calendar__year-view__months__month")).get(Integer.parseInt(month)-1).click();
		driver.findElement(By.xpath("//abbr[text()='"+day+"']")).click();
		List<WebElement> list =driver.findElements(By.cssSelector(".react-date-picker__inputGroup__input"));
		for(int i=0; i<list.size();i++) {
			System.out.println(list.get(i).getAttribute("value"));
			Assert.assertEquals(list.get(i).getAttribute("value"), expectedlist[i]);
		}
	}

}
