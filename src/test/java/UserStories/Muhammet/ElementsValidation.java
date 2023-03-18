package UserStories.Muhammet;

import Utilities.Tools.Tools_Muhammet;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ElementsValidation extends Tools_Muhammet {

    /**
     * Step 1 – I login as an Admin
     * Step 2 – I navigate to Admin / User Management page.
     * Step 3 – I click on Add button
     * Step 4 – I verify that all the required elements are displayed
     * (User Role, Employee Name, Status, Username, Password, Confirm Password, Cancel, Save)
     * */

    @Test
    @Parameters
    void elementsValidation(){
        ElementsValidation_POM elements = new ElementsValidation_POM();

        elements.clickMethod(elements.getAdminButton());
        elements.clickMethod(elements.getAddButton());

        elements.verifyDisplayedElements(elements.getUserRole());
        elements.verifyDisplayedElements(elements.getEmployeeName());
        elements.verifyDisplayedElements(elements.getStatus());
        elements.verifyDisplayedElements(elements.getUsername());
        elements.verifyDisplayedElements(elements.getPassword());
        elements.verifyDisplayedElements(elements.getPasswordConfirm());
        elements.verifyDisplayedElements(elements.getCancelButton());
        elements.verifyDisplayedElements(elements.getSaveButton());


    }
}
