package apptest.wechat;

import apptest.base.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

import java.util.List;

/**
 * @author Naruto
 * @Title:
 * @Package
 * @Description:
 * @date 2020-06-1619:36
 */
public class SchedulePage extends BasePage {
    public By scheduleLocate=By.id("ag9");
    public By addScheduleLocate=By.id("gym");
    public By taskName=By.id("b2k");
    public By save=By.id("ag2");

    public By taskId=By.id("gg_");



    public SchedulePage(AppiumDriver<MobileElement> driver) {
        super(driver);

    }


    public SchedulePage addSchedule(String key){
        click(scheduleLocate);
        click(addScheduleLocate);
        sendkey(taskName,key);
        click(save);
        return this;
    }






    public List<MobileElement> getScheduleList(){
        click(scheduleLocate);

        return findElements(taskId);
    }


    public void delSchedule(List<String> scheduleNames){

        for (String name:scheduleNames) {
            click(By.xpath("//*[@text='"+name+"']"));
            click(By.id("bfi"));
            click(By.id("b_o"));
        }


    }


}
