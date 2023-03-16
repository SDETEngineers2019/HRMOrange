package UserStories;

import Utilities.Tools.Tools_Cagdas;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UserStory_Cagdas extends Tools_Cagdas {
    /**
     * 1. In the login Panel, enter the username
     *
     * 2. Enter the Password for the ESS-User account in the password field
     *
     * 3. Click "Login" button
     *
     * 4. Check the fields on the "Personal information Page"
     * */

    @Test
    void checkTheFieldsOnThePersonalInformationPage(){
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        visibilityOfElement(By.xpath("//input[@name='username']"));
        WebElement username = driver.findElement(By.xpath("//input[@name='username']"));
        username.sendKeys("Admin");

        WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
        password.sendKeys("admin123");

        WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));
        loginButton.click();

        visibilityOfElement(By.xpath("//span[text()='My Info']"));
        WebElement myInfo = driver.findElement(By.xpath("//span[text()='My Info']"));
        myInfo.click();

        visibilityOfElement(By.xpath("//label[text()='Employee Id']"));
        WebElement employeeId = driver.findElement(By.xpath("//label[text()='Employee Id']"));
        if (employeeId.isDisplayed()) System.out.println("Verification of Employee Id is passed");

        WebElement ssnNo = driver.findElement(By.xpath("//label[text()='SSN Number']"));
        if (ssnNo.isDisplayed()) System.out.println("Verification of SSN Number is passed");

        WebElement sinNo = driver.findElement(By.xpath("//label[text()='SIN Number']"));
        if (sinNo.isDisplayed()) System.out.println("Verification of SIN Number is passed");

        WebElement driverLicenseNo = driver.findElement(By.xpath("//label[text()=\"Driver\'s License Number\"]"));
        if (driverLicenseNo.isDisplayed()) System.out.println("Verification of Driver's License Number is passed");

        WebElement dateOfBirth = driver.findElement(By.xpath("//label[text()='Date of Birth']"));
        if (dateOfBirth.isDisplayed()) System.out.println("Verification of Date of Birth is passed");

    }
}
