package programs;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebElement_GetAttribute {

	public static void main(String[] args) {
		System.out.println("Program to get attribute value from a web element");

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		try {
			String url = "https://www.selenium.dev/selenium/web/web-form.html";
			driver.get(url);
			WebElement disabledInputElement = driver.findElement(By.name("my-disabled"));
			String actualText = disabledInputElement.getAttribute("placeholder"); // getAttribute() will get the value of an attribute.
			String expectedText = "Welcome to the Secure Area. When you are done click logout below.";

			System.out.println("Value of the attribute 'placeholder' displayed: " + actualText);
			
			if (actualText.equals(expectedText)) {
				System.out.println("Value of the attribute 'placeholder' displayed as expected - Test Passed.");
			} else {
				System.out.println("Value of the attribute 'placeholder' displayed is not as expected - Test Failed.");
			}
		} catch (Exception e) {
			throw new RuntimeException("Test execution failed due to: " + e.getMessage());
		} finally {
			driver.quit();
		}
	}
}
