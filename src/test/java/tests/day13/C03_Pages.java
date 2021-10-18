package tests.day13;

import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.TestBase;

public class C03_Pages extends TestBase {
    // amazon sayfasina gidin
// dropdown menuden book kategorisini secin
// java icin arama yapin
// bulunan sonuc sayisini yazin
// ilk urunun isminde Java gectigini test edin

    @Test
    public void test(){
        driver.get("https://www.amazon.com/");

        AmazonPage amazonPage=new AmazonPage(driver);

        Select select=new Select(amazonPage.dropdownMenu);

        select.selectByVisibleText("Bücher");

        amazonPage.aramaKutusu.sendKeys("java"+ Keys.ENTER);

        System.out.println(amazonPage.sonucYazisiElementi.getText());

        Assert.assertTrue(amazonPage.ilkUrurnAdi.getText().contains("Java"));


    }
}
