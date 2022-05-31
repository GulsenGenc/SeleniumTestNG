package tests.day18_pom;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.FacebookPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C02_ConfigReaderKullanımı {
    @Test
    public void test01() {

        // facebook anasayfaya gidin
        Driver.getDriver().get(ConfigReader.getProperty("facebookUrl"));
        // cikarsa cookies kabul edin

        // kullanici mail kutusuna rastgele bir isim yazdirin
        FacebookPage facebookPage = new FacebookPage();
        facebookPage.emailKutusu.sendKeys(ConfigReader.getProperty("fbWrongUserName"));

        // kullanici sifre kutusuna rastgele bir password yazdirin
        facebookPage.passwordKutusu.sendKeys(ConfigReader.getProperty("fbWrongPassword"));

        // login butonuna basin
        facebookPage.loginButton.click();

        // giris yapilamadigini test edin
       Assert.assertTrue(facebookPage.girisYapılamadıYazısı.isDisplayed());
       Driver.closeDriver();
    }
}
