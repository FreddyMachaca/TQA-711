import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class LoginInvalidTest {
    WebDriver driver;

    @BeforeClass
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/login");
    }

    @Test
    public void testInvalidLogin() {
        driver.findElement(By.id("username")).sendKeys("wronguser");
        driver.findElement(By.id("password")).sendKeys("wrongpassword");
        driver.findElement(By.cssSelector(".radius")).click();
        String errorMessage = driver.findElement(By.id("flash")).getText();
        Assert.assertTrue(errorMessage.contains("Your username is invalid!"));
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
