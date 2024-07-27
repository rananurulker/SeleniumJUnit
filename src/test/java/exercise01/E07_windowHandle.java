package exercise01;

import Utilities.ReusableMethods;
import Utilities.TestBaseAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WindowType;

public class E07_windowHandle extends TestBaseAll {
    @Test
    public void test01(){
         //● Yeni bir class olusturun: WindowHandle
        //● testotomasyonu anasayfa adresine gidin.
        driver.get("https://www.testotomasyonu.com");

        //● Sayfa’nin window handle degerini String bir degiskene atayin
        String testOtomasyonuWHD=driver.getWindowHandle();

        //● Sayfa title’nin “Otomasyon” icerdigini test edin
        String expectedTitle="Otomasyon";
        String actualTitle=driver.getTitle();

        Assertions.assertTrue(actualTitle.contains(expectedTitle));

        //● Yeni bir tab olusturup, acilan tab’da wisequarter.com adresine gidin
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("http://www.wisequarter.com");


        //● Sayfa title’nin “Wise Quarter” icerdigini test edin
        String expectedWiseQuarter="Wise Quarter";
        String actualWiseQuarter=driver.getTitle();

        Assertions.assertTrue(actualWiseQuarter.contains(expectedWiseQuarter));

        //● Yeni bir window olusturup, acilan sayfada walmart.com adresine gidin
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("http://www.walmart.com");

        //● Sayfa title’nin “Walmart” icerdigini test edin
        String expectedWalmartTitle="Walmart";
        String actualWalmartTitle=driver.getTitle();

        Assertions.assertTrue(actualWalmartTitle.contains(expectedWalmartTitle));

        //● Ilk acilan window’a donun ve testotomasyonu sayfasina dondugunuzu test edin
        driver.switchTo().window(testOtomasyonuWHD);
        String expectedURL="https://www.testotomasyonu.com/";
        String actualURL=driver.getCurrentUrl();

        Assertions.assertEquals(expectedURL,actualURL);

        ReusableMethods.bekle(3);
    }
}
