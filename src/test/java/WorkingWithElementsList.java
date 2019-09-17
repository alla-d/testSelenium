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

public class WorkingWithElementsList {

    WebDriver driver;
    String baseUrl;

    @Before
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
        baseUrl = "https://learn.letskodeit.com/p/practice";
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(baseUrl);
    }

    @Test
    public void testListOfElements() throws Exception {
        boolean isChecked = false;
        List<WebElement> radioButtons = driver.findElements(
                By.xpath("//input[contains(@type, 'radio') and contains(@name, 'cars')]"));
        int size = radioButtons.size();
        System.out.println("Size of the list: " + size);
        for (int i = 0; i < size; i++) {
            isChecked = radioButtons.get(i).isSelected();

            if (!isChecked) {
                radioButtons.get(i).click();
                Thread.sleep(200);
            }
        }

        List<WebElement> checkBoxes = driver.findElements(
                By.xpath("//input[contains(@type, 'checkbox') and contains(@name, 'cars')]"));
        for (WebElement checkBox : checkBoxes) {
            isChecked = checkBox.isSelected();
            if (!isChecked) {
                checkBox.click();
                Thread.sleep(2000);
            }
        }
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
    }
}
