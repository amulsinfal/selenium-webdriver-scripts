package programs;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropDown_GetOptions {
	public static void main(String[] args) {
		System.out.println("Program to get option from dropdown web element");

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		try {
			String url = "https://www.w3schools.com/tags/tryit.asp?filename=tryhtml_select";
			driver.get(url);
			driver.switchTo().frame("iframeResult");
			WebElement carsDropDown = driver.findElement(By.id("cars"));
			Select selectCars = new Select(carsDropDown);
			
			List<WebElement> allOptions = selectCars.getOptions(); // getOptions() will get all the option in the dropdown list
			List<String> actualOptions = new ArrayList<>();
			
			for(WebElement option : allOptions) {
				actualOptions.add(option.getText());
			}
			
			List<String> expectedOptions = List.of("Volvo", "Saab", "Opel", "Audi");
			
			if(actualOptions.equals(expectedOptions)) {
				System.out.println("Expected List: " + expectedOptions);
				System.out.println("Actual List: " + actualOptions);
				System.out.println("Options match - Test Passed.");
			} else {
				System.out.println("Options do not match - Test Failed.");
				System.out.println("Expected List: " + expectedOptions);
				System.out.println("Actual List: " + actualOptions);
			}
			
			driver.switchTo().defaultContent();
		} catch (Exception e) {
			throw new RuntimeException("Test execution failed due to: " + e.getMessage());
		} finally {
			driver.quit();
		}
	}

}

