package Utilities.Tools;

import Utilities.BaseDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.time.Duration;

public class Tools_Berk extends BaseDriver {


    public static WebDriverWait wait;

//    @BeforeClass(alwaysRun = true)
//   @Parameters(value = "browser")
//    public void startingSettings(String browserName) {
//
//       if (browserName.equalsIgnoreCase("chrome")) {
//           driver = new ChromeDriver();
//       } else if (browserName.equalsIgnoreCase("firefox")) {
//            driver = new FirefoxDriver();
//        }
//       driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
//       wait = new WebDriverWait(driver, Duration.ofSeconds(30));
//       driver.manage().window().maximize();
//
//    }

////    @AfterClass(alwaysRun = true)
////    public void finishSettings(){
////        try {
////            Thread.sleep(3000);
////        } catch (InterruptedException e) {
////            throw new RuntimeException(e);
////        }
////        driver.quit();
////    }
////
}