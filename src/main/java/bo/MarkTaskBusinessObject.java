package bo;

import factory.WaitDriverUtils;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import page.MarkTasksPage;

import java.util.List;
import java.util.Optional;

public class MarkTaskBusinessObject {
    private MarkTasksPage markTasksPage;

    public MarkTaskBusinessObject() {
        markTasksPage = new MarkTasksPage();
    }


    @Step("Find task for name: {taskName}")
    public void findTask(String taskName) {
        markTasksPage.writeWorldForSearch(taskName);
        markTasksPage.openFinedTask();
    }

    @Step("Add task to Bookmarks list")
    public void addTaskToBookmarkList() {
        markTasksPage.addTaskToBookmark();
    }

    @Step("Open Bookmarks list")
    public void openBookmarksList() {
        markTasksPage.openUserProfile();
        markTasksPage.openListBookmarksTasks();
    }

    @Step("Remove task from Bookmark list")
    public void removeTaskFromBookMarkList() {
        markTasksPage.removeTaskFromList();
    }

    @Step("Verify task {taskName}  was removed")
    public void verifyTaskWasRemoved(String taskName) {
        List<WebElement> elements = markTasksPage.getListBookmarkTasks();
        if (!elements.isEmpty()) {
            elements.forEach(element -> {
                Assert.assertNotEquals(String.format("Element equals %s word", element.getText())
                        , taskName, element.getText());
            });
        }
    }


     @Step("Verify task {taskName}  was added")
    public void verifyTaskIsInBookmarksList(String taskName) {
        List<WebElement> elements = markTasksPage.getListBookmarkTasks();
        if (!elements.isEmpty()) {
            WaitDriverUtils.waitForVisibilityAllElements(elements);
            Optional<WebElement> optional = elements.stream()
                    .filter(element -> taskName.equals(element.getText())).findFirst();
            optional.ifPresent(element -> Assert.assertEquals
                    (String.format("Element does not equals %s word", element.getText())
                    , taskName, element.getText()));
        } else {
            Assert.fail(String.format("Element with text: '%s' not found!", taskName));
        }
    }
}

