package tests.day16_notations;

import org.testng.annotations.Test;
import utilities.TestBase;

public class C01_BeforeMethod_AfterMethod extends TestBase {

    //BeforeMethod_AfterMethod notasyonları jUnittekı before ve after gıbıdır.
    // her test methodu oncesınde ve sonrasında çalışır.


    @Test
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
