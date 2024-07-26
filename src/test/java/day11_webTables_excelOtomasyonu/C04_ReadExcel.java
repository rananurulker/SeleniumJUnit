package day11_webTables_excelOtomasyonu;

import org.apache.poi.ss.usermodel.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C04_ReadExcel {
    @Test
    public void test01() throws IOException {
        //excele ulasim sayfa1 de 8. satir ve 1. sutundaki datayi yazdiralim

        //1. adim java ile dosyaya ulasabilmek icin dosya yolunu hazirlayalim
        String dosyaYolu="src/test/java/day11_webTables_excelOtomasyonu/ulkeler.xlsx";

        //2. adim Java ile dosyaya erisip icindeki bilgileri alalim
        FileInputStream fis=new FileInputStream(dosyaYolu);

        //3. adim excel dosyalari birden fazla sayfa icerebilen dosyalar oldugu ucun
        //bunu apache.poi kullanarak workbbok olarak kaydedelim
        Workbook workbook= WorkbookFactory.create(fis);
        //gercek exceldeki bilgileri Java yardimi ile okuyup
        //bu classta olusturdugumuz workbooka yuledik
        //workbook exceldeki bilgilere sahip ama excelin bir kopyasi

        Sheet sayfa1=workbook.createSheet();

        //excel de java gibi index kullanir 8. satira gitmek istiyorsak index 7

        Row row8=sayfa1.getRow(8);
        Cell data8cisutun1Data= row8.getCell(1);
        System.out.println(data8cisutun1Data);//yerevan

    }
    @Test
    public  void test02() throws IOException {
        //excelde sayfa1 15.satir 4.datasini yazdirin



        String dosyaYolu="src/test/java/day11_webTables_excelOtomasyonu/ulkeler.xlsx";

        FileInputStream fis=new FileInputStream(dosyaYolu);
        Workbook workbook=WorkbookFactory.create(fis);

        //workbook olusturup exceldeki tum bilgileri wrkbooka yukledik
        //bundan sonra workbbokta vaer olan bilgileri alacagiz, bunun icin get () kullaniriz
        Sheet sayfa1=workbook.getSheet("sayfa 1");
        System.out.println(sayfa1.getRow(14).getCell(3));

        //22.satir 3.sutundaki bilginin Bolivya oldugunu test edin
        String expectedData="Bolivya";
        String actualData=sayfa1.getRow(21).getCell(2).toString();

        Assertions.assertEquals(expectedData,actualData);
    }
}
