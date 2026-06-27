package programs;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MouseActions_MoveToElement {
	public static void main(String[] args) {
		System.out.println("Program to move to element and click a button.");

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		try {
			String url = "https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_onclick";
			driver.get(url);
			driver.switchTo().frame("iframeResult");

			WebElement button = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Click me']")));
			Actions action = new Actions(driver);
			action.moveToElement(button).click().perform(); // mouse cursor moves to button and then click it.

			WebElement label = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("demo")));
			String actualText = label.getText().trim();
			String expectedText = "Hello World";

			if (actualText.equals(expectedText)) {
				System.out.println("Text displayed as expected - Test Passed.");
			} else {
				System.out.println("Text displayed not as expected - Test Failed.");
			}
			driver.switchTo().defaultContent();
		} catch (Exception e) {
			throw new RuntimeException("Test execution failed due to: " + e.getMessage());
		} finally {
			driver.quit();
		}
	}
}
