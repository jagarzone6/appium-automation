package IOSCloud;

import driver.appDriverIOSDeviceSauce;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;

public class Demo1 {
    public static void main(String[] args) throws InterruptedException {

        appDriverIOSDeviceSauce app= new appDriverIOSDeviceSauce("");
        IOSDriver<IOSElement> driver = app.capabilities();

        driver.get("http://google.com");
        Thread.sleep(8000L);
    }
}
