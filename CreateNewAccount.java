package com.seleniumwebdriver.thomeekocar.subpages;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;


public class CreateNewAccount {
    public static void main(String[] args) {
        
        WebDriver driver = new FirefoxDriver();
		
	//Maximize the window
	driver.manage().window().maximize();
		
	//Waiting for loading the page
	driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		
	//Navigate to the website
	String baseUrl = "http://localhost:8084/Thomeeko_Car_Diagnostic_Web/";
	driver.get(baseUrl);
		
	//Check whether new account exists or not
	try{
            WebElement newUsername = driver.findElement(By.xpath("/html/body/div[1]/div/a[2]/div"));
            newUsername.click();
					 
            WebElement newAccountText = driver.findElement(By.xpath("/html/body/div[2]/form/div/div/label[1]"));
            String text = newAccountText.getText();
            if(text.equals("User Name")){
                System.out.println("New Account is Exists");
            }else{
                System.err.println("Not found new account");
            }
        }catch(Throwable throwable){
            System.err.println(throwable);
        }
        
        //Add New Account for checking new account is working or not
        try{
            WebElement username = driver.findElement(By.xpath("/html/body/div[2]/form/div/div/input[1]"));
            WebElement password = driver.findElement(By.xpath("/html/body/div[2]/form/div/div/input[2]"));
            WebElement confirmPassword = driver.findElement(By.xpath("/html/body/div[2]/form/div/div/input[3]"));
            WebElement doneButton = driver.findElement(By.xpath("/html/body/div[2]/form/div/div/input[4]"));
            WebElement loginText = driver.findElement(By.xpath("/html/body/div[1]/div/a[1]/div"));
					 
            username.sendKeys("Vinod");
            password.sendKeys("12345");
            confirmPassword.sendKeys("12345");
            doneButton.click();
            String text = loginText.getText();
            if(text.equals("User Name")){
                System.out.println("New Account is Exists");
            }else{
                System.err.println("Not found new account");
            }
            loginText.click();
        }catch(Throwable throwable){
            System.err.println(throwable);
        } 
	//Relogging by new username n password
        try{
            WebElement username = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div/form/input[1]"));
            WebElement password = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div/form/input[2]"));
            WebElement loginButton = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div/form/input[3]"));
            WebElement loginText = driver.findElement(By.xpath("/html/body/div[1]/div/a[1]/div"));
            
            username.sendKeys("Vinod");
            password.sendKeys("12345");
            loginButton.click();
            
            String text = loginText.getText();
            if(text.equals("LOG OUT")){
                System.out.println("Login Was successfully");
            }else{
                System.err.println("Login Error");
            }
        }catch(Throwable throwable){
            System.err.println(throwable);
        }
    }
}
