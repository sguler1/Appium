import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class Appium05 {
    @Test
    public void test() throws MalformedURLException, InterruptedException {
        DesiredCapabilities capabilities = new DesiredCapabilities();

        //capabilities.setCapability("platformName","Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10.0");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "samet");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        capabilities.setCapability(MobileCapabilityType.APP, "C:\\Users\\Samet\\IdeaProjects\\appiums\\src\\Apps\\Calculator.apk");
        capabilities.setCapability("noReset", true);
        AndroidDriver<MobileElement> driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);


      MobileElement num1 = driver.findElementById("com.google.android.calculator:id/digit_1");
      MobileElement num2 = driver.findElementById("com.google.android.calculator:id/digit_2");
      MobileElement num3 = driver.findElementById("com.google.android.calculator:id/digit_3");
      MobileElement num4 = driver.findElementById("com.google.android.calculator:id/digit_4");
      MobileElement num5 = driver.findElementById("com.google.android.calculator:id/digit_5");
      MobileElement num6 = driver.findElementById("com.google.android.calculator:id/digit_6");
      MobileElement num7 = driver.findElementById("com.google.android.calculator:id/digit_7");
      MobileElement num8 = driver.findElementById("com.google.android.calculator:id/digit_8");
      MobileElement num9 = driver.findElementById("com.google.android.calculator:id/digit_9");
      MobileElement num0 = driver.findElementById("com.google.android.calculator:id/digit_0");

      MobileElement plus = driver.findElementByAccessibilityId("plus");
      MobileElement multiply = driver.findElementByAccessibilityId("multiply");
      MobileElement divide = driver.findElementByAccessibilityId("divide");
      MobileElement minus = driver.findElementByAccessibilityId("minus");
      MobileElement equals = driver.findElementByAccessibilityId("equals");

      // 64  + 71
      num6.click();
      num4.click();
      plus.click();
      num7.click();
      num1.click();
      Thread.sleep(1000);

      String preResult = driver.findElementById("com.google.android.calculator:id/result").getText();
      Thread.sleep(1000);
      equals.click();
      Thread.sleep(3000);
      String actualResult = driver.findElementByClassName("android.widget.TextView").getText();
      System.out.println("preResult = " + preResult);
      System.out.println("actualResult = " + actualResult);
      Assert.assertEquals(actualResult, preResult);


    }
}
