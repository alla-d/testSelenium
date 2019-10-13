package interviewquestions;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import usefulmethods.GenericMethods;

import java.util.concurrent.TimeUnit;

public class NoSuchElementDemo {
    private WebDriver driver;
    private String baseUrl;
    private GenericMethods gm;


    @Before
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
        baseUrl = "https://learn.letskodeit.com/p/practice";
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(baseUrl);
        gm = new GenericMethods(driver);

    }

    @Test
    public void NoSuchElementDemo() throws Exception {
        //1. Timing Issues
        driver.findElement(By.xpath("//a[href='/sing_in']")).click();
        // This part for implicitlyWait
        //  WebElement emailField = driver.findElement(By.id("user_email"));
        //emailField.sendKeys("testing");

        //This part for explicitWait
        WebDriverWait wait = new WebDriverWait(driver, 3);
        WebElement emailField = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id("user_email")));
        emailField.sendKeys("testing");

        // 2. Incorrect locator or type of locator
        driver.findElement(By.xpath("//a[contains(href='/sing_in')]")).click();

        // 3. Element is in iFrame
        driver.get("https://letskodeit.teachable.com/pages/practice");
        driver.switchTo().frame("search-courses");
        driver.findElement(By.id("search-courses")).sendKeys("Java");
        driver.switchTo().defaultContent();
    }

    @After
    public void tearDown() throws Exception {
        Thread.sleep(2000);
        driver.quit();
    }
}
