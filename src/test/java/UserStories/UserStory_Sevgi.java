package UserStories;

import Utilities.Tools.Tools_Sevgi;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class UserStory_Sevgi extends Tools_Sevgi {
    @Test
            void TC_MI_MIM_02() throws InterruptedException {
        WebDriver driver =new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(30));

        driver.get("https://opensource-demo.orangehrmlive.com/");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Username']")));
        WebElement userName = driver.findElement(By.xpath("//input[@placeholder='Username']"));
        userName.sendKeys("Admin");

        WebElement password = driver.findElement(By.xpath("//input[@placeholder='Password']"));
        password.sendKeys("admin123");
        Thread.sleep(3000);

        WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));
        loginButton.click();

        WebElement myInfo= driver.findElement(By.xpath("(//a[@class='oxd-main-menu-item'])[6]"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[@class='oxd-main-menu-item'])[6]")));
        myInfo.click();
        WebElement employeeFullName =driver.findElement(By.xpath("//label[text()='Employee Full Name']"));
        driver.findElement(By.xpath("//input[@name='firstName']"));
        Thread.sleep(3000);
        Actions actions =new Actions(driver);
        actions.click(driver.findElement(By.xpath("//input[@name='firstName']"))).keyDown(Keys.CONTROL).sendKeys("a").
                keyUp(Keys.CONTROL).sendKeys(Keys.BACK_SPACE).sendKeys("Tom").build().perform();

        WebElement saveButton=driver.findElement(By.xpath("//button[@type='submit']"));
        Thread.sleep(2000);
        saveButton.click();
        Thread.sleep(3000);
        driver.navigate().refresh();
        Assert.assertEquals("Tom","Tom");
        System.out.println("actual name ==>Tom");
    }

}
