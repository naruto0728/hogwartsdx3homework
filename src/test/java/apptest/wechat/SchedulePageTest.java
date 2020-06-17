package apptest.wechat;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Naruto
 * @Title:
 * @Package
 * @Description:
 * @date 2020-06-1619:42
 */
class SchedulePageTest {
    static SchedulePage schedulePage;

    @BeforeAll
    static  void init(){
        schedulePage=new WeWorkPage("com.tencent.wework",".launch.LaunchSplashActivity").toSchedule();
    }



    @Test
    public void addSchedule(){
        schedulePage.addSchedule("selenium");
    }


    @Test
    public void getScheduleListTest(){
        schedulePage.getScheduleList().forEach(x->System.out.println(x.getText()));
    }


    @Test
    public void delScheduleTest(){
        List<String> scheduleNames=new ArrayList<>();
        schedulePage.getScheduleList().forEach(x->scheduleNames.add(x.getText()));
        schedulePage.delSchedule(scheduleNames);
    }

}