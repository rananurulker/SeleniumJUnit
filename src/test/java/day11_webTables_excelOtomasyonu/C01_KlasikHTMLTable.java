package day11_webTables_excelOtomasyonu;

import Utilities.ReusableMethods;
import Utilities.TestBaseEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class C01_KlasikHTMLTable extends TestBaseEach {
    @Test
    public void test01(){
        //1."https://testotomasyonu.com/webtables" adresine gidin
        driver.get("https://testotomasyonu.com/webtables");

        //butun basliklari yazdirin
        //once satira gider satirin icindeki datayi verir. sutuna gitmez
        WebElement headerButunBasliklar= driver.findElement(By.xpath("//table/thead"));
        System.out.println(headerButunBasliklar.getText()); //Produt Name Category Price Actions

        //baslik satirindaki ikinci basligi yazdirin
        System.out.println(driver.findElement(By.xpath("//thead/tr/th[2]")).getText());//Category

        //tum basliklari bir liste olarak kaydedin
       List<WebElement> baslikElementleriListesi=driver.findElements(By.xpath("//thead/tr/th"));
       List<String> basliklarList= ReusableMethods.getStringList(baslikElementleriListesi);
        System.out.println(basliklarList);//[Produt Name, Category, Price, Actions]
        //4.satirdakini yazdirin
        System.out.println(basliklarList.get(3));//Actions

        //tablodaki urunlerden ikinci satir 3. sutundaki bilgiyi yazdirin
        System.out.println(driver.findElement(By.xpath("//tbody/tr[2]/td[3]")).getText());//$40.00

        //3. satirdaki urunun butuun bilgilerini yazdirin
        System.out.println(driver.findElement(By.xpath("//tbody/tr[3]")).getText()); //Medium 25 L Laptop Backpack
        //For Office/College/Travel (Black, Yellow)
        //Travel
        //$99.00 Go


        //2.Web table tum body’sini yazdirin

        //3. Web tablosunda "Comfortable Gaming Chair" bulundugunu test edin
        //4. Web table’daki satir sayisinin 5 oldugunu test edin
        //5. Tum satirlari yazdirin
        //6. Web table’daki sutun sayisinin 4 olduğunu test edin
        //7. 3.sutunu yazdirin
        //8. Tablodaki basliklari yazdirin
        //9. Satir ve sutunu parametre olarak alip, hucredeki bilgiyi döndüren bir method olusturun
        //10. 4.satirdaki category degerinin "Furniture" oldugunu test edin
    }
}
