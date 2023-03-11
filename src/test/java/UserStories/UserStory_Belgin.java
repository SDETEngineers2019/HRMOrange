package UserStories;

import Utilities.Tools.Tools_Belgin;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;

public class UserStory_Belgin extends Tools_Belgin {

/**
 * 1- Click on the photograph displayed at the top left corner of the page
 *
 * 2- Click on "Choose a file" button
 *
 * 3- Choose the JPG file that is more than 1 MB
 *
 * 4- Click on upload
 * */
    @Test
    void checkTheUploadPictureByOverTheSizeOf1MB() throws AWTException {

        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/pim/viewPersonalDetails/empNumber/7");

        visibilityOfElement(By.xpath("//input[@name='username']"));
        WebElement username = driver.findElement(By.xpath("//input[@name='username']"));
        username.sendKeys("Admin");

        WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
        password.sendKeys("admin123");

        WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));
        loginButton.click();

        visibilityOfElement(By.cssSelector("div[class='orangehrm-edit-employee-image']"));
        WebElement picture = driver.findElement(By.cssSelector("div[class='orangehrm-edit-employee-image']"));
        picture.click();

        visibilityOfElement(By.xpath("(//button[@type='button'])[2]"));
        WebElement uploadPicture = driver.findElement(By.xpath("(//button[@type='button'])[2]"));
        uploadPicture.click();

        robot = new Robot();

        setWait(2);

        StringSelection stringSelection = new StringSelection("https://github.com/SDETEngineers2019/HRMOrange/blob/master/src/test/java/UserStories/picture.jpg?raw=true");
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(stringSelection, stringSelection);

        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);

        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);

        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);

        visibilityOfElement(By.xpath("//span[text()='Attachment Size Exceeded']"));
        WebElement errorMessage = driver.findElement(By.xpath("//span[text()='Attachment Size Exceeded']"));
        String actualMessage = errorMessage.getText();
        Assert.assertEquals(actualMessage, "Attachment Size Exceeded", "The test is failed");

    }
}
