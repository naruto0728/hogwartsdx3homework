package apptest.xueqiu;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import sun.applet.Main;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Naruto
 * @Title:
 * @Package
 * @Description:
 * @date 2020-06-1514:12
 */
class SearchPageTest {

    static SearchPage searchPage;

    @BeforeAll
    static  void init() throws Exception {
        searchPage=new MainPage("com.xueqiu.android",".view.WelcomeActivityAlias").toSearch();


    }

    @ParameterizedTest
    @CsvSource({
            "alibaba,阿里巴巴",
            "jd,京东"
    })
    void search(String key,String name) {

        assertEquals(searchPage.search(key).getSerachList().get(0),name);
    }

    @ParameterizedTest
    @CsvSource({
            "alibaba",
            "jd"
    })
    @Test
    void getPrice(String key) {

        assertTrue(searchPage.search(key).getPrice()>200);
    }
}