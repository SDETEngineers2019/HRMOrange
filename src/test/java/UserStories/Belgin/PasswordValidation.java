package UserStories.Belgin;

import Utilities.Tools.Tools_Belgin;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class PasswordValidation extends Tools_Belgin {

    /**
     * Step 1 – I login as an Admin
     * Step 2 – I navigate to Admin / User Management page.
     * Step 3 – I click on Add button
     * Step 4 – I enter a required value in to the “password” field and different value in to the “confirm password” field
     * Step 5 – I verify that notification messages “Passwords do not match” in red color displayed.
     */

    @Test
    void passwordValidation(){
        PasswordValidationPageElements elements = new PasswordValidationPageElements();

        login();

        elements.clickMethod(elements.getAdminButton());
        elements.clickMethod(elements.getAddButton());

        elements.clickMethod(elements.getUserRole());
        List<WebElement> userRoles = driver.findElements(By.xpath("//div[@role='listbox']"));
        waitUntilClickable(userRoles.get(0));
        elements.clickMethod(userRoles.get(0));

        elements.sendKeysMethod(elements.getEmployeeName(), "Nina  Patel");

        elements.clickMethod(elements.getStatus());
        List<WebElement> status = driver.findElements(By.xpath("//div[@role='listbox']"));
        waitUntilClickable(status.get(0));
        elements.clickMethod(status.get(0));

        elements.sendKeysMethod(elements.getUsername(), "ninapatel");

        elements.sendKeysMethod(elements.getPassword(), "NinaPatel123.");
        elements.sendKeysMethod(elements.getPasswordConfirm(), "NinaPatel123?");

        elements.verifyContainsText(elements.getMessage(), "Passwords do not match");

    }

}
