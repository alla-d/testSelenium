package javascripexecution;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Javascriptexecution {
    private WebDriver driver;
    String baseUrl;
    private JavascriptExecutor js;
    private Wait wt;

    @Before
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
        baseUrl = "https://letskodeit.teachable.com/pages/practice";
        js = (JavascriptExecutor) driver;

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();

    }

    @Test
    public void testJavaScripExecution() throws Exception {
        // Navigation
        //driver.get(baseUrl);
        js.executeScript("window.location = 'https://letskodeit.teachable.com/pages/practice';");
        // Find element
        //WebElement textBox = driver.findElement(By.id("name"));
        //textBox.sendKeys("test");
        WebDriverWait wait = new WebDriverWait(driver, 3);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("name")));
        js.executeScript("return document.getElementById('name').value='someValue';");

    }

    @After
    public void tearDown() throws Exception {
        //driver.quit();
    }
}
