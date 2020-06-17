package apptest.xueqiu;

import apptest.base.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import sun.applet.Main;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Naruto
 * @Title:
 * @Package
 * @Description:
 * @date 2020-06-1514:08
 */
public class SearchPage extends BasePage {


    private By nameLocate=By.id("name");

    public SearchPage(AppiumDriver<MobileElement> driver) throws Exception {
        super(driver);
    }


    public SearchPage search(String key) {

        //定位首页搜索框
        //driver.findElement(By.id("com.xueqiu.android:id/home_search")).click();
        click(By.id("home_search"));


        //定位搜索页搜索框
        //driver.findElement(By.id("com.xueqiu.android:id/search_input_text")).sendKeys(key);
        sendkey(By.id("search_input_text"),key);

        return this;
    }


    public List<String> getSerachList() {
        List<String> stockNames = new ArrayList<>();

        //List<MobileElement> elements = driver.findElements(nameLocate);


        findElements(nameLocate).forEach(x -> stockNames.add(x.getText()));

        //driver.findElement(By.id("action_close")).click();
        click(By.id("action_close"));
        return stockNames;
    }

    public double getPrice() {

       // driver.findElement(nameLocate).click();
        click(nameLocate);

        //String current_price = driver.findElement(By.id("current_price")).getText();

        String current_price = findElement(By.id("current_price")).getText();

        //driver.findElement(By.id("action_close")).click();

        click(By.id("action_close"));

        return Double.parseDouble(current_price);

    }
}
