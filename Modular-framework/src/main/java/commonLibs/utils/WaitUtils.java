package commonLibs.utils;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtils {
	public static void waitTillAlertIsPresent(WebDriver driver, Duration timeoutInseconds)throws Exception {
        WebDriverWait wait = new WebDriverWait(driver, timeoutInseconds);
		wait.until(ExpectedConditions.alertIsPresent());
	}

}
