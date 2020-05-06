package page;

import factory.DriverFactory;
import factory.WaitDriverUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class JavaTaskPage extends AbstractPage {
    @FindBy(xpath = "//h3[contains(.,'Java')]//ancestor::*[@class='card-content']//*[@class='ui-text']")
    private WebElement javaTasks;
    @FindBy(xpath = "//*[contains(text(),'Solved')]//ancestor::*[@class='label-wrap']")
    private WebElement checkSolvedTask;
    @FindBy(xpath = "//*[contains(text(),'Unsolved')]//ancestor::*[@class='label-wrap']")
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
    @FindBy(xpath = "//span[contains(.,'Solved')]//ancestor::*[@id='contest-challenges-problem']")
    private List<WebElement> solvedContainers;
    @FindBy(xpath = "//span[contains(.,'Easy')]//ancestor::*[@id='contest-challenges-problem']")
    private List<WebElement> easyContainers;


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
        WaitDriverUtils.waitForClickable(checkSolvedTask);
        checkSolvedTask.click();
        WaitDriverUtils.waitForRefreshedAllElements(solvedContainers);
    }

    public void invisibleUnsolvedTasks() {
        WaitDriverUtils.waitForInvisibleAll(UnsolvedTasks);
    }

    public void checkEasyTasks() {
        checkEasyTask.click();
        DriverFactory.refresh();
        WaitDriverUtils.waitForRefreshedAllElements(easyContainers);
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
