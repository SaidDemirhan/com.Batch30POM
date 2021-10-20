package tests.day15;

import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;


public class C01_DriverClassKullanimi {
    @Test
    public void test(){
        Driver.getDriver();
        Driver.getDriver().get(ConfigReader.getProperty("AmazonUrl"));
        Driver.getDriver().get(ConfigReader.getProperty("FacebookUrl"));
        Driver.getDriver().get(ConfigReader.getProperty("CHUrl"));

        Driver.closeDriver();

        //Driver driver=new Driver();

        //Driver class indan obje uretilmesini engellemek icin Driver Class i SINGLETON yapiyoruz
        // default const yerine  psiz const. yapip acc modd privat yazariz.

        //Driver driver=new Driver("ben istedim ama olmadi");
        //pli const da kabul etmez.
    }
}
