package factory;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Objects;


public class WaitDriverUtils {
    public static void waitForVisibility(WebElement element) {
        new WebDriverWait(DriverFactory.getDiver(), 20)
                .until(ExpectedConditions.visibilityOf(element));
    }

    public static void waitForClickable(WebElement element) {
        new WebDriverWait(DriverFactory.getDiver(), 20)
                .until(ExpectedConditions.elementToBeClickable(element));
    }
    public static void waitForVisibilityAllElements(List<WebElement> elements) {
        new WebDriverWait(DriverFactory.getDiver(), 20)
                .until(ExpectedConditions.visibilityOfAllElements(elements));
    }
    public static void waitForRefreshedAllElements(List<WebElement> elements) {
        new WebDriverWait(DriverFactory.getDiver(), 20)
                .until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOfAllElements(elements)));
    }

    public static void waitForInvisibleAll(List<WebElement> elements) {
        new WebDriverWait(DriverFactory.getDiver(), 20)
                .until(ExpectedConditions.invisibilityOfAllElements(elements));
    }

    public static void waitForLoad() {
        new WebDriverWait(DriverFactory.getDiver(), 20)
                .until((ExpectedCondition<Boolean>) wd->((JavascriptExecutor) Objects.requireNonNull(wd))
                        .executeScript("return document.readyState").equals("complete"));
    }
}
