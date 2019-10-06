package actionsclass;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import usefulmethods.GenericMethods;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class MouseHoverActions {

    private WebDriver driver;
    private String baseUrl;
    private GenericMethods gm;
    private JavascriptExecutor jse;


    @Before
    public void setUp () throws Exception {
        driver = new FirefoxDriver();
        baseUrl = "https://letskodeit.teachable.com/pages/practice";
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(baseUrl);
        gm = new GenericMethods(driver);
        jse = (JavascriptExecutor) driver;
    }

    @Test
    public void testMouseHoverActions() throws Exception {
        jse.executeScript("window.scrollBy(0, 700)");
        Thread.sleep(2000);

        WebElement mainElement = gm.getElement("mousehover", "id");

        Actions action = new Actions(driver);
        action.moveToElement(mainElement).perform();
        Thread.sleep(2000);

        WebElement subElement = gm.getElement("//div[@class='mouse-hover-content']//a[text()='Top']", "xpath");
        action.moveToElement(subElement).click().perform();
    }

    @After
    public void tearDown() throws Exception{
        Thread.sleep(2000);
        driver.quit();
    }
}
