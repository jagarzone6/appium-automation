package Android.realDevice.basics;


import driver.basics.appDriverRealDevice;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.AndroidKeyCode;
import org.junit.Test;


/**
 * Created by jgarzon on 13/07/17.
 */
public class GesturesKeyEventsRealDevice {

    @Test
    public static void main(String[] args) {

        appDriverRealDevice app= new appDriverRealDevice();
        AndroidDriver<AndroidElement> driver = app.capabilities();
        try {
            AndroidElement Views = driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Views\"))");
            Views.click();

            //Check driver activity:
            System.out.println(driver.currentActivity());
            //Check view (native, Hybrid or Web-view )
            System.out.println(driver.getContext());
            //Check Orientation
            System.out.println(driver.getOrientation());
            //Check Locked
            System.out.println(driver.isLocked());
            //HideKeyBoard
            //driver.hideKeyboard();
            //Press Key-code
            driver.pressKeyCode(AndroidKeyCode.BACK);







            driver.quit();

        }catch (Exception e) {
            System.out.println("\n\rERROR:   ");
            System.out.println(e);
            driver.quit();
        }
    }


}
