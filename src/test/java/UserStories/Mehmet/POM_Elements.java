package UserStories.Mehmet;

import Utilities.Tools.Tools_Mehmet;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class POM_Elements extends Tools_Mehmet {
    public POM_Elements(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(linkText = "Admin")
    private WebElement adminButton;

    @FindBy(css = "button[class='oxd-button oxd-button--medium oxd-button--secondary']")
    private WebElement addButton;

    @FindBy(xpath = "(//input[@type='password'])[1]")
    private WebElement addUserPasswordInput;

    @FindBy(xpath = "//span[@class= 'oxd-text oxd-text--span oxd-input-field-error-message oxd-input-group__message']")
    private WebElement errorMessage;

    public WebElement getAdminButton() {
        return adminButton;
    }

    public WebElement getAddButton() {
        return addButton;
    }

    public WebElement getAddUserPasswordInput() {
        return addUserPasswordInput;
    }

    public WebElement getErrorMessage() {
        return errorMessage;
    }
}
