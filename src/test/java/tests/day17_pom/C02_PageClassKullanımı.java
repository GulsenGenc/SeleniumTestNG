package tests.day17_pom;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AmazonPages;
import utilities.Driver;

public class C02_PageClassKullanımı {
    AmazonPages amazonPage = new AmazonPages();

    @Test
    public void test01() {
        //amazona gıdelım
        Driver.getDriver().get("https://www.amazon.com");
        //nutella aratalım
        amazonPage.aramakUtusu.sendKeys("nutella");
        //sonuc yazısın ın nutella içerdiğini test edelim
        String actualSonucYazısı=amazonPage.aramaSonucElementi.getText();
        Assert.assertTrue(actualSonucYazısı.contains("nutella"));

    }
}
