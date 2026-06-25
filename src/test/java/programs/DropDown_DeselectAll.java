package programs;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropDown_DeselectAll {

	public static void main(String[] args) {
		System.out.println("Program to de-select options");

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		try {
			String url = "https://www.w3schools.com/tags/tryit.asp?filename=tryhtml_select_multiple";
			driver.get(url);
			driver.switchTo().frame("iframeResult");

			WebElement carsDropDown = driver.findElement(By.id("cars"));
			Select selectCars = new Select(carsDropDown);

			System.out.println("Selecting options in dropdown...");
			selectCars.selectByIndex(1);
			selectCars.selectByIndex(2);
			selectCars.selectByIndex(3);
			List<WebElement> allSelectedOptions = selectCars.getAllSelectedOptions();
			List<String> actualSelectedOptions = new ArrayList<>();
			for (WebElement selectedOption : allSelectedOptions) {
				actualSelectedOptions.add(selectedOption.getText());
			}
			System.out.println("Number of options selected: " + actualSelectedOptions.size());
			System.out.println("Selected Options: " + actualSelectedOptions);

			System.out.println("De-selecting options from dropdown...");
			selectCars.deselectAll();		// deslectAll() will de-select all the selected value from the dropdown list.
			allSelectedOptions = selectCars.getAllSelectedOptions();

			System.out.println("Number of options selected: " + allSelectedOptions.size());
			System.out.println("Selected Options: " + allSelectedOptions);

			if (allSelectedOptions.isEmpty()) {
				System.out.println("All options deselected from dropdown - Test Passed");
			} else {
				System.out.println("Some options are still selected - Test Failed.");
			}
			
			driver.switchTo().defaultContent();
		} catch (Exception e) {
			throw new RuntimeException("Test execution failed due to: " + e.getMessage());
		} finally {
			driver.quit();
		}

	}
}
