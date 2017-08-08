package Android.hybridApp;

import driver.appDriverAndroidDevice;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;

import java.util.Set;

/**
 * Created by jagarzone on 7/08/17.
 */
public class InitDemo {
    public static void main(String[] args) {

        //appDriverAndroidDevice app= new appDriverAndroidDevice("testApp.apk");
        appDriverAndroidDevice app= new appDriverAndroidDevice("ApiDemos-debug.apk");
        AndroidDriver<AndroidElement> driver = app.capabilities();

        try{
            System.out.println("APP Context : "+driver.getContext());
            //driver.findElementById("com.example.testapp:id/urlField").sendKeys("http://google.com");
            //driver.findElementById("com.example.testapp:id/goButton").click();

            AndroidElement Views = driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Views\"))");
            Views.click();

            AndroidElement webView = driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"WebView\"))");
            webView.click();

            driver.findElement(By.id("android:id/action_bar")).click();
            //SWITCH VIEW
            Set<String> setViews = driver.getContextHandles();
            System.out.println("APP views : "+setViews);

            // "Enable view attribute inspection" in "Developer Options" on Android device.
            driver.context("WEBVIEW_io.appium.android.apis");

            driver.findElement(By.partialLinkText("Hello World! - 1")).click();

            driver.context("NATIVE_APP");

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
