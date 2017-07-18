package emulator.raagaApp;

import driver.appDriverAndroidDevice;
import driver.basics.appDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.junit.Test;

import java.util.List;


/**
 * Created by jgarzon on 13/07/17.
 */
public class RaagaDemo {


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