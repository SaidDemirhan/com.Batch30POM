package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.w3c.dom.html.HTMLInputElement;
import utilities.ConfigReader;
import utilities.Driver;

import java.util.List;

public class QAConcortPage {


    public QAConcortPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }


    @FindBy(linkText="Log in")
    public WebElement ilkLoginLinki;

    @FindBy(id="UserName")
    public WebElement usernameKutusu;

    @FindBy(id="Password")
    public WebElement passwordKutusu;

    @FindBy(id="btnSubmit")
    public WebElement loginButonu;

    @FindBy(xpath = " //span[@class='caption-subject font-green-sharp bold uppercase']")
    public WebElement basariliGirisYaziElementi;

    @FindBy (xpath = "//*[.='Try again please']")
    public WebElement loginFaildYazisi;

    @FindBy(xpath = "//span[text()='Hotel Management']")
    public WebElement hotelManagementLinki;

    @FindBy(partialLinkText = "Hotel List")
    public WebElement hotelListLink;

    @FindBy(xpath ="//span[text()='Add Hotel ']")
    public WebElement addHotelLink;

    @FindBy(id = "Code")
    public WebElement addHotelCodeKutusu;

    @FindBy(partialLinkText ="Hotel Rooms")
    public WebElement hotelRoomsLinki;

    @FindBy(xpath = "//span[text()='Add Hotelroom ']")
    public WebElement addHotelLinkButonu;

    @FindBy(id ="IDHotel")
    public WebElement addRoom;

    @FindBy(id = "IDGroupRoomType")
    public WebElement addRoomType;

    @FindBy(id="IDGroup")
    public WebElement addHotelDropdown;

    @FindBy (id ="btnSubmit" )
    public WebElement addRoomSaveButonu;

    @FindBy (xpath = "//div[class='bootbox-body']")
    public WebElement addRoomSuccesfullYazisi;

    @FindBy(xpath = "//button[@class='btn btn-primary']")
    public WebElement addRoomAllertOkButonu;

    @FindBy (linkText = "Hotelrooms")
    public WebElement addroomHotelRooms;

    @FindBy(linkText = "Hotelrooms")
    public WebElement addroomHotelRoomsLinki;

    @FindBy(xpath ="//span[text()='List Of Hotelrooms']")
    public WebElement addRoomHotelListyazisi;

    @FindBy(xpath = "//thead/tr[1]/th")
    public List<WebElement> basliklarListesi;

    @FindBy(xpath = "//tbody")
    public WebElement tBodyTumu;

    @FindBy(xpath = "//tbody//tr")
    public List<WebElement> satirlarListesi;

    @FindBy(xpath = "//tbody//tr[1]")
    public WebElement birinciSatir;

    @FindBy(xpath = "//tbody/tr//td[4]")
    public List<WebElement> dorduncuSutunListesi;


    //===================================================//
    @FindBy(xpath = "(//*[text()='Log in'])[2]")
    public WebElement pLoginTusu;

    @FindBy(xpath = "//select[@id='IDUser']")
    public WebElement pSelectUser;

    @FindBy(xpath = "//select[@id='IDHotelRoom']")
    public WebElement pSelectHotelRoom;

    @FindBy(xpath = "//input[@id='Price']")
    public WebElement pPrice;

    @FindBy(xpath = "(//span[@class='input-group-btn'])[1]")
    public WebElement pDateStartTakvim;

    @FindBy(xpath = "(//i[@class='fa fa-angle-right'])[3]")
    public WebElement pTakvimSagOk;

    @FindBy(xpath = "(//td[@class='day'])[20]")
    public WebElement pStartDay;

    @FindBy(xpath = "(//td[@class='day'])[25]")
    public WebElement pEndDay;

    @FindBy(xpath = "(//span[@class='input-group-btn'])[2]")
    public WebElement pDateEndTakvim;

    @FindBy(xpath = "//input[@id='AdultAmount']")
    public WebElement pAdultAmount;

    @FindBy(xpath = "//input[@id='ChildrenAmount']")
    public WebElement pChildrenAmount;

    @FindBy(xpath = "//input[@id='ContactNameSurname']")
    public WebElement pContactNameSurname;

    @FindBy(xpath = "//input[@id='ContactPhone']")
    public WebElement pContactPhone;

    @FindBy(xpath = "//input[@id='ContactEmail']")
    public WebElement pContactEmail;

    @FindBy(xpath = "//input[@id='Notes']")
    public WebElement pNotes;

    @FindBy(xpath = "//button[@id='btnSubmit']")
    public WebElement pSave;

    @FindBy(className = "bootbox-body")
    public WebElement pBasariliYazisiElementi;






    //===================================================//

    public void QAConcortHotelLogin(){
        Driver.getDriver().get(ConfigReader.getProperty("CHQAUrl"));
        QAConcortPage qaConcortPage=new QAConcortPage();
        qaConcortPage.ilkLoginLinki.click();
        qaConcortPage.usernameKutusu.sendKeys(ConfigReader.getProperty("CHQAValidUsername"));
        qaConcortPage.passwordKutusu.sendKeys(ConfigReader.getProperty("CHQAValidPassword"));
        qaConcortPage.loginButonu.click();

}

    public String printData(int satir, int sutun) {
        //örnekteki haliyle 5.satir 3. sütundaki elemani yazdiralim
        //degismeyecek kisimlari string
        //degisecek kisimlari da parametre ismi olarak yazdik

       String xpath ="//tbody//tr["+satir+"]//td["+sutun+"]";

        //System.out.println("satir: "+satir+"sütun: "+sutun);

        //@FindBy notasyonu parametrelicalismadigi icin önceki yöntemle
        //locate edelim.

        String istenenData= Driver.getDriver().findElement(By.xpath(xpath)).getText();
        System.out.println("satir: "+satir+" sütun: "+sutun+"'deki istenen data");

        return istenenData;
    }
}

