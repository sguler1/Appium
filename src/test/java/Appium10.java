import Appium.BaseClass;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class Appium10 extends BaseClass {
    @Test
    public void test() throws MalformedURLException, InterruptedException {
        DesiredCapabilities capabilities = new DesiredCapabilities();

        //  capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        //  capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10.0");
        //  capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "samet");
        //  capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        //  capabilities.setCapability(MobileCapabilityType.APP, "C:\\Users\\Samet\\IdeaProjects\\appiums\\src\\Apps\\API Demos for Android_1.9.0_Apkpure.apk");
        //  // capabilities.setCapability("appPackage", "com.davemac327.gesture.tool");
        //  // capabilities.setCapability("appActivity", "com.davemac327.gesture.tool.GestureBuilderActivity");
        //  capabilities.setCapability("noReset", true);
//
        //  AndroidDriver<MobileElement> driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

        AndroidDriver driver = getAndroidDriver();

        System.out.println("App installed");
        //api demos button tikla
        driver.findElementByXPath("//android.widget.TextView[@text='API Demos']").click();
        Thread.sleep(5000);
        //preference button tikla
        driver.findElementByXPath("//android.widget.TextView[@text='Preference']").click();
        Thread.sleep(5000);
        //pereference dependencies butonuna tikla
        driver.findElementByXPath("//android.widget.TextView[@text='3. Preference dependencies']").click();
        Thread.sleep(5000);
        //checkbox tikla
        driver.findElementById("android:id/checkbox").click();
        Thread.sleep(5000);
        //wifi settings tikla
        driver.findElementByXPath("//android.widget.TextView[@text='WiFi settings']").click();
        Thread.sleep(5000);
        //text penceresi acildiğini görme
        Assert.assertTrue(driver.findElementById("android:id/alertTitle").isDisplayed());
        Thread.sleep(5000);
        //samo yazdir
        driver.findElementById("android:id/edit").sendKeys("samo");
        Thread.sleep(8000);
        //ok button tikla
        driver.findElementById("android:id/button1").click();
        Thread.sleep(8000);

        System.out.println("Mission Completed");


        //session kapat
        driver.closeApp();


    }

}
