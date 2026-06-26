package programs;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebElement_IsEnabled {

	public static void main(String[] args) {
		System.out.println("Program to check if element is Enabled or Disabled.");

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		try {
			String url = "https://www.selenium.dev/selenium/web/web-form.html";
			driver.get(url);
			
			// To check whether Text input field is enabled or not.
			
			WebElement textInputElement = driver.findElement(By.name("my-text"));
			boolean result = textInputElement.isEnabled();
			
			System.out.println("Is the Text input field Enabled: " + result);
			
			if (result) {
				System.out.println("Text input field is enabled as expected - Test Passed.");
			} else {
				System.out.println("Text input field is disabled but should be enabled - Test Failed.");
			}
			
			// To check whether Disabled input field is disabled or not.
			
			WebElement disabledInputElement = driver.findElement(By.name("my-disabled"));
			result = disabledInputElement.isEnabled();
			
			System.out.println("Is the Disabled input field Enabled: " + result);
			
			if (!result) {
				System.out.println("Disabled input field is disabled as expected - Test Passed.");
			} else {
				System.out.println("Disabled input field is enabled but should be disabled - Test Failed.");
			}
		} catch (Exception e) {
			throw new RuntimeException("Test execution failed due to: " + e.getMessage());
		} finally {
			driver.quit();
		}
	}
}
