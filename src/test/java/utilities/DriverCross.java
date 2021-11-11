package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;

import java.util.concurrent.TimeUnit;

public class DriverCross {

    private static WebDriver driver;

    private DriverCross(){

    }
    //driver i baska class lardan cagirabilmek icin static yaptik
    //henuz driverlarl  ilgili atama ve ayar yapilmadigi icin
    //yanlis kullanimlarin önune gecmek icin privat yaptik.

    public static WebDriver getDriver(String browser) {



        if (driver == null) {

            browser=browser==null? ConfigReader.getProperty("browser"):browser;
            //eger browser null olarak gelirse emniyet sibopu olarak ternary koyduk.

            switch ("browser") {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;

                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;

                case "opera":
                    WebDriverManager.operadriver().setup();
                    driver = new OperaDriver();
                    break;

                case "edge":
                    WebDriverManager.edgedriver().setup();
                    driver = new EdgeDriver();
                    break;

                default:
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
            }

           // driver.manage().window().maximize();
           // driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

            //diger yerde (testbaseCross) de oldugu icin bunu devre disi biraktik
        }
        return driver;
    }

    public static void closeDriver () {

        if (driver!=null) {
            driver.quit();

        }

        driver=null;
    }



}
