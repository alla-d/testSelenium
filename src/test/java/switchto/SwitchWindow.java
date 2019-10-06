package switchto;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import usefulmethods.GenericMethods;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class SwitchWindow {
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
        //Get the handle
        String parentHandle =driver.getWindowHandle();
        System.out.println("Parent handle is: " + parentHandle);

        //Find open window button
        WebElement openWindow = driver.findElement(By.id("openwindow"));
        openWindow.click();

        // Get all handles
        Set<String> handles = driver.getWindowHandles();

        //Switch between handles
        for (String handle: handles){
            System.out.println(handle);
            if (!handle.equals(parentHandle)){
                driver.switchTo().window(handle);
                Thread.sleep(2000);
                WebElement searchBox = driver.findElement(By.id("search-courses"));
                searchBox.sendKeys("python");
                driver.close();
                break;
            }
        }

        //Switch back to the parent window
        driver.switchTo().window(parentHandle);
        gm.getElement("name", "id").sendKeys("Test Successful");
    }

    @After
    public void tearDown() throws Exception{
        Thread.sleep(2000);
        driver.quit();
    }
}
