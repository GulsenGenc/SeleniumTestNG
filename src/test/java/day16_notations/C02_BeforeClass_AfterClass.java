package day16_notations;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utilities.TestBase;

public class C02_BeforeClass_AfterClass extends TestBase {

    //TestNG de beforeclass ve afterclass methodlarını statıc yapmak zorunda değiliz

    @BeforeClass
    public void beforeClassMethodu() {
        System.out.println("before class çalıştı");
    }
    @AfterClass
    public void afterClassMethodu(){
        System.out.println("after class");
    }

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
