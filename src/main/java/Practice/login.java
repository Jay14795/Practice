package login;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.html5.LocalStorage;
import org.openqa.selenium.html5.WebStorage;
import org.openqa.selenium.remote.Augmenter;
import org.testng.annotations.Test;

public class login
{
    WebDriver driver = new ChromeDriver();
    WebStorage webStorage = (WebStorage) new Augmenter().augment(driver);
    LocalStorage localStorage = webStorage.getLocalStorage();

    String validEmail= "jay.gandhi@siliconithub.in";
    String validPassword="Jay@14795";

    public static void main(String[] args) {

    }

    @Test(priority = 1)
    public void launch() throws InterruptedException {
        driver.get("https://test.credebt.com/");
        Thread.sleep(5000);
        driver.manage().window().maximize();

    }

    @Test(priority = 2)
    public void valid_login() throws InterruptedException {
        driver.findElement(By.id("email")).sendKeys(validEmail);
        driver.findElement(By.id("password")).sendKeys(validPassword);
        driver.findElement(By.xpath("//button[@type='submit']")).sendKeys(Keys.ENTER);
        Thread.sleep(5000);

    }
}



