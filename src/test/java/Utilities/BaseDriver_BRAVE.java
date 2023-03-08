package Utilities;

import Utilities.Tools.Tools_Burak;
import Utilities.Tools.Tools_Busra;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.io.IOException;
import java.time.Duration;
import java.util.logging.Level;
import java.util.logging.Logger;


public class BaseDriver_BRAVE {
    public WebDriver driver;
    public WebDriverWait wait;


     @BeforeClass()
     @Parameters("browser")
    public void startingSettings(String browser) {

        System.out.println("The start settings has been started");
        Logger logger = Logger.getLogger("");
        logger.setLevel(Level.SEVERE);

        if (browser.equalsIgnoreCase("Chrome")) {
            System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("Firefox")) {
            System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "/dev/null");
            driver = new FirefoxDriver();
        } else {
            WebDriverManager.chromedriver().setup();
            ChromeOptions opt = new ChromeOptions();
            opt.setBinary("C:/Program Files/BraveSoftware/Brave-Browser/Application/brave.exe");
            driver = new ChromeDriver(opt);
        }

        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    @AfterClass(alwaysRun = true)
    public void finishSettings() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.quit();
        try {
            Runtime.getRuntime().exec("taskkill /F /IM chromedriver.exe /T");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
