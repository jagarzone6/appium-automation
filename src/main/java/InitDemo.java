import driver.appDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.junit.Test;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;


/**
 * Created by jgarzon on 13/07/17.
 */
public class InitDemo {


    @Test
    public static void main(String[] args) {

        appDriver app= new appDriver();
        AndroidDriver<AndroidElement> driver = app.capabilities();

        /* x-path
        *  //tagName[@attribute='value']
        *  //className[@attribute='value']
        * */
        try {


            AndroidElement preference = driver.findElementByXPath("//android.widget.TextView[@text='Preference']");
            preference.click();
            AndroidElement preferenceoption = driver.findElementByXPath("//android.widget.TextView[@text='3. Preference dependencies']");
            preferenceoption.click();

            driver.findElementById("android:id/checkbox").click();

            driver.findElementByXPath("(//android.widget.RelativeLayout)[2]").click();

            driver.findElementById("android:id/edit").sendKeys("wifi-text");
            List<AndroidElement> buttonsWifi = driver.findElementsByClassName("android.widget.Button");
            buttonsWifi.get(1).click();

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
