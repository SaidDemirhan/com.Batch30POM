package pages;

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


    public void QAConcortHotelLogin(){
        Driver.getDriver().get(ConfigReader.getProperty("CHQAUrl"));
        QAConcortPage qaConcortPage=new QAConcortPage();
        qaConcortPage.ilkLoginLinki.click();
        qaConcortPage.usernameKutusu.sendKeys(ConfigReader.getProperty("CHQAValidUsername"));
        qaConcortPage.passwordKutusu.sendKeys(ConfigReader.getProperty("CHQAValidPassword"));
        qaConcortPage.loginButonu.click();

}

}

