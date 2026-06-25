package programs;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropDown_IsMulitple {

	public static void main(String[] args) {
		System.out.println("Program to check if the dropdown supports to select multiple options");

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		try {
			String url = "https://www.w3schools.com/tags/tryit.asp?filename=tryhtml_select_multiple";
			driver.get(url);
			driver.switchTo().frame("iframeResult");

			WebElement carsDropDown = driver.findElement(By.id("cars"));
			Select selectCars = new Select(carsDropDown);
			boolean result = selectCars.isMultiple();
			
			System.out.println("Dropdown allows to select multiple options: " + result);
			if (result) {
				System.out.println("The dropdown supports multiple option selection - Test Passed.");
			} else {
				System.out.println("The dropdown does not support multiple option selection - Test Failed.");
			}

			driver.switchTo().defaultContent();
		} catch (Exception e) {
			throw new RuntimeException("Test execution failed due to: " + e.getMessage());
		} finally {
			driver.quit();
		}
	}

}
