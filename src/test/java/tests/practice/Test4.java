package tests.practice;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.TestBase;

import java.util.Set;

public class Test4 extends TestBase {
    // 1) https://www.ntv.com.tr/ ADRESİNE GİT
    // 2) SAYFANIN TiTLE'NIN "NTV HABER - Haberler, Son Dakika Haberleri" OLDUGUNU DOGRULA
    // 3) SAYFANIN HANDLE DEGERiNi AL.
    // 4) SPOR SAYFASINA TIKLA
    // 5) URL'iN "https://www.ntvspor.net/" OLDUGUNU DOGRULA
    // 6) ANA SAYFAYA GERi DON

    @Test
    public void test() throws InterruptedException {
        driver.get("https://www.ntv.com.tr/");
        System.out.println("Sayfa Title: "+driver.getTitle());

        String expectedTitle= "NTV HABER - Haberler, Son Dakika Haberleri";
        String actualTitle=driver.getTitle();

        SoftAssert softAssert=new SoftAssert();
        softAssert.assertEquals(actualTitle,expectedTitle,"Sayfa basligi yanlis");

        String ilkSayfa=driver.getWindowHandle();
        System.out.println("ilk sayfanin handle degeri: "+ilkSayfa);

        driver.findElement(By.xpath("//a[@class='header-category-link spor']")).click();

        System.out.println(driver.getCurrentUrl());

        Set<String> tumWindowHandles= driver.getWindowHandles();
        System.out.println("Tüm hadle lar : "+tumWindowHandles);

        String ikincisayfa = "";

        for (String each:tumWindowHandles
        ) {
            if (!each.equals(ilkSayfa)) {
                ikincisayfa = each;

            }

        }

        System.out.println("ikinci sayfanin Handle degeri :"+ikincisayfa);

        driver.switchTo().window(ikincisayfa);
        System.out.println(driver.getCurrentUrl());

        String expectedUrl="https://www.ntvspor.net/";
        String actualUrl=driver.getCurrentUrl();

        softAssert.assertEquals(actualUrl,expectedUrl,"2. sayfanin url si uyusmuyor.");

        softAssert.assertAll();

        driver.switchTo().window(ilkSayfa);
        Thread.sleep(3000);
    }
}
