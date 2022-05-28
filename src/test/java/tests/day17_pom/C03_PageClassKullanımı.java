package tests.day17_pom;

import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.FacebookPage;
import utilities.Driver;

public class C03_PageClassKullanımı {
    @Test
    public void test01() {
        FacebookPage facebookPage = new FacebookPage();
        //facebook anasayfaya gıdın
        Driver.getDriver().get("https://www.facebook.com");
        //kullanıcı mail kutusuna rastgele bır ısım yazdırın
        Faker faker = new Faker();
        facebookPage.emailKutusu.sendKeys(faker.internet().emailAddress());
        //kullanıcı sıfre kutusuna rastgele bır password yazdırın
        facebookPage.passwordKutusu.sendKeys(faker.internet().password());
        //logın butonuna basın
        facebookPage.loginButton.click();
        //giriş yapılamadıgını test edın
        Assert.assertTrue(facebookPage.girisYapılamadıYazısı.isDisplayed());
        Driver.closeDriver();
    }
}
