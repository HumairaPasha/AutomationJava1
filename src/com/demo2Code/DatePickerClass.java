package com.demo2Code;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Calendar;
import java.util.List;

public class DatePickerClass {

    @Test
    public void DatePicker()
    {
        //---------------Driver Initialization-----------------------------//
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\Humaira Pasha\\Downloads\\geckodriver-v0.19.1-win64\\geckodriver.exe");
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Humaira Pasha\\Downloads\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();

        driver.navigate().to("https://jqueryui.com/datepicker/");
        driver.switchTo().frame(0);


        driver.findElement(By.id("datepicker")).click();

        //-------------Get Current Date---------------------------------//
        Calendar now = Calendar.getInstance();
        String day1=""+now.get(Calendar.DATE);
        String month1=""+now.get(Calendar.MONTH)+1;

        int daysToAdd=30;
        int newDay; //day that has to be selected
        int addedDate = Integer.parseInt(day1) + daysToAdd;
        int nextCount = addedDate/30; //no of time next arrow needs to be clicked

        if ((Integer.parseInt(month1)%2)==0) //even months == 30 days
            newDay = addedDate % 30;

        else
            newDay = addedDate%31;



        //-------move to next month---//
        for (int x=0;x<nextCount;x++)
            driver.findElement(By.cssSelector("#ui-datepicker-div > div > a.ui-datepicker-next.ui-corner-all > span")).click();

        WebElement table = driver.findElement(By.cssSelector("#ui-datepicker-div > table"));
        List<WebElement> columns=table.findElements(By.tagName("td"));

        for (WebElement cell: columns){

            if (cell.getText().equals(""+newDay)){

                cell.findElement(By.linkText(""+newDay)).click();
                break;
            }






        }


    }

}
