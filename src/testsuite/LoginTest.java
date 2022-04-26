package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utility.Utility;

public class LoginTest extends Utility {

    String BaseUrl = "http://the-internet.herokuapp.com/login";

    @Before
    public void setup() {
        openBrowser(BaseUrl);
    }

    @Test
    public void userSholdLoginSuccessfullyWithValidCredentials() throws InterruptedException{

        //locate and Enter “SuperSecretPassword!” password
        sendTextToElement(By.id("username"), "tomsmith");

        //locate and Enter “SuperSecretPassword!” password
        sendTextToElement(By.id("password"), "SuperSecretPassword!");

        //Click on ‘LOGIN’ button
        clickOnElement(By.xpath("//i[contains(text(),'Login')]"));

        // Verify the text “Secure Area”
        verifyExpectedAndActual(By.xpath("//body[1]/div[2]/div[1]/div[1]/h2[1]"), "Secure Area");
    }


    @Test
    public void verifyTheUsernameErrorMessage() throws InterruptedException {
        //locate and Enter “tomsmith1” username
        sendTextToElement(By.id("username"),"tomsmith1");

        //locate and Enter “SuperSecretPassword!” password
        sendTextToElement(By.id("password"),"SuperSecretPassword!");

        //Click on ‘LOGIN’ button
        clickOnElement(By.xpath("//i[contains(text(),'Login')]"));
        Thread.sleep(1000);

        // Verify the error message “Your username is invalid!”
        verifyExpectedAndActual(By.id("flash"), "Your username is invalid!");
    }


    @Test
    public void verifyThePasswordErrorMessage() throws InterruptedException {

        //locate and Enter “tomsmith” username
        sendTextToElement(By.id("username"),"tomsmith");


        //locate and Enter “SuperSecretPassword” password
        sendTextToElement(By.id("password"),"SuperSecretPassword");
        Thread.sleep(1000);

        //Click on ‘LOGIN’ button
        clickOnElement(By.xpath("//i[contains(text(),'Login')]"));
        Thread.sleep(2000);

        verifyExpectedAndActual(By.id("flash"), "Your password is invalid!");
    }


    @After
    public void teardown() {
        closeBrowser();
    }
}




