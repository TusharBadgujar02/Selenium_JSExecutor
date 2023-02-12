package selenium;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class webTable {
	public WebDriver driver;
	@BeforeMethod
	public void setup() {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\cheta\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
	}
	@Test
	public void WebTable() {
		driver.get("C:\\Users\\cheta\\OneDrive\\Desktop\\WebTable.html");
		driver.manage().window().maximize();
		List<WebElement> rows = driver.findElements(By.xpath("//tr"));
		int totalRows = rows.size();
		System.out.println("Total rows = " + totalRows);
	}
	@Test
	public void ColumnCount () {
		driver.get("C:\\Users\\cheta\\OneDrive\\Desktop\\WebTable.html");
		driver.manage().window().maximize();
		List<WebElement> columns = driver.findElements(By.xpath("//th"));
		int totalColumns = columns.size();
		System.out.println("Total Columns = " + totalColumns);
	}
	@Test
	public void CellsCount () {
		driver.get("C:\\Users\\cheta\\OneDrive\\Desktop\\WebTable.html");
		List<WebElement> cells = driver.findElements(By.xpath("//th | //td"));
		int totalCells = cells.size();
		System.out.println("Total cells present in the table = " + totalCells);
	}
	}
