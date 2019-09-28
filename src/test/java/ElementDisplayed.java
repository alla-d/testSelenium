import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class ElementDisplayed {

    WebDriver driver;
    String baseUrl;



    @Before
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
        baseUrl = "https://learn.letskodeit.com/p/practice";
       driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(baseUrl);

    }

    @Test
    public void testLetsKodeIt() throws Exception {
       /** Element is presented on DOM but is hided from view */

        WebElement textBox = driver.findElement(By.id("displayed-text"));
        System.out.println("Text Box Displayed: " + textBox.isDisplayed());

        Thread.sleep(3000);

        WebElement hideButton = driver.findElement(By.id("hide-textbox"));
        hideButton.click();
        System.out.println("Clicked on hide button");
        System.out.println("Text Box Displayed: " + textBox.isDisplayed());

        Thread.sleep(3000);

        WebElement showButton = driver.findElement(By.id("show-textbox"));
        showButton.click();
        System.out.println("Clicked on show button");
        System.out.println("Text Box Displayed: " + textBox.isDisplayed());
    }


    @After
    public void tearDown() throws Exception {
        Thread.sleep(2000);
        driver.quit();
    }
}

