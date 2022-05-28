package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class FacebookPage {
    public FacebookPage() {
        PageFactory.initElements(Driver.getDriver(),this);

    }

    @FindBy(xpath = "//input[@class='inputtext _55r1 _6luy']")
  public   WebElement emailKutusu;

    @FindBy(xpath = "//input[@id='pass']")
   public WebElement passwordKutusu;

    @FindBy(xpath = "//button[@name='login']")
  public   WebElement loginButton;

    @FindBy(xpath = "//div[@class='_9ay7']")
    public WebElement girisYapılamadıYazısı;
}
