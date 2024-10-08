package SidharthSelenium;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Assignment1 {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "path_to_chromedriver"); // Specify path to chromedriver
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/loginpagePractise/");
        login(driver, wait);
        addKard(driver, wait);
        driver.quit(); // Close the WebDriver session
    }

    public static void login(WebDriver driver, WebDriverWait wait) {
        driver.findElement(By.id("username")).sendKeys("rahulshettyacademy");
        driver.findElement(By.name("password")).sendKeys("learning");
        driver.findElement(By.cssSelector("input[type='submit'][value='Login']")).click(); // Better selector for login button

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("okayBtn")));
        driver.findElement(By.id("okayBtn")).click();
        WebElement options = driver.findElement(By.xpath("//select[@class='form-control']"));
        Select s = new Select(options);
        s.selectByValue("consult");
        driver.findElement(By.id("terms")).click();
        driver.findElement(By.name("signin")).click();
    }

    public static void addKard(WebDriver driver, WebDriverWait wait) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText("Checkout")));
        List<WebElement> products = driver.findElements(By.cssSelector(".card-footer .btn-info"));
        for (WebElement product : products) {
            product.click();
        }

        driver.findElement(By.partialLinkText("Checkout")).click();
    }
}
