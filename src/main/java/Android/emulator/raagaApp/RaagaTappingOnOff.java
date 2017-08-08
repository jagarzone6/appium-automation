package Android.emulator.raagaApp;

import driver.appDriverAndroidDevice;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.junit.Test;


/**
 * Created by jgarzon on 13/07/17.
 */
public class RaagaTappingOnOff {


    @Test
    public static void main(String[] args) {

        appDriverAndroidDevice app= new appDriverAndroidDevice("com.raaga.android.apk");
        AndroidDriver<AndroidElement> driver = app.capabilities();

        /* x-path
        *  //tagName[@attribute='value']
        *  //className[@attribute='value']
        * */
        try {

            driver.findElementById("android:id/button2").click();
            driver.findElementById("com.raaga.android:id/skip_text").click();
            driver.findElementById("com.raaga.android:id/landing_skip_to_raaga").click();
            driver.findElementById("com.raaga.android:id/gotit_btn").click();

            driver.swipe(0,0,200,200,1);
            driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Kannada\"))").click();

            //Tapping on off from push notification

            driver.findElementById("com.raaga.android:id/toolbar_logo").click();

            driver.findElementById("com.raaga.android:id/menu_settings_btn").click();

            driver.findElementById("com.raaga.android:id/app_push").click();
            AndroidElement toggleButton = driver.findElementById("com.raaga.android:id/toggle_notifyrecommend");

            TouchAction t=new TouchAction(driver);
            int x,y;
            x=toggleButton.getCenter().getX();
            y=toggleButton.getCenter().getY();
            t.tap(x+20,y).perform();
            t.tap(x-20,y).perform();
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
