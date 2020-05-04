package bo;

import factory.WaitDriverUtils;
import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import page.JavaTaskPage;

import java.util.List;

public class JavaTasksBusinessObject {
    private JavaTaskPage javaTaskPage;

    public JavaTasksBusinessObject() {
        javaTaskPage = new JavaTaskPage();
    }

    @Step("Open list with Java tasks")
    @ru.yandex.qatools.allure.annotations.Step("fghjhgfgh")

    public void openJavaTasksList() {
        javaTaskPage.openJavaTasks();
    }

    @Step("Select only soled task")
    public void selectSolvedTasks() {
        javaTaskPage.checkSolvedTasks();
    }

    @Step("Verify all tasks have status: {str}")
    public void verifyAllTasksSolved( String str) {
        List<WebElement> elements = javaTaskPage.getStatusTasks();
        elements.forEach(webElement ->
                Assert.assertEquals(String.format("Element %s does not equals " + str + " word.", webElement.getText()),
                        webElement.getText(), str));
    }

    @Step("Select tasks with level: Easy")
    public void selectEasyTasks() {
        javaTaskPage.checkEasyTasks();
    }

    @Step("Verify all tasks have level: {str}")
    public void verifyAllTasksEasy(String str) {
        List<WebElement> elements = javaTaskPage.getLevelOfAllTask();
        WaitDriverUtils.waitForVisibilityAllElements(elements);
        elements.forEach(webElement ->
                Assert.assertEquals(String.format("Element %s does not equals " + str + " word.", webElement.getText()),
                        webElement.getText(), str));

    }

    @Step("Select tasks with level: Medium")
    public void selectMediumTasks() {
        javaTaskPage.checkMediumTasks();
    }

    @Step("Verify all tasks have level: {str}")
    public void verifyAllTasksMedium(String str) {
        List<WebElement> elements = javaTaskPage.getLevelOfAllTask();
        WaitDriverUtils.waitForVisibilityAllElements(elements);
        elements.forEach(webElement ->
                Assert.assertEquals(String.format("Element %s does not equals " + str + " word.", webElement.getText()),
                        webElement.getText(), str));
    }
}
