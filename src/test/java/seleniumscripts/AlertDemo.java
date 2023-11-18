package seleniumscripts;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertDemo {

	public static void main(String[] args) throws InterruptedException {
		
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
		
		driver.findElement(By.xpath("//input[@value='Sign in']")).click();
		
		Alert a = driver.switchTo().alert();
		
		String alertText = a.getText();
		
		System.out.println(alertText);
		
		Thread.sleep(3000);
		
		a.accept();
		
		
		
		

		
		

	}

}
