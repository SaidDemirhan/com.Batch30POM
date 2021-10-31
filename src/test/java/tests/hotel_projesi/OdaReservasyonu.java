package tests.hotel_projesi;

import com.github.javafaker.Faker;
import org.openqa.selenium.Keys;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.QAConcortPage;
import utilities.ConfigReader;
import utilities.Driver;

public class OdaReservasyonu {

    @Test
    public void odaReservasyonuTest() throws InterruptedException {
        Driver.getDriver().get(ConfigReader.getProperty("PCHUrl"));

        QAConcortPage qaConcortPage= new QAConcortPage();
        qaConcortPage.usernameKutusu.sendKeys(ConfigReader.getProperty("CHValidUsername"));
        qaConcortPage.passwordKutusu.sendKeys(ConfigReader.getProperty("CHValidPassword"));
        qaConcortPage.pLoginTusu.click();

        Select selectUser=new Select(qaConcortPage.pSelectUser);
        selectUser.selectByValue("2");

        Select selectHotelRoom =new Select(qaConcortPage.pSelectHotelRoom);
        selectHotelRoom.selectByValue("16");

        Faker faker =new Faker();
        qaConcortPage.pPrice.sendKeys(String.valueOf(faker.number().numberBetween(20,200)));

        Actions actions=new Actions(Driver.getDriver());
        actions.sendKeys(Keys.PAGE_DOWN).perform();

        Thread.sleep(2000);

        qaConcortPage.pDateStartTakvim.click();
        qaConcortPage.pTakvimSagOk.click();
        qaConcortPage.pStartDay.click();

        qaConcortPage.pDateEndTakvim.click();
        qaConcortPage.pTakvimSagOk.click();
        qaConcortPage.pEndDay.click();

        qaConcortPage.pAdultAmount.sendKeys("2");
        actions.sendKeys(Keys.TAB)
                .sendKeys("1")
                .sendKeys(Keys.TAB)
                .sendKeys(faker.name().fullName())
                .sendKeys(Keys.TAB)
                .sendKeys("5262415878")
                .sendKeys(Keys.TAB)
                .sendKeys(faker.internet().emailAddress())
                .sendKeys(Keys.TAB)
                .sendKeys("Bu hotelde konaklamak icin sabirsizlaniyoruz.")
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .perform();

        qaConcortPage.pSave.click();

        Thread.sleep(2000);

        String expectedYazi="RoomReservation was inserted successfully";
        String actualYazi=qaConcortPage.pBasariliYazisiElementi.getText();

        Assert.assertEquals(actualYazi,expectedYazi,"Rezervasyon yapilamamistir!");

        Driver.closeDriver();
    }
}
