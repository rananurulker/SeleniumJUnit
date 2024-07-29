package day12_excelOtomasyon_Screenshot_JsExecutor;

import Utilities.ReusableMethods;
import Utilities.TestBaseAll;
import Utilities.TestBaseEach;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class C03_TumSayfaScreenshot extends TestBaseEach {

    @Test
    public void test01() throws IOException {
        //testotomasyonu sayfasina gidin

        driver.get("https://www.testotomasyonu.com");

        //phone icin arama yapin
        WebElement aramaKutusu=driver.findElement(By.id("global-search"));
        aramaKutusu.sendKeys("phone"+ Keys.ENTER);


        //urun bulunabildigini test edin
        String unExpectedSonucYazisi="0 Products Found";
        String actualSonucYazisi=driver.findElement(By.className("product-count-text")).getText();

        Assertions.assertNotEquals(unExpectedSonucYazisi,actualSonucYazisi);

        ReusableMethods.bekle(3);


        //eger tum sayfa screenshot almak isterseniz 4 adim atmak gerekli

        //1. adim screenshot objesi olusturmak ve deger olarak driverimizi atama
        TakesScreenshot tss=(TakesScreenshot) driver;

        //2.adim screenshoti kaydedecegimiz file olusturulmali
        File tumSayfaSS=new File("target/ekrangoruntuleri/tumSayfaSS.png");

        //3.adim screnshot i alip gecici bir dosyaya kopyalayalim
        File geciciDosya=tss.getScreenshotAs(OutputType.FILE);

        //4. adim gecici dosyayi asil kaydetmek istedigimiz dosyaya kopyalayalim
        FileUtils.copyFile(geciciDosya,tumSayfaSS);








}
}
