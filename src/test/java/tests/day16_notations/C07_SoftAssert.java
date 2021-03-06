package tests.day16_notations;

import jdk.dynalink.linker.LinkerServices;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.TestBase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class C07_SoftAssert extends TestBase {
    @Test
    public void test01() {
        // 1. “http://zero.webappsecurity.com/” Adresine gidin
        driver.get("http://zero.webappsecurity.com/");
        // 2. Sign in butonuna basin
        driver.findElement(By.xpath("//button[@id='signin_button']")).click();
        // 3. Login kutusuna “username” yazin
        driver.findElement(By.xpath("//input[@id='user_login']")).sendKeys("username");
        // 4. Password kutusuna “password” yazin
        driver.findElement(By.xpath("//input[@id='user_password']")).sendKeys("password");

        // 5. Sign in tusuna basin
        driver.findElement(By.xpath("//input[@value='Sign in']")).click();
        driver.navigate().back();
        // 6. Online banking menusu icinde Pay Bills sayfasina gidin
        driver.findElement(By.xpath("//strong[text()='Online Banking']")).click();
        driver.findElement(By.id("pay_bills_link")).click();
        // 7. “Purchase Foreign Currency” tusuna basin
        driver.findElement(By.xpath("//a[text()='Purchase Foreign Currency']")).click();
        // 8. “Currency” drop down menusunden Eurozone’u secin
        WebElement ddm= driver.findElement(By.xpath("//select[@id='pc_currency']"));
        Select select=new Select(ddm);
        select.selectByVisibleText("Eurozone (euro)");
        // 9. soft assert kullanarak "Eurozone (Euro)" secildigini test edin
        SoftAssert softAssert=new SoftAssert();
        String expecedSecılen="Eurozone (Euro)";
        String  actualSecılen=select.getFirstSelectedOption().getText();
        softAssert.assertEquals(expecedSecılen,actualSecılen,"secılen optıon uygun degıl");
        // 10. soft assert kullanarak DropDown listesinin su secenekleri oldugunu test edin "Select One",
        // "Australia (dollar)", "Canada (dollar)","Switzerland (franc)","China (yuan)","Denmark (krone)",
        // "Eurozone (euro)","Great Britain (pound)","Hong Kong (dollar)","Japan (yen)","Mexico (peso)",
        // "Norway (krone)","New Zealand (dollar)","Sweden (krona)","Singapore (dollar)","Thailand (baht)"
        List<WebElement> optionsList = select.getOptions();
        List<String> optionsListString = new ArrayList<>();
        List<String> expectedListString = new ArrayList<>(Arrays.asList("Select One", "Australia (dollar)", "Canada (dollar)","Switzerland (franc)",
                "China (yuan)","Denmark (krone)","Eurozone (euro)","Great Britain (pound)","Hong Kong (dollar)","Japan (yen)",
                "Mexico (peso)","Norway (krone)","New Zealand (dollar)","Sweden (krona)","Singapore (dollar)","Thailand (baht)"));
        for (WebElement each : optionsList
        ) {
            optionsListString.add(each.getText());
        }
        System.out.println("optionsListString = " + optionsListString);
        Collections.sort(optionsListString);
        Collections.sort(expectedListString);
        softAssert.assertEquals(optionsListString,expectedListString,"iki liste birbirinden farklı");
        softAssert.assertAll();
    }
}
