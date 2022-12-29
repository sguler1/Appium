import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Set;

public class Appium07 {
    @Test
    public void test() throws MalformedURLException, InterruptedException {
        DesiredCapabilities capabilities = new DesiredCapabilities();

        //capabilities.setCapability("platformName","Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10.0");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "samet");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "chrome");
        capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "60000");
        capabilities.setCapability("chromedriverExecutable", "C:\\Users\\Samet\\IdeaProjects\\appiums\\src\\driver\\chromedriver.exe");
        AndroidDriver<MobileElement> driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        Thread.sleep(5000);
        driver.get("https://www.amazon.com");
        Thread.sleep(5000);
        System.out.println(driver.getContext() + "<====app acildiginda tur");
        // burda aplikasyonun hangi turleri oldugunu gormek icin getContextHandles() kullanilir
        Set<String> butunTurler = driver.getContextHandles();
        for (String tur : butunTurler) {
            Thread.sleep(5000);
            System.out.println(tur);
            if (tur.contains("WEBVIEW_chrome")) {
                Thread.sleep(5000);
                driver.context(tur);
            }

        }
        Thread.sleep(5000);
        System.out.println(driver.getContext() + "========app sonraki konum");

        MobileElement logo = driver.findElementByXPath("//a[@id='nav-logo-sprites']");
        Assert.assertTrue(logo.isEnabled());
        System.out.println("Ana sayfadayiz...");
        Thread.sleep(5000);

        MobileElement signIn=driver.findElementByXPath("//a[@id='nav-logobar-greeting']");
        signIn.click();
        Thread.sleep(5000);
      //  Assert.assertTrue(signIn.isEnabled());


        MobileElement welcomeText= driver.findElementByXPath("//h2");
        Assert.assertTrue(welcomeText.isDisplayed());
        System.out.println("Sign in sayfasindayiz");
        Thread.sleep(5000);

        //close session
        driver.closeApp();

    }
}
