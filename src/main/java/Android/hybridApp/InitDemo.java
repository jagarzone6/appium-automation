package Android.hybridApp;

import driver.appDriverAndroidDevice;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

/**
 * Created by jagarzone on 7/08/17.
 */
public class InitDemo {
    public static void main(String[] args) {

        appDriverAndroidDevice app= new appDriverAndroidDevice("testApp.apk");
        AndroidDriver<AndroidElement> driver = app.capabilities();

        try{



        driver.quit();
        }
        catch (Exception e) {
        System.out.println("\n\rERROR:   ");
        System.out.println(e);
        //driver.closeApp();
        driver.quit();

        }


    }
}
