package seleniumtest;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Set;
import java.util.StringTokenizer;

/**
 * @author Naruto
 * @Title:
 * @Package
 * @Description:
 * @date 2020-05-3014:29
 */
public class TestSelenium  {

    WebDriver driver;

    @Test
    public void fun() throws Exception{
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("debuggerAddress", "127.0.0.1:9222");
        //利用chromedriver控制chrome
        driver = new ChromeDriver();
        driver.get("https://work.weixin.qq.com/wework_admin/frame");
        //如果不存在cookie.txt。先去开启浏览器复用，调用writeCookie方法生成cookie.txt，然后再调用loadCookie填入cookie。
        // 如果存在，直接loadCookie 填入cookie
        loadCookie(driver);
        driver.get("https://work.weixin.qq.com/wework_admin/frame");


    }



    public void loadCookie(WebDriver driver){

        try {
            FileReader fileReader = new FileReader(System.getProperty("user.dir")+"/src/main/resources/cookie.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                StringTokenizer tokenizer = new StringTokenizer(line, ";");
                String name = tokenizer.nextToken();
                String value = tokenizer.nextToken();
                String domain = tokenizer.nextToken();
                String path = tokenizer.nextToken();
                Date expiry = null;
                String dt = tokenizer.nextToken();
                if (!dt.equals("null")) {
                    SimpleDateFormat sdf = new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy", Locale.ENGLISH);
                    //把 string 转换成 date
                    expiry = sdf.parse(dt);
                }
                //把 string 转换成 boolean
                boolean isSecure = Boolean.parseBoolean(tokenizer.nextToken());
                System.out.println(name);
                System.out.println(value);
                System.out.println(domain);
                System.out.println(path);
                System.out.println(expiry);
                System.out.println(isSecure);
                Cookie cookie = new Cookie(name, value, domain, path, expiry, isSecure);
                driver.manage().addCookie(cookie);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    public void writeCookie(WebDriver driver){
        try {
            FileWriter fw=new FileWriter(System.getProperty("user.dir")+"/src/main/resources/cookie.txt");
            BufferedWriter bfw=new BufferedWriter(fw);


            for (Cookie cookie:driver.manage().getCookies()) {
                bfw.write(cookie.getName() + ';' +
                        cookie.getValue() + ";" +
                        cookie.getDomain() + ";" +
                        cookie.getPath() + ";" +
                        cookie.getExpiry() + ";" +
                        cookie.isSecure());
                bfw.newLine();



            }
            bfw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
