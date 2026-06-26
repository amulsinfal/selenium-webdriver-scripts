package programs;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class InputBox_SendKeys {

	public static void main(String[] args) {

		System.out.println("Program to send keys to the web element");
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		try {
			String url = "https://www.w3schools.com/TAGs/tryit.asp?filename=tryhtml5_input_type_text";
			driver.get(url);
			driver.switchTo().frame("iframeResult");
			
			WebElement fnameElement = driver.findElement(By.id("fname"));
			fnameElement.sendKeys("John");
			
			WebElement lnameElement = driver.findElement(By.id("lname"));
			lnameElement.sendKeys("Doe");
			
			WebElement submitButton = driver.findElement(By.xpath("//input[@value='Submit']"));
			submitButton.click();
			
			WebElement result = driver.findElement(By.xpath("//div[@class='w3-container w3-large w3-border']"));
			
			String actualText = result.getText();
			String expectedText = "fname=John&lname=Doe ";
			
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
