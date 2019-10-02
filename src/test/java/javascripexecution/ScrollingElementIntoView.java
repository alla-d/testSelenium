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
import usefulmethods.GenericMethods;

import java.util.concurrent.TimeUnit;

public class ScrollingElementIntoView {
    private WebDriver driver;
    String baseUrl;
    private JavascriptExecutor js;
    private Wait wt;
    private GenericMethods gm;

    @Before
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
        baseUrl = "https://letskodeit.teachable.com/pages/practice";
        js = (JavascriptExecutor) driver;
        gm = new GenericMethods(driver);

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();

    }

    @Test
    public void testJavaScripExecution() throws Exception {
       // Navigation
        js.executeScript("window.location = 'https://letskodeit.teachable.com/pages/practice';");
       Thread.sleep(2000);

        // Scroll Down
        js.executeScript("window.scrollBy(0, 1900);");
        Thread.sleep(2000);


        // Scroll up
        js.executeScript("window.scrollBy(0, -1900);");
        Thread.sleep(2000);

        // Scroll element into view
        WebElement element = gm.getElement("mousehover", "id");
        js.executeScript("arguments[0].scrollIntoView(true);", element);

        // More scroll up
        js.executeScript("window.scrollBy(0, -190);");
    }

    @After
    public void tearDown() throws Exception {
        //driver.quit();
    }
}
