package programs;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MouseAction_ClickAndHold {
	public static void main(String[] args) {
		System.out.println("Program to perform click and hold action.");
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		try {
			String url = "https://www.w3schools.com/TAGs/tryit.asp?filename=tryhtml5_ev_onmousedown";
			driver.get(url);
			driver.switchTo().frame("iframeResult");
			
			WebElement targetElement = wait.until(ExpectedConditions.elementToBeClickable(By.id("p1")));
			Actions action = new Actions(driver); 
			action.clickAndHold(targetElement).perform();
			
			String actualText = targetElement.getDomAttribute("style");
			String expectedText = "color: red;";
			
			System.out.println("Style set: " + actualText);
			
			if (actualText.equals(expectedText)) {
				System.out.println("Style set is as expected - Test Passed.");
			} else {
				System.out.println("Style set is not as expected - Test Failed.");
			}
			
			driver.switchTo().defaultContent();
		} catch(Exception e) {
			throw new RuntimeException("Test execution failed due to: " +e.getMessage());
		} finally {
			driver.quit();
		}
	}
}
