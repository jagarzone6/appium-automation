import driver.appDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

import java.util.List;
import java.util.concurrent.TimeUnit;


/**
 * Created by jgarzon on 13/07/17.
 */
public class AndroidUIAutomator {



    public static void main(String[] args) {

        appDriver app= new appDriver();
        AndroidDriver<AndroidElement> driver = app.capabilities();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);        //xpath - id - classname - androidUIAutomator

        try {
            //driver.findElementByAndroidUIAutomator("attribute(value)");
            driver.findElementByAndroidUIAutomator("text(\"Views\")").click();

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
