import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class NakariProfile {

	public static void main(String[] args) throws InterruptedException {

		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.naukri.com/mnjuser/homepage");
		
		  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		  
		  By username = By.cssSelector("input[placeholder='Enter Email ID / Username']");
		  By password = By.cssSelector("input[placeholder='Enter Password']");
		  By button = By.xpath("(//*[text()='Login'])[3]");
		  By cross = By.cssSelector("div[class='crossIcon chatBot chatBot-ic-cross']");
		  By button2 = By.xpath("(//a[@href='/mnjuser/profile'])[1]");
		  By updateResume = By.cssSelector("input[value='Update resume']");
		  
		  WebElement Username = wait.until(ExpectedConditions.elementToBeClickable(username));
		  Username.sendKeys("mahmankar333@gmail.com");
		  
		  
		  WebElement Password =  wait.until(ExpectedConditions.elementToBeClickable(password));
		  Password.sendKeys("Mahesh@123");
		  
		  WebElement Button =  wait.until(ExpectedConditions.elementToBeClickable(button));
		  Button.click();
		  
		  try {
		  WebElement Cross = wait.until(ExpectedConditions.elementToBeClickable(cross));
		  Cross.click();
		  }catch(org.openqa.selenium.TimeoutException e)
		  {
			  System.out.println("continue");
		  }
		  
		  WebElement viewprofile = wait.until(ExpectedConditions.elementToBeClickable(button2));
		  viewprofile.click();

          Thread.sleep(2000);
		  driver.findElement(By.id("attachCV"))
		  .sendKeys("C:\\Users\\mahma\\Downloads\\MaheshMankarResume.pdf");      //.sendKeys("C:\\Users\\mahma\\Downloads\\Software_Test_Engineer.pdf");
		  
		  Thread.sleep(10000);
		  driver.quit();	  
	}
}
