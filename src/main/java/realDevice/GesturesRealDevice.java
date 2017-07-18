package realDevice;

import driver.basics.appDriverRealDevice;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


/**
 * Created by jgarzon on 13/07/17.
 */
public class GesturesRealDevice {

    @Test
    public static void main(String[] args) {

        appDriverRealDevice app= new appDriverRealDevice();
        AndroidDriver<AndroidElement> driver = app.capabilities();

        try {
            AndroidElement Views = driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Views\"))");
            Views.click();

            TouchAction t=new TouchAction(driver);

            AndroidElement expandableLists = driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Expandable Lists\"))");

            t.tap(expandableLists).perform();
            driver.findElementByXPath("//android.widget.TextView[@text='1. Custom Adapter']").click();
            //List<AndroidElement> options = driver.findElementsByClassName("android.widget.TextView");
            AndroidElement opt = driver.findElementByXPath("//android.widget.TextView[@text='People Names']");
            opt.click();
            t=new TouchAction(driver);

            t.longPress(opt,app.getSecondDuration()).perform();

            assertEquals(driver.findElementById("android:id/alertTitle").getText(),"Sample menu");
            assertEquals(driver.findElementById("android:id/title").getText(),"Sample action");

            driver.quit();

        }catch (Exception e) {
            System.out.println("\n\rERROR:   ");
            System.out.println(e);
            driver.quit();
        }
    }


}
