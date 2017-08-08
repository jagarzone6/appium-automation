package Android.realDevice.basics;

import driver.basics.appDriverRealDevice;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.junit.Test;


/**
 * Created by jgarzon on 13/07/17.
 */
public class GesturesScrollingRealDevice {

    @Test
    public static void main(String[] args) {

        appDriverRealDevice app= new appDriverRealDevice();
        AndroidDriver<AndroidElement> driver = app.capabilities();
        try {
            AndroidElement Views = driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Views\"))");
            Views.click();

            AndroidElement lastElementScroll = driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"WebView\"))");
            lastElementScroll.click();

            driver.quit();

        }catch (Exception e) {
            System.out.println("\n\rERROR:   ");
            System.out.println(e);
            driver.quit();
        }
    }


}
