package com.seleniumwebdriver.thomeekocar.subpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class NavigationBar {

	
	public static void main(String[] args) {
		WebDriver driver = new FirefoxDriver();
		String baseUrl = "http://localhost:8084/Thomeeko_Car_Diagnostic_Web/";
		driver.get(baseUrl);
		
		WebElement mainText = driver.findElement(By.xpath("/html/body/nav/div/div[1]/a"));
		String text = mainText.getText();
		if(text.equals("LOG OUT")){
			System.out.println("Login Was successfully");
		}else{
			System.err.println("Login Error");
		}
	}

}
