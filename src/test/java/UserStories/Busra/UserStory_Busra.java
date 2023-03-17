package UserStories.Busra;

import Utilities.Tools.Tools_Busra;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.time.Duration;

public class UserStory_Busra extends Tools_Busra{

    @Test
    @Parameters(value = "keyWord")
    void editName(String name){
        driver.get(" https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        visibilityOfElement(By.xpath("//input[@name='username']"));
        WebElement username = driver.findElement(By.xpath("//input[@name='username']"));
        username.sendKeys("Admin");

        WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
        password.sendKeys("admin123");

        WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));
        loginButton.click();

        visibilityOfElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[6]/a"));
        WebElement myInfo = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[6]/a"));
        myInfo.click();

        visibilityOfElement(By.cssSelector("input[name='firstName']"));
        WebElement firstName = driver.findElement(By.cssSelector("input[name='firstName']"));
        firstName.click();

        String actualName = firstName.getText();
        String selectAll = Keys.chord(Keys.CONTROL, "a");
        firstName.sendKeys(selectAll);
        firstName.sendKeys(Keys.DELETE);
        firstName.sendKeys(name);

        WebElement saveButton = driver.findElement(By.cssSelector("button[type='submit']"));
        saveButton.click();

        driver.navigate().refresh();

        Assert.assertNotEquals(actualName,"Mark", "test failed");

    }
}
