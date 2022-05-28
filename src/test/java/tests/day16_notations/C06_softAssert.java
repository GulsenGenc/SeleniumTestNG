package tests.day16_notations;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.TestBase;

public class C06_softAssert extends TestBase {

    /*
       Softassertion baslangic ve bitis satirlari arasindaki
       tum assertion'lari yapip
       bitis satirina geldiginde bize buldugu tum hatalari rapor eder
      */
    // softassert baslangici obje olusturmaktir
    @Test
    public void test01() {
        SoftAssert softAssert=new SoftAssert();
        //1-amazon anasayfaya gıdıp
        driver.get("https://www.amazon.com");
        //2-tittle ın amazon içerdiğini test edın
        String expectedTitle = "Amazon";
        String actualTıtle = driver.getTitle();
        softAssert.assertTrue(expectedTitle.contains(actualTıtle),"amazon içermez");
        //3-arama kutusumnun erısılebılır oldugunu test edın
        WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));
        softAssert.assertTrue(aramaKutusu.isEnabled(),"arama kutusu erişilebilr değil");
        //4-arama kutusuna nutella yazıp aratın
        aramaKutusu.sendKeys("Nutella" + Keys.ENTER);
        //5-arama yapıldıgını test edın
        WebElement sonucYazıElementi = driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        softAssert.assertTrue(sonucYazıElementi.isDisplayed(),"arama yapılamadı");
        //6-arama sonucunun nutella içerdiğini test edin
       softAssert.assertTrue( sonucYazıElementi.getText().contains("Kutella"),"sonuc yazısı Kutella içermiyor");
       softAssert.assertAll();


        /*
        Softassert'un hata bulsa bile calismaya devam etme ozelligi
        assertAll()'a kadardir.
        Eger assertAll()'da failed rapor edilirse calisma durur
        ve class'in kalan kismi calistirilmaz
        (Yani assertAll hardAsserdeki her bir assert gibidir, hatayi yakalarsa calisma durur)
         */


    }
}
