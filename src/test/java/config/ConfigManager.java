package config;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.time.Duration;

public class ConfigManager {
    private static WebDriver driver;
    public static WebDriver getDriver() {
//        int count=0;
//        while(driver==null||count<5) {
//            Thread.sleep(500);
//        }
        return driver;
    }

    @BeforeSuite
    @Parameters("browser")
    public static void setUp(@Optional("chrome") String browser) {
        if (browser.equalsIgnoreCase("chrome")) {
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("--lang=en");
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver(chromeOptions);
        } else if (browser.equalsIgnoreCase("firefox")) {
            FirefoxOptions firefoxOptions = new FirefoxOptions();
            firefoxOptions.addPreference("intl.assert_language", "en");
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver(firefoxOptions);
        } else if (browser.equalsIgnoreCase("safari")) {
            SafariOptions safarioptions = new SafariOptions();
            safarioptions.setCapability("language", "en");
            WebDriverManager.safaridriver().setup();
            driver = new SafariDriver();
        } else {
            throw new IllegalArgumentException("Unknown browser: " + browser);
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofMillis(20000));
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(60000));
       // driver.navigate().to("https://demoqa.com/");
       navigateToMainPage();
    }

    public static void navigateToMainPage() {
        driver.navigate().to("https://demoqa.com/");
    }
    @AfterSuite
    public static void tearDown() {
        //driver.quit();
    }
}
