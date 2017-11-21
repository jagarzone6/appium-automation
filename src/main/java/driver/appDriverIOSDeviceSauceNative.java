package driver;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

/**
 * Created by jgarzon on 13/07/17.
 */
public class appDriverIOSDeviceSauceNative {
    private static URL sauce_lab_server;
    public Duration secondDuration;
    public String apkResource;

    static {
        try {
            sauce_lab_server =new URL("http://jagarzone2:92f5c1a7-89c8-4cf4-8581-008973821939@ondemand.saucelabs.com:80/wd/hub") ;
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
    private IOSDriver<IOSElement> driver;

    public appDriverIOSDeviceSauceNative(String apkFile) {
        this.secondDuration = Duration.ofSeconds(1);
        this.apkResource = apkFile;
    }
    public Duration getSecondDuration(){
        return this.secondDuration;
    }

    public IOSDriver<IOSElement> capabilities(){


// TODO Auto-generated method stub
        File f = new File("src");
        File fs =  new File(f,"main/resources/"+apkResource);

        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability(MobileCapabilityType.APP,fs.getAbsolutePath());

        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "iOS");

        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "9.0");

        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"iPhone Simulator");

        //capabilities.setCapability(MobileCapabilityType.APPIUM_VERSION,"5.0.0-BETA9");

        //capabilities.setCapability(MobileCapabilityType.BROWSER_NAME,"Safari");



        driver = new IOSDriver<IOSElement>(sauce_lab_server,capabilities);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);        //xpath - id - classname - androidUIAutomator

        return driver;
    }
}
