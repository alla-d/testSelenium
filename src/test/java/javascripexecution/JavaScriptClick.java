package javascripexecution;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Wait;
import usefulmethods.GenericMethods;

import java.util.concurrent.TimeUnit;

public class JavaScriptClick {
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
    driver.get(baseUrl);
        Thread.sleep(2000);

        WebElement checkBoxElement = gm.getElement("bmwcheck", "id");
        js.executeScript("arguments[0].click();", checkBoxElement);



    }

    @After
    public void tearDown() throws Exception {
        //driver.quit();
    }
}
