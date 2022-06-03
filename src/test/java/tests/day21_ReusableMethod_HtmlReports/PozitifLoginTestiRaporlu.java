package tests.day21_ReusableMethod_HtmlReports;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BrcPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class PozitifLoginTestiRaporlu extends TestBaseRapor {

    @Test
    public void pozitifLoginTest() {
        extentTest=extentReports.createTest("pozitif Login","Gecerli username ve sifre ile girebilmeli");

        BrcPage brcPage = new BrcPage();
        //       https://www.bluerentalcars.com/ adresine git
        Driver.getDriver().get(ConfigReader.getProperty("brcUrl"));
        extentTest.info("Brc anasayfaya gidildi");
        //      login butonuna bas
        brcPage.ilkLoginButonu.click();
        extentTest.info("login butonuna basıldı");
        //test data user email: customer@bluerentalcars.com ,
        brcPage.emailKutusu.sendKeys(ConfigReader.getProperty("brcValidEmail"));
        extentTest.info("geçerli email yazıldı");
        //test data password : 12345
        brcPage.passwordKutusu.sendKeys(ConfigReader.getProperty("brcValidPassword"));
        extentTest.info("geçerli password yazıldı");
        //login butonuna tıklayın
        brcPage.ikinciLoginButonu.click();
        extentTest.info("ikinci logın butonuna basıldı.");
        //Degerleri girildiginde sayfaya basarili sekilde girilebildigini test et
        String actualUsername= brcPage.kullanıcıProfilIsmi.getText();
        String expectedUsername=ConfigReader.getProperty("brcValidUsername");
        Assert.assertEquals(actualUsername,expectedUsername);
        extentTest.pass("kullanici basarili sekilde giris yapti");
        Driver.closeDriver();

    }
}
