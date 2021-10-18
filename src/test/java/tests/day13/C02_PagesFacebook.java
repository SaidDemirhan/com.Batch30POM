package tests.day13;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.FacebookPage;
import utilities.TestBase;

public class C02_PagesFacebook extends TestBase {
    //facebook logon sayfasina gidin
    //kullanici adi techproed@hotmail.com
    //sifre 12345
    //yaildiginida giris yapamadiginizi test edin

    //facebook sayfasinda cokies gec methodu olustur.

    @Test
    public void test() {

        driver.get("https://www.facebook.com");

        FacebookPage facebookPage = new FacebookPage(driver);

        facebookPage.cookiesGec();

        facebookPage.mailKutusu.sendKeys("techproed@hotmail.com");

        facebookPage.sifreKutusu.sendKeys("12345");

        facebookPage.loginTusu.click();

        Assert.assertTrue(facebookPage.girilemediYaziElementi.isDisplayed());


    }

}
