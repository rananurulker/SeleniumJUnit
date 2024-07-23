package day08SwitchingWindows_actionclass;

import Utilities.ReusableMethods;
import Utilities.TestBaseAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;

public class C02_KontrolluWindowDegistirme extends TestBaseAll {
    @Test
    public void test01(){
        driver.get("https://www.testotomasyonu.com");

        System.out.println(driver.getCurrentUrl()); // https://www.testotomasyonu.com/
        System.out.println(driver.getWindowHandle()); // B3EAA570CB2910434B41A8E608AF22F2
        String newhandleDegeri= driver.getWindowHandle();
        ReusableMethods.bekle(1);

        //yeni bir tab olusturup
        //eger yeni bir window olusturuo yeni sekmede acmak istiyorsak switch to ile yapabiliriz

        driver.switchTo().newWindow(WindowType.TAB);
        //1-driver otomatik olarak yeni acilan windowa gecer
        //2- yeni window bos olarak gelir. yani url blank olarak gelir
        //3- yeni acilan window bos olacagi icin navigate burada kullanilmaz
        //4- anasayfaya donmek icin driver.switchto(Ana sayfa handle degeri yazilmali)
        //5- yeni acilan sayfa bos oldugu icin orada herhangi birmlinke basmak mumkun olmayacaktir
        //bu sebeple yeni bir tabda acilan window icin driver.get diyerek yeniden url gonderimi yapilmalidir.



        System.out.println(driver.getCurrentUrl()); // about:blank
        System.out.println(driver.getWindowHandle()); // C17348F2A384AA8B21A845DAEB277698
        ReusableMethods.bekle(1);

        System.out.println("+++++++++++++++++++++++++++++++++");
        driver.get("https://www.testotomasyonu.com");
        driver.findElement(By.xpath("(//a[text()='Electronics'])[3]"))
                .click();
        String ikinciwindowhandleDegeri=driver.getWindowHandle();
        System.out.println("Electronics linkine basinca: "+driver.getCurrentUrl()); //about:blank
        System.out.println("Electronics linkine basinca WHD: "+driver.getWindowHandle());//C64E9D3DFBC50CDFFDE19B060D48517F
        System.out.println("Electronics linkine basinca WHDS: "+driver.getWindowHandles()); //[EFCB266F47AF8424E4EB748DC4E1C16E, A3EFEDB3CCF9814A0BCB51473CFC869B, C64E9D3DFBC50CDFFDE19B060D48517F]

        System.out.println("+++++++++++++++++++++++++++++++++");

        //yeni bir windowda wisequarter.coma gidin
        driver.switchTo().newWindow(WindowType.WINDOW);

        System.out.println("3. window acilinca: "+driver.getCurrentUrl()); //
        System.out.println("3. window acilinca: "+driver.getWindowHandle());
        System.out.println("3. window acilinca: "+driver.getWindowHandles());

        driver.get("https://www.wisequarter.com");

        String ucuncuWindowHandleDegeri=driver.getWindowHandle();
        System.out.println("++++++++++++++++++++++++++++++++++");
        System.out.println("Birinci window icin whd: "+ newhandleDegeri);
        System.out.println("Ikinci window icin whd: "+ ikinciwindowhandleDegeri);
        System.out.println("Ucuncu window icin whd: "+ ucuncuWindowHandleDegeri);

        // testotomasyonu anasayfanin acik oldugu window'a donun ve
        // anasayfada oldugunuzu test edin

        driver.switchTo().window(newhandleDegeri);
        String expecedURL="https://www.testotomasyonu.com";
        String actualURL=driver.getCurrentUrl();

        Assertions.assertEquals(expecedURL,actualURL);

        // electronics urunlerin oldugu window'a gidin
        // Home/Electronics yazdigini test edin

        driver.switchTo().window(ikinciwindowhandleDegeri);
        WebElement seciliKategoriElementi=driver.findElement(By.xpath("//li[@class='current']"));

        String expectedSeciliKategori="Electronics";
        String actualSeciliKategori=seciliKategoriElementi.getText();
        Assertions.assertEquals(expectedSeciliKategori,actualSeciliKategori);
        ReusableMethods.bekle(2);


        // wisequarter'in acik oldugu window'a gidin
        // url'in wisequarter icerdigini test edin

        driver.switchTo().window(ucuncuWindowHandleDegeri);
        String expectedURLIcerik="wisequarter";
        String actualURLIcerik=driver.getCurrentUrl();

        Assertions.assertTrue(actualURLIcerik.contains(expectedURLIcerik));



    }
}
