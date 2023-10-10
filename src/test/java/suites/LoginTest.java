package suites;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.BrowserSetup;
import pages.LoginPage;
import util.ConfigReader;

import java.util.concurrent.TimeUnit;

public class LoginTest {
    private WebDriver driver;
    private LoginPage loginPage;
    private String url;

    @BeforeMethod
    public void setUp() {
        url = ConfigReader.getProperty("url");
        driver = BrowserSetup.initialize();
        loginPage = new LoginPage(driver);
    }

    @Test
    public void loginTest() {
        String username = ConfigReader.getProperty("username");
        String password = ConfigReader.getProperty("password");

        driver.get(url);
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.clickLoginButton();
    // Set implicit wait to 5 seconds
        driver.manage().timeouts().implicitlyWait(1000,TimeUnit.SECONDS);
    }

    @AfterMethod
    public void tearDown() {
        BrowserSetup.quit();
    }
}
