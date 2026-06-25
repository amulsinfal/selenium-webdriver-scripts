package programs;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebElement_Click {

	public static void main(String[] args) {
		System.out.println("Program to click an webelement");

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		try {
			String url = "https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_onclick";
			driver.get(url);

			driver.switchTo().frame("iframeResult");
			WebElement clickMeButton = driver.findElement(By.xpath("//button[text()='Click me']"));
			clickMeButton.click();

			WebElement result = driver.findElement(By.id("demo"));

			String actualText = result.getText();
			String expectedText = "Hello World";

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
