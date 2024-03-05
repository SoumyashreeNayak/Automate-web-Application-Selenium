import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumAutomation {
	public static void main(String[] args) throws IOException, InterruptedException {
		seleniumAuto();
	}

	public static void seleniumAuto() throws IOException, InterruptedException {
		int countOfScreenshots = 1;
		System.setProperty("webdriver.chrome.driver", "A:\\SELENIUM\\chromedriver.exe");
		WebDriver webDriver = new ChromeDriver();
		webDriver.manage().window().maximize();

		webDriver.get("http://localhost:8080/Web-Application-Automation");
		webDriver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
		//=========User Login===============//
		WebElement webEle1 = webDriver.findElement(By.linkText("Login"));
		if (webEle1 != null) {
			takeScreenshot(webDriver, countOfScreenshots);
			countOfScreenshots++;
		}
		webEle1.click();

		WebElement webEle2 = webDriver.findElement(By.id("user-email"));
		WebElement webEle3 = webDriver.findElement(By.id("user-pwd"));
		WebElement webEle4 = webDriver.findElement(By.id("submit-btn"));
		// SENDING INCORRECT CREDENTIALS
		webEle2.sendKeys("a1@test.com");
		webEle3.sendKeys("aabbcc");
		takeScreenshot(webDriver, countOfScreenshots);
		countOfScreenshots++;
		webEle4.click();

		takeScreenshot(webDriver, countOfScreenshots);
		countOfScreenshots++;
		Thread.sleep(1000);
		// SENDING CORRECT CREDENTIALS
		webEle2 = webDriver.findElement(By.id("user-email"));
		webEle3 = webDriver.findElement(By.id("user-pwd"));
		webEle4 = webDriver.findElement(By.id("submit-btn"));
		webEle2.sendKeys("a1@test.com");
		webEle3.sendKeys("123456");
		takeScreenshot(webDriver, countOfScreenshots);
		countOfScreenshots++;
		webEle4.click();
		Thread.sleep(2000);
		takeScreenshot(webDriver, countOfScreenshots);
		countOfScreenshots++;
		
		WebElement webEle5 = webDriver.findElement(By.linkText("Logout"));
		webEle5.click();
		
		takeScreenshot(webDriver, countOfScreenshots);
		countOfScreenshots++;
		//=========New User Registration===============//
		WebElement webEle6 = webDriver.findElement(By.linkText("Register"));
		if (webEle6 != null) {
			takeScreenshot(webDriver, countOfScreenshots);
			countOfScreenshots++;
		}
		webEle6.click();
	
		WebElement webEle7 = webDriver.findElement(By.id("user-first-name"));
		WebElement webEle8 = webDriver.findElement(By.id("user-last-name"));
		WebElement webEle9 = webDriver.findElement(By.id("user-email"));
		WebElement webEle10 = webDriver.findElement(By.id("user-pwd"));
		WebElement webEle11 = webDriver.findElement(By.id("submit-btn"));
		Thread.sleep(1000);
		
		// USING EXISTING EMAIL ID
		webEle7.sendKeys("TR");
		webEle8.sendKeys("Akshay");
		webEle9.sendKeys("a1@test.com");
		webEle10.sendKeys("00112233");
		takeScreenshot(webDriver, countOfScreenshots);
		countOfScreenshots++;
		webEle11.click();
		takeScreenshot(webDriver, countOfScreenshots);
		countOfScreenshots++;
		
		// USING UNUSED EMAIL ID
		webEle7 = webDriver.findElement(By.id("user-first-name"));
		webEle8 = webDriver.findElement(By.id("user-last-name"));
		webEle9 = webDriver.findElement(By.id("user-email"));
		webEle10 = webDriver.findElement(By.id("user-pwd"));
		webEle11 = webDriver.findElement(By.id("submit-btn"));
		webEle7.sendKeys("TR");
		webEle8.sendKeys("Akshay");
		webEle9.sendKeys("a2@test.com");
		webEle10.sendKeys("1234512345");
		takeScreenshot(webDriver, countOfScreenshots);
		countOfScreenshots++;
		webEle11.click();
		takeScreenshot(webDriver, countOfScreenshots);
		countOfScreenshots++;
		Thread.sleep(1000);
		//LOGGING IN USING NEWLY REGISTERED ID.
		webEle1 = webDriver.findElement(By.linkText("Login"));
		webEle1.click();
		webEle2 = webDriver.findElement(By.id("user-email"));
		webEle3 = webDriver.findElement(By.id("user-pwd"));
		webEle4 = webDriver.findElement(By.id("submit-btn"));
		webEle2.sendKeys("a2@test.com");
		webEle3.sendKeys("1234512345");
		takeScreenshot(webDriver, countOfScreenshots);
		countOfScreenshots++;
		webEle4.click();

		takeScreenshot(webDriver, countOfScreenshots);
		countOfScreenshots++;
		webEle5 = webDriver.findElement(By.linkText("Logout"));

		webEle5.click();
		webDriver.close();
	}

	public static void takeScreenshot(WebDriver wd, int count) throws IOException {
		File file = ((TakesScreenshot) wd).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file, new File(
				"C:\\Users\\workspace-spring-tool-suite-4-4.18.0.RELEASE\\Web-Application-Automation\\src\\main\\java\\images\\automate_"
						+ count + ".png"));
	}
}
