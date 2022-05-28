package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Driver {
    /*
    POM de driver için testbase classına extends etmek yerıne
    drıver classından statıc methodlar kullanarak drıver oluşturup
    ilgılı ayarların yapılması ve en sonunda drıverın kapatılması tercıh edılmıştır.

     */
    static WebDriver driver;

    public static WebDriver getDriver() {
        if (driver == null) {

            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        }
        return driver;
    }

    public static void closeDriver() {
        if (driver != null) {//driver a değer atanmışsa
            driver.close();
            driver=null;
        }
    }
}
