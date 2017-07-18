package emulator.basics;

import driver.basics.appDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


/**
 * Created by jgarzon on 13/07/17.
 */
public class Gestures {

    @Test
    public static void main(String[] args) {

        appDriver app= new appDriver();
        AndroidDriver<AndroidElement> driver = app.capabilities();

        try {
            AndroidElement Views = driver.findElementByXPath("//android.widget.TextView[@text='Views']");
            Views.click();
           // List<AndroidElement> options =driver.findElementsById("android:id/text1");

            TouchAction t=new TouchAction(driver);


            t.tap(driver.findElementByXPath("//android.widget.TextView[@text='Expandable Lists']")).perform();
            driver.findElementByXPath("//android.widget.TextView[@text='1. Custom Adapter']").click();
            //List<AndroidElement> options = driver.findElementsByClassName("android.widget.TextView");
            AndroidElement opt = driver.findElementByXPath("//android.widget.TextView[@text='People Names']");
            opt.click();
            t=new TouchAction(driver);

            t.longPress(opt,app.getSecondDuration()).perform();

            assertEquals(driver.findElementById("android:id/title").getText(),"Sample menu");
            driver.quit();

        }catch (Exception e) {
            System.out.println("\n\rERROR:   ");
            System.out.println(e);
            driver.quit();
        }
    }


}
