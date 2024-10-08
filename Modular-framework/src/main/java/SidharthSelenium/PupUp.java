package SidharthSelenium;

import java.time.Duration;


import org.openqa.selenium.chrome.ChromeDriver;



public class PupUp {

	public static void main(String[] args) {
		//WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		String username = "abc" ;
		String password ="123";
		//String url = "https://" + username + ":" + pass + "@the-internet.herokuapp.com/basic_auth";
		String url = "https://" + username + ":" + password + "@the-internet.herokuapp.com/basic_auth";
	//	driver.get("https://the-internet.herokuapp.com/basic_auth");
		driver.get(url);
		
		

	}

}
