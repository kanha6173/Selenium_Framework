package RelativeLoc;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.openqa.selenium.support.locators.RelativeLocator.*;

public class RelativeLoc {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		WebElement nameEditBox = driver.findElement(By.xpath("//input[@name='name']"));
       String output = driver.findElement(with(By.tagName("label")).above(nameEditBox)).getText();
       System.out.println(output);
       
       WebElement dob = driver.findElement(By.xpath("//label[@for='dateofBirth']"));
       driver.findElement(with(By.tagName("input")).below(dob)).click();
       
       WebElement check = driver.findElement(By.xpath("//label[@for='exampleCheck1']"));
       driver.findElement(with(By.tagName("input")).toLeftOf(check)).click();
       
       WebElement radio = driver.findElement(By.xpath("//input[@id='inlineRadio1']"));
       String radiobtn = driver.findElement(with(By.tagName("label")).toRightOf(radio)).getText();
       System.out.println(radiobtn);
	}

}
