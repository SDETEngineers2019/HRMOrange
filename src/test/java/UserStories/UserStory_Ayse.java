package UserStories;

import Utilities.BaseDriver;
import Utilities.Tools.Tools_Ayse;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class UserStory_Ayse extends Tools_Ayse {


//    Test Steps:
//
// 1- Click on the photograph displayed at the top left corner of the page
//2- Click on "Choose a file" button
//3- Choose a image file of type "JPG" that is less than 1 MB
//4- Click on upload
//
//    Expected Results:
//    The "Photograph screen" will be displayed
//    You will be able to browse your local machine for images
//    The file name is selected in the "Choose a file" box
//    The file gets uploaded and the older image is replaced


    @Test
    void uploadingPhotoLessThan1MB() throws InterruptedException {

        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        Thread.sleep(3000);

        WebElement userName = driver.findElement(By.xpath("//input[@name='username']"));
        userName.sendKeys("Admin");

        WebElement password = driver.findElement(By.cssSelector("input[type='password']"));
        password.sendKeys("admin123");

        WebElement logIn = driver.findElement(By.xpath("//button[@type='submit']"));
        logIn.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='My Info']")));

        WebElement myInfo = driver.findElement(By.xpath("//span[text()='My Info']"));
        myInfo.click();
        wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@class='employee-image']")));
        Thread.sleep(2000);

        WebElement pic = driver.findElement(By.xpath("//img[@class='employee-image']"));
        pic.click();
        Thread.sleep(2000);

        WebElement chooseFile = driver.findElement(By.cssSelector("input[type='file']"));
        chooseFile.sendKeys("C:\\Users\\ayse\\IdeaProjects\\JavaProjects\\HRMOrange2\\src\\test\\java\\UserStories\\dogyeni.jpg");
        Thread.sleep(2000);

        WebElement saveButton = driver.findElement(By.xpath("//button[@type='submit']"));
        saveButton.click();
        driver.quit();

    }
}



