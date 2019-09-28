package waittypes;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import utilities.WaitTypes;



public class ExplicitWaitWithUtilityDemo {

    private WebDriver driver;
    private String baseUrl;
    private WaitTypes wt;


    @Before
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
        baseUrl = "https://learn.letskodeit.com/p/practice";
        wt = new WaitTypes(driver);
        driver.manage().window().maximize();

        driver.get(baseUrl);

    }

    @Test
    public void testMethod() throws Exception {
       WebElement loginLink =  driver.findElement(By.linkText("Login"));
       loginLink.click();

        WebElement emailField = wt.waitForElement(By.id("user_email"), 5);
        emailField.sendKeys("test");

        wt.clickWhenReady(By.name("commit"), 3);
    }

    @After
    public void tearDown() throws Exception {
        Thread.sleep(2000);
       // driver.quit();
    }
}
