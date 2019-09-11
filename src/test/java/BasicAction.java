import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.util.concurrent.TimeUnit;

public class BasicAction {
    WebDriver driver;
    String baseUrl;

    @Before
    public void setUp() throws Exception{
        driver = new FirefoxDriver();
        baseUrl = "https://letskodeit.teachable.com/";
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    public void test() throws Exception {
        driver.get(baseUrl);
        driver.findElement(By.xpath("//div[@id='navbar']//a[@href='/sign_in']")).click();
        System.out.println("Click on Login");
        driver.findElement(By.id("user_email")).sendKeys("test@test.com");
        System.out.println("Sending keys to username field");
        driver.findElement(By.id("user_password")).sendKeys("test");
        System.out.println("Sending password");
        driver.findElement(By.id("user_email")).clear();
        System.out.println("Clearing the username feild");
    }

    @After
    public void tearDown() throws Exception{
        driver.quit();
    }


}
