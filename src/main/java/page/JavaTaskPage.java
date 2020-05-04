package page;

import factory.DriverFactory;
import factory.WaitDriverUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class JavaTaskPage extends AbstractPage {
    @FindBy(xpath = "//h3[contains(.,'Java')]//ancestor::*[@class='card-content']//*[@class='ui-text']")
    private WebElement javaTasks;
    @FindBy(xpath = "//*[@class='label' and contains(text(),'Solved')]")
    private WebElement checkSolvedTask;
    @FindBy(xpath = "//*[@class='label' and contains(text(),'Unsolved')]")
    private WebElement checkUnsolvedTask;
    @FindBy(xpath = "//button[@class='ui-btn ui-btn-normal primary-cta ui-btn-line-primary']//span[@class='ui-text']")
    private List<WebElement> statusTasks;
    @FindBy(xpath = "//*[@class='label' and contains(text(),'Easy')]")
    private WebElement checkEasyTask;
    @FindBy(xpath = "//*[@class='label' and contains(text(),'Medium')]")
    private WebElement checkMediumTask;
    @FindBy(xpath = "//*[@class='card-details pmT']//*[1]")
    private List<WebElement> levelOfAllTask;
    @FindBy(xpath = "//span[@class='ui-text' and contains(text(),'Solve Challenge')]")
    private List<WebElement> UnsolvedTasks;


    public JavaTaskPage() {
        super();
    }

    public void openJavaTasks() {
        WaitDriverUtils.waitForClickable(javaTasks);
        javaTasks.click();
    }

    public void checkSolvedTasks() {
        WaitDriverUtils.waitForClickable(checkUnsolvedTask);
        checkUnsolvedTask.click();
        DriverFactory.refresh();
        WaitDriverUtils.waitForLoad();
        WaitDriverUtils.waitForClickable(checkSolvedTask);
        checkSolvedTask.click();
        DriverFactory.refresh();
    }

    public void invisibleUnsolvedTasks() {
        WaitDriverUtils.waitForInvisibleAll(UnsolvedTasks);
    }

    public void checkEasyTasks() {
        checkEasyTask.click();
        DriverFactory.refresh();
        WaitDriverUtils.waitForLoad();
    }

    public void checkMediumTasks() {
        checkEasyTask.click();
        DriverFactory.refresh();
        WaitDriverUtils.waitForLoad();
        WaitDriverUtils.waitForClickable(checkMediumTask);
        checkMediumTask.click();
        DriverFactory.refresh();
        WaitDriverUtils.waitForLoad();
    }


    public List<WebElement> getStatusTasks() {
        return statusTasks;
    }

    public List<WebElement> getLevelOfAllTask() {
        return levelOfAllTask;
    }
}
