package javascripexecution;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class WindowSize {
    private WebDriver driver;
    String baseUrl;
    private JavascriptExecutor js;
    private Wait wt;

    @Before
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
        baseUrl = "https://letskodeit.teachable.com/pages/practice";
        js = (JavascriptExecutor) driver;

        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.manage().window().maximize();

    }

    @Test
    public void testJavaScripExecution() throws Exception {
        js.executeScript("window.location = 'https://letskodeit.teachable.com/pages/practice';");

        long height = (long) js.executeScript("return window.innerHeight") ;
        long width = (long) js.executeScript("return window.innerWidth") ;
        System.out.println("Height is: " + height);
        System.out.println("Width is: " + width);
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
    }
}
