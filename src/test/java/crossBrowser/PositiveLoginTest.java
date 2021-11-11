package crossBrowser;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.QAConcortPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.DriverCross;
import utilities.TestBaseCross;

public class PositiveLoginTest extends TestBaseCross {
    @Test
    public void positiveLoginTest() throws InterruptedException {

        //Crossbrowser testinde testbase class ina geri dönüyoruz.
        //Bunun sebebi @Parameters notasyonunu kullanmaktir.
        //Dolayisiyla Driver.getDriver() ve Pages sayfalarindaki locaterlari kullanamayiz.

        //Bir test method olustur positiveLoginTest()
        //https://qa-environment.concorthotel.com/ adresine git


        //Driver.getDriver().get(ConfigReader.getProperty("CHQAUrl"));
        //yerine
        driver.get(ConfigReader.getProperty("CHQAUrl"));
        //olusturduk.



        //QAConcortPage qaConcortPage=new QAConcortPage();
        //artk buna ihtiyacimiz kalmadi


        //qaConcortPage.ilkLoginLinki.click();
        //yerine
        driver.findElement(By.linkText("Log in")).click();

        //test data username: manager ,
        //qaConcortPage.usernameKutusu.sendKeys(ConfigReader.getProperty("CHQAValidUsername"));
        //yerine
        driver.findElement(By.id("UserName")).sendKeys(ConfigReader.getProperty("CHQAValidUsername"));

        //test data password : Manager1!
        //qaConcortPage.passwordKutusu.sendKeys(ConfigReader.getProperty("CHQAValidPassword"));
        //yerine
        driver.findElement(By.id("Password")).sendKeys(ConfigReader.getProperty("CHQAValidPassword"));
        Thread.sleep(4000);

        //qaConcortPage.loginButonu.click();
        //yerine
        driver.findElement(By.id("btnSubmit")).click();

        //Degerleri girildiginde sayfaya basarili sekilde girilebildigini test et
        //Assert.assertTrue(qaConcortPage.basariliGirisYaziElementi.isDisplayed());
        //yerine
        WebElement basariliGirisYaziElementi=driver.findElement(By.xpath("//span[text()='ListOfUsers']"));
        Assert.assertTrue(basariliGirisYaziElementi.isDisplayed());



        DriverCross.closeDriver();
    }

}
