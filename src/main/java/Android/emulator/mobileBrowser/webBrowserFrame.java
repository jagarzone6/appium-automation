package Android.emulator.mobileBrowser;

import driver.webBrowserDriverAndroidDevice;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.junit.Test;

import java.util.List;


/**
 * Created by jgarzon on 13/07/17.
 */
public class webBrowserFrame {


    @Test
    public static void main(String[] args) {

        webBrowserDriverAndroidDevice app= new webBrowserDriverAndroidDevice("Chrome","https://fantasycricket.dream11.com/in/");
        AndroidDriver<AndroidElement> driver = app.capabilities();

        /* x-path
        *  //tagName[@attribute='value']
        *  //className[@attribute='value']
        * */
        try {

            //SWITCH TO FRAME
            List<AndroidElement> frames = driver.findElementsByTagName("iframe");
            int framecount = frames.size();
            System.out.println("# of frames: "+framecount);

            for(AndroidElement frame: frames){
                driver.switchTo().frame(frame);
            }

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
