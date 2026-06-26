package programs;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebElement_IsDisplayed {

	public static void main(String[] args) {
		System.out.println("Program to check if element is displayed or not.");

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		try {
			String url = "https://www.selenium.dev/selenium/web/web-form.html";
			driver.get(url);
			
			// To check whether Text input field is enabled or not.
			WebElement textInputElement = driver.findElement(By.name("my-text"));
			boolean result = textInputElement.isDisplayed();
			
			System.out.println("Is the Text input field displayed: " + result);
			
			if (result) {
				System.out.println("Text input field is displayed as expected - Test Passed.");
			} else {
				System.out.println("Text input field is not displayed - Test Failed.");
			}
		} catch (Exception e) {
			throw new RuntimeException("Test execution failed due to: " + e.getMessage());
		} finally {
			driver.quit();
		}
	}
}
