package keypress;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import usefulmethods.GenericMethods;
import org.openqa.selenium.Keys;

import java.util.concurrent.TimeUnit;

public class KeyPressDemo1 {

    private WebDriver driver;
    private String baseUrl;
    private GenericMethods gm;


    @Before
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
        baseUrl = "https://learn.letskodeit.com/p/practice";
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(baseUrl);
        gm = new GenericMethods(driver);

    }

    @Test
    public void testKeyPress() throws Exception {
        driver.findElement(By.xpath("//a[contains(@href, 'sign_in')]")).click();
        gm.isElementPresent("user_email", "id");
        driver.findElement(By.id("user_email")).sendKeys("test@test.com");
        Thread.sleep(2000); // just to see how it work
        driver.findElement(By.id("user_email")).sendKeys(Keys.TAB);
        gm.getElement("user_password", "id").sendKeys("password");
        Thread.sleep(2000);
       // gm.getElement("commit", "name").sendKeys(Keys.ENTER);
    }

    @After
    public void tearDown() throws Exception {
        Thread.sleep(2000);
        driver.quit();
    }
}
