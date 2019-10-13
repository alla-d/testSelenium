package interviewquestions;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import usefulmethods.GenericMethods;

import java.util.concurrent.TimeUnit;

public class ElementNotClicableDemo {
    private WebDriver driver;
    private String baseUrl;
    private GenericMethods gm;
    private JavascriptExecutor js;


    @Before
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
        baseUrl = "https://freecrm.com/index.html";
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(baseUrl);
        gm = new GenericMethods(driver);
        JavascriptExecutor js = (JavascriptExecutor) driver;

    }

    @Test
    public void ElementNotClicableDemo() throws Exception {
      driver.findElement(By.name("username")).sendKeys("tsting");
     // WebElement loginButton = driver.findElement(By.xpath("//input[@value='Login']"));
      //loginButton.click();

        // Best way
//        WebDriverWait wait = new WebDriverWait(driver, 3);
//        boolean invisible = wait.until(ExpectedConditions.invisibilityOfElementLocated(
//                By.id("preloader")));
//        if (invisible){
//        WebElement loginButton = wait.until(ExpectedConditions.visibilityOfElementLocated(
//                By.xpath("//input[@value='Login']")));
//        loginButton.click();
//        }

        // Another way
        WebElement loginButton =driver.findElement(By.xpath("//input[@value='Login']"));
        js.executeScript("arguments[0].click", loginButton);


    }

    @After
    public void tearDown() throws Exception {
        Thread.sleep(2000);
        driver.quit();
    }
}
