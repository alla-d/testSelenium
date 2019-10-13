package interviewquestions;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import usefulmethods.GenericMethods;

import java.util.concurrent.TimeUnit;

public class StaleElementDemo {
    private WebDriver driver;
    private String baseUrl;




    @Before
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
        baseUrl = "https://learn.letskodeit.com/p/practice";
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(baseUrl);
    }

    @Test
    public void StaleElementDemo() throws Exception {
        // when you do something on the page and it changes/reloads DOM is rebuilt
        // Previously found elements become stale
      WebElement checkboxElement = driver.findElement(By.id("bmxcheck"));
      driver.get(driver.getCurrentUrl());
      checkboxElement = driver.findElement(By.id("bmxcheck")); // find element when you actually need it
      checkboxElement.click();
    }

    @After
    public void tearDown() throws Exception {
        Thread.sleep(2000);
        driver.quit();
    }
}
