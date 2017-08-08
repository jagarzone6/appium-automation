package Android.emulator.basics;

import driver.basics.appDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


/**
 * Created by jgarzon on 13/07/17.
 */
public class GesturesSwiping {

    @Test
    public static void main(String[] args) {

        appDriver app= new appDriver();
        AndroidDriver<AndroidElement> driver = app.capabilities();

        try {
            AndroidElement Views = driver.findElementByXPath("//android.widget.TextView[@text='Views']");
            Views.click();
           // List<AndroidElement> options =driver.findElementsById("android:id/text1");

            TouchAction t=new TouchAction(driver);


            t.tap(driver.findElementByXPath("//android.widget.TextView[@text='Date Widgets']")).perform();
            driver.findElementByXPath("//android.widget.TextView[@text='2. Inline']").click();
            //driver.findElementByAndroidUIAutomator("new UiSelector().descriptionContains(\"9\")").click();
            //OR SAME:
            driver.findElementByXPath("//*[@content-desc='9']").click();
            AndroidElement minuteA = driver.findElementByXPath("//*[@content-desc='45']");
            AndroidElement minuteB = driver.findElementByXPath("//*[@content-desc='0']");
            //t.press(minuteB).moveTo(minuteA).release().perform();
            driver.swipe(minuteB.getCenter().getX(),minuteB.getCenter().getY(),minuteA.getCenter().getX(),minuteA.getCenter().getY(),1500);
            driver.quit();

        }catch (Exception e) {
            System.out.println("\n\rERROR:   ");
            System.out.println(e);
            driver.quit();
        }
    }


}
