import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import java.util.concurrent.TimeUnit;

public class XPathTraining {
    public static void main(String[] args) throws InterruptedException {


        System.getProperty("webdriver.chrome.driver", "C:\\Windows\\System32\\chromedriver.exe");
        WebDriver driver;
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize(); //maximise window

        String baseURL = "https://www.google.com";
        driver.get(baseURL);

        driver.findElement(By.name("q")).sendKeys("letskodeit.teachable.com" + Keys.ENTER);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        driver.findElement(By.xpath("//div[@class='ellip'][1]")).click(); //take the second element
        //driver.findElement(By.linkText("Login")).click(); //find by full link text
        driver.findElement(By.partialLinkText("Pract")).click(); //find by part link text
        driver.findElement(By.className("mouse-hover")).click(); //find by class name
        driver.findElement(By.xpath("//div[@id='navbar']/div[@class='container']")); // '/' find  first immediate child
        driver.findElement(By.xpath("//div[@id='navbar']//div")); // '//' find any element
        driver.findElement(By.xpath("//div[@class='left-align']//td[text()='25']")); // find element using text
        driver.findElement(By.xpath("//div[@id='navbar']//a[contains(text(),'Practice')]")).click(); //find element using contains text
        driver.findElement(By.xpath("//div[@id='navbar']//a[contains(@class,'navbar-link') and contains(@href,'/pages/practice')]")); //find element using more than contains
        driver.findElement(By.xpath("//table[@id='product']//td[text()='Python Programming Language']//following-sibling::td")); //find element using following-sibling
        driver.findElement(By.xpath("//div[@id='navbar']//a[starts-with(@class,'navbar-link')]")); // find with key word start-with
        driver.findElement(By.xpath("//a[@href='/sign_in']"));
        driver.findElement(By.xpath("//a[@href='/sign_in']//parent::li")); //find parent
        driver.findElement(By.xpath("//a[@href='/sign_in']//parent::li//preceding-sibling::li//following-sibling::li")); // find presiding-sibling and following-sibling

        //css selectors
        driver.findElement(By.cssSelector("input[id=show-textbox")).click(); // find by id
        driver.findElement(By.cssSelector(".inputs.displayed-class")).click(); //find by class name
        driver.findElement(By.cssSelector("#hide-textbox")).click(); //find by id
        driver.findElement(By.cssSelector("fields>#product")); // find child
    }
}
