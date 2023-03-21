package UserStories.Sevgi;
import Utilities.Tools.Tools_Sevgi;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class ValidationUSerNAmeAndPAssWord extends Tools_Sevgi{

     /*1-
As an Admin user I should be able to create an ESS user account so that ESS user will be having his own valid username and valid password.
Step 1 – I login as an Admin
Step 2 – I navigate to Admin / User Management page.
Step 3 – I click on Add button
Step 4 – I fill up the form by entering the required info to the all input boxes
Step 5 – I click on Save button
Step 6 – I verify that ESS – userName is added on the list
*/


     @Test

    void AddInput() throws InterruptedException {

          driver.get("https://opensource-demo.orangehrmlive.com/");


          wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Username']")));
         WebElement userName = driver.findElement(By.xpath("//input[@placeholder='Username']"));
         userName.sendKeys("Admin");

         WebElement password = driver.findElement(By.xpath("//input[@placeholder='Password']"));
         password.sendKeys("admin123");
         Thread.sleep(3000);

         WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));
         loginButton.click();

         WebElement adminButton =driver.findElement(By.xpath("//span[@class='oxd-text oxd-text--span oxd-main-menu-item--name']"));
         wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='oxd-text oxd-text--span oxd-main-menu-item--name']")));
         adminButton.click();

         WebElement addButton =driver.findElement(By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--secondary']"));
         wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--secondary']")));
         addButton.click();

         Thread.sleep(2000);
         WebElement ddmMnu = driver.findElement(By.xpath("(//div[@class='oxd-select-text--after'])[1]"));
         ddmMnu.click();

         Thread.sleep(2000);
         List<WebElement> elements = driver.findElements(By.xpath("//div[@role='listbox']//child::*"));
         for(WebElement el : elements){
             System.out.println(el.getText());
         }
         elements.get(3).click();

         Thread.sleep(2000);
         WebElement menu2 = driver.findElement(By. xpath("(//div[@class='oxd-select-wrapper'])[2]"));
         menu2.click();
         List<WebElement> elements2 = driver.findElements(By.xpath("//div[@role='listbox']//child::*"));
         for(WebElement el : elements2){
             System.out.println(el.getText());
         }
         elements2.get(2).click();


         Thread.sleep(1000);
         WebElement epname = driver.findElement(By.xpath("//input[@placeholder='Type for hints...']"));
         epname.click();

         epname.sendKeys("O");
         Thread.sleep(3000);
         WebElement epName= driver.findElement(By.xpath("//span[text()='Odis  Adalwin']"));
         Thread.sleep(2000);
         epName.click();

         Actions actions=new Actions(driver);
         WebElement usernameButton= driver.findElement(By.xpath("(//input[@class='oxd-input oxd-input--active'])[2]"));
         actions.moveToElement(usernameButton).click().sendKeys("GERRY").build().perform();
         WebElement passwordButton=driver.findElement(By.xpath("(//input[@type='password'])[1]"));
         actions.moveToElement(passwordButton).click().sendKeys("Gerry123.").build().perform();
         WebElement confirmPassword=driver.findElement(By.xpath("(//input[@type='password'])[2]"));
         actions.moveToElement(confirmPassword).click().sendKeys("Gerry123.").build().perform();
         WebElement submitButton=driver.findElement(By.xpath("//button[@type='submit']"));
         submitButton.click();
         Thread.sleep(3000);
         Assert.assertTrue(usernameButton.isDisplayed(), "GERRY");










     }
}
