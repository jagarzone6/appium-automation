import driver.appDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;


/**
 * Created by jgarzon on 13/07/17.
 */
public class Init {



    public static void main(String[] args) {

        appDriver app= new appDriver();
        app.capabilities();

    }


}
