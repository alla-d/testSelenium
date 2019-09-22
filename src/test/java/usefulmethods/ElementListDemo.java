package usefulmethods;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class ElementListDemo {

    private WebDriver driver;
    private String baseUrl;
    private GenericMethodsOld gm;


    @Before
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
        baseUrl = "https://learn.letskodeit.com/p/practice";
        gm = new GenericMethodsOld(driver);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(baseUrl);

    }

    @Test
    public void testMethod() throws Exception {
        List <WebElement> elementList = gm.getElementList("//input[@type='text']", "xpath");
        int size =elementList.size();
        System.out.println("Size of element list is: " + size);
    }

    @After
    public void tearDown() throws Exception {
        Thread.sleep(2000);
        driver.quit();
    }
}

