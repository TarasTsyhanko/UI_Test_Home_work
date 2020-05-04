package tests;

import bo.LoginBusinessObject;
import config.PropertyFile;
import factory.DriverFactory;
import factory.TestAllureListeners;
import org.testng.annotations.*;

import static config.ConfigConstants.*;


@Listeners(TestAllureListeners.class)
public class LoginTest {
    private LoginBusinessObject loginBusinessObject;

    @BeforeMethod
    public void setUp() {
        loginBusinessObject = new LoginBusinessObject();
    }

    @Test
    public void doLoginTest()  {
        loginBusinessObject.openWebSite(PropertyFile.getProperty(WEBSITE));
        loginBusinessObject.openLoginForm();
        loginBusinessObject.logIn(PropertyFile.getProperty(EMAIL), PropertyFile.getProperty(PASSWORD));
        loginBusinessObject.verifyUser(PropertyFile.getProperty(USERNAME));

    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        DriverFactory.quitDriver();
    }
}
