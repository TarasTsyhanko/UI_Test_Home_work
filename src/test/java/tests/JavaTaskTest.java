package tests;

import bo.JavaTasksBusinessObject;
import bo.LoginBusinessObject;
import config.PropertyFile;
import factory.DriverFactory;
import factory.TestAllureListeners;
import factory.WaitDriverUtils;
import io.qameta.allure.Step;
import org.junit.Before;
import org.testng.annotations.*;

import static config.ConfigConstants.*;

@Listeners(TestAllureListeners.class)
public class JavaTaskTest {
    private LoginBusinessObject loginBusinessObject;
    private JavaTasksBusinessObject javaTasksBusinessObject;

    @BeforeMethod
    public void setUp() {
        loginBusinessObject = new LoginBusinessObject();
        javaTasksBusinessObject = new JavaTasksBusinessObject();
    }

    @Test
    public void doJavaTaskTest() {
        loginBusinessObject.openWebSite(PropertyFile.getProperty(WEBSITE));
        loginBusinessObject.openLoginForm();
        loginBusinessObject.logIn(PropertyFile.getProperty(EMAIL), PropertyFile.getProperty(PASSWORD));
        javaTasksBusinessObject.openJavaTasksList();
        javaTasksBusinessObject.selectSolvedTasks();
        javaTasksBusinessObject.verifyAllTasksSolved(PropertyFile.getProperty(TASK_STATUS));
        javaTasksBusinessObject.selectEasyTasks();
        javaTasksBusinessObject.verifyAllTasksEasy(PropertyFile.getProperty(EASY_TASK));
        javaTasksBusinessObject.selectMediumTasks();
        javaTasksBusinessObject.verifyAllTasksMedium(PropertyFile.getProperty(MEDIUM_TASK));

    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        DriverFactory.quitDriver();
    }
}
