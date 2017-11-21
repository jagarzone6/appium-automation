package IOSCloud;

import driver.appDriverIOSDeviceSauceWebBrowser;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;

public class Demo1 {
    public static void main(String[] args) throws InterruptedException {

        appDriverIOSDeviceSauceWebBrowser app= new appDriverIOSDeviceSauceWebBrowser("");
        IOSDriver<IOSElement> driver = app.capabilities();

        driver.get("http://cricbuzz.com");

        try {

            driver.findElementByXPath("//a[@href='#menu']").click();
            driver.findElementByCssSelector("a[title='Cricbuzz Home']").click();
            System.out.println(driver.getCurrentUrl());

            //Scroll
            JavascriptExecutor jse = (JavascriptExecutor) driver;
            jse.executeScript("window.scrollBy(0,480)","");

            Assert.assertTrue(driver.findElementByXPath("//*[@id=\"top\"]/div/div[10]/h4").getAttribute("class").contains("header"));

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
