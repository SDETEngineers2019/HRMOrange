package Utilities.Tools;

import Utilities.ParameterDriverClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;


public class Tools_Muhammet extends ParameterDriverClass {

    public static WebDriverWait wait;

    public void waitUntilClickable(WebElement element){
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void clickMethod(WebElement element){
        waitUntilClickable(element);
        element.click();
    }

    public void waitUntilVisible(WebElement element){
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void verifyDisplayedElements(WebElement element){
        waitUntilVisible(element);
        Assert.assertTrue(element.isDisplayed(), "Test is failed");
    }



}

