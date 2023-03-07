package UserStories;

import Utilities.Tools.Tools_Berk;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UserStory_Berk extends Tools_Berk {

    //Test Steps:

    //In the login Panel, enter the username
    //Enter the Password for the ESS-User account in the password field
    //Click "Login" button
    //Expected Result: An Error message is displayed and the user is not logged in to the Orange HRM portal. "<Exact Error Message>" saying "Invalid credentials"

    @Test
    void invalidLoginTest(){

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

}
