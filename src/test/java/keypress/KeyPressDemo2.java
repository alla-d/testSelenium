package keypress;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import usefulmethods.GenericMethods;

import java.util.concurrent.TimeUnit;

public class KeyPressDemo2 {

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
        //gm.getElement("openwindow", "id").sendKeys(Keys.CONTROL, "a");
        Thread.sleep(2000);
        gm.getElement("openwindow", "id").sendKeys(Keys.chord(Keys.CONTROL, "a"));
        String selectAll = Keys.chord(Keys.CONTROL, "a");
       // gm.getElement("openwindow", "id").sendKeys(selectAll);

    }

    @After
    public void tearDown() throws Exception {
        Thread.sleep(2000);
        driver.quit();
    }
}
