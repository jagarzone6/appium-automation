package deskBrowser;

import driver.webBrowserDriverAndroidDevice;
import driver.webBrowserDriverDesktop;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;


/**
 * Created by jgarzon on 13/07/17.
 */
public class webBrowserFrame {


    @Test
    public static void main(String[] args) {

        webBrowserDriverDesktop driverDesktop = new webBrowserDriverDesktop("https://fantasycricket.dream11.com/in/");
        WebDriver driver=  driverDesktop.capabilities();
        /* x-path
        *  //tagName[@attribute='value']
        *  //className[@attribute='value']
        * */
        try {

            //SWITCH TO FRAME
            List<WebElement> frames = driver.findElements(By.tagName("iframe"));
            int framecount = frames.size();
            System.out.println("# of frames: "+framecount);

            for(WebElement frame: frames){
                driver.switchTo().frame(frame);
                driver.findElement(By.xpath("")).click();
            }

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
