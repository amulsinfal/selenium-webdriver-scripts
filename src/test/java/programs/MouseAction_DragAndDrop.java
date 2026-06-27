package programs;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MouseAction_DragAndDrop {
	
	public static void main(String[] args) {
		System.out.println("Program to perform drag and drop action.");
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		try {
			String url = "https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_ondrop";
			driver.get(url);
			driver.switchTo().frame("iframeResult");
			
			WebElement dragableText = wait.until(ExpectedConditions.elementToBeClickable(By.id("dragtarget")));
			WebElement targetElement = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class='droptarget']"))).get(1);
			Actions action = new Actions(driver); 
			action.dragAndDrop(dragableText, targetElement).perform();
			
			WebElement result = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("demo")));
			String actualText = result.getText();
			String expectedText = "The text was dropped";
			
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
