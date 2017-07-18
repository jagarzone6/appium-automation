package realDevice;

import driver.basics.appDriverRealDevice;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.junit.Test;

import java.util.List;


/**
 * Created by jgarzon on 13/07/17.
 */
public class AndroidUIAutomatorRealDevice {


    @Test
    public static void main(String[] args) {

        appDriverRealDevice app= new appDriverRealDevice();
        AndroidDriver<AndroidElement> driver = app.capabilities();
        try {
            //driver.findElementByAndroidUIAutomator("attribute(value)");
            AndroidElement Views = driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Views\"))");
            Views.click();
            //  Validate clickable feature for all options
            //  driver.findElementsByAndroidUIAutomator("new UiSelector().property(value)");
            List<AndroidElement> options = driver.findElementsByAndroidUIAutomator("new UiSelector().clickable(true)");
            //Selects Only the elements actually in the screen, the other elements (not visible) are not selected
            System.out.println(options.size());


            driver.quit();

        }catch (Exception e) {
            System.out.println("\n\rERROR:   ");
            System.out.println(e);
            driver.quit();
        }
    }


}
