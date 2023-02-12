package selenium;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ChildBrowserPopup {
	public WebDriver driver;
	@BeforeMethod
	public void setup() {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\cheta\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
}
	@Test
	public void childBrowser() throws InterruptedException {
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		Thread.sleep(5000);
		 String parentwindowhandle= driver.getWindowHandle();
		 System.out.println("The parent handle is:"+parentwindowhandle );
		 WebElement element= driver.findElement(By.cssSelector("input[type='text']"));
		  element.sendKeys("tusharbadgujar0000@gmail.com");
		  Thread.sleep(5000);
		  driver.findElement(By.xpath("//a[contains(text(),'Forgotten password?')]")).click();
		  Set<String>handles =driver.getWindowHandles();
		  for(String handle:handles) {
			  System.out.println(handle);
	 if(!handle.equals(parentwindowhandle)) {
			  driver.switchTo().window(handle);
			  driver.findElement(By.xpath("//input[@id='identify_email']")).sendKeys("tusharbadgujar0000@gmail.com");
			  driver.findElement(By.xpath("//button[@id='did_tushar']")).click();
			  driver.close();
		  }
}}}
