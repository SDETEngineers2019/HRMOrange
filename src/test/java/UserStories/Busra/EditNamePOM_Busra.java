package UserStories.Busra;

import Utilities.Tools.Tools_Busra;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EditNamePOM_Busra extends Tools_Busra {
    public EditNamePOM_Busra(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[@class='oxd-main-menu-item']")
    private WebElement adminPage;

    @FindBy(css= "button[class='oxd-button oxd-button--medium oxd-button--secondary']")
    private WebElement addButton;

    //   @FindBy(xpath = "(//input[@class=\"oxd-input oxd-input--active\"])[2]")
    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[4]/div/div[2]/input")
    private WebElement usernameInput;

    @FindBy(xpath = "//span[@class='oxd-text oxd-text--span oxd-input-field-error-message oxd-input-group__message']")
    private WebElement displayedMessage;

    public WebElement getAdminPage() {
        return adminPage;
    }

    public WebElement getAddButton() {
        return addButton;
    }

    public WebElement getUsernameInput() {
        return usernameInput;
    }

    public WebElement getDisplayedMessage() {
        return displayedMessage;
    }
}
