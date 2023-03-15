package Playwright;


import com.microsoft.playwright.*;
import org.testng.annotations.Test;

import java.nio.file.Paths;

public class Login
{
    @Test(priority = 0)
    public void login() throws InterruptedException {
        Playwright playwright= Playwright.create();
        Browser browser= playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        BrowserContext brContext = browser.newContext();

        Page page= brContext.newPage();
        page.navigate("https://test.credebt.com/");
        Thread.sleep(5000);
        page.fill("#email","jay.gandhi@siliconithub.in");
        page.fill("#password","Jay@14795");
        page.click("//button[@type='submit']");
        page.waitForLoadState();
        brContext.storageState(new BrowserContext.StorageStateOptions().setPath(Paths.get("Token.json")));

    }
}
