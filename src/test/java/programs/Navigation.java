package programs;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Navigation {
	public static void main(String[] args) {
		System.out.println("Program to demonstrate navigation using selenium webdriver");

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		try {
			String url = "https://www.google.com";
			driver.get(url);
			System.out.println("Launching...");
			System.out.println("Url launched: " + driver.getCurrentUrl());

			// Navigate to gmail
			System.out.println("Navigating to...");
			driver.navigate().to("https://www.gmail.com");
			System.out.println("Navigated to: " + driver.getCurrentUrl());

			// Navigate back to google
			driver.navigate().back();
			System.out.println("Navigating back...");
			System.out.println("Navigate back to: " + driver.getCurrentUrl());

			// Navigate forward to gmail
			driver.navigate().forward();
			System.out.println("Navigating forward...");
			System.out.println("Navigated forward to: " + driver.getCurrentUrl());

			// Refreshing page
			driver.navigate().refresh();
			System.out.println("Refreshing page...");
			System.out.println("Current page URL: " + driver.getCurrentUrl());
		} catch (Exception e) {
			throw new RuntimeException("Test execution failed due to: " + e.getMessage());
		} finally {
			driver.quit();
		}
	}

}
