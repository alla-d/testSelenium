package switchto;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import usefulmethods.GenericMethods;

import java.util.concurrent.TimeUnit;

public class SwitchAlert {
    private WebDriver driver;
    private String baseUrl;
    private GenericMethods gm;
    private JavascriptExecutor js;


    @Before
    public void setUp () throws Exception {
        driver = new FirefoxDriver();
        baseUrl = "https://letskodeit.teachable.com/pages/practice";
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(baseUrl);
        gm = new GenericMethods(driver);
        js = (JavascriptExecutor) driver;
    }


    @Test
    public void test1() throws Exception{
        Thread.sleep(2000);
        // Scroll till element present
        WebElement element = driver.findElement(By.xpath("//div[@class='right-align']//legend[contains(text(),'Switch To Alert Example')]"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        Thread.sleep(3000);
        gm.getElement("name", "id").sendKeys("TEST");
        gm.getElement("alertbtn", "id").click();
        Thread.sleep(3000);
        Alert alert = driver.switchTo().alert();
        alert.accept();

    }
    @Test
    public void test2() throws Exception{
        Thread.sleep(2000);
       // Scroll till element present
        WebElement element = driver.findElement(By.xpath("//div[@class='right-align']//legend[contains(text(),'Switch To Alert Example')]"));
        WebElement textBox = gm.getElement("name", "id");
        js.executeScript("arguments[0].scrollIntoView(true);", element);
        Thread.sleep(3000);
        textBox.sendKeys("TEST");
        driver.findElement(By.id("confirmbtn")).click();
        Thread.sleep(3000);
        Alert alert = driver.switchTo().alert();
        alert.accept();
        // alert.

    }

    @After
    public void tearDown() throws Exception{
        Thread.sleep(2000);
        driver.quit();
    }
}
