package UserStories;

import Utilities.BaseDriver;
import Utilities.Tools.Tools_Berk;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class UserStory_Berk extends Tools_Berk {

    //Test Steps:

    @Test
    void invalidLoginTest(){

        wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='username']")));

        WebElement username = driver.findElement(By.xpath("//input[@name='username']"));
        username.sendKeys("Test123");

        WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
        password.sendKeys("Test123");

        //<button type="submit" class="oxd-button oxd-button--medium oxd-button--main orangehrm-login-button" data-v-7e88b27e="" data-v-30b9e6c4=""><!----> Login <!----></button>
        WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));
        loginButton.click();

        ////*[@id="app"]/div[1]/div/div[1]/div/div[2]/div[2]/div/div[1]/div[1]/p

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.oxd-alert--error")));

        WebElement invalidText = driver.findElement(By.cssSelector("div.oxd-alert--error"));

        Assert.assertTrue(invalidText.isDisplayed());
        Assert.assertEquals(invalidText.getText(), "Invalid credentials");

    }

    @Test
    void userManagementPageTest(){
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='username']")));

        WebElement username = driver.findElement(By.xpath("//input[@name='username']"));
        username.sendKeys("Admin");

        WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
        password.sendKeys("admin123");

        WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));
        loginButton.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class=\"oxd-text oxd-text--span oxd-main-menu-item--name\"]")));

        WebElement adminButton = driver.findElement(By.xpath("//span[@class=\"oxd-text oxd-text--span oxd-main-menu-item--name\"]"));
        adminButton.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class=\"oxd-button oxd-button--medium oxd-button--secondary\"]")));
        WebElement addButton = driver.findElement(By.xpath("//button[@class=\"oxd-button oxd-button--medium oxd-button--secondary\"]"));
        addButton.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='oxd-layout-context']//h6")));
        WebElement addUserHeader = driver.findElement(By.xpath("//div[@class='oxd-layout-context']//h6"));

        Assert.assertTrue(addUserHeader.isDisplayed());

    }

}