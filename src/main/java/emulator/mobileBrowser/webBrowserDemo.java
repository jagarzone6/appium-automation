package emulator.mobileBrowser;

import driver.appDriverAndroidDevice;
import driver.webBrowserDriverAndroidDevice;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


/**
 * Created by jgarzon on 13/07/17.
 */
public class webBrowserDemo {


    @Test
    public static void main(String[] args) {

        webBrowserDriverAndroidDevice app= new webBrowserDriverAndroidDevice("Chrome","http://facebook.com");
        AndroidDriver<AndroidElement> driver = app.capabilities();

        /* x-path
        *  //tagName[@attribute='value']
        *  //className[@attribute='value']
        * */
        try {

            driver.findElementByName("email").sendKeys("qwerty");
            driver.findElementByName("pass").sendKeys("12345");
            driver.findElementByName("login").click();

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
