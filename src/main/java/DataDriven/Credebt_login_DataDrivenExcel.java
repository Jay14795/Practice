package DataDriven;

import Library.ExcelDataConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;


public class Credebt_login_DataDrivenExcel {
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
        ExcelDataConfig config= new ExcelDataConfig("C:\\Users\\Jay Gandhi\\Intellij\\Practice\\src\\main\\TestData\\AutoTestData.xlsx");
        int rows= config.getRowCount(0);

        Object[][] data = new Object[rows][2];
        for(int i=1; i<rows;i++)
        {
            data[i][0]= config.getData(0,i,0);
            data[i][1]= config.getData(0,i,1);
        }

        return data;

    }

}
