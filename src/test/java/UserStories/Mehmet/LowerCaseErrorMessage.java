package UserStories.Mehmet;

import Utilities.Tools.Tools_Mehmet;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LowerCaseErrorMessage extends Tools_Mehmet {
    /**
     * Step 1 – I login as an Admin
     * Step 2 – I navigate to Admin / User Management page.
     * Step 3 – I click on Add button
     * Step 4 – I enter a value in to the Password field which doesn’t have lower case character.
     * Step 5 – I verify that notification messages “Your password must contain a lower-case letter, an upper-case letter, a digit and a special character.
     *          Try a different password” in red color displayed
     */

    @Test
    @Parameters("samplePassword")
    void lowerCaseErrorMessageTest(String samplePassword){
        POM_Elements elements = new POM_Elements(driver);

        wait.until(ExpectedConditions.visibilityOf(elements.getAdminButton()));
        elements.getAdminButton().click();
        wait.until(ExpectedConditions.visibilityOf(elements.getAddButton()));
        elements.getAddButton().click();
        wait.until(ExpectedConditions.visibilityOf(elements.getAddUserPasswordInput()));
        elements.getAddUserPasswordInput().sendKeys(samplePassword);
        wait.until(ExpectedConditions.visibilityOf(elements.getErrorMessage()));
        Assert.assertTrue(elements.getErrorMessage().isDisplayed());

    }


}
