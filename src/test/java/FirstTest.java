import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import  org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class FirstTest {
    public static void main(String[] args) {

        System.getProperty("webdriver.gecko.driver", "C:\\Windows\\System32\\geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.google.com");

        WebElement element = driver.findElement(By.name("q"));
        element.sendKeys("mirrorcool.art");
        element.sendKeys(Keys.ENTER);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//div[contains (text(), 'MirrorCool: Home')]")).click();


        driver.close();
    }



}
