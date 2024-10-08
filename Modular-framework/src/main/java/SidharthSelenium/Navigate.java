package SidharthSelenium;

import org.openqa.selenium.chrome.ChromeDriver;

public class Navigate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.google.com");
		driver.navigate().to("http://www.flipkart.com");
		driver.navigate().back();
		driver.navigate().forward();
		

	}

}
