package day08SwitchingWindows_actionclass;

import Utilities.ReusableMethods;
import Utilities.TestBaseEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import java.util.Set;

public class C05_ReusableMethodsIleKontrolsuzWindowGecisi extends TestBaseEach {
    @Test
    public void test01(){
        // https://testotomasyonu.com/addremove/ adresine gidin.
        driver.get("https://testotomasyonu.com/addremove/");

        //Please click for Electronics Products' linkine tiklayin.
        driver.findElement(By.xpath("//*[text() ='Electronics Products']"))
                .click();
        /*
        Birden fazla window acildiginda
        acilan windowlarin WHDni onceden bilmemiz mumkun degildir.
        ama gecmek istedigimiz windowun title veya urlini biliriz.
         */
        Set<String > acikWindowlarinWHDSeti=driver.getWindowHandles();
        String hedefURl="https://testotomasyonu.com/category/7/products";
        for (String eachWHD : acikWindowlarinWHDSeti) {
            //once eachWHD nin getirdigi WHD ile bir windowa gecis yapalim
            driver.switchTo().window(eachWHD);
            String gecilenSyafaURL=driver.getCurrentUrl();

            if (gecilenSyafaURL.equals(hedefURl)){
                break;
            }

        }
        //Electronics sayfasinin acildigini test edin
        System.out.println(driver.getCurrentUrl());//addRemove ? electronics sayfasinda
        String expectedURL="https://testotomasyonu.com/category/7/products";
        String actualURL=driver.getCurrentUrl();

        Assertions.assertEquals(expectedURL,actualURL);

        //Ilk actiginiz addremove sayfasinin oldugu window'a donun
        hedefURl = "https://testotomasyonu.com/addremove/";

        ReusableMethods.SwitchWindowbyURL(driver,"https://testotomasyonu.com/addremove/");




        //Url’in addremove icerdigini test edin

        String expectedUrlIcerik = "addremove";
        actualURL = driver.getCurrentUrl();

        Assertions.assertTrue(actualURL.contains(expectedUrlIcerik));

    }
}
