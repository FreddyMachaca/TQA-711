import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class LogoutTest {
    WebDriver driver;

    @BeforeClass
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/login");
    }

    @Test
    public void testLogout() {
        driver.findElement(By.id("username")).sendKeys("tomsmith");
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
        driver.findElement(By.cssSelector(".radius")).click();
        driver.findElement(By.cssSelector(".button.secondary.radius")).click();
        String loginMessage = driver.findElement(By.id("flash")).getText();
        Assert.assertTrue(loginMessage.contains("You logged out"));
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
