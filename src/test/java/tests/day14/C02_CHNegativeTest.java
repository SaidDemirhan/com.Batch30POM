package tests.day14;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ConcortHotelPage;
import utilities.TestBase;

public class C02_CHNegativeTest extends TestBase {

    // Bir test method olustur NegativeLoginTest()
    // https://www.concorthotel.com/ adresine git
    // login butonuna bas
    // test data username: manager1 ,
    // test data password : manager1!
    // Degerleri girildiginde sayfaya girilemedigini test et



    @Test
    public void test(){
        ConcortHotelPage concortHotelPage=new ConcortHotelPage(driver);
        driver.get("https://www.concorthotel.com/");

        concortHotelPage.ilkLoginLinki.click();

        concortHotelPage.usernameKutusu.sendKeys("manager1");

        concortHotelPage.passwordKutusu.sendKeys("manager1!");

        concortHotelPage.loginButonu.click();

        Assert.assertTrue(concortHotelPage.loginFaildYazisi.isDisplayed());


    }




}
