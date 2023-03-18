package UserStories.Ayse;

import Utilities.Tools.Tools_Ayse;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ValidatingNotificationColorChange extends Tools_Ayse {
    //    As an Admin user I should be able to see notification messages displayed, when I click on Save button without entering mandatory fields.
//    Step 1 – I login as an Admin
//    Step 2 – I navigate to Admin / User Management page.
//    Step 3 – I click on Add button
//    Step 4 – I click on Save button before entering any mandatory field.
//    Step 5 – I verify that notification messages in red color displayed.


    @Test
    void validateNotificationMessage() throws InterruptedException {
        AysePOM element = new AysePOM(driver);
        elementClickable(element.getAdmin());
        element.getAdmin().click();
        elementClickable(element.getAddButton());
        element.getAddButton().click();
        elementClickable(element.getSaveButton());
        element.getSaveButton().click();
        element.getNotificationMessage().isDisplayed();
        // String ExpectedColorOfNotificationMessage=element.getNotificationMessage().getCssValue("color");
        String TextColor = element.getNotificationMessage().getCssValue("color");
        System.out.println(TextColor);
        Thread.sleep(3000);
        Assert.assertTrue(TextColor.contains("rgba(235, 9, 16, 1)"), "It is not red");
    }
}
