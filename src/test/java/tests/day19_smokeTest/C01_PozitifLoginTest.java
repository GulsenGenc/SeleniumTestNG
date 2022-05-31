package tests.day19_smokeTest;

import org.testng.annotations.Test;
import pages.BrcPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C01_PozitifLoginTest {

    @Test
    public void pozitifLoginTest() {
        BrcPage brcPage = new BrcPage();
        //       https://www.bluerentalcars.com/ adresine git
        Driver.getDriver().get(ConfigReader.getProperty("brcUrl"));
        //      login butonuna bas
        brcPage.ilkLoginButonu.click();
        //test data user email: customer@bluerentalcars.com ,
        brcPage.emailKutusu.sendKeys(ConfigReader.getProperty("brcValidEmail"));
        //test data password : 12345
        brcPage.passwordKutusu.sendKeys(ConfigReader.getProperty("brcValidPassword"));
        //login butonuna tıklayın
        brcPage.ikinciLoginButonu.click();
        //Degerleri girildiginde sayfaya basarili sekilde girilebildigini test et

    }
}
