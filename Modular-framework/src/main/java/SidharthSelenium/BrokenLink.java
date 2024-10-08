package SidharthSelenium;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class BrokenLink {

	public static void main(String[] args) throws MalformedURLException, IOException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");

		List<WebElement> links = driver.findElements(By.xpath("//li[@class='gf-li']/a"));
		SoftAssert a = new SoftAssert();
		for (WebElement link : links) {
			String url = link.getAttribute("href");
			HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
			conn.setRequestMethod("HEAD");
			conn.connect();
			int respcode = conn.getResponseCode();
			// System.out.println(respcode);
			a.assertTrue(respcode < 400,
					"Broken links are " + link.getText() + " and it's status codes are " + respcode);
			/*
			 * if (respcode > 400) { System.out.println("Broken links are " + link.getText()
			 * + " and it's status codes are " + respcode); Assert.assertTrue(false); }
			 */
		}
		a.assertAll();

	}

}
