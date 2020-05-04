package page;

import factory.WaitDriverUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends AbstractPage {
    @FindBy(css = "#menu-item-2887")
    private WebElement login;
    @FindBy(xpath = "//*[@class='fl-button-wrap fl-button-width-auto fl-button-left']//*")
    private WebElement loginForm;
    @FindBy(xpath = "//*[@id='input-1']")
    private WebElement emailInput;
    @FindBy(xpath = "//*[@id='input-2']")
    private WebElement passwordInput;
    @FindBy(xpath = "//button[@data-analytics='LoginPassword']")
    private WebElement logInButton;

    public LoginPage() {
        super();
    }

    public void openMenu() {
        login.click();
    }

    public void openLoginForm() {
        WaitDriverUtils.waitForVisibility(loginForm);
        loginForm.click();
    }

    public void writeEmail(String email) {
        WaitDriverUtils.waitForVisibility(emailInput);
        emailInput.sendKeys(email);
    }

    public void writePassword(String password) {
        passwordInput.sendKeys(password);
    }

    public void clickLogIn() {
        WaitDriverUtils.waitForClickable(logInButton);
        logInButton.click();
    }
}
