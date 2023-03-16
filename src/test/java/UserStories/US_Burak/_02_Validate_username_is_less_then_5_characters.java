package UserStories.US_Burak;

import Utilities.BaseDriver_BRAVE;
import Utilities.Tools.Tools_Burak;
import dev.failsafe.internal.util.Assert;
import org.asynchttpclient.util.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import java.awt.*;

public class _02_Validate_username_is_less_then_5_characters extends Tools_Burak {
    @Test
    public void test() throws InterruptedException, AWTException {
        // startingSettings("firefox"); dont use it when you use XML
        _01_UserStory_Less_Then_1MB_NON_PIC_FILE.login();

        visibilityOfElementLocated_Tools(By.xpath("(//a[@class='oxd-main-menu-item'])[1]"));
        WebElement admin = driver.findElement(By.xpath("(//a[@class='oxd-main-menu-item'])[1]"));
        clickElement_Tools(admin);

        visibilityOfElementLocated_Tools(By.xpath("//i[@class='oxd-icon bi-plus oxd-button-icon']"));
        WebElement addBtn = driver.findElement(By.xpath("//i[@class='oxd-icon bi-plus oxd-button-icon']"));
        clickElement_Tools(addBtn);

        visibilityOfElementLocated_Tools(By.xpath("(//input[@class='oxd-input oxd-input--active'])[2]"));
        WebElement userNameTextBox= driver.findElement(By.xpath("(//input[@class='oxd-input oxd-input--active'])[2]"));
        userNameTextBox.sendKeys("ali");

        WebElement userNameError = driver.findElement(By.xpath("//span[@class='oxd-text oxd-text--span oxd-input-field-error-message oxd-input-group__message']"));
        verifyElementContainsText_Tools(userNameError, "least 5 characters");
        //System.out.println(userNameError.getCssValue("color"));
        Assert.isTrue(userNameError.getCssValue("color").contains("rgba(235, 9, 16, 1)"), "It is not red!!!!");
    }
}
