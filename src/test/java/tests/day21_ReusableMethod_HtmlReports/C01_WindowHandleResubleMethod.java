package tests.day21_ReusableMethod_HtmlReports;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.Set;

public class C01_WindowHandleResubleMethod {
    @Test
    public void test01() {
        //● https://the-internet.herokuapp.com/windows adresine gidin.
        Driver.getDriver().get("https://the-internet.herokuapp.com/windows");
        String whandle1 = Driver.getDriver().getWindowHandle();

        //          ● Click Here butonuna basın.
        Driver.getDriver().findElement(By.linkText("Click Here")).click();
        Set<String> whandleSeti = Driver.getDriver().getWindowHandles();
        String whandle2 = "";
        for (String w : whandleSeti
        ) {
            if (!(w.equals(whandle1))) {
                whandle2 = w;
            }
        }
        Driver.getDriver().switchTo().window(whandle2);
        //acılan yenı tabın New Window oldugunu test edın
        String expectedTitle = "New Window";
        String actualTitle = Driver.getDriver().getTitle();
        Assert.assertEquals(actualTitle, expectedTitle);
    }

    @Test
    public void test02() {
        //● https://the-internet.herokuapp.com/windows adresine gidin.
        Driver.getDriver().get("https://the-internet.herokuapp.com/windows");

        //          ● Click Here butonuna basın.
        Driver.getDriver().findElement(By.linkText("Click Here")).click();
        //acılan yenı tabın New Window oldugunu test edın
        ReusableMethods.switchToWindow("New Window");
        String expectedTitle = "New Window";
        String actualTitle = Driver.getDriver().getTitle();
        Assert.assertEquals(actualTitle, expectedTitle);
    }
}
