package Android.realDevice.raagaApp;

import driver.appInvokeDriverAndroidDevice;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.junit.Test;


/**
 * Created by jgarzon on 13/07/17.
 */
public class RaagaTappingOnOff {


    @Test
    public static void main(String[] args) {

        appInvokeDriverAndroidDevice app= new appInvokeDriverAndroidDevice("com.raaga.android","com.raaga.android.SplashScreen");
        AndroidDriver<AndroidElement> driver = app.capabilities();

        /* x-path
        *  //tagName[@attribute='value']
        *  //className[@attribute='value']
        * */
        try {

            driver.findElementById("com.raaga.android:id/skip_text").click();
            driver.findElementById("com.raaga.android:id/landing_skip_to_raaga").click();
            driver.findElementById("com.raaga.android:id/gotit_btn").click();

            driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Kannada\"))").click();

            //Tapping on-off from push notifications

            driver.findElementById("com.raaga.android:id/toolbar_logo").click();

            driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(resourceId(\"com.raaga.android:id/menu_settings_btn\"))").click();

            driver.findElementById("com.raaga.android:id/app_features").click();


            //driver.findElementById("com.raaga.android:id/app_push").click();
            //AndroidElement toggleButton = driver.findElementById("com.raaga.android:id/toggle_notifyrecommend");

            //TouchAction t=new TouchAction(driver);

            //t.tap(toggleButton.getCenter().getX()+50,toggleButton.getCenter().getY()).perform();
            //t.tap(toggleButton.getCenter().getX()-50,toggleButton.getCenter().getY()).perform();

            driver.quit();

        }catch (Exception e) {
            System.out.println("\n\rERROR:   ");
            System.out.println(e);
            //driver.closeApp();
            driver.quit();
        }
    }


}
