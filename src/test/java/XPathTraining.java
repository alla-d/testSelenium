import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import java.util.concurrent.TimeUnit;

public class XPathTraining {
    public static void main(String[] args) {


        System.getProperty("webdriver.chrome.driver", "C:\\Windows\\System32\\chromedriver.exe");
        WebDriver driver;
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        String baseURL = "https://www.google.com";
        driver.get(baseURL);

        driver.findElement(By.name("q")).sendKeys("letskodeit.teachable.com" + Keys.ENTER);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//div[@class='ellip'][1]")).click(); //take the second element
       // driver.findElement(By.linkText("Login")).click(); //searching by full link text
        driver.findElement(By.partialLinkText("Pract")).click(); //searching by part link text

    }
}
