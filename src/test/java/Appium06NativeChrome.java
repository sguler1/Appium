import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Set;

public class Appium06NativeChrome {
    @Test
    public void test() throws MalformedURLException, InterruptedException {
        DesiredCapabilities capabilities = new DesiredCapabilities();

        //capabilities.setCapability("platformName","Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10.0");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "samet");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        capabilities.setCapability(MobileCapabilityType.APP, "C:\\Users\\Samet\\IdeaProjects\\appiums\\src\\Apps\\Calculator.apk");
        capabilities.setCapability("appPackage", "com.android.chrome");
        capabilities.setCapability("appPackage", "com.google.android.apps.chrome.Main");
        capabilities.setCapability("noReset", true);
        AndroidDriver<MobileElement> driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        Thread.sleep(5000);
        driver.get("https://www.amazon.com");
        System.out.println(driver.getContextHandles() + "<====app acildiginda tur");
// burda aplikasyonun hangi turleri oldugunu gormek icin getContextHandles() kullanilir
        Set<String> butunTurler = driver.getContextHandles();
        for (String tur : butunTurler) {
            System.out.println(tur);
            if (tur.contains("WEBVIEW_chrome")) {
                driver.context(tur);
            }

        }
        Thread.sleep(7000);

        MobileElement homeScreenLogo = driver.findElementByAccessibilityId("Amazon");
        Assert.assertTrue(homeScreenLogo.isDisplayed());
        System.out.println("Ana Sayfada");

        System.out.println(driver.getCurrentUrl() + "<========== url ");
        Thread.sleep(3000);
        MobileElement signInButoon = driver.findElementByAccessibilityId("Sign in >");
        signInButoon.click();

        MobileElement welcomeText = driver.findElementByXPath("//android.widget.TextView[@text='Welcome']");

        Assert.assertEquals(welcomeText.getText(), "Welcome");

        System.out.println("Test Bitti....");
        Thread.sleep(3000);

    }
}
