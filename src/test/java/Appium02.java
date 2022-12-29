


import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class Appium02 {
    @Test
    public void test() throws MalformedURLException, InterruptedException {
        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10.0");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "samet");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        capabilities.setCapability(MobileCapabilityType.APP, "C:/Users/Samet/IdeaProjects/appiums/src/Apps/GestureTool.apk");
        capabilities.setCapability("noReset", true);
        AndroidDriver<MobileElement> driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

        //capabilities.setCapability("platformName","Android");
    //  capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
    //  capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10.0");
    //  capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "samet");
    //  capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
    //  capabilities.setCapability(MobileCapabilityType.APP, "C:\\Users\\Samet\\IdeaProjects\\appiums\\src\\Apps\\GestureTool.apk");
    //  capabilities.setCapability("appPackage", "com.davemac327.gesture.tool");
    //  capabilities.setCapability("appActivity", "com.davemac327.gesture.tool.GestureBuilderActivity");
    //  //capabilities.setCapability("noReset", true);
    //  AndroidDriver<MobileElement> driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

        System.out.println("app yüklendi");
        Thread.sleep(3000);
        driver.findElementById("com.android.permissioncontroller:id/continue_button").click();
        Thread.sleep(3000);
        MobileElement okButton=driver.findElementByXPath("//android.widget.Button[@text='OK']");
        okButton.click();
        System.out.println("izinler onaylandi");
        Thread.sleep(3000);
        MobileElement homeScreenTitle=driver.findElementById("android:id/title");
        Assert.assertTrue(homeScreenTitle.isDisplayed());
        System.out.println("Ana sayfa acildi");
    }
}
