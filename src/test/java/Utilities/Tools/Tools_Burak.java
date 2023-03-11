package Utilities.Tools;

import Utilities.BaseDriver;
import Utilities.BaseDriver_BRAVE;
import dev.failsafe.internal.util.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import static Utilities.BaseDriver.driver;
import static Utilities.Tools.Tools_Berk.wait;

public class Tools_Burak extends BaseDriver_BRAVE {
    JavascriptExecutor js = (JavascriptExecutor) driver;;
    Robot r2d2;

    public void scrollToElement_Tools(WebElement element) {
       // js = (JavascriptExecutor) driver;

        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public void clickElementFromDOM_I_GUES_IDK_Tools(WebElement element) {
        js = (JavascriptExecutor) driver;

        js.executeScript("arguments[0].click();", element);
    }

    public void waitUntilElementToBeVisible_Tools(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitUntilClickable_Tools(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void visibilityOfElementLocated_Tools(By path) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(path));
    }

    public void waitUntilElementToBeClickable_Tools(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void clickElement_Tools(WebElement element) {
        waitUntilElementToBeClickable_Tools(element);
        scrollToElement_Tools(element);
        element.click();
    }

    public void sendKeysElement_Tools(WebElement element, String value) {
        waitUntilElementToBeVisible_Tools(element);
        scrollToElement_Tools(element);
        element.sendKeys(value);
    }

    public void r2d2_TAB_AND_ENTER_Tools(int TAB, int Enter) throws AWTException {
        r2d2 = new Robot();

        for (int i=0; i < TAB; i++){
            r2d2.keyPress(KeyEvent.VK_TAB);
            r2d2.keyRelease(KeyEvent.VK_TAB);
        }
        for (int i=0; i < Enter; i++){
            r2d2.keyPress(KeyEvent.VK_ENTER);
            r2d2.keyRelease(KeyEvent.VK_ENTER);
        }
        r2d2.setAutoDelay(2000);
    }
    public void stringSelection_Tools(String path){
        StringSelection selection = new StringSelection(path);
        Clipboard cb = Toolkit.getDefaultToolkit().getSystemClipboard();
        cb.setContents(selection,selection);

        r2d2.keyPress(KeyEvent.VK_CONTROL);
        r2d2.keyPress(KeyEvent.VK_V);

        r2d2.keyRelease(KeyEvent.VK_CONTROL);
        r2d2.keyRelease((KeyEvent.VK_V));

        r2d2.keyPress(KeyEvent.VK_ENTER);
        r2d2.keyRelease(KeyEvent.VK_ENTER);
    }
    public void verifyElementContainsText_Tools(WebElement element, String text){
        Assert.isTrue(element.getText().contains(text),"Does not contain");
    }
}
