package SidharthSelenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SSL {

	public static void main(String[] args) {
		//for delete ssl certificate
		ChromeOptions option = new ChromeOptions();
		option.setAcceptInsecureCerts(true);
		
		WebDriver driver = new ChromeDriver(option);
		driver.manage().window().maximize();
		driver.get("https://10.10.40.6:3500/UnifiedDashboard/#/login");

	}

}
