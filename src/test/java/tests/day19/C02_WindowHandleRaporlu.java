package tests.day19;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class C02_WindowHandleRaporlu extends TestBaseRapor {

    @Test
    public void test(){

        extentTest=extentReports.createTest("Window Handle Test","yeni sayfada new window yazisini test eder");

        Driver.getDriver().get("https://the-internet.herokuapp.com/windows");
        extentTest.info("adrese gidildi");

        Driver.getDriver().findElement(By.linkText("Click Here")).click();
        extentTest.info("linke tiklandi");

        ReusableMethods.switchToWindow("New Window");
        extentTest.info("yeni sayfaya gidildi");

        WebElement newWindowYaziElementi=Driver.getDriver().findElement(By.tagName("h3"));
        extentTest.info("locate edildi");

        Assert.assertFalse(newWindowYaziElementi.isDisplayed());
        extentTest.pass("yazi görünüyor");



    }
}
