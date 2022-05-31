package tests.day19_smokeTest;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BrcPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C02_negatifLoginTesti {
     /*
   Bir test method olustur positiveLoginTest()
         https://www.bluerentalcars.com/ adresine git
        login butonuna bas
  test data user email: customer@bluerentalcars.com ,
  test data password : 12345
  login butonuna tiklayin
  Degerleri girildiginde sayfaya basarili sekilde girilebildigini test et
 */
    BrcPage brcPage=new BrcPage();
    @Test
    public void yanlışSifre() {
        //       https://www.bluerentalcars.com/ adresine git
        Driver.getDriver().get(ConfigReader.getProperty("brcUrl"));
        //      login butonuna bas
        brcPage.ilkLoginButonu.click();
        //test data user email: customer@bluerentalcars.com ,
        brcPage.emailKutusu.sendKeys(ConfigReader.getProperty("brcWrongEmail"));
        //test data password : 12345
        brcPage.passwordKutusu.sendKeys(ConfigReader.getProperty("brcValidPassword"));
        //login butonuna tıklayın
        brcPage.ikinciLoginButonu.click();
        //değerler gırıldığınde sayfanın basarılı sekılde gırılemedıgını test edınız
        Assert.assertTrue(brcPage.ikinciLoginButonu.isDisplayed());

    }
}
