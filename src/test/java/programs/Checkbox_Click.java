package programs;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Checkbox_Click {

	public static void main(String[] args) {

		System.out.println("Program to check a checkbox");

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		try {
			String url = "https://www.w3schools.com/howto/tryit.asp?filename=tryhow_js_display_checkbox_text";

			driver.get(url);
			driver.switchTo().frame("iframeResult");

			WebElement checkboxElement = driver.findElement(By.id("myCheck"));
			checkboxElement.click();	// click() method will select the checkbox option.

			WebElement result = driver.findElement(By.id("text"));
			
			String actualText = result.getText();
			String expectedText = "Checkbox is CHECKED!";
			
			System.out.println("Text displayed: " + actualText);
			
			if (actualText.equals(expectedText)) {
				System.out.println("Result text displayed as expected - Test Passed.");
			} else {
				System.out.println("Result text displayed is not as expected - Test Failed.");
			}

			driver.switchTo().defaultContent();
		} catch (Exception e) {
			throw new RuntimeException("Test execution failed due to: " + e.getMessage());
		} finally {
			driver.quit();
		}

	}

}
