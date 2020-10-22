package demo;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class PopUpWindow {

	WebDriver wd;
	String url = "http://popuptest.com/goodpopups.html";

	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "D:\\Certification Data\\Selenium\\Driver\\chromedriver.exe");
		wd = new ChromeDriver();
		wd.get(url);
		wd.manage().window().maximize();
	}

	@Test
	public void test() {

		
		
	}

	@After
	public void tearDown() throws Exception {
		wd.quit();
	}
}
