package com.seleniumwebdriver.thomeekocar.subpages;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
public class AddLoginAllLinks {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String baseURL = "http://localhost:8084/Thomeeko_Car_Diagnostic_Web/";
		WebDriver subDriver = new FirefoxDriver();
		String underConsTitle = "Under Construction : mercury tours";
		subDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		subDriver.get(baseURL);
		try{
                    WebElement login = subDriver.findElement(By.xpath("/html/body/nav/div/div[2]/ul/li[5]/a"));
                    login.click();
			
                    WebElement username = subDriver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div/form/input[1]"));
                    username.sendKeys("Chathura");
			
                    WebElement password = subDriver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div/form/input[2]"));
                    password.sendKeys("12345");
			
                    WebElement loginButton = subDriver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div/form/input[3]"));
                    loginButton.click();
		}catch(Throwable throwable){
                    System.err.print("Login not found" + throwable);
		}

		List<WebElement> linkElements = subDriver.findElements(By.tagName("a")); 
		String[] linkTexts = new String[linkElements.size()];
		int i=0;
		
		//extract the links text of each link texts
		for(WebElement e : linkElements){
			linkTexts[i] = e.getText();
			i++;
		}
		
		//test the each links
		for(String t: linkTexts){
                    subDriver.findElement(By.linkText(t)).click();
                    if(subDriver.getTitle().equals(underConsTitle)){
                        System.out.println("\"" + t + "\"" + " is under construction.");
                    }else{
                        System.out.println("\"" + t + "\"" + " is working");					
                    }
                    subDriver.navigate().back();
		}
		
		
	}

}
