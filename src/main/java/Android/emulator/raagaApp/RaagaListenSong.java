package Android.emulator.raagaApp;

import driver.appDriverAndroidDevice;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.junit.Test;


/**
 * Created by jgarzon on 13/07/17.
 */
public class RaagaListenSong {


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

            //Most popular

            driver.findElementByAndroidUIAutomator("text(\"MOST POPULAR\")").click();
            driver.findElementByAndroidUIAutomator("text(\"Kirik Party\")").click();
            driver.findElementById("com.raaga.android:id/fab").click();
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
