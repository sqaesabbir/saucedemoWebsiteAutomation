package pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class BrowserSetup {
    private static WebDriver driver;

    public static WebDriver initialize() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        // Set implicit wait to 5 seconds
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        return driver;
    }

    public static void quit() {
        if (driver != null) {
            driver.quit();
        }
    }
}
