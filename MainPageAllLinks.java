package com.seleniumwebdriver.thomeekocar.subpages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class MainPageAllLinks {

	public static void main(String[] args) {
            String baseURL = "http://localhost:8084/Thomeeko_Car_Diagnostic_Web/";
            WebDriver subDriver = new FirefoxDriver();
		
            subDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            subDriver.get(baseURL);
		
            java.util.List<WebElement> links = subDriver.findElements(By.tagName("a")); 
            int sizeOfAllLinks = links.size();
            System.out.println(links.size());
		
            for (int i = 1; i<=links.size(); i=i+1){ 
                System.out.println(links.get(i).getText()); 
            }
            for (int index=0; index<sizeOfAllLinks; index++ ) {
                links.get(index).click();
                subDriver.navigate().back();
            }
		

	}

}
