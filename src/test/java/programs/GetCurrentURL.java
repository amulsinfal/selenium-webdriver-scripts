package programs;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetCurrentURL {
	public static void main(String[] args) {
		System.out.println("Program to get the current URL.");
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		try {
			String url = "https://www.google.com";
			driver.get(url);
			String actualURL = driver.getCurrentUrl();
			String expectedURL = "https://www.google.com/";
			if(actualURL.equals(expectedURL)) {
				System.out.println("Current Url is as expected - Test Passed.");
			} else {
				System.out.println("Current Url is not as expected - Test Failed.");
			}
		} catch (Exception e) {
			throw new RuntimeException("Test execution failed due to: " + e.getMessage());
		} finally {
			driver.quit();
		}
	}
}
