package UserStories;

import Utilities.BaseDriver;
import Utilities.Tools.Tools_Muhammet;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class UserStory_Muhammet extends Tools_Muhammet {

    // Test Steps

    //1-In the login Panel, enter the username
    //2-Enter the Password for the ESS-User account in the password field
    //3-Click "Login" button

    //Expected Results:
    //The user is logged in successfully.

    @Test
    void successfulLogged(){

        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(1000));


        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username")));

        WebElement username = driver.findElement(By.name("username"));
        username.sendKeys("Admin");

        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("admin123");

        WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));
        loginButton.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Admin']")));
        WebElement userDropdownName = driver.findElement(By.xpath("//span[text()='Admin']"));

        Assert.assertTrue(userDropdownName.isDisplayed());
        Assert.assertEquals(userDropdownName.getText(), "Admin");


    }


}
