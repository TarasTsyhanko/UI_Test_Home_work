package tests;

import bo.JavaTasksBusinessObject;
import bo.LoginBusinessObject;
import bo.MarkTaskBusinessObject;
import config.PropertyFile;
import factory.DriverFactory;
import factory.TestAllureListeners;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static config.ConfigConstants.*;


@Listeners(TestAllureListeners.class)
public class BookmarksTasksTest {
    private LoginBusinessObject loginBusinessObject;
    private MarkTaskBusinessObject markTaskBusinessObject;
    private String taskName = PropertyFile.getProperty(BOOKMARK_TASK);

    @BeforeMethod
    public void setUp() {
        loginBusinessObject = new LoginBusinessObject();
        markTaskBusinessObject = new MarkTaskBusinessObject();
    }

    @Test
    public void doBookmarksTasksTest() {
        loginBusinessObject.openWebSite(PropertyFile.getProperty(WEBSITE));
        loginBusinessObject.openLoginForm();
        loginBusinessObject.logIn(PropertyFile.getProperty(EMAIL), PropertyFile.getProperty(PASSWORD));
        markTaskBusinessObject.findTask(taskName);
        markTaskBusinessObject.addTaskToBookmarkList();
        markTaskBusinessObject.openBookmarksList();
        markTaskBusinessObject.verifyTaskIsInBookmarksList(taskName);
        markTaskBusinessObject.removeTaskFromBookMarkList();
        markTaskBusinessObject.verifyTaskWasRemoved(taskName);

    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        DriverFactory.quitDriver();
    }
}
