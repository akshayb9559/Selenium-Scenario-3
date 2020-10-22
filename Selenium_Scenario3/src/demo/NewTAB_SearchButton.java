package demo;


import java.util.Set;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class NewTAB_SearchButton {

	WebDriver wd;
	String url = "http://openclinic.sourceforge.net/openclinic/home/index.php";

	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "D:\\Certification Data\\Selenium\\Driver\\chromedriver.exe");
		wd = new ChromeDriver();
		wd.get(url);
		wd.manage().window().maximize();
	}

	@Test
	public void test() {

		// Opening Medical Records in New Tab
		String newTAB = Keys.chord(Keys.CONTROL, Keys.RETURN);
		wd.findElement(By.linkText("Medical Records")).sendKeys(newTAB);

		Set<String> windowHandle = wd.getWindowHandles();

		for (String nTab : windowHandle) {
			wd.switchTo().window(nTab);
		}

		wd.findElement(By.linkText("Search Patient")).click();
		
		WebElement element = wd.findElement(By.id("search_type"));
		Select select = new Select(element);
		select.selectByVisibleText("First Name");
		
	}

	@After
	public void tearDown() throws Exception {
		wd.quit();
	}
}
