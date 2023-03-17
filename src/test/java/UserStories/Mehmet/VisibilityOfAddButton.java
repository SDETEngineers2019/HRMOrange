package UserStories.Mehmet;

import Utilities.Tools.Tools_Mehmet;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class VisibilityOfAddButton extends Tools_Mehmet {
    /**
     * Step 1 – I login as an Admin
     * Step 2 – I navigate to Admin / User Management page.
     * Step 3 – I verify that “Add” button is displayed.
     */

    @Test
    void visibilityOfAddButtonTest(){
        POM_Elements elements = new POM_Elements(driver);

        wait.until(ExpectedConditions.visibilityOf(elements.getAdminButton()));
        elements.getAdminButton().click();
        wait.until(ExpectedConditions.visibilityOf(elements.getAddButton()));
        Assert.assertTrue(elements.getAddButton().isDisplayed());
    }

}
