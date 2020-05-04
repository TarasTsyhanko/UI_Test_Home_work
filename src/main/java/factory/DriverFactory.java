package factory;

import config.PropertyFile;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.util.concurrent.TimeUnit;

import static config.ConfigConstants.DRIVER_WAY;
import static config.ConfigConstants.WEB_DRIVER;
import static java.lang.System.setProperty;

public class DriverFactory {
    private static WebDriver DRIVER ;
    private static final long implicitlyWait = 25;

    private static void setWait(WebDriver driver) {
        driver.manage().timeouts().implicitlyWait(implicitlyWait, TimeUnit.SECONDS);

    }

    public static void initDriver() {
        setProperty(PropertyFile.getProperty(WEB_DRIVER), PropertyFile.getProperty(DRIVER_WAY));
        WebDriver driver = new ChromeDriver();
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
     public static void refresh(){
        DRIVER.navigate().refresh();
     }

    public static void quitDriver() {
        if (DRIVER != null) {
            DRIVER.quit();
            DRIVER = null;
        }
    }

}
