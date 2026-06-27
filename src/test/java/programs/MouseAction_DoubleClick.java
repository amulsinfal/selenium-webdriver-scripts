package programs;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MouseAction_DoubleClick {
	
	public static void main(String[] args) {
		System.out.println("Program to perform double click on an element.");
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		try {
			String url = "https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_ondblclick";
			driver.get(url);
			driver.switchTo().frame("iframeResult");
			
			WebElement doubleClickButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Double-click me']")));
			Actions action = new Actions(driver); 
			action.doubleClick(doubleClickButton).perform();
			
			WebElement result = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("demo")));
			String actualText = result.getText();
			String expectedText = "Hello World";
			
			System.out.println("Text displayed: " + actualText);
			
			if (actualText.equals(expectedText)) {
				System.out.println("Result text displayed as expected - Test Passed.");
			} else {
				System.out.println("Result text displayed is not as expected - Test Failed.");
			}
			
			driver.switchTo().defaultContent();
		} catch(Exception e) {
			throw new RuntimeException("Test execution failed due to: " +e.getMessage());
		} finally {
			driver.quit();
		}
	}
}
