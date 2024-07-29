package exercise02;

import Utilities.TestBaseEach;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class E01_excelRead {
    @Test
    public void test01() throws IOException {
        //gerekli ayarlamalari yapip ulkeler excelindeki sayfa 1 e gidin
        String dinamikDosyaYolu=System.getProperty("user.dir")+"/"+"src/test/java/day11_webTables_excelOtomasyonu/ulkeler.xlsx";
        FileInputStream fis=new FileInputStream(dinamikDosyaYolu);
        Workbook workbook= WorkbookFactory.create(fis);
        Sheet sayfa1=workbook.getSheet("Sayfa1");

        //10. satirdaki 2. hucreye gidip yazdir
        System.out.println(sayfa1.getRow(9).getCell(1));

        // 10. satrdaki 2. hucreyi bir string degiskene ata ve degerinin "Canberra" oldugunu test edin
        String expectedYazi="Canberra";
        String actualYazi=sayfa1.getRow(9).getCell(1).toString();

        Assertions.assertEquals(expectedYazi,actualYazi);

        //2. satir 4. cellin afganistanin baskenti "Kabil" oldugunu test edin
        String expectedBaskent="Kabil";
        String actualBaskent=sayfa1.getRow(1).getCell(3).toString();

        Assertions.assertEquals(expectedBaskent,actualBaskent);

        //ulke sayisinin 190 oldugunu test edin
        int expectedUlkeSayisi=190;
        int actualUlkeSayisi=sayfa1.getLastRowNum()+1-1;

        //getLastRowNumber bize index verdigi icin 191 satir kullanildigi halde 190 verecek
        //eger kac satir kullanildigini bulmak istersek buna 1 eklemek gerekir.
        //ancak en basta baslik oldugundan ulke sayisini bulmak icin kullanilan satir sayisini -1 yapmaliyiz

        Assertions.assertEquals(expectedUlkeSayisi,actualUlkeSayisi);

        //fiziki olarak kullanilan satir sayisinin 191 oldugunu test edin
        int expectedKullanilanSatirSayisi=191;
        int actualKullanilanSatirSayisi=sayfa1.getPhysicalNumberOfRows();
        Assertions.assertEquals(expectedKullanilanSatirSayisi,actualKullanilanSatirSayisi);




    }
}
