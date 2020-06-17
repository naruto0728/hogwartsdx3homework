package apptest.base;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
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
    /**
     * app对应的包名
     */
    private String appPackage;
    /**
     * app对应的activity
     */
    private String appActivity;
    /**
     * 显示等待
     */

    protected WebDriverWait wait;
    /**
     * driver驱动类
     */
    protected AppiumDriver<MobileElement> driver;

    /**
     * 等待市场
     */
    protected long waitTime = 60;

    /**
     * @param appPackage
     * @param appActivity
     */
    public BasePage(String appPackage, String appActivity) {
        this.appPackage = appPackage;
        this.appActivity = appActivity;
        startApp(this.appPackage, this.appActivity);
    }

    /**
     * 构造方法，初始化显示等待类
     *
     * @param driver
     */
    public BasePage(AppiumDriver<MobileElement> driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, waitTime);
    }

    /**
     * 启动app方法类。同时实例化driver对象
     *
     * @param appPackage
     * @param appActivity
     */
    public void startApp(String appPackage, String appActivity) {
        try {
            DesiredCapabilities caps = new DesiredCapabilities();
            caps.setCapability("platformName", "android");
            caps.setCapability("deviceName", "hogwarts");
            caps.setCapability("appPackage", appPackage);
            caps.setCapability("appActivity", appActivity);
            caps.setCapability("noReset", "true");
            driver = new AppiumDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), caps);
            driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
            wait = new WebDriverWait(driver, waitTime);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

    }

    /**
     * 重写click方法
     *
     * @param by
     */
    public void click(By by) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(by)).click();
    }

    /**
     * 重写sendkey方法
     *
     * @param by
     * @param key
     */
    public void sendkey(By by, String key) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(by)).sendKeys(key);
    }


    /**
     * 加了显示等待的findElement方法
     *
     * @param by
     * @return
     */
    public MobileElement findElement(By by) {

        return (MobileElement) wait.until(ExpectedConditions.visibilityOfElementLocated(by));

    }


    /**
     * 加了显示等待的findElements方法
     *
     * @param by
     * @return
     */
    public List<MobileElement> findElements(By by) {
        return driver.findElements(by);
    }


    /**
     * 给定字符串通过xpath @text去定位
     *
     * @param expression
     * @return
     */
    public MobileElement byText(String expression) {
        return driver.findElement(By.xpath("//*[@text='" + expression + "'] or //*[@content-desc='" + expression + "']"));
    }
}
