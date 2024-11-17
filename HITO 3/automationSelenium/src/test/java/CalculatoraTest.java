import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class CalculatoraTest {
    WebDriver driver;

    @BeforeClass
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://testpages.eviltester.com/styled/calculator");
    }

    @Test
    public void testAddition() {
        driver.findElement(By.id("number1")).sendKeys("5");
        driver.findElement(By.id("number2")).sendKeys("3");
        driver.findElement(By.id("calculate")).click();
        WebElement result = driver.findElement(By.id("answer"));
        Assert.assertEquals(result.getText(), "8");
    }

    // Agrega tests para multiplicación y división
    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
