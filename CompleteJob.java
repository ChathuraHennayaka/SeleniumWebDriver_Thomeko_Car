package com.seleniumwebdriver.thomeekocar.subpages;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CompleteJob {
    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();
		
	//Maximize the window
	driver.manage().window().maximize();
		
	//Waiting for loading the page
	driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		
	//Navigate to the website
	String baseUrl = "http://localhost:8084/Thomeeko_Car_Diagnostic_Web/";
	driver.get(baseUrl);
        //Check whether login is working or not
	try{
            WebElement login = driver.findElement(By.xpath("/html/body/nav/div/div[2]/ul/li[5]/a"));
            login.click();
            WebElement username = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div/form/input[1]"));
            WebElement password = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div/form/input[2]"));
            WebElement loginButton = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div/form/input[3]"));
            
            username.sendKeys("Chathura");            
            password.sendKeys("12345");            
            loginButton.click();
            
            WebElement completeJob = driver.findElement(By.xpath("/html/body/div[3]/div[3]/div[3]/a/img"));
            completeJob.click();
            
            WebElement selectJobNumber = driver.findElement(By.xpath("/html/body/div/div[3]/div[1]/fieldset/form/select"));
            System.out.println(selectJobNumber.getSize());
            WebElement testedBy = driver.findElement(By.xpath("/html/body/div/div[3]/div[1]/fieldset/form/input[2]"));
            testedBy.sendKeys("wheel");
            WebElement jobDirector = driver.findElement(By.xpath("/html/body/div/div[3]/div[1]/fieldset/form/input[3]"));
            jobDirector.sendKeys("Amantha");
            WebElement finishDate = driver.findElement(By.xpath("/html/body/div/div[3]/div[1]/fieldset/form/input[4]"));
            finishDate.sendKeys("2/5/2014");
            
            WebElement save = driver.findElement(By.xpath("/html/body/div/div[3]/div[1]/fieldset/form/button"));
            save.click();
            WebElement body = driver.findElement(By.tagName("body"));
            System.out.print(body.getText()+" "); 
            System.out.println();
            
            WebElement cancel = driver.findElement(By.xpath("/html/body/div/div[3]/div[1]/fieldset/form/a/button"));
            cancel.click();
        }catch(Throwable throwable){
            System.out.println(throwable);
        }
        
    }
}
