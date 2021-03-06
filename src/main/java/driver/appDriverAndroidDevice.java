package driver;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
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
public class appDriverAndroidDevice {
    private static URL appium_server;
    public Duration secondDuration;
    public String apkResource;

    static {
        try {
            appium_server = new URL("http://127.0.0.1:4723/wd/hub");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
    private AndroidDriver<AndroidElement> driver;

    public appDriverAndroidDevice(String apkFile) {
        this.secondDuration = Duration.ofSeconds(1);
        this.apkResource = apkFile;
    }
    public Duration getSecondDuration(){
        return this.secondDuration;
    }

    public AndroidDriver<AndroidElement> capabilities(){


// TODO Auto-generated method stub
        File f = new File("src");
        File fs =  new File(f,"main/resources/"+apkResource);
        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"DemoEmulator");
        capabilities.setCapability(MobileCapabilityType.APP,fs.getAbsolutePath());
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, Platform.ANDROID);

        driver = new AndroidDriver<>(appium_server,capabilities);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);        //xpath - id - classname - androidUIAutomator

        return driver;
    }
}
