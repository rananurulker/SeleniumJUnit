package day11_webTables_excelOtomasyonu;

import Utilities.ReusableMethods;
import Utilities.TestBaseEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class C02_KlasikHTMLTable extends TestBaseEach {
    @Test
    public void test01(){

        //1."https://testotomasyonu.com/webtables" adresine gidin
        driver.get("https://testotomasyonu.com/webtables");

        //2.Web table tum body’sini yazdirin
        System.out.println("=====================================");

        WebElement tumbodyElemeti=driver.findElement(By.xpath("//tbody"));
        System.out.println(tumbodyElemeti.getText());
        System.out.println("=====================================");


        //3. Web tablosunda "Comfortable Gaming Chair" bulundugunu test edin
        String expectedBodyIcerigi="Comfortable Gaming Chair";
        String actualBody=tumbodyElemeti.getText();

        Assertions.assertTrue(actualBody.contains(expectedBodyIcerigi));

        //4. Web table’daki satir sayisinin 5 oldugunu test edin
        List<WebElement> satirElementleriListesi=driver.findElements(By.xpath("//tbody//tr"));
        int expectedSatirSayisi=5;
        int actualSatirSayisi=satirElementleriListesi.size();

        Assertions.assertEquals(expectedSatirSayisi,actualSatirSayisi);

        //alttaki sekilde yazilirsa da 1 satirda tum kod yazilmis olur

        // Assertions.assertEquals(5,satirElementleriListesi.size());

        //5. Tum satirlari yazdirin

        for (int i = 0; i <satirElementleriListesi.size() ; i++) {
            System.out.println(i+1 + ".satir  ==>  \n"+satirElementleriListesi.get(i).getText());

        }
        //6. Web table’daki sutun sayisinin 4 olduğunu test edin
        //web tablolarindaki sutun bilgisi olmaz.
        //bunn yerine herhangi bir satirdaki data saysini alabiliriz

        List<WebElement> ucuncuSatirElementleriList=driver.findElements(By.xpath("//tbody//tr[3]/td"));

        int expectedSutunSayisi=4;
        int actualSutunSayisi=ucuncuSatirElementleriList.size();
        Assertions.assertEquals(expectedSutunSayisi,actualSutunSayisi);

        //7. 3.sutunu yazdirin
        //web tablolarinda sutun olmaz
        //bun yerine hangi satir olursa olsun o satirin 3. datasini yazdirabilirz

        List<WebElement> ucuncusutunElementleriListesi=driver.findElements(By.xpath("//tbody//tr[*]/td[3]"));
        System.out.println(ReusableMethods.getStringList(ucuncusutunElementleriListesi));

        //8. Tablodaki basliklari yazdirin
        System.out.println(driver.findElement(By.xpath("//thead")).getText());
        //9. Satir ve sutunu parametre olarak alip, hucredeki bilgiyi döndüren bir method olusturun
        System.out.println(getCellData(1, 2));

        //10. 4.satirdaki category degerinin "Furniture" oldugunu test edin
        String expectedCategory="Furniture";
        String actualCategory=getCellData(4,2);
        Assertions.assertEquals(expectedCategory,actualCategory);

        //Categorysi travel olan urunun fiyatinin 99 dolar oldyunu test edin
        //her satirdaki category degerine bakarim
        //categorisi travel olan satirdaki fiyat bilgisini alip actual fiyat olarak kaydederim
        //ikisini karsilastiririm

        String expectedFiyat="$99.00";
        String actualFiyat="";
        for (int i = 1; i <=satirElementleriListesi.size() ; i++) {

            //i.satirdaki kategori bilgisini alalim
            String satirdakiCategori=getCellData(i,2);

            if (satirdakiCategori.equalsIgnoreCase("travel")){
                actualFiyat=getCellData(i,3);

            }


        }
        Assertions.assertEquals(expectedFiyat,actualFiyat);



    }
    //9. Satir ve sutunu parametre olarak alip, hucredeki bilgiyi döndüren bir method olusturun

    public String getCellData(int satir,int sutun){
        //bir dataya ulasmak icin xpath: //tbody/tr [5] /td[3]

    String dinamikXpath = "//tbody/tr[" +satir+ "]/td[" +sutun + "]";
    WebElement istenenDataElementi=driver.findElement(By.xpath(dinamikXpath));
    istenenDataElementi.getText();

    return istenenDataElementi.getText();
}
}
