package actionsclass;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import usefulmethods.GenericMethods;

import java.util.concurrent.TimeUnit;

public class SliderAction {
    private WebDriver driver;
    private String baseUrl;
    private GenericMethods gm;
    private JavascriptExecutor jse;


    @Before
    public void setUp () throws Exception {
        driver = new FirefoxDriver();
        baseUrl = "https://jqueryui.com/slider/";
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(baseUrl);
        gm = new GenericMethods(driver);
        jse = (JavascriptExecutor) driver;
    }

    @Test
    public void testDragAndDrop() throws Exception{
       driver.switchTo().frame(0);
        Thread.sleep(2000);

        WebElement element = gm.getElement("//div[@id='slider']/span", "xpath");
        Actions action = new Actions(driver);
        action.dragAndDropBy(element, 100, 0).perform();
    }

    @After
    public void tearDown() throws Exception{
        Thread.sleep(2000);
        driver.quit();
    }
}
