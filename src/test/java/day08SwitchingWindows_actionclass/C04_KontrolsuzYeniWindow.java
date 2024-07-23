package day08SwitchingWindows_actionclass;

import Utilities.ReusableMethods;
import Utilities.TestBaseEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.Set;

public class C04_KontrolsuzYeniWindow extends TestBaseEach {
    @Test
    public void test01(){

        //● https://testotomasyonu.com/addremove/ adresine gidin.
        driver.get("https://testotomasyonu.com/addremove/");
        String ilkWindowWHD=driver.getWindowHandle();

        //● Sayfadaki textin “Add/Remove Elements” olduğunu doğrulayın.
        String expectedYazi="Add/Remove Elements";
        WebElement yaziElementi=driver.findElement(By.tagName("h2"));
        String actualYazi=yaziElementi.getText();

        Assertions.assertEquals(expectedYazi,actualYazi);


        //● Sayfa başlığının(title) “Test Otomasyonu” icerdigini doğrulayın.

        String expectedTitleIcerik="Test Otomasyonu";
        String actualTitle=driver.getTitle();
        Assertions.assertTrue(actualTitle.contains(expectedTitleIcerik));

        //● ’Please click for Electronics Products’ linkine tiklayin.

        driver.findElement(By.xpath("//*[text() ='Electronics Products']"))
                .click();

        //● Electronics sayfasinin acildigini test edin



        //yeni sayfanin window handle degerinin bilgisini vermeliyiz.
        //kontrolsuz acilan ikinci windowa gecis yapmaliyiz

        Set<String> tumWindowlarinWHDSeti=driver.getWindowHandles();
        System.out.println(ilkWindowWHD);
        System.out.println(tumWindowlarinWHDSeti);
        String ikinciWIndowWHD="";
        for (String eachWHD : tumWindowlarinWHDSeti) {
            if ( ! eachWHD.equals(ilkWindowWHD)){
                ikinciWIndowWHD=eachWHD;
            }

        }
        //artik 2. windowun WHD biliyoruz driveri 2. windowa gecis yapabiliriz

        driver.switchTo().window(ikinciWIndowWHD);
        String expectedURL="https://testotomasyonu.com/category/7/products";
        String actualURL=driver.getCurrentUrl();

        Assertions.assertEquals(expectedURL,actualURL);
        //● Bulunan urun sayisinin 16 olduğunu test edin
        //● Ilk actiginiz addremove sayfasinin oldugu window’a donun
        //● Url’in addremove icerdigini test edin

        ReusableMethods.bekle(3);

    }
}
