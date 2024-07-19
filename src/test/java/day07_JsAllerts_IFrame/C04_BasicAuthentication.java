package day07_JsAllerts_IFrame;

import Utilities.TestBaseEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class C04_BasicAuthentication extends TestBaseEach {

    @Test
    public void basicAuthenticationTesti(){

        /*
        Bir url e ulasirken
        kullanici adi ve sifreyi de url e ekleyip ulasmak istedigimiz
        servera giris yapabilmek icin Basic Authentication kullanilabilir

        Buradaki en onemli kural:
        gidecegimiz url
        kullancii adi ve sifre
        kullanici adi ve sifreyi URL e ekleme yontemi
        bizim bulabilecegimiz veya tahin edebilecegimiz bir bilgi degildir.
        bu bilgilerin otomasyon oncesi bize verilmis olmasi gerekir.
         */
//1- Bir class olusturun : BasicAuthentication
//2- https://testotomasyonu.com/basicauth sayfasina gidin

        //sadece url ile gidersek otomasyon ile kullanici adi ve sifreyi giremeyiz.
      //  driver.get("https://testotomasyonu.com/basicauth");

//3- asagidaki yontem ve test datalarini kullanarak authentication’i yapin
//Html komutu : https://username:password@URL
// Username    : membername
//  password     : sunflower
        driver.get("https://membername:sunflower@testotomasyonu.com/basicauth");
//4- Basarili sekilde sayfaya girildigini dogrulayin
        WebElement basariliGirisYAziElementi=driver.findElement(By.tagName("i"));

        String expectedYaziIcerigi="membername";
        String actualYazi=basariliGirisYAziElementi.getText();
        Assertions.assertTrue(actualYazi.contains(expectedYaziIcerigi));


}
}
