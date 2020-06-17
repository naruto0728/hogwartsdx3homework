package apptest.base;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author Naruto
 * @Title:
 * @Package
 * @Description:
 * @date 2020-06-1615:12
 */
public class BasePage {

    private String appPackage;
    private String appActivity;
    protected WebDriverWait wait;

    protected AppiumDriver<MobileElement> driver;

    public BasePage(String appPackage, String appActivity) {
        this.appPackage = appPackage;
        this.appActivity = appActivity;
        startApp(this.appPackage,this.appActivity);
    }

    public BasePage(AppiumDriver<MobileElement> driver) {
        this.driver = driver;
        wait=new WebDriverWait(driver,60);
    }

    public void startApp(String appPackage,String appActivity) {
        try {
            DesiredCapabilities caps = new DesiredCapabilities();
            caps.setCapability("platformName", "android");
            caps.setCapability("deviceName", "hogwarts");
            caps.setCapability("appPackage", appPackage);
            caps.setCapability("appActivity", appActivity);
            caps.setCapability("noReset", "true");
            driver = new AppiumDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), caps);
            driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
            wait = new WebDriverWait(driver, 60);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

    }


    public  void click(By by){
        wait.until(ExpectedConditions.visibilityOfElementLocated(by)).click();
    }


    public void sendkey(By by,String key){
        wait.until(ExpectedConditions.visibilityOfElementLocated(by)).sendKeys(key);
    }



    public MobileElement findElement(By by){


       return (MobileElement) wait.until(ExpectedConditions.visibilityOfElementLocated(by));


    }



    public List<MobileElement> findElements(By by){
        return driver.findElements(by);
    }


}
