package day12_excelOtomasyon_Screenshot_JsExecutor;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class C01_ReadExcel {

    @Test
    public void test01() throws IOException {
    //gerekli ayarlamalri yapip ulkeler excelindeki sayfa1 e gidin
   // String dosyaYolu="src/test/java/day11_webTables_excelOtomasyonu/ulkeler.xlsx";
    //eger calisacagimiz dosya proje klasorunun icinde degilse
    // proje ekibindeki herkesin calistorabilmesi icin
     //dosya yolunun dinemik olmasi gerek

    System.out.println(System.getProperty("user.dir"));//projenin dosyayolunu verir
        //C:\Users\User\IdeaProjects\Team144_JUnit

    System.out.println(System.getProperty("user.home"));//bilgisayarin kodun calistigi bilgisayarin ana dosya yolunu verir
        //C:\Users\User

        String dinamikDosyaYolu=System.getProperty("user.dir")+"/"+
                "src/test/java/day11_webTables_excelOtomasyonu/ulkeler.xlsx";

        FileInputStream fis=new FileInputStream(dinamikDosyaYolu);
        Workbook workbook= WorkbookFactory.create(fis);
        Sheet sayfa1= workbook.getSheet("Sayfa1");

        //- 1.satirdaki 2.hucreye gidelim ve yazdirin
        System.out.println(sayfa1.getRow(0).getCell(1));

        // - 1.satirdaki 2.hucreyi bir string degiskene atayalim ve  degerinin
        // baskent ingilizce olduhunu est edin yazdirin

        String expectedYazi="Başkent (İngilizce)";
        String actualYazi=sayfa1.getRow(0).getCell(1).toString();

        Assertions.assertEquals(expectedYazi,actualYazi);

    // - 2.satir 4.cell’in afganistan’in baskenti “Kabil” oldugunu test edin

        String expectedBaskent="Kabil";
        String actualBaskent=sayfa1.getRow(1).getCell(3).toString();

        Assertions.assertEquals(expectedBaskent,actualBaskent);

    // - Ulke sayisinin 190 oldugunu test edin
        int expectedUlkeSayisi=190;
        int actualUlkeSayisi=sayfa1.getLastRowNum()+1-1;

        Assertions.assertEquals(expectedUlkeSayisi,actualUlkeSayisi);

        //getLastRownum() bize index verdigi icin 191 satir kullanildigi halde 190 verecek
        //eger kac satir kullanildigini bulmak istersek buna 1 eklememiz gerekiyor
        //ancak en basta baslik oldugundan
        //ulke sayisini bulmak icin  kullanilan satir sayisindan 1 cikarmak gerekiyor

    // - Fiziki olarak kullanilan satir sayisinin 191 oldugunu test edin
        int expectedKullanilanSatir=191;
        int actualKUllanilanSatir=sayfa1.getPhysicalNumberOfRows();

        Assertions.assertEquals(expectedKullanilanSatir,actualKUllanilanSatir);
        //getphsicalnumberofrows bos satirlari saymaz. arada bos satir varsa +1 demeliyiz

    // - Ingilizce ismi Netherlands olan ulkenin baskentinin turkce Amsterdam oldugunu test edin
        String satirdakiTurkceBaskentIsmi="";
        for (int i = 1; i <=sayfa1.getLastRowNum() ; i++) {
            String satirdakiUlkeIsmi=sayfa1.getRow(i).getCell(0).toString();
            if (satirdakiUlkeIsmi.equalsIgnoreCase("Netherlands")){
                satirdakiTurkceBaskentIsmi = sayfa1.getRow(i).getCell(3).toString();
            }

        }
        Assertions.assertEquals("Amsterdam",satirdakiTurkceBaskentIsmi);

    //- Turkce baskent isimlerinde Ankara bulundugunu test edin

        //bu soru iki turlu cozulebilir
        //1- for loop ve flag kullanimi

        boolean ankaraVarmi=false;

        for (int i = 1; i <=sayfa1.getLastRowNum() ; i++) {
            satirdakiTurkceBaskentIsmi=sayfa1.getRow(i).getCell(3).toString();

            if (satirdakiTurkceBaskentIsmi.equalsIgnoreCase("Ankara")){
                ankaraVarmi=true;
                break;
            }

        }

        Assertions.assertTrue(ankaraVarmi);

        //2.yol Ingilizce ulke ismini Key, Turkce baskent ismini value olarak secip
        //tum ulkelerin bu iki bilgisini bir mape koyalim

        Map<String,String> ulkelerMap=new TreeMap<>();

        for (int i = 1; i <=sayfa1.getLastRowNum() ; i++) {
            String satirdakiIngilizceUlkeIsmi=sayfa1.getRow(i).getCell(0).toString();
            satirdakiTurkceBaskentIsmi=sayfa1.getRow(i).getCell(3).toString();

            ulkelerMap.put(satirdakiIngilizceUlkeIsmi,satirdakiTurkceBaskentIsmi);


        }
        System.out.println(ulkelerMap);
        //ulkeler mapinde baskent ankara oldugunu test edin
        Assertions.assertTrue(ulkelerMap.containsValue("Ankara"));

        //ulkeler mapinda berlin bulundgunu test edin
        Assertions.assertTrue(ulkelerMap.containsValue("Berlin"));

        //ulkeler listesinde Nepal bulundugnu test edin
        Assertions.assertTrue(ulkelerMap.containsKey("Nepal"));

        //195.satirin 1. hcresini yazdirin
        //System.out.println(sayfa1.getRow(194).getCell(0)); //NullPointerException firlatir

        //3. satirdaki 10. hucreyi yazdirin
        System.out.println(sayfa1.getRow(2).getCell(9));//null cunku satir zaten var sadece o sutun bos


    }
}

