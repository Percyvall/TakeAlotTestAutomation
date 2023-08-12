package Accelerators;

import Utility.utils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import javax.swing.*;
import java.time.Duration;

public class ActionsClass extends Base{

    public static String browserName;
    public static boolean bResult;
    public static int Wait_Fast;
    public static Action builder;
    public static String sTestCaseName;
    public static final String TestDataPath = System.getProperty("user.dir")+ utils.getProperty("testdatapath");

    //Function to launch a browser
    public static void launchAnApplication(String url){
        try{
            driver.get(url);
        }catch (Exception e){

        }
    }

    //Function to click an element
    public static boolean clickOnElement(By object, String elementName){
        try{
            WebElement element = driver.findElement(object);
            Wait<WebDriver> wait = new FluentWait<>(driver)
                    .withTimeout(Duration.ofSeconds(10))
                    .pollingEvery(Duration.ofMillis(1000))
                    .ignoring(WebDriverException.class);
            wait.until(ExpectedConditions.elementToBeClickable(element));
            element.click();
            return true;
        }catch (Exception e){
            Assert.fail("Failed to click on" + elementName +" "+e.getMessage());
            return false;
        }
    }

    //Function to validate
    public static String getObjectText(By object, String elementName){
        String text;
        try{
            WebElement element = driver.findElement(object);
            Wait<WebDriver> wait = new FluentWait<>(driver)
                    .withTimeout(Duration.ofSeconds(10))
                    .pollingEvery(Duration.ofMillis(1000))
                    .ignoring(WebDriverException.class);
            wait.until(ExpectedConditions.elementToBeClickable(element));
            text = element.getText();
            return text;
        }catch (Exception e){
            Assert.fail("Failed to get text on" + elementName +" "+e.getMessage());
            return "Not Found";
        }
    }


    //Function to type in the text box
    public static void typeInTextBox(By object, String data, String elementName){
        try{
            if(driver.findElement(object).isDisplayed()){
                driver.findElement(object).clear();
                driver.findElement(object).sendKeys(data);
            }else {
                Assert.fail("Failed to enter data in");
            }
        }catch (Exception e){
            Assert.fail("Failed to enter data in" +e.getMessage());
        }
    }

    //Function to verify that the element is displayed
    public static boolean isElementVisible(By object, String elementName) throws Throwable{
        try{
            WebElement element = driver.findElement(object);
            Wait<WebDriver> wait = new FluentWait<>(driver)
                    .withTimeout(Duration.ofSeconds(10))
                    .pollingEvery(Duration.ofMillis(1000))
                    .ignoring(WebDriverException.class);
            wait.until(ExpectedConditions.visibilityOf(element));
            return true;
        }catch (Exception e){
            Assert.fail("Failed, element is not visible on screen "+e.getMessage());
            return false;
        }
    }
}
