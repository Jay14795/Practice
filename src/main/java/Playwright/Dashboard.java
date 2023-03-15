package Playwright;

import com.microsoft.playwright.*;
import org.testng.annotations.Test;

import java.nio.file.Paths;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class Dashboard {
    Playwright playwright = Playwright.create();
    Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
    BrowserContext brContext = browser.newContext(new Browser.NewContextOptions().setStorageStatePath(Paths.get("Token.json")));

    Page page = brContext.newPage();

    @Test(priority = 1)
    public void dashboard() throws InterruptedException {

        page.navigate("https://test.credebt.com/dashboard");
        Thread.sleep(10000);
        assertThat(page).hasURL("https://test.credebt.com/cash-transactions/import-batch");

    }

    @Test(priority = 2)
    public void Transaction_Type() throws InterruptedException {
        page.navigate("https://test.credebt.com/administration/trade/trade-transaction/trade-type");
        Thread.sleep(5000);

        page.click("(//button[@type='button'])[1]");          Thread.sleep(1000);
        page.fill("#type_name","AutomationDemo");        Thread.sleep(1000);
        page.click("//button[@type='submit']");

    }
}
