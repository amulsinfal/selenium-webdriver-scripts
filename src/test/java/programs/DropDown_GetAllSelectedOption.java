package programs;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropDown_GetAllSelectedOption {
	public static void main(String[] args) {
		System.out.println("Program to get all selected options from dropdown");
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		try {
			String url = "https://www.w3schools.com/tags/tryit.asp?filename=tryhtml_select_multiple";
			driver.get(url);
			driver.switchTo().frame("iframeResult");
			
			WebElement carsDropDown = driver.findElement(By.id("cars"));
			Select selectCars = new Select(carsDropDown);
			selectCars.selectByIndex(1);
			selectCars.selectByIndex(2);
			selectCars.selectByIndex(3);

			List<WebElement> allSelectedOptions = selectCars.getAllSelectedOptions();
			List<String> actualSelectedOptions = new ArrayList<>();
			
			for(WebElement selectedOption : allSelectedOptions) {
				actualSelectedOptions.add(selectedOption.getText());
			}
			
			List<String> expectedSelectedOptions = List.of("Saab", "Opel", "Audi");
			System.out.println("All Selected Option from dropdown: " + actualSelectedOptions);
			
			if (actualSelectedOptions.equals(expectedSelectedOptions)) {
				System.out.println("Expected List: " + expectedSelectedOptions);
				System.out.println("Actual List: " + actualSelectedOptions);
				System.out.println("All selected options match - Test Passed.");
			} else {
				System.out.println("All selected Options do not match - Test Failed.");
				System.out.println("Expected List: " + expectedSelectedOptions);
				System.out.println("Actual List: " + actualSelectedOptions);
			}
			
			driver.switchTo().defaultContent();
		} catch (Exception e) {
			throw new RuntimeException("Test execution failed due to: " + e.getMessage());
		} finally {
			driver.quit();
		}
	}

}
