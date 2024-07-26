package day11_webTables_excelOtomasyonu;

import Utilities.ReusableMethods;
import Utilities.TestBaseEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class C03_KlasikOlmayanWebTablolari extends TestBaseEach {
    @Test
    public void test01(){
        //1. “https://testotomasyonu.com/webtables2” sayfasina gidin
        driver.get("https://testotomasyonu.com/webtables2");

        // 2. Headers da bulunan basliklari yazdirin
        List<WebElement> baslikElementleriList=
                driver.findElements(By.xpath("//*[@role ='hrow']/*[@role='hdata']"));
        System.out.println(ReusableMethods.getStringList(baslikElementleriList));

        //klasik HTML tablo olsaydi //thead/th olurdu ancak burada klasik tablo olmadigi icin


        // 3. 3.sutunun basligini yazdirin
        System.out.println(baslikElementleriList.get(2).getText());

        // 4. Tablodaki tum datalari yazdirin
        List<WebElement> tumDatalar=driver.findElements(By.xpath("//*[@role ='tdata']"));
        System.out.println(ReusableMethods.getStringList(tumDatalar));

        // 5. Tabloda kac tane cell (data) oldugunu yazdirin
        System.out.println("Tablodaki tum data sayisi: "+ tumDatalar.size());

        // 6. Tablodaki satir sayisini yazdirin
        List<WebElement> satirElementleriList=
                driver.findElements(By.xpath("//*[@role ='trow']"));
        System.out.println("Tablodaki satir sayisi: "+ satirElementleriList.size());


        // 7. Tablodaki sutun sayisini yazdirin
        //web tablosunda sutun olmaz, bu sebeple herhangi bir satirdaki data sayisini yazalim

        System.out.println("tablodaki sutun sayisi: "+baslikElementleriList.size());

        // 8. Tablodaki 3.kolonu yazdirin
        //sutun olmadigi icin her satirdaki 3. listeyi yazdiralim

        List<WebElement> ucuncuKolonElemetnlerList=
                driver.findElements(By.xpath("(//*[@role ='trow']) / *[@role ='tdata'][3]"));
        System.out.println(ReusableMethods.getStringList(ucuncuKolonElemetnlerList));

        // 9. Tabloda " Category" si Men Fashion olan urunun fiyatini yazdirin

        String expectedFiyat="$15.00";
        String actualFiyat="";
        for (int i = 1; i <= satirElementleriList.size() ; i++) {
            //i.satirdaki kategori bilgisini alalim
            String satirdakiCategori=getCellData(i,2);

           if (satirdakiCategori.equalsIgnoreCase("Men Fashion")){
               System.out.println("istenen fiyat: "+ getCellData(i,3));
           }


        }



        //10. Bir method olusturun, Test sayfasindan satir ve sutun verildiginde datayi dondursun
        System.out.println(getCellData(1, 1));
        System.out.println(getCellData(4, 2));

    }
    public String getCellData(int satir, int sutun){
        String istenenData="";

        //herhangi bir cell icin xpath : //*[@role ='trow'][3] / *[@role='tdata'][1]

        String dinemaikXpath= "//*[@role ='trow']["+satir+"] / *[@role='tdata']["+sutun+"]";
        istenenData=driver.findElement(By.xpath(dinemaikXpath)).getText();

        return istenenData;
    }
}
