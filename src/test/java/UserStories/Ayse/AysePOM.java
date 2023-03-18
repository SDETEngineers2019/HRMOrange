package UserStories.Ayse;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AysePOM {


    //fINDBY ELEMENT LER BURDA


    public AysePOM(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//span[text()='Admin']")
    private WebElement admin;
    @FindBy(xpath = "//button[@class='oxd-button oxd-button--medium oxd-button--secondary']")
    private WebElement addButton;

    @FindBy(xpath = "//button[@class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space']")
    private WebElement saveButton;
    @FindBy(xpath = "//span[text()='Required']")
    private WebElement notificationMessage;

    public WebElement getAdmin() {
        return admin;
    }

    public WebElement getAddButton() {
        return addButton;
    }

    public WebElement getSaveButton() {
        return saveButton;
    }

    public WebElement getNotificationMessage() {
        return notificationMessage;
    }
}
