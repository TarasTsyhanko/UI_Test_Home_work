package bo;

import factory.DriverFactory;
import factory.WaitDriverUtils;
import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import page.HomePage;
import page.LoginPage;

public class LoginBusinessObject {
    private HomePage homePage;
    private LoginPage loginPage;

    public LoginBusinessObject() {
        homePage = new HomePage();
        loginPage = new LoginPage();
    }

    @Step("Open Website {url}")
    public void openWebSite(String url) {
        DriverFactory.getDiver().get(url);
    }

    @Step("Open login form")
    @ru.yandex.qatools.allure.annotations.Step("cvbnmnb")
    public void openLoginForm() {
        loginPage.openMenu();
        loginPage.openLoginForm();
    }

    @Step("Write email: {email} end password: {password}")
    public void logIn(String email, String password) {
        loginPage.writeEmail(email);
        loginPage.writePassword(password);
        loginPage.clickLogIn();
    }

    @Step("Verify we Log In user {userName}")
    public void verifyUser(String userName) {
        WebElement element = homePage.getUserNameLabel();
        WaitDriverUtils.waitForVisibility(element);
        Assert.assertTrue("user name label is not displayed", element.isDisplayed());
        Assert.assertEquals(userName, element.getText());
    }
}
