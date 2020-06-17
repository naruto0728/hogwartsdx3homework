package apptest.xueqiu;

import apptest.base.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author Naruto
 * @Title:
 * @Package
 * @Description:
 * @date 2020-06-1514:06
 */
public class MainPage extends BasePage {



    public MainPage(String appPackage, String appActivity ) {
        super(appPackage,appActivity);
    }



    public SearchPage toSearch() throws Exception {

        return new SearchPage(driver);
    }





    public void toStock(){

    }
}
