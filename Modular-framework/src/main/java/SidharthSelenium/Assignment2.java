package SidharthSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assignment2 {

	public static void main(String[] args) {
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://qaclickacademy.com/practice.php");
		ass(driver);
	}

	public static void ass(ChromeDriver driver) {
		driver.findElement(By.id("checkBoxOption2")).click();
		String opt = driver.findElement(By.xpath("//div[@id='checkbox-example']/fieldset/label[2]")).getText();
		WebElement drop = driver.findElement(By.name("dropdown-class-example"));
		Select s = new Select(drop);
		s.selectByVisibleText(opt);
		driver.findElement(By.name("enter-name")).sendKeys(opt);

		driver.findElement(By.id("alertbtn")).click();
		String text = driver.switchTo().alert().getText();
		if (text.contains(opt)) {
			System.out.println("Alert message success");
		} else {
			System.out.println("Something wrong with execution");
		}

	}

}
