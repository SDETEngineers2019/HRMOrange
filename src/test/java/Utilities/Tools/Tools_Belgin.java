package Utilities.Tools;

import Utilities.BaseDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.awt.*;
import java.time.Duration;

public class Tools_Belgin extends BaseDriver {

    public static WebDriverWait wait;
    public static Robot robot;

    public void login(){
        driver.get(" https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        visibilityOfElement(By.xpath("//input[@name='username']"));
        WebElement username = driver.findElement(By.xpath("//input[@name='username']"));
        username.sendKeys("Admin");

        WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
        password.sendKeys("admin123");

        WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));
        loginButton.click();
    }

    public void sendKeysMethod(WebElement element, String keys){
        waitUntilVisible(element);
        element.clear();
        element.sendKeys(keys);
    }

    public void waitUntilVisible(WebElement element){
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitUntilClickable(WebElement element){
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void clickMethod(WebElement element){
        waitUntilClickable(element);
        element.click();
    }

    public void verifyContainsText(WebElement element, String value){
        waitUntilVisible(element);
        Assert.assertTrue(element.getText().contains(value), "Test is failed");
    }

    public void visibilityOfElement(By locator){
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void setWait(double second){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
