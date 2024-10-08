package commonLibs.implementation;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import commonLibs.contracts.IDriver;

public class CommonDriver implements IDriver {
	private WebDriver driver;
	private int pageLoadTimeout;
	private int elementDetectionTimeout;
	private String currentWorkingDirectory;

	public CommonDriver(String browserType) throws Exception {
		pageLoadTimeout = 60;
		elementDetectionTimeout = 10;
		currentWorkingDirectory= System.getProperty("user.dir");
		if (browserType.equalsIgnoreCase("chrome")) {
			// System.setProperty("webdriver.chrome.driver" ,currentWorkingDirectory +"/drivers/chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browserType.equalsIgnoreCase("edge")) {
			System.setProperty("webdriver.edge.driver", currentWorkingDirectory + "/drivers/edgedriver_win64");
			driver = new EdgeDriver();

		} else {
			throw new Exception("Invalid browser type");
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
	}

	public WebDriver getDriver() {
		return driver;
	}

	public void setPageLoadTimeout(int pageLoadTimeout) {
		this.pageLoadTimeout = pageLoadTimeout;
	}

	public void setElementDetectionTimeout(int elementDetectionTimeout) {
		this.elementDetectionTimeout = elementDetectionTimeout;
	}


	@Override
	public void navigateToFirstUrl(String url) throws Exception {
		driver.manage().timeouts().pageLoadTimeout(pageLoadTimeout, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(elementDetectionTimeout, TimeUnit.SECONDS);
		url = url.trim();
		driver.get(url);

	}

	@Override
	public String getTitle() throws Exception {
		String title = driver.getTitle();
		return title;
	}

	@Override
	public String getCurrentUrl() throws Exception {
		String currenturl = driver.getCurrentUrl();
		return currenturl;
	}

	@Override
	public String getPageSource() throws Exception {
		String pageSource = driver.getPageSource();
		return pageSource;
	}

	@Override
	public void navigateToUrl(String url) throws Exception {
		url = url.trim();
		driver.navigate().to(url);

	}

	@Override
	public void navigateForword() throws Exception {
		driver.navigate().forward();
	}

	@Override
	public void navigateBackword() throws Exception {
		driver.navigate().back();

	}

	@Override
	public void refresh() throws Exception {
		driver.navigate().refresh();

	}

	@Override
	public void closeBrowser() throws Exception {
		if (driver != null) {
			driver.close();
		}
	}

	@Override
	public void closeAllBrowser() throws Exception {
		if (driver != null) {
			driver.quit();
		}
	}

}
