package tests.day16_notations;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

public class C05_Assertions extends TestBase {
    @Test
    public void test01() {
        //1-amazon anasayfaya gıdıp
        driver.get("https://www.amazon.com");
        //2-tittle ın amazon içerdiğini test edın
        String expectedTitle = "Amazon";
        String actualTıtle = driver.getTitle();
        Assert.assertTrue(expectedTitle.contains(actualTıtle));
        //3-arama kutusumnun erısılebılır oldugunu test edın
        WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));
        Assert.assertTrue(aramaKutusu.isEnabled());
        //4-arama kutusuna nutella yazıp aratın
        aramaKutusu.sendKeys("Nutella" + Keys.ENTER);
        //5-arama yapıldıgını test edın
        WebElement sonucYazıElementi = driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        Assert.assertTrue(sonucYazıElementi.isDisplayed());
        //6-arama sonucunun nutella içerdiğini test edin
        Assert.assertTrue(sonucYazıElementi.getText().contains("Nutella"));


    }
}
