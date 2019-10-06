package actionsclass;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import usefulmethods.GenericMethods;

import java.util.concurrent.TimeUnit;


public class DragAndDropActions {
    private WebDriver driver;
    private String baseUrl;
    private GenericMethods gm;
    private JavascriptExecutor jse;


    @Before
    public void setUp () throws Exception {
        driver = new FirefoxDriver();
        baseUrl = "https://jqueryui.com/droppable/";
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(baseUrl);
        gm = new GenericMethods(driver);
        jse = (JavascriptExecutor) driver;
    }

    @Test
    public void testDragAndDrop() throws Exception{
        Thread.sleep(2000);
        driver.switchTo().frame(0);

        WebElement fromElement = gm.getElement("draggable", "id");
        WebElement toElement = gm.getElement("droppable", "id");

        Actions action = new Actions(driver);
        //Drag and drop
       // action.dragAndDrop(fromElement, toElement).build().perform();

         // Click and hold element, release, build and perform
        action.clickAndHold(fromElement).moveToElement(toElement).release().build().perform();
    }

    @After
    public void tearDown() throws Exception{
        Thread.sleep(2000);
        driver.quit();
    }
}
