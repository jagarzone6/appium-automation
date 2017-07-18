package driver;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

/**
 * Created by jgarzon on 13/07/17.
 */
public class appInvokeDriverAndroidDevice {
    private static URL appium_server;
    public Duration secondDuration;
    public String appPackage;
    public String appMainActivity;

    static {
        try {
            appium_server = new URL("http://127.0.0.1:4723/wd/hub");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
    private AndroidDriver<AndroidElement> driver;

    public appInvokeDriverAndroidDevice(String appPackage_,String appMainActivity_) {
        this.secondDuration = Duration.ofSeconds(1);
        this.appPackage = appPackage_;
        this.appMainActivity = appMainActivity_;
    }
    public Duration getSecondDuration(){
        return this.secondDuration;
    }

    public AndroidDriver<AndroidElement> capabilities(){


// TODO Auto-generated method stub

        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"Android device");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, Platform.ANDROID);
        capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE,appPackage);
        capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY,appMainActivity);

        driver = new AndroidDriver<>(appium_server,capabilities);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);        //xpath - id - classname - androidUIAutomator

        return driver;
    }
}
