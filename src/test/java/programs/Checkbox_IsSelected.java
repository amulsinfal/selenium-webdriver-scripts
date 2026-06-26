package programs;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Checkbox_IsSelected {

	public static void main(String[] args) {
		System.out.println("Program to check if element is selected or not.");

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		try {
			String url = "https://www.selenium.dev/selenium/web/web-form.html";
			driver.get(url);
			
			// To check whether Checked checkbox is selected.
			WebElement checkedCheckbox = driver.findElement(By.id("my-check-1"));
			boolean result = checkedCheckbox.isSelected();	// isSelected()  method will return true if checkbox is checked or else false.
			
			System.out.println("Is Checked checkbox is Selected: " + result);
			
			if (result) {
				System.out.println("Checked checkbox is Selected as expected - Test Passed.");
			} else {
				System.out.println("Checked checkbox is not selected - Test Failed.");
			}
			
			// To check whether Default checkbox is not selected.
			WebElement defaultCheckbox = driver.findElement(By.id("my-check-2"));
			result = defaultCheckbox.isSelected();	// isSelected()  method will return true if checkbox is checked or else false.
			
			System.out.println("Is the Default checkbox selected: " + result);
			
			if (!result) {
				System.out.println("Default checkbox is not selected/Checked as expected - Test Passed.");
			} else {
				System.out.println("Default checkbox is selected - Test Failed.");
			}
		} catch (Exception e) {
			throw new RuntimeException("Test execution failed due to: " + e.getMessage());
		} finally {
			driver.quit();
		}
	}
}
