package programs;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebElement_GetText {

	public static void main(String[] args) {
		System.out.println("Program to get text from webelement");

		WebDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		try {
			String url = "https://the-internet.herokuapp.com/login";
			driver.get(url);
			driver.findElement(By.id("username")).sendKeys("tomsmith");
			driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
			driver.findElement(By.xpath("//button/i[text()=' Login']")).click();
			WebElement result = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h4")));
			
			String actualText = result.getText();		// .getText() will extract the text.
			String expectedText = "Welcome to the Secure Area. When you are done click logout below.";

			System.out.println("Message displayed: " + result.getText());
			
			if (actualText.equals(expectedText)) {
				System.out.println("Result text displayed as expected - Test Passed.");
			} else {
				System.out.println("Result text displayed is not as expected - Test Failed.");
			}
		} catch (Exception e) {
			throw new RuntimeException("Test execution failed due to: " + e.getMessage());
		} finally {
			driver.quit();
		}
	}
}
