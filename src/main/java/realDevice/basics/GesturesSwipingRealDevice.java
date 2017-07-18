package realDevice.basics;

import driver.basics.appDriverRealDevice;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.junit.Test;


/**
 * Created by jgarzon on 13/07/17.
 */
public class GesturesSwipingRealDevice {

    @Test
    public static void main(String[] args) {

        appDriverRealDevice app= new appDriverRealDevice();
        AndroidDriver<AndroidElement> driver = app.capabilities();
        try {
            AndroidElement Views = driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Views\"))");
            Views.click();

            TouchAction t=new TouchAction(driver);

            AndroidElement dateWidgets = driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Date Widgets\"))");


            t.tap(dateWidgets).perform();
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
