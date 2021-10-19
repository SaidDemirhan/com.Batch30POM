package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    //1-Properties objesi olusturacagiz
    static Properties properties;


    //2-Bu class in amaci konfigiration.properties dosyasini okumak ve
    //oradaki key value iklilerini kullanarak istenilen key e ait value yu
    //bize getirmesidir.

    static {    //statiic blok olusturduk
        String dosyaYolu="configuration.properties";
        try {
            FileInputStream fileInputStream=new FileInputStream(dosyaYolu);
            properties=new Properties();
            properties.load(fileInputStream);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    //3-Test class larindan configreader class ina ulasip yukardaki islemleri
    //yapmamizi saglayacak bir method olusturacagiz.

    public static String getProperty(String key){

        String value=properties.getProperty(key);

        return value;
    }

}
