package Android.realDevice.raagaApp;

import driver.appInvokeDriverAndroidDevice;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.junit.Test;
import org.openqa.selenium.Dimension;


/**
 * Created by jgarzon on 13/07/17.
 */
public class RaagaDemo {


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

            Dimension size= driver.manage().window().getSize();
            System.out.println("screen size: h:"+ size.getHeight() + "w:" +size.getWidth());
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
