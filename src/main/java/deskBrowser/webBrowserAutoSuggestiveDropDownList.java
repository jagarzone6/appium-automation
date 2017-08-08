package deskBrowser;

import driver.webBrowserDriverDesktop;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;


/**
 * Created by jgarzon on 13/07/17.
 */
public class webBrowserAutoSuggestiveDropDownList {


    @Test
    public static void main(String[] args) {

        webBrowserDriverDesktop driverDesktop = new webBrowserDriverDesktop("https://fantasycricket.dream11.com/in/");
        WebDriver driver=  driverDesktop.capabilities();
        /* x-path
        *  //tagName[@attribute='value']
        *  //className[@attribute='value']
        * */
        try {
            driver.findElement(By.id("m_rtxtEmail1")).sendKeys("jagar");
            WebDriverWait dw = new WebDriverWait(driver,1);
            dw.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"m_frmRegister\"]/div[1]/ul")));
            String emailSuggested = driver.findElement(By.xpath("//*[@id=\"m_frmRegister\"]/div[1]/ul/li[3]")).getText();
            driver.findElement(By.xpath("//*[@id=\"m_frmRegister\"]/div[1]/ul/li[3]")).click();
            String EmailField = driver.findElement(By.id("m_rtxtEmail1")).getAttribute("value");
            Assert.assertEquals(EmailField.toString(),emailSuggested.toString());
            //Assert.assertTrue("Password Tip is shown",driver.findElement(By.className("passwordTippasswordTip")).isDisplayed());
            Assert.assertTrue("Password Tip is shown",driver.findElement(By.xpath("//*[@id=\"m_frmRegister\"]/div[2]/p")).isDisplayed());

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
