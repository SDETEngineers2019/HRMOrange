package Utilities.Tools;

import Utilities.BaseDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;

public class Tools_Busra extends BaseDriver {

public static WebDriverWait wait;

    public void visibilityOfElement(By locator){
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

}
