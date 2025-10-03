package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.time.Duration;

public class NakariProfileTest {

    WebDriver driver;
    WebDriverWait wait;

    @BeforeTest
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test
    public void updateResume() throws InterruptedException {
        driver.get("https://www.naukri.com/mnjuser/homepage");

        By username = By.cssSelector("input[placeholder='Enter Email ID / Username']");
        By password = By.cssSelector("input[placeholder='Enter Password']");
        By button = By.xpath("(//*[text()='Login'])[3]");
        By cross = By.cssSelector("div[class='crossIcon chatBot chatBot-ic-cross']");
        By button2 = By.xpath("(//a[@href='/mnjuser/profile'])[1]");

        WebElement Username = wait.until(ExpectedConditions.elementToBeClickable(username));
        Username.sendKeys("mahmankar333@gmail.com");

        WebElement Password = wait.until(ExpectedConditions.elementToBeClickable(password));
        Password.sendKeys("Mahesh@123");

        WebElement Button = wait.until(ExpectedConditions.elementToBeClickable(button));
        Button.click();

        try {
            WebElement Cross = wait.until(ExpectedConditions.elementToBeClickable(cross));
            Cross.click();
        } catch (org.openqa.selenium.TimeoutException e) {
            System.out.println("continue");
        }

        WebElement viewprofile = wait.until(ExpectedConditions.elementToBeClickable(button2));
        viewprofile.click();

        Thread.sleep(2000);

        driver.findElement(By.id("attachCV"))
              .sendKeys("C:\\Users\\mahma\\Downloads\\Software_Test_Engineer.pdf");

        Thread.sleep(10000);

        System.out.println("Resume updated successfully");
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
