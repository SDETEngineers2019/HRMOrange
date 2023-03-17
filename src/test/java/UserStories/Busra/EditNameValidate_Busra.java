package UserStories.Busra;

import Utilities.Tools.Tools_Busra;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class EditNameValidate_Busra extends Tools_Busra {

    @Test
    @Parameters(value = "keyWord")
    void editNameTest(String word){
        EditNamePOM_Busra elements = new EditNamePOM_Busra(driver);
        login();

        elements.clickMethod(elements.getAdminPage());
        elements.clickMethod(elements.getAddButton());

        elements.clickMethod(elements.getUsernameInput());
        elements.sendKeysMethod(elements.getUsernameInput(), word);

        elements.setWait(4000);

        elements.verifyEqualsText(elements.getDisplayedMessage(), "Already exists");

    }
}
