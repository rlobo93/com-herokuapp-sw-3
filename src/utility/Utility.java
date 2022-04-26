package utility;

import browserfactory.BaseTest;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Utility extends BaseTest {

    /**
     *This method will click on element
     */
    public void clickOnElement(By by){
        WebElement element = driver.findElement(by);
        element.click();
    }

    /**
     *This method will get text from element
     */
    public String getTextFromElement(By by){
        return driver.findElement(by).getText();
    }


    /**
     * This method will send text to element
     */

    public void sendTextToElement(By by, String text) {
        driver.findElement(by).sendKeys(text);
    }

    public void sendTextToElements(By by,String text) {
        driver.findElement(by).sendKeys(text);
    }

    public int getNumberFromElement(By by) {
        List<WebElement> actualNumberElement = driver.findElements(by);
        int actualNumber = actualNumberElement.size();
        return actualNumber;
    }

    public String getSubstringTextElement(By by, double i) {
        WebElement actualMessageElement = driver.findElement(by);
        String actualMessage = actualMessageElement.getText().substring((int) i);
        return actualMessage;
    }






    //***************************Alert Methods*********************//

    /**
     * This method will switch to alert
     */
    public void switchToAlert(){
        driver.switchTo().alert();
    }
    /**
     * This method will accept to alert
     */

    public void acceptAlert(){
        driver.switchTo().alert().accept();
    }
    /**
     * This method will dismissto alert
     */

    public void dismissAlert(){
        driver.switchTo().alert().dismiss();
    }

//    public void sendKeysAlert(){
//        driver.switchTo().alert().sendKeys();
//    }



    //***********************************Drop Down*************************************************************/



    /**
     * This method will select the option by visible text
     */
    public void selectByVisibleFromDropDown(By by , String text){
        WebElement dropdown = driver.findElement(by);
        Select select = new Select(dropdown);
        select.selectByVisibleText(text);
    }
    /**
     * This method will select the option by Index
     */

    public void selectByIndexFromDropDown(By by, int i ) {
        WebElement dropdown = driver.findElement(by);
        Select select = new Select(dropdown);
        select.selectByIndex(i);
    }

    /**
     * This method will select the option by Value
     */

    public void selectByValueFromDropDown(By by , String text) {
        WebElement dropdown = driver.findElement(by);
        Select select = new Select(dropdown);
        select.selectByValue(text);
    }
//*****************************mouse hover************************************//

    public void mouseHoverToElement(By by ){
        Actions actions = new Actions(driver);
        WebElement move = driver.findElement(by);
        actions.moveToElement(move).build().perform();
    }


    public void mouseHoverAndClick(By by){
        Actions actions = new Actions(driver);
        WebElement select = driver.findElement(by);
        actions.moveToElement(select).build().perform();
        actions.moveToElement(select).click().build().perform();
    }


    //**************************************************************************************//


    public void productArrangeAlphabetically(By by){
        ArrayList<String> list = new ArrayList<>();
        List<WebElement> elementsList = driver.findElements(by);
        for (WebElement we:elementsList) {
            list.add(we.getText());
        }
        ArrayList<String> sortedList = new ArrayList<>();
        for (String s: list){
            sortedList.add(s);
        }
        Collections.sort(sortedList);
        Assert.assertTrue(sortedList.equals(list));
    }



    public void clearValue(By by){
        driver.findElement(by).clear();
    }

    public void verifyExpectedAndActual(By by, String expectedText) {
        String actualText = getTextFromElement(by);
        Assert.assertEquals(actualText, expectedText);
    }



    public void selectMenu(String menu,By by) throws InterruptedException {
        List<WebElement> names = driver.findElements(by);
        for (WebElement name : names) {
            if (name.getText().equalsIgnoreCase(menu)) {
                Thread.sleep(2000);
                name.click();
                break;
            }
        }
    }



}

