package tests.day19;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class C03_Raporlama extends TestBaseRapor {
    @Test
    public void test1(){
        extentTest=extentReports.createTest("Nutella Testi","sonuc sayisi 1000 den az olmali");
        //Amazon sayfasina git
        //nutella ara
        //sonuc sayisinin 1000 den az oldugunu test edelim

        Driver.getDriver().get(ConfigReader.getProperty("AmazonUrl"));
        extentTest.info("amazon sayfasina gidildi");
        AmazonPage amazonPage=new AmazonPage();
        WebElement aramaKutusu=Driver.getDriver().findElement(By.cssSelector("#twotabsearchtextbox"));
        aramaKutusu.sendKeys("nutella"+ Keys.ENTER);
        extentTest.info("nutella icin arama yapildi");
        WebElement sonucSayisiElementi= Driver.getDriver().findElement(By.xpath("(//span[@dir='auto'])[1]"));
        String sonucYazisi=sonucSayisiElementi.getText();
        String sonucArray[]=sonucYazisi.split(" ");
        int sonucSayisi= Integer.parseInt(sonucArray[2]);
        extentTest.info("sonuc yazisi int haline getirildi");

        Assert.assertTrue(sonucSayisi<1000);
        extentTest.pass("sonuc yazisinin 1000 den az oldugu onaylandi.");


        Driver.closeDriver();

    }

    @Test
    public void test2(){
        // amazon sayfasina gidip
        // samsung icin arama yapalim
        // sonuc sayisinin 1000'den az oldugunu test edelim
        extentTest=extentReports.createTest("Samsung testi","sonuc sayisi 1000 den az olmali");
        // amazon sayfasina gidip
        Driver.getDriver().get(ConfigReader.getProperty("AmazonUrl"));
        extentTest.info("amazon sayfasina gidildi");
        // nutella icin arama yapalim
        WebElement aramaKutusu=Driver.getDriver().findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("Samsung"+Keys.ENTER);

        extentTest.info("Samsung icin arama yapildi");
        // sonuc sayisinin 1000'den az oldugunu test edelim
        WebElement sonucSayisiElementi=Driver.getDriver().findElement(By.xpath("(//span[@dir='auto'])[1]"));
        //1-48 of 130 results for

        String sonucYazisi=sonucSayisiElementi.getText();
        String sonucArrayi[]=sonucYazisi.split(" ");

        String sonucAdedi=sonucArrayi[4];
        sonucAdedi=sonucAdedi.replace(".","");
        System.out.println(sonucAdedi);
        int sonucSayisi= Integer.parseInt(sonucAdedi);

        extentTest.info("sonuc yazisi int haline getirildi");
        Assert.assertTrue(sonucSayisi<1000);
        extentTest.pass("sonuc sayisinin 1000'den az oldugu test edildi");
    }

    @Test
    public void test3(){
        // amazon sayfasina gidip
        // electronic kategorisinde java icin arama yapalim
        extentTest=extentReports.createTest("java testi","ilk urunde java olmali");
        Driver.getDriver().get(ConfigReader.getProperty("AmazonUrl"));
        extentTest.info("amazona gidildi");
        Select select=new Select(Driver.getDriver().findElement(By.id("searchDropdownBox")));
        select.selectByVisibleText("Elektronik");
        extentTest.info("dropdown dan electronics secildi");
        WebElement aramaKutusu=Driver.getDriver().findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("Java"+Keys.ENTER);
        extentTest.info("java kelimesi aratildi");
        // cikan sonuclardan ilkinin isminde java oldugunu test edelim
        WebElement ikinciUrun=Driver.getDriver().findElement(By.xpath("(//div[@class='s-expand-height s-include-content-margin s-latency-cf-section s-border-bottom'])[2]"));
        String ikinciElementYazisi=ikinciUrun.getText();
        Assert.assertTrue(ikinciElementYazisi.contains("Java"));
        extentTest.pass("ilk urun isminde java oldugu test edildi");
    }
}
