package tests.day25;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.ConfigReader;
import utilities.Driver;

public class DataProviderIleTest {

    @DataProvider
    public static Object[] aranacakkelimelistesi(){
        String arr[]= {"Nutella","Java","Aple"};
        return arr;
    }

    @Test(dataProvider = "aranacakkelimelistesi")
    public void test(String aranacak){
        Driver.getDriver().get(ConfigReader.getProperty("AmazonUrl"));





        // girilen deger icin arama yapin
        Driver.getDriver().findElement(By.id("twotabsearchtextbox")).sendKeys(aranacak+ Keys.ENTER);
        // sonuc sayisini yazdirin ve sonuc yazisinin aranan kelimeyi icerdigini test edin
        WebElement sonucYazisiElementi=Driver.getDriver().findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        System.out.println(sonucYazisiElementi.getText());

        Assert.assertTrue(sonucYazisiElementi.getText().contains(aranacak));

    }

}
