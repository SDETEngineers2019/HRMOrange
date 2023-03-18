package UserStories.Muhammet;

import Utilities.ParameterDriverClass;
import Utilities.Tools.Tools_Muhammet;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ElementsValidation_POM extends Tools_Muhammet {

    public ElementsValidation_POM() {
        PageFactory.initElements(ParameterDriverClass.driver, this);
    }

    @FindBy(xpath = "//span[text()='Admin']")
    private WebElement adminButton;

    @FindBy(xpath = "//i[@class=\"oxd-icon bi-plus oxd-button-icon\"]")
    private WebElement addButton;

    @FindBy(xpath = "(//div[@class='oxd-select-text--after'])[1]")
    private WebElement userRole;

    @FindBy(css = "input[placeholder='Type for hints...']")
    private WebElement employeeName;

    @FindBy(xpath = "(//div[@class='oxd-select-text--after'])[2]")
    private WebElement status;

    @FindBy(xpath = "(//input[@class=\"oxd-input oxd-input--active\"])[2]")
    private WebElement username;

    @FindBy(xpath = "(//input[@type='password'])[1]")
    private WebElement password;

    @FindBy(xpath = "(//input[@type='password'])[2]")
    private WebElement passwordConfirm;

    @FindBy(xpath = "//button[text()=' Cancel ']")
    private WebElement cancelButton;

    @FindBy(xpath = "//button[text()=' Save ']")
    private WebElement saveButton;

    public WebElement getAdminButton() {
        return adminButton;
    }

    public WebElement getAddButton() {
        return addButton;
    }

    public WebElement getUserRole() {
        return userRole;
    }

    public WebElement getEmployeeName() {
        return employeeName;
    }

    public WebElement getStatus() {
        return status;
    }

    public WebElement getUsername() {
        return username;
    }

    public WebElement getPassword() {
        return password;
    }

    public WebElement getPasswordConfirm() {
        return passwordConfirm;
    }

    public WebElement getCancelButton() {
        return cancelButton;
    }

    public WebElement getSaveButton() {
        return saveButton;
    }
}
