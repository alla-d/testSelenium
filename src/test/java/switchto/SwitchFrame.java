package switchto;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import usefulmethods.GenericMethods;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class SwitchFrame {
    private WebDriver driver;
    private String baseUrl;
    private GenericMethods gm;

    @Before
    public void setUp () throws Exception {
        driver = new FirefoxDriver();
        baseUrl = "https://letskodeit.teachable.com/pages/practice";
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(baseUrl);
        gm = new GenericMethods(driver);
    }

    @Test
    public void test() throws Exception{
        Thread.sleep(2000);
        // Switch to Frame
        driver.switchTo().frame("courses-iframe");
        // Switch to Frame by name
        // driver.switchTo().frame("iframe-name");
        // Switch to Frame by numbers
        // driver.switchTo().frame(0);

        WebElement searchBox = driver.findElement(By.id("search-courses"));
        searchBox.sendKeys("python");

        // Switch to parent
        driver.switchTo().defaultContent();
        Thread.sleep(2000);
        gm.getElement("name", "id").sendKeys("Test Successful");

    }

    @After
    public void tearDown() throws Exception{
        Thread.sleep(2000);
        driver.quit();
    }
}
