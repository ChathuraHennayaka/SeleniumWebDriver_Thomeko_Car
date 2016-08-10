package com.seleniumwebdriver.thomeekocar.subpages;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ManageJobCard {
    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();
		
	//Maximize the window
	driver.manage().window().maximize();
		
	//Waiting for loading the page
	driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		
	//Navigate to the website
	String baseUrl = "http://localhost:8084/Thomeeko_Car_Diagnostic_Web/";
	driver.get(baseUrl);
        
        //Login page accessing
        System.out.println("Login page accessing");
        try{
            WebElement login = driver.findElement(By.xpath("/html/body/nav/div/div[2]/ul/li[5]/a"));
            login.click();
            WebElement username = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div/form/input[1]"));
            WebElement password = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div/form/input[2]"));
            WebElement loginButton = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div/form/input[3]"));
            
            username.sendKeys("Chathura");            
            password.sendKeys("12345");            
            loginButton.click();
            
            //Open the Manage Customer form
            System.out.println("Open the Manage Customer form");
            WebElement manageJobCard = driver.findElement(By.xpath("/html/body/div[3]/div[1]/div[2]/a/img"));
            manageJobCard.click();
        }catch(Throwable throwable){
            System.out.println(throwable);
        }
        
        //Checking form is working correctly
        System.out.println("Checking form is working correctly");
        try{
            
            //Checking search query
            System.out.println("Checking search query");
            WebElement searchJobCard = driver.findElement(By.xpath("/html/body/div/div/div[3]/form/input"));
            searchJobCard.sendKeys("1");
            WebElement search = driver.findElement(By.xpath("/html/body/div/div/div[3]/form/button"));
            search.click();
            WebElement body = driver.findElement(By.tagName("body"));
            System.out.print(body.getText()+" "); 
            System.out.println();
            
            //search number page
            WebElement cancel = driver.findElement(By.xpath("/html/body/div/div[3]/div[1]/fieldset/form/a/button"));
            cancel.click();
            
            //back to manage job card page
            WebElement manageJobCard = driver.findElement(By.xpath("/html/body/div[3]/div[1]/div[2]/a/img"));
            manageJobCard.click();
            //input values
            WebElement vehicleNumber = driver.findElement(By.xpath("/html/body/div/div/div[2]/fieldset/form/input[2]"));
            vehicleNumber.sendKeys("3534");
            WebElement date = driver.findElement(By.xpath("/html/body/div/div/div[2]/fieldset/form/input[3]"));
            date.sendKeys("4/5/2016");
            WebElement model = driver.findElement(By.xpath("/html/body/div/div/div[2]/fieldset/form/input[4]"));
            model.sendKeys("aqua");
            WebElement groupLeader = driver.findElement(By.xpath("/html/body/div/div/div[2]/fieldset/form/input[5]"));
            groupLeader.sendKeys("Nirmal");
            
            WebElement saveButton = driver.findElement(By.xpath("/html/body/div/div/div[2]/fieldset/form/button"));
            saveButton.click();
            WebElement nextButton = driver.findElement(By.xpath("/html/body/div/div/div[2]/fieldset/form/a/button"));
            nextButton.click();
            
            System.out.print(body.getText()+" "); 
            System.out.println();
                        
        }catch(Throwable throwable){
            System.out.println(throwable);
        }
        
        //Checking complaint Add form
        System.out.println("Checking complaint Add form");
        try{
            WebElement selectJobNumber = driver.findElement(By.xpath("/html/body/div/div[3]/div[1]/fieldset/form/select"));
            WebElement nature = driver.findElement(By.xpath("/html/body/div/div[3]/div[1]/fieldset/form/input[2]"));
            WebElement instruction = driver.findElement(By.xpath("/html/body/div/div[3]/div[1]/fieldset/form/input[3]"));
            
            selectJobNumber.getSize();
            nature.sendKeys("Painting");
            instruction.sendKeys("Use machines correctly");
            
            WebElement saveButton = driver.findElement(By.xpath("/html/body/div/div[3]/div[1]/fieldset/form/button"));
            saveButton.click();
            
            WebElement body = driver.findElement(By.tagName("body"));
            System.out.print(body.getText()+" "); 
            System.out.println();
            
            WebElement finishedJobButton = driver.findElement(By.xpath("/html/body/div/div[3]/div[1]/fieldset/form/a/button"));
            finishedJobButton.click();
            
            WebElement viewJobCard = driver.findElement(By.xpath("/html/body/div[3]/div[3]/div[4]/a/img"));
            viewJobCard.click();
            System.out.print(body.getText()+" "); 
            System.out.println();
        }catch(Throwable throwable){
            System.out.println(throwable);
        }
                
    }
}
