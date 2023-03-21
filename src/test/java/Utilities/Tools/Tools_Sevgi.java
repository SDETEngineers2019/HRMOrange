package Utilities.Tools;

import Utilities.BaseDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;

public class Tools_Sevgi extends BaseDriver {


    public static WebDriver driver;

        public static WebDriverWait wait;


        public void login(){
            driver.get(" https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");


            WebElement username = driver.findElement(By.xpath("//input[@name='username']"));
            username.sendKeys("Admin");

            WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
            password.sendKeys("admin123");

            WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));
            loginButton.click();
        }





    @BeforeClass(alwaysRun = true)
    public void startingSettings() {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        wait = new WebDriverWait(driver,Duration.ofSeconds(30));
        driver.manage().window().maximize();

        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        // login();
    }


    @AfterClass(alwaysRun = true)
    public void finishSettings(){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        //driver.quit();
    }



}



