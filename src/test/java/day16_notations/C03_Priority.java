package day16_notations;

import org.testng.annotations.Test;
import utilities.TestBase;

public class C03_Priority extends TestBase {
    /*
    testNG methodları isim sırasına gore çalıştırır.eğer ısım sıralamasının dısında bır sıra ıle çalışmasını ıstersenız
    o zaman test methodlarınıa oncelık(priorıty) tnımlayabılırız

    priorıty kucukten buyuge gore çalışır
    ege bır test methoduna
     */


    @Test (priority = 5)
    public void test01() {
        driver.get("https://www.amazon.com");
    }

    @Test
    public void test02() {
        driver.get("https://www.bestbuy.com");
    }

    @Test
    public void techproeducatıonTestı() {
        driver.get("https://www.techproeducation.com");
    }
}
