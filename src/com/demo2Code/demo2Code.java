package com.demo2Code;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import javax.swing.*;
import java.io.IOException;
import java.util.Calendar;
import java.util.List;


public class demo2Code {

    private static int count = 0;

    @Test
    public void iframeTest() throws InterruptedException, IOException {

         String expAlert[]={"Alert Message","You must correct the following Errors:\n" +
               "You must select a messaging price plan.\n" +
                "You must select an international messaging price plan.\n" +
                "You must enter a value for the Network Lookup Charge","Verifique se todos os campos obrigatórios foram preenchidos.\n" +
                "\n" +
                "Produto:required."};

        String fileName="mac.png";

        System.setProperty("webdriver.gecko.driver", "C:\\Users\\Humaira Pasha\\Downloads\\geckodriver-v0.19.1-win64\\geckodriver.exe");
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Humaira Pasha\\Downloads\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();

        driver.navigate().to("http://sahitest.com/demo/iframesTest.htm");

        Thread.sleep(2000);
        driver.findElement(By.cssSelector("input[value='Click me']")).click();
        Thread.sleep(2000);

        driver.switchTo().frame(0);

        driver.findElement(By.linkText("Alert Test")).click();
        Thread.sleep(2000);

        for (int i=0;i<3;i++) {
            driver.findElement(By.cssSelector("input[name='b"+(i+1)+"']")).click();
            Thread.sleep(3000);


            String alertText = driver.switchTo().alert().getText();
            System.out.println(alertText);
            //   driver.switchTo().alert().accept();

            driver.switchTo().alert().accept();

            if (expAlert[i].equals(alertText))
            count++; //verify each alert message

        }
        System.out.println(count);

        //Assert.assertEquals(""+count,"3");
       // Assert.assertEquals(alertText,expAlert1);
        driver.findElement(By.linkText("Back")).click();
        driver.findElement(By.linkText("File Upload Test")).click();
        driver.findElement(By.id("file")).sendKeys("C:\\Users\\Humaira Pasha\\Desktop\\"+fileName);
        driver.findElement(By.name("submit")).click();
        String result = driver.findElement(By.id("file")).getText();

        if (result.equals(fileName))
            count++; //file uploaded successfully check

        Assert.assertEquals(""+count,"4"); //count==4 i.e. alert messages verified and file uploaded successfully





    }


    }



