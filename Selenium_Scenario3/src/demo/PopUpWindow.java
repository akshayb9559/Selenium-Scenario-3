package demo;

import java.util.Iterator;
import java.util.Set;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PopUpWindow {

	WebDriver wd;
	String url = "http://popuptest.com/goodpopups.html";

	@Before
	public void setUp() throws Exception {

		System.setProperty("webdriver.chrome.driver", "D:\\Certification Data\\Selenium\\Driver\\chromedriver.exe");
		wd = new ChromeDriver();
		wd.manage().window().maximize();
		wd.get(url);
		Thread.sleep(3000);
	}

	@Test
	public void test() {

		wd.findElement(By.linkText("Good PopUp #1")).click();

		Set<String> handle = wd.getWindowHandles();

		Iterator<String> str = handle.iterator();

		String parentWindow = str.next();
		String childWindow = str.next();

		wd.switchTo().window(childWindow);

		System.out.println("Child Window Title is : " + wd.getTitle());
		wd.close();

		wd.switchTo().window(parentWindow);
		System.out.println("Parent Window Title is : " + wd.getTitle());

	}

	@After
	public void tearDown() throws Exception {

		wd.quit();
	}

}
