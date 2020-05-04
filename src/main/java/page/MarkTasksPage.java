package page;

import factory.WaitDriverUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class MarkTasksPage extends AbstractPage {
    @FindBy(xpath = "//*[@placeholder='Search']")
    private WebElement search;
    @FindBy(xpath = "//*[contains(text(),'Java Iterator')]")
    private WebElement iteratorTask;
    @FindBy(css = ".icon-bookmark")
    private WebElement bookedTask;
    @FindBy(xpath = "//*[@class='ui-icon-chevron-down down-icon']")
    private WebElement userProfile;
    @FindBy(xpath = "//*[contains(text(),'Bookmarks')]")
    private WebElement bookMark;
    @FindBy(css = ".challengecard-title")
    private List<WebElement> listBookmarkTasks;
    @FindBy(xpath = "//*[contains(text(),'Java Iterator')]//ancestor::*[@class='content--list_header-v2']//*[@class='bookmark-cta']")
    private WebElement removeFromBookmarksList;

    public MarkTasksPage() {
        super();
    }

    public void writeWorldForSearch(String word) {
        WaitDriverUtils.waitForVisibility(search);
        search.sendKeys(word);
    }

    public void openFinedTask() {
        iteratorTask.click();
    }

    public void addTaskToBookmark() {
        WaitDriverUtils.waitForClickable(bookedTask);
        bookedTask.click();
    }

    public void openUserProfile() {
        userProfile.click();
    }

    public void openListBookmarksTasks() {
        bookMark.click();
    }

    public List<WebElement> getListBookmarkTasks() {
        return listBookmarkTasks;
    }
    public void removeTaskFromList(){
        removeFromBookmarksList.click();
    }
}
