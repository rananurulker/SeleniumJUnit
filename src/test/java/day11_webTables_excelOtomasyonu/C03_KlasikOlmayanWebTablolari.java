package day11_webTables_excelOtomasyonu;

import Utilities.ReusableMethods;
import Utilities.TestBaseEach;
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
        System.out.println("Tablodaki tum data sayisi"+ tumDatalar.size());

        // 6. Tablodaki satir sayisini yazdirin


        // 7. Tablodaki sutun sayisini yazdirin
        // 8. Tablodaki 3.kolonu yazdirin
        // 9. Tabloda " Category" si Furniture olan urunun fiyatini yazdirin
        //10. Bir method olusturun, Test sayfasindan satir ve sutun verildiginde datayi yazdirsin
    }
}
