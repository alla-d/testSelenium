package basicweb;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.WaitTypes;

import javax.swing.text.Highlighter;
import java.util.List;

public class CalendarSelection {

    private WebDriver driver;
    private String baseUrl;
    private WaitTypes wt;



    @Before
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
        baseUrl = "https://www.expedia.com";
        wt = new WaitTypes(driver);
        driver.manage().window().maximize();
        driver.get(baseUrl);
    }

    @Test
    @Ignore
    public void test1() throws Exception {
        WebElement departingField = driver.findElement(By.id("package-departing-hp-package"));
        departingField.click();
        driver.findElement(By.xpath("//div[@class='datepicker-dropdown']")).click();
        WebElement dateToSelect = driver.findElement(By.xpath("//div[@class='datepicker-cal-month'][position()=1]//button[text()='30']"));
        dateToSelect.click();


    }

    @Test
    public void test2() throws Exception {
        WebElement departingField = driver.findElement(By.id("package-departing-hp-package"));

        departingField.click();

        WebElement calMonth = driver.findElement(By.xpath(
                "//div[@class='datepicker-cal-month'][position()=1]//button"));
        // List<WebElement> allValidDates = calMonth.findElements(By.xpath("//div[@class='datepicker-cal-month'][position()=1]//table/tbody[1]//td//button"));
        List<WebElement> allValidDates = calMonth.findElements(By.xpath("//div[@class='datepicker-cal-month'][position()=1]//button[@class='datepicker-cal-date']"));
        //  Thread.sleep(3000);
        for (WebElement date : allValidDates) {

            if (date.getText().equals("30")) {

                date.click();
                break;
            }


        }
    }

    @After
    public void tearDown() throws Exception {
        Thread.sleep(2000);
        //driver.quit();
    }
}
