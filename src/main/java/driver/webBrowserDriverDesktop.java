package driver;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

/**
 * Created by jgarzon on 13/07/17.
 */
public class webBrowserDriverDesktop {
    public Duration secondDuration;
    public String appURL;

    private WebDriver driver;

    public webBrowserDriverDesktop( String  url) {
        this.secondDuration = Duration.ofSeconds(1);
        this.appURL = url;
    }
    public Duration getSecondDuration(){
        return this.secondDuration;
    }

    public WebDriver capabilities(){


// TODO Auto-generated method stub
        System.setProperty("webdriver.gecko.driver", "src/main/resources/driversDesk/geckodriver");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);        //xpath - id - classname - androidUIAutomator
        driver.get(appURL);
        return driver;
    }
}
