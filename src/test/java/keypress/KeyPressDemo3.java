package keypress;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import usefulmethods.GenericMethods;

import java.util.concurrent.TimeUnit;

public class KeyPressDemo3 {

    private WebDriver driver;
    private String baseUrl;
    private GenericMethods gm;




    @Before
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
        baseUrl = "https://learn.letskodeit.com/p/practice";
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        gm = new GenericMethods(driver);
        driver.get(baseUrl);
    }

    @Test
    public void testKeyPress() throws Exception {
        Thread.sleep(2000);

        Actions action = new Actions(driver);
        action.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).perform();

    }

    @After
    public void tearDown() throws Exception {
        Thread.sleep(2000);
        driver.quit();
    }
}
