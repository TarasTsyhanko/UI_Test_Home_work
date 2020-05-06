package factory;

import config.PropertyFile;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

import static config.ConfigConstants.*;
import static java.lang.System.setProperty;

public class DriverFactory {
    private static WebDriver DRIVER;
    private static final long implicitlyWait = 25;

    private static void setWait(WebDriver driver) {
        driver.manage().timeouts().implicitlyWait(implicitlyWait, TimeUnit.SECONDS);

    }

    public static void initDriver() {
        String browser = System.getProperty("browser");
        WebDriver driver = null;

        if (browser != null && browser.equals("chrome")) {
            setProperty(PropertyFile.getProperty(CHROME_WEBDRIVER), PropertyFile.getProperty(CHROME_DRIVER_WAY));
            driver = new ChromeDriver();
        } else {
            setProperty(PropertyFile.getProperty(FIREFOX_WEBDRIVER), PropertyFile.getProperty(FIREFOX_DRIVER_WAY));
            driver = new FirefoxDriver();
        }
        driver.manage().window().maximize();
        setWait(driver);
        DRIVER = driver;
    }

    public static WebDriver getDiver() {
        if (DRIVER == null) {
            initDriver();
        }
        return DRIVER;
    }

    public static void refresh() {
        DRIVER.navigate().refresh();
    }

    public static void quitDriver() {
        if (DRIVER != null) {
            DRIVER.quit();
            DRIVER = null;
        }
    }

}
