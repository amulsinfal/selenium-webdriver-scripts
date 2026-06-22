package programs;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetTitle {
	public static void main(String[] args) {
		System.out.println("Program to get the page title.");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		try {
			String url = "https://www.google.com";
			driver.get(url);
			String actualTitle = driver.getTitle();
			String expectedTitle = "Google";
			if(actualTitle.equals(expectedTitle)) {
				System.out.println("Page title is as expected - Test Passed.");
			} else {
				System.out.println("Page title is not as expected - Test Failed.");
			}
		} catch (Exception e) {
			throw new RuntimeException("Test execution failed due to: " + e.getMessage());
		} finally {
			driver.quit();
		}
	}
}
