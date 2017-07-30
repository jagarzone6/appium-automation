package emulator.mobileBrowser;

import driver.webBrowserDriverAndroidDevice;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;


/**
 * Created by jgarzon on 13/07/17.
 */
public class webBrowserExample2 {


    @Test
    public static void main(String[] args) {

        webBrowserDriverAndroidDevice app= new webBrowserDriverAndroidDevice("Chrome","http://cricbuzz.com");
        AndroidDriver<AndroidElement> driver = app.capabilities();

        /* x-path
        *  //tagName[@attribute='value']
        *  //className[@attribute='value']
        * */
        try {

            driver.findElementByXPath("//a[@href='#menu']").click();
            driver.findElementByCssSelector("a[title='Cricbuzz Home']").click();
            System.out.println(driver.getCurrentUrl());

            //Scroll
            JavascriptExecutor jse = (JavascriptExecutor) driver;
            jse.executeScript("window.scrollBy(0,480)","");

            Assert.assertTrue(driver.findElementByXPath("//*[@id=\"top\"]/div/div[10]/h4").getAttribute("class").contains("header"));

            //driver.closeApp();
            driver.quit();

        }catch (Exception e) {
            System.out.println("\n\rERROR:   ");
            System.out.println(e);
            //driver.closeApp();
            driver.quit();
        }
    }


}
