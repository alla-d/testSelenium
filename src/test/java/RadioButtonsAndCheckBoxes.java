import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class RadioButtonsAndCheckBoxes {

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
    public void radioAndCheckbox() throws Exception {
        WebElement benzRadio = driver.findElement(By.id("benzradio"));
        benzRadio.click(); // click on radiobutton, where type= 'radio'
        WebElement hondaRadio =driver.findElement(By.id("hondaradio"));
        hondaRadio.click();


        driver.findElement(By.id("hondacheck")).click(); //click on checkbox, where type= 'checkbox'
        driver.findElement(By.id("benzcheck")).click();
        Thread.sleep(2000);

        System.out.println("Benz Radio is selected? " + benzRadio.isSelected()); // return true or false
        System.out.println("Honda Radio is selected? " + hondaRadio.isSelected());
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
    }
}
