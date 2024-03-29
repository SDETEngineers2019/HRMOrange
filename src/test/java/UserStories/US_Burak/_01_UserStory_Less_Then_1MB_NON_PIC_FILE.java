package UserStories.US_Burak;

import Utilities.Tools.Tools_Burak;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.awt.*;

public class _01_UserStory_Less_Then_1MB_NON_PIC_FILE extends Tools_Burak {
    //BaseDriver_BRAVE bd = new BaseDriver_BRAVE();

    @Test
    public void test() throws InterruptedException, AWTException {
        login();

        visibilityOfElementLocated_Tools(By.xpath("(//a[@class='oxd-main-menu-item'])[6]"));
        WebElement myInfo = driver.findElement(By.xpath("(//a[@class='oxd-main-menu-item'])[6]"));
        clickElement_Tools(myInfo);

        visibilityOfElementLocated_Tools(By.cssSelector("[class='employee-image']"));
        WebElement pp = driver.findElement(By.cssSelector("[class='employee-image']"));
        clickElementFromDOM_I_GUES_IDK_Tools(pp);

        visibilityOfElementLocated_Tools(By.cssSelector("[class='oxd-icon bi-plus']"));
        WebElement picAddbtn= driver.findElement(By.cssSelector("[class='oxd-icon bi-plus']"));
        clickElement_Tools(picAddbtn);

        r2d2_TAB_AND_ENTER_Tools(0,1);
        stringSelection_Tools("E:\\IdeaProjects\\HRMOrange\\src\\test\\java\\UserStories\\UserStory_Burak.java"); //TODO   CHANGE THIS TO YOUR OWN PATH

        //Thread.sleep(2000);
        visibilityOfElementLocated_Tools(By.cssSelector("[class='oxd-text oxd-text--span oxd-input-field-error-message oxd-input-group__message']"));
        WebElement errorText = driver.findElement(By.cssSelector("[class='oxd-text oxd-text--span oxd-input-field-error-message oxd-input-group__message']"));
        verifyElementContainsText_Tools(errorText,"File type");
    }

    public static void login() throws InterruptedException, AWTException {
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        // driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        // wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".oxd-form-row:nth-of-type(1)>.oxd-input-group>.oxd-input-group__label-wrapper+div>input")));
        visibilityOfElementLocated_Tools(By.cssSelector(".oxd-form-row:nth-of-type(1)>.oxd-input-group>.oxd-input-group__label-wrapper+div>input"));
        WebElement userName = driver.findElement(By.cssSelector(".oxd-form-row:nth-of-type(1)>.oxd-input-group>.oxd-input-group__label-wrapper+div>input"));
        sendKeysElement_Tools(userName, "Admin");

        WebElement userPSW = driver.findElement(By.cssSelector(".oxd-form-row:nth-of-type(2) >.oxd-input-group > .oxd-input-group__label-wrapper+div>input"));
        sendKeysElement_Tools(userPSW, "admin123");

        WebElement lgnBtn = driver.findElement(By.cssSelector(".orangehrm-login-action>button"));
        clickElement_Tools(lgnBtn);
    }
}
