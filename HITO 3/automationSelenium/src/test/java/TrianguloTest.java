import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import java.time.Duration;

public class TrianguloTest {
    WebDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://testpages.eviltester.com/styled/apps/triangle/triangle001.html");
    }

    @Test
    public void testEquilateralTriangle() {
        enterTriangleSides("5", "5", "5");
        clickIdentifyButton();
        String result = getTriangleType();
        Assert.assertTrue(result.toLowerCase().contains("equilateral"),
            "Expected triangle to be equilateral but got: " + result);
    }

    @Test
    public void testIsoscelesTriangle() {
        enterTriangleSides("5", "5", "3");
        clickIdentifyButton();
        String result = getTriangleType();
        Assert.assertTrue(result.toLowerCase().contains("isosceles"),
            "Expected triangle to be isosceles but got: " + result);
    }

    @Test
    public void testScaleneTriangle() {
        enterTriangleSides("3", "4", "5");
        clickIdentifyButton();
        String result = getTriangleType();
        Assert.assertTrue(result.toLowerCase().contains("scalene"),
            "Expected triangle to be scalene but got: " + result);
    }

    @Test
    public void testInvalidTriangle() {
        enterTriangleSides("1", "1", "3");
        clickIdentifyButton();
        String result = getTriangleType();
        Assert.assertTrue(result.toLowerCase().contains("not a triangle"),
            "Expected result to indicate not a triangle but got: " + result);
    }

    private void enterTriangleSides(String side1, String side2, String side3) {
        WebElement side1Input = wait.until(ExpectedConditions.elementToBeClickable(By.name("side1")));
        WebElement side2Input = driver.findElement(By.name("side2"));
        WebElement side3Input = driver.findElement(By.name("side3"));

        side1Input.clear();
        side1Input.sendKeys(side1);

        side2Input.clear();
        side2Input.sendKeys(side2);

        side3Input.clear();
        side3Input.sendKeys(side3);
    }

    private void clickIdentifyButton() {
        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(
            By.id("identify-triangle-action")));
        button.click();
    }

    private String getTriangleType() {
        // Esperar a que el mensaje de resultado aparezca y obtenerlo
        WebElement result = wait.until(ExpectedConditions.presenceOfElementLocated(
            By.cssSelector("#triangle-type"))); // Cambio de ID a triangle-type
        return result.getText();
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}