package com.temp.qnode;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DatePickerExample {

	public static void main(String[] args) {

		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("http://seleniumpractise.blogspot.com/2016/08/how-to-handle-calendar-in-selenium.html");
		
		driver.findElement(By.id("datepicker")).click();
		
		String monthyear = driver.findElement(By.cssSelector(".ui-datepicker-title")).getText();
		
		System.out.println(monthyear);
		
		String my[] = monthyear.split(" ");
		
		String month = my[0]; // November
		String year = my[1]; // 2023
		
		System.out.println(month);
		System.out.println(year);
		
		// //span[text()='Next']
		
		while(!(month.equals("May") && year.equals("2026"))) {
			
			
			driver.findElement(By.xpath("//span[text()='Next']")).click();
			
			String monthyear1= driver.findElement(By.cssSelector(".ui-datepicker-title")).getText();
			 month = monthyear1.split(" ")[0];
			 year = monthyear1.split(" ")[1];
		}
		
		driver.findElement(By.xpath("//a[text()='25']")).click();

	}

}
