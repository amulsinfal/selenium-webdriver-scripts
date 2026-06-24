package programs;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropDown_GetFirstSelectedOption {
	public static void main(String[] args) {
		System.out.println("Program to get first selected option from dropdown");
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		try {
			String url = "https://www.w3schools.com/tags/tryit.asp?filename=tryhtml_select";
			driver.get(url);
			driver.switchTo().frame("iframeResult");
			
			WebElement carsDropDown = driver.findElement(By.id("cars"));
			Select selectCars = new Select(carsDropDown);
			selectCars.selectByIndex(2);

			String actualText = selectCars.getFirstSelectedOption().getText();
			String expectedText = "Opel";

			System.out.println("First Selected Option displayed: " + actualText);
			
			if (actualText.equals(expectedText)) {
				System.out.println("First Selected Option displayed as expected - Test Passed.");
			} else {
				System.out.println("First Selected Option displayed is not as expected - Test Failed.");
			}

			driver.switchTo().defaultContent();
		} catch (Exception e) {
			throw new RuntimeException("Test execution failed due to: " + e.getMessage());
		} finally {
			driver.quit();
		}
	}

}
