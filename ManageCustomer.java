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
import org.openqa.selenium.interactions.Actions;

public class ManageCustomer {
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
            
            //Open the Manage Customer form
            WebElement manageCustomer = driver.findElement(By.xpath("/html/body/div[3]/div[1]/div[1]/a"));
            manageCustomer.click();
            
            WebElement searchCustomer = driver.findElement(By.xpath("/html/body/div/div[3]/div[2]/form/input"));
            searchCustomer.sendKeys("1");
            
        }catch(Throwable throwable){
            System.out.println(throwable);
        }
        //Check whether all fields are working correctly
        
        try{
            
            //Check whether search customer is working            
            WebElement search = driver.findElement(By.xpath("/html/body/div/div[3]/div[2]/form/button"));
            search.click();
            WebElement body = driver.findElement(By.tagName("body"));
            System.out.print(body.getText()+" ");            
            System.out.println();
            WebElement searchCancel = driver.findElement(By.xpath("/html/body/div/div[3]/div[1]/fieldset/form/a/button"));
            searchCancel.click();
            WebElement manageCustomer = driver.findElement(By.xpath("/html/body/div[3]/div[1]/div[1]/a/img"));
            manageCustomer.click();
        }catch(Throwable throwable){
            System.out.println(throwable);
        }
        try{
            
            //Check whether save is working correctly
            WebElement customerName = driver.findElement(By.xpath("/html/body/div/div[3]/div[1]/fieldset/form/input[2]"));
            WebElement address = driver.findElement(By.xpath("/html/body/div/div[3]/div[1]/fieldset/form/input[3]"));
            WebElement faxNumber = driver.findElement(By.xpath("/html/body/div/div[3]/div[1]/fieldset/form/input[4]"));
            WebElement contactOne = driver.findElement(By.xpath("/html/body/div/div[3]/div[1]/fieldset/form/input[5]"));
            WebElement contactTwo = driver.findElement(By.xpath("/html/body/div/div[3]/div[1]/fieldset/form/input[6]"));            
            WebElement save = driver.findElement(By.xpath("/html/body/div/div[3]/div[1]/fieldset/form/button"));            
            
            customerName.sendKeys("Nuwan");
            address.sendKeys("Homagama");
            faxNumber.sendKeys("012334467");
            contactOne.sendKeys("0714466447");
            contactTwo.sendKeys("0123377736");
            
            save.click();
            WebElement body = driver.findElement(By.tagName("body"));
            System.out.println(body.getText()+" ");
            System.out.println();
        }catch(Throwable throwable){
            System.out.println(throwable);
        }
            //Developing random numbers
        try{
            WebElement customerName = driver.findElement(By.xpath("/html/body/div/div[3]/div[1]/fieldset/form/input[2]"));
            WebElement address = driver.findElement(By.xpath("/html/body/div/div[3]/div[1]/fieldset/form/input[3]"));
            WebElement faxNumber = driver.findElement(By.xpath("/html/body/div/div[3]/div[1]/fieldset/form/input[4]"));
            WebElement contactOne = driver.findElement(By.xpath("/html/body/div/div[3]/div[1]/fieldset/form/input[5]"));
            WebElement contactTwo = driver.findElement(By.xpath("/html/body/div/div[3]/div[1]/fieldset/form/input[6]")); 
            
            Random random = new Random();
            int num1 = (random.nextInt(7) + 1) * 100 + (random.nextInt(8) * 10) + random.nextInt(8);
            int num2 = random.nextInt(743);
            int num3 = random.nextInt(10000);
             
            DecimalFormat df3 = new DecimalFormat("000"); // 3 zeros
            DecimalFormat df4 = new DecimalFormat("0000"); // 4 zeros
             
            String phoneNumber = df3.format(num1) + "-" + df3.format(num2) + "-" + df4.format(num3);
            
            //categorize string elements and integer elements
            ArrayList<WebElement> stringElements = new ArrayList<WebElement>();
            ArrayList<WebElement> integerElements = new ArrayList<WebElement>();
            
            stringElements.add(customerName);
            stringElements.add(address);
            
            integerElements.add(faxNumber);
            integerElements.add(contactOne);
            integerElements.add(contactTwo);
            
            //Developing random Strings
            String uuid = UUID.randomUUID().toString();
            for(int index = 0;index < 5;index++){
                for(int i = 0;i < 2;i++){
                    stringElements.get(i).sendKeys(uuid);
                }
                for(int j = 0;j < 3;j++){
                    integerElements.get(j).sendKeys(phoneNumber);
                }
                WebElement save = driver.findElement(By.xpath("/html/body/div/div[3]/div[1]/fieldset/form/button"));
                save.click();
            }
            for(int i = 0;i < 5;i++){
                stringElements.get(i).sendKeys(uuid);
            }
            
            //Check whether cancel is working correctly
            customerName.sendKeys("Sameera");
            address.sendKeys("Anuradhapura");
            faxNumber.sendKeys("012384467");
            contactOne.sendKeys("0714766447");
            contactTwo.sendKeys("0123377796");
            
            WebElement cancel = driver.findElement(By.xpath("/html/body/div/div[3]/div[1]/fieldset/form/a/button"));            
            cancel.click();
            WebElement body = driver.findElement(By.tagName("body"));
            System.out.println(body.getText()+" ");
            System.out.println();
        }catch(Throwable throwable){
            System.out.println(throwable);
        }
            
            //Check  whether update is working
            WebElement update = driver.findElement(By.xpath("/html/body/div/div[3]/div[3]/div/table/tbody/tr[2]/td[8]/form/button"));
            update.click();
            WebElement updateCustomerName = driver.findElement(By.xpath("/html/body/div/div[3]/div/fieldset/form[1]/input[2]"));
            WebElement updateAddress = driver.findElement(By.xpath("/html/body/div/div[3]/div/fieldset/form[1]/input[3]"));
            WebElement updateFaxNumber = driver.findElement(By.xpath("/html/body/div/div[3]/div/fieldset/form[1]/input[4]"));
            WebElement updateContactOne = driver.findElement(By.xpath("/html/body/div/div[3]/div/fieldset/form[1]/input[5]"));
            WebElement updateContactTwo = driver.findElement(By.xpath("/html/body/div/div[3]/div/fieldset/form[1]/input[6]"));
            WebElement updateButton = driver.findElement(By.xpath("/html/body/div/div[3]/div/fieldset/form[1]/button"));
            
            updateCustomerName.clear();
            updateCustomerName.sendKeys("Denuwan");
            updateAddress.clear();
            updateAddress.sendKeys("Horana");
            updateFaxNumber.clear();
            updateFaxNumber.sendKeys("011273764545");
            updateContactOne.clear();
            updateContactOne.sendKeys("01163635353");
            updateContactTwo.clear();
            updateContactTwo.sendKeys("07535353535");
            updateButton.click();
            
            WebElement body = driver.findElement(By.tagName("body"));
            System.out.println(body.getText()+" ");
            System.out.println();
            
            //Check whether Delete is working
            WebElement delete = driver.findElement(By.xpath("/html/body/div/div[3]/div[3]/div/table/tbody/tr[2]/td[7]/form/button"));
            delete.click();
            System.out.println(body.getText()+" ");
            System.out.println();
            
            //check whether view customer is correctly recorded
            WebElement home = driver.findElement(By.xpath("/html/body/div/div[1]/div/div/a[2]/div"));
            home.click();
            WebElement viewCustomer = driver.findElement(By.xpath("/html/body/div[3]/div[1]/div[4]/a/img"));
            viewCustomer.click();
            System.out.println(body.getText());
            System.out.println();
            
                    
    }
}
