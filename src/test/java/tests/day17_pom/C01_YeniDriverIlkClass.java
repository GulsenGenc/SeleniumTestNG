package tests.day17_pom;

import org.testng.annotations.Test;
import utilities.Driver;

public class C01_YeniDriverIlkClass {
    @Test
    public void test01() {
        Driver.getDriver().get("https://www.amazon.com");
        Driver.closeDriver();
        /*
        bugune kadar testbase clasına extends ederek kullandığımız drıver yerıne
        bundan sonra Driver classından kullanacagımız getDriver() static methodunu
        kullanacagız.

        Driver.getDriver() methodu  -->     in
        driver                      -->     out
         */

        Driver.getDriver().get("https://www.bestbuy.com");
        Driver.getDriver().get("https://www.facebook.com");
    }
}
