package com.seleniumwebdriver.thomeekocar.subpages;

import java.awt.Desktop.Action;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class Slider {

	
	public static void main(String[] args) {
		
		WebDriver driver = new FirefoxDriver();
		String baseUrl = "http://localhost:8084/Thomeeko_Car_Diagnostic_Web/";
		driver.get(baseUrl);
		
		//Identify WebElement
		WebElement slider = driver.findElement(By.xpath("/html/body/div/div/div"));
		
		//Using Action Class
		try{
                    Actions move = new Actions(driver);
                    org.openqa.selenium.interactions.Action action = move.dragAndDropBy(slider, 30, 0).build();
                    action.perform();
                    System.out.println("Slider is Working");
                    
		}catch(Throwable throwable){
                    System.err.println("Error:Slider"+throwable);
		}
		
		
	
		
	}	

}
