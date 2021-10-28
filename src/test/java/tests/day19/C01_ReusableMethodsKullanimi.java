package tests.day19;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.Set;

public class C01_ReusableMethodsKullanimi {

    @Test
    public void test(){
        //URL=https://the-internet.herokuapp.com/windows gidin
        //click here ye basin
        //yeni sayfada new window yazisini test edin.


        Driver.getDriver().get("https://the-internet.herokuapp.com/windows");
        String ilkSayfaHandle=Driver.getDriver().getWindowHandle();

        Driver.getDriver().findElement(By.linkText("Click Here")).click();

        Set<String>windowHandleKumesi= Driver.getDriver().getWindowHandles();
        
        String ikinciSayfaHandle="";

        for (String each:windowHandleKumesi
             ) {
            if (!each.equals(ilkSayfaHandle)){
                ikinciSayfaHandle=each;
            }
            
        }
        Driver.getDriver().switchTo().window(ikinciSayfaHandle);
        System.out.println(Driver.getDriver().getTitle());

        WebElement newWindowYazisi=Driver.getDriver().findElement(By.tagName("h3"));

        Assert.assertTrue(newWindowYazisi.isDisplayed());

        Driver.closeDriver();
    }

    @Test
    public void testReusableIle(){
        Driver.getDriver().get("https://the-internet.herokuapp.com/windows");
        Driver.getDriver().findElement(By.linkText("Click Here")).click();
        ReusableMethods.switchToWindow("New Window");
        WebElement newWindowYaziElementi=Driver.getDriver().findElement(By.tagName("h3"));
        Assert.assertTrue(newWindowYaziElementi.isDisplayed());
        ReusableMethods.waitFor(5);
        Driver.closeDriver();
    }
}
