package apptest.wechat;

import apptest.base.BasePage;

/**
 * @author Naruto
 * @Title:
 * @Package
 * @Description:
 * @date 2020-06-1619:30
 */
public class WeWorkPage extends BasePage {



    public WeWorkPage(String appPackage, String appActivity) {
        super(appPackage, appActivity);
    }


    public SchedulePage toSchedule(){
        return new SchedulePage(driver);
    }


}
