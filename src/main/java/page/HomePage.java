package page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends AbstractPage {
    @FindBy(xpath = "//span[@class='mmR username text-ellipsis']")
    private WebElement userNameLabel;

    public HomePage() {
        super();
    }

    public WebElement getUserNameLabel() {
        return userNameLabel;
    }
}
