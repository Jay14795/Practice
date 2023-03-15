package DataDriven;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;


public class Credebt_login_DataDriven {
    WebDriver driver;
    @Test(dataProvider="CredebtData")
    public void login(String email, String password) throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        driver.get("https://test.credebt.com/");

        driver.findElement(By.id("email")).sendKeys(email);
        driver.findElement(By.id("password")).sendKeys(password);

        driver.findElement(By.xpath("//button[@type='submit']")).click();
        Thread.sleep(5000);

        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
        Assert.assertTrue(driver.getCurrentUrl().contains("https://test.credebt.com/dashboard"),"Unable to login, Credentials may invalid.");

        System.out.println("Page URL Verified & users can able to login successfully");
    }
    @AfterMethod
    public void teardown()
    {
        driver.quit();
    }
@DataProvider(name="CredebtData")
    public Object[][] passData()
    {
        Object[][] data = new Object[3][2];
        data[0][0]="demo@yopmail.com";
        data[0][1]= "Demo@1234";
        data[1][0]="demo2@yopmail.com";
        data[1][1]= "Demo@123456";

        data[2][0]="jay.gandhi@siliconithub.in";
        data[2][1]= "Jay@14795";

        return data;

    }

}
