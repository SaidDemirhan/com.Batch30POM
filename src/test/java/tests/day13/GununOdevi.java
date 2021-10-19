package tests.day13;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.util.List;

public class GununOdevi extends TestBase {
    /*
    ~ Navigate to http://tutorialsninja.com/demo/index.php?route=common/home
    ~ click on Phones & PDAs
    ~ get the brandName of phones
    ~ click on add to button for all elements
    ~ click on black total added cart button
    ~ get the names of list from the cart
    ~ compare the names from displaying list and cart list

    ~ http://tutorialsninja.com/demo/index.php?route=common/home adresine gidin
    ~ Telefonlar ve PDA'lara tıklayın
    ~ telefonların marka adını alın
    ~ tüm öğeler için ekle düğmesine tıklayın
    ~ siyah toplam eklenen sepet düğmesine tıklayın
    ~ listenin isimlerini sepetten alın
    ~ listeden ve sepet listesinden isimleri karşılaştırın

     */
    @Test
    public void test() throws InterruptedException {
        driver.get("http://tutorialsninja.com/demo/index.php?route=common/home");

        driver.findElement(By.linkText("Phones & PDAs")).click();

        List<WebElement>markalar=driver.findElements(By.tagName("h4"));

        for (WebElement each:markalar) {
            System.out.println("Telefon markalari: "+each.getText());
        }

        Actions actions=new Actions(driver);

        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(1000);
        driver.findElement(By.xpath("(//i[@class='fa fa-shopping-cart'])[4]")).click();

        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(1000);
        driver.findElement(By.xpath("(//i[@class='fa fa-shopping-cart'])[5]")).click();

         actions.sendKeys(Keys.PAGE_DOWN)
                 .sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(1000);
        driver.findElement(By.xpath("(//i[@class='fa fa-shopping-cart'])[6]")).click();

        driver.findElement(By.cssSelector("#cart-total")).click();

        //List<WebElement>sepettekiler=driver.findElements()

        Thread.sleep(3000);
    }

}
