import driver.appDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;


/**
 * Created by jgarzon on 13/07/17.
 */
public class Gestures {



    public static void main(String[] args) {

        appDriver app= new appDriver();
        AndroidDriver<AndroidElement> driver = app.capabilities();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);        //xpath - id - classname - androidUIAutomator

        try {
            AndroidElement Views = driver.findElementByXPath("//android.widget.TextView[@text='Views']");
            Views.click();
           // List<AndroidElement> options =driver.findElementsById("android:id/text1");

            TouchAction t=new TouchAction(driver);
            t.longPress(driver.findElementByXPath("//android.widget.TextView[@text='Expandable Lists']"),app.getSecondDuration()).perform();

            driver.quit();

        }catch (Exception e) {
            System.out.println("\n\rERROR:   ");
            System.out.println(e);
            driver.quit();
        }
    }


}
