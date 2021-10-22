package tests.day17_ExelAutomation;

import org.apache.poi.ss.usermodel.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class C01_ReadExel {

    @Test
    public void test () throws IOException {
        //. Dosya yolunu bir String degiskene atayalim
        String dosyaYolu= "src/test/java/resources/ulkeler.xlsx";
        //8. FileInputStream objesi olusturup,parametre olarak dosya yolunu girelim
        FileInputStream fileInputStream=new FileInputStream(dosyaYolu);
        //9. Workbook objesi olusturalim,parameter olarak fileInputStream objesini girelim
        Workbook workbook= WorkbookFactory.create(fileInputStream);
        //10. WorkbookFactory.create(fileInputStream)

        //11. Worksheet objesi olusturun workbook.getSheetAt(index)
        Sheet sheet= workbook.getSheet("sayfa1");
        //12. Row objesi olusturun sheet.getRow(index)
        Row row= sheet.getRow(4);
        //13. Cell objesi olusturun row.getCell(index)
        Cell cell= row.getCell(1);
        //indexler 0 dan baslar

        System.out.println(cell);

    }

    @Test
    public void test2 () throws IOException {
        //. Dosya yolunu bir String degiskene atayalim
        String dosyaYolu= "src/test/java/resources/ulkeler.xlsx";
        //8. FileInputStream objesi olusturup,parametre olarak dosya yolunu girelim
        FileInputStream fileInputStream=new FileInputStream(dosyaYolu);
        //9. Workbook objesi olusturalim,parameter olarak fileInputStream objesini girelim
        Workbook workbook= WorkbookFactory.create(fileInputStream);
        //10. WorkbookFactory.create(fileInputStream)

        //11. Worksheet objesi olusturun workbook.getSheetAt(index)

        //12. Row objesi olusturun sheet.getRow(index)

        //13. Cell objesi olusturun row.getCell(index)
        Cell cell= workbook.getSheet("sayfa1").getRow(5).getCell(3);
        //indexler 0 dan baslar

        System.out.println(cell);



        Assert.assertEquals(cell.toString(),"Luanda");
        Assert.assertEquals(cell.getStringCellValue(),"Luanda");

        //cell in data türü cell
        //ruanadanin data türü string

        //data türü farkli oldugu icin bu ikisi equal olamaz.

        //cell data türü yazdirilabilir ama String methodlarla kullanilamaz

        //string maniplation yapmak icin cell data turu nu stringe cast yapmaliyiz.

        //indexi 3 olan satirdaki 2. olan hucredeki yaziyi büyük harflerle yazdralim

        Cell cell1= workbook.getSheet("sayfa1").getRow(3).getCell(2);

        System.out.println(cell1.toString().toUpperCase());

        System.out.println(workbook.getSheet("sayfa1").getFirstRowNum());//0

        System.out.println(workbook.getSheet("sayfa1").getLastRowNum());//190

        System.out.println(workbook.getSheet("sayfa1").getPhysicalNumberOfRows());//191

        System.out.println(workbook.getSheet("sayfa2").getLastRowNum());//19

        System.out.println(workbook.getSheet("sayfa2").getPhysicalNumberOfRows());//6

        System.out.println(workbook.getSheet("sayfa2").getFirstRowNum());//0

    }

    @Test
    public void test3() throws IOException {
        //Tablodaki 2. sütunu bir liste olarak yazdirin.

        List<String>ikinciSutun=new ArrayList<>();

                String dosyaYolu= "src/test/java/resources/ulkeler.xlsx";

        FileInputStream fileInputStream=new FileInputStream(dosyaYolu);

        Workbook workbook= WorkbookFactory.create(fileInputStream);

        for (int i=0; i<=workbook.getSheet("sayfa1").getLastRowNum(); i++){
            ikinciSutun.add(workbook.getSheet("Sayfa1").getRow(i).getCell(1).toString());
        }
        System.out.println(ikinciSutun);


        //a ile baslayan sehirleri liste yapip yazdirin.

        List<String>aIleBaslayanSehirler=new ArrayList<>();

        for (String each:ikinciSutun
             ) {
            if (each.startsWith("A")){
                aIleBaslayanSehirler.add(each);
            }
        }

        System.out.println(aIleBaslayanSehirler);

        //eger tüm datayi java da kullanilabilir bir collectiona cevirmek istesek;

        //en  uygun yapi map olur

        //map icin unique degerlere sahip bir sutunu geriye kalan tüm sütunlari ise virgul ile ayrilan
        //string ler olarak valure yapmaliyiz.
        //key=Turkey value Ankara,Türkiye,Ankara

        Map<String,String>ulkelerMap=new HashMap<>();

        String key="";
        String value="";

        for (int i=0; i<=workbook.getSheet("sayfa1").getLastRowNum(); i++){
            key=workbook.getSheet("sayfa1").getRow(i).getCell(0).toString();
            value=workbook.getSheet("sayfa1").getRow(i).getCell(1).toString()+ ", "+
                  workbook.getSheet("sayfa1").getRow(i).getCell(2).toString()+ ", "+
                    workbook.getSheet("sayfa1").getRow(i).getCell(3).toString();

            ulkelerMap.put(key,value);
        }
        System.out.println(ulkelerMap);

        //biz java methodlarini ve collection u kullanarak
        //exel deki datalari manupile edebilecegimiz Java ortamina alabiliriz.
    }
}
