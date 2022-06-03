package tests.day19_smokeTest;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HotelPage;
import utilities.ConfigReader;
import utilities.Driver;

public class E2E_Test_Hotel {
    HotelPage hotelPage = new HotelPage();

    @Test
    public void createHotel() throws InterruptedException {
        //https://www.hotelmycamp.com adresine git
        Driver.getDriver().get(ConfigReader.getProperty("hotelUrl"));

        //Username textbox ve password metin kutularını locate edin ve asagidaki verileri girin.
        //a. Username:manager
        //b. Password:Manager1!
        hotelPage.loginButonu.click();
        hotelPage.usernameKutusu.sendKeys(ConfigReader.getProperty("hotelUsername"));
        hotelPage.passwordKutusu.sendKeys(ConfigReader.getProperty("hotelPassword"));

        //Login butonuna tıklayın.
        hotelPage.loginButonu2.click();

        // Hotel Management/Hotel List menusunden ADD HOTEL butonuna tiklayin
        hotelPage.hotelManagement.click();
        hotelPage.hotelList.click();
        hotelPage.addHotel.click();

        // Açılan sayfadaki tüm metin kutularına istediğiniz verileri girin.
        Actions actions=new Actions(Driver.getDriver());
        actions.click(hotelPage.codeKutusu).sendKeys(hotelPage.codeKutusu,ConfigReader.getProperty("hcCode")+Keys.TAB)

                .sendKeys(ConfigReader.getProperty("hcName")+Keys.TAB)

                .sendKeys(ConfigReader.getProperty("hcAdress")+Keys.TAB)

                .sendKeys(ConfigReader.getProperty("hcPhone")+Keys.TAB)

                .sendKeys(ConfigReader.getProperty("hcEmail")+Keys.TAB)
                .perform();
        Select select=new Select(hotelPage.ddm);
        select.selectByIndex(1);

        //Save butonuna tıklayın.
        hotelPage.saveButonu.click();
        Thread.sleep(2000);
        // “Hotel was inserted successfully” textinin göründüğünü test edin.
       WebElement yazı=Driver.getDriver().findElement(By.xpath("//div[@class='bootbox-body']"));
        Assert.assertTrue(yazı.isDisplayed());
        //OK butonuna tıklayın.
    }
}
