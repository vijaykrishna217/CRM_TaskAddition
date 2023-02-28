package CRMAutomation;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
public class TaskAddition {
	static WebDriver driver = new ChromeDriver();
	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver\\chromedriver.exe");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://classic.crmpro.com/");
		driver.findElement(By.name("username")).sendKeys("kvs0594");
		driver.findElement(By.name("password")).sendKeys("Incorrect003@");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		driver.switchTo().frame("mainpanel");
		Thread.sleep(3000);
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//a[@title='Tasks']"))).build().perform();
		driver.findElement(By.xpath("//a[@title='New Task']")).click();
		driver.findElement(By.xpath("//*[@id=\"title\"]")).sendKeys("TO DO");
		driver.findElement(By.xpath("//img[@id='f_trigger_c_deadline']")).click();
		String monthYear = driver.findElement(By.xpath(
				"//td[@class='title']"))
				.getText(); 
		System.out.println("current MonthYear :" + monthYear);
		String month = monthYear.split(", ")[0].trim();
		String Year = monthYear.split(", ")[1].trim();
		int day = 11;
		while (!(month.equals("August"))) {
			driver.findElement(By.xpath("//div[contains(text(),'›')]")).click();
			monthYear = driver.findElement(By.xpath(
					"//td[@class='title']"))
					.getText();
			// System.out.println(monthYear);
			month = monthYear.split(", ")[0].trim();
			Year = monthYear.split(", ")[1].trim();
		}
		while (!(Year.equals("2030"))) {
			driver.findElement(By.xpath("//div[contains(text(),'»')]")).click();
			monthYear = driver.findElement(By.xpath(
					"//td[@class='title']"))
					.getText();
			month = monthYear.split(", ")[0].trim();
			Year = monthYear.split(", ")[1].trim();
		}
		System.out.println("required MonthYear :" + monthYear);
		driver.findElement(By.xpath("//td[contains(text(),'" + day + "')]")).click();
		Select select = new Select(driver.findElement(By.xpath("//select[@name='auto_extend']")));
		select.selectByIndex(1);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//tbody//tr[1]/td[1]/input[1][@type='submit']")).click();
	}
	
}
