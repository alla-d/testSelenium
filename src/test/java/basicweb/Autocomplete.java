package basicweb;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import utilities.WaitTypes;

import java.util.List;

public class Autocomplete {

    private WebDriver driver;
    private String baseUrl;
    private WaitTypes wt;


    @Before
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
        baseUrl = "https://www.southwest.com/";
        wt = new WaitTypes(driver);
        driver.manage().window().maximize();
        driver.get(baseUrl);
    }


    @Test
    public void test() throws Exception {
        String searchingText = "New York/Newark, NJ - EWR";
        String partialText = "New York";

        WebElement text = driver.findElement(By.id("LandingAirBookingSearchForm_originationAirportCode"));
        text.sendKeys(partialText);

        WebElement element = driver.findElement(By.xpath("//div[@class='flyout-portal']"));
        List<WebElement> results = element.findElements(By.tagName("button"));
        int size = results.size();

        System.out.println("The size of the list is: " + size);

        for (int i = 0; i < size; i++) {
            System.out.println(results.get(i).getText());
        }

   //     Thread.sleep(3000);
        for (WebElement result : results) {
            if (result.getText().equals(searchingText)) {
                result.click();
              //  System.out.println("Selected: " + result.getText());
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
