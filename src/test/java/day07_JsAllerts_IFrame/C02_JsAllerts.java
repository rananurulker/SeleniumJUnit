package day07_JsAllerts_IFrame;

import Utilities.ReusableMethods;
import Utilities.TestBaseEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class C02_JsAllerts extends TestBaseEach {
    @Test
    public void test01(){
        //youtube anasayfaya gidin
        driver.get("https://www.youtube.com");
        //cookies kabul edin
        driver.findElement(By.xpath("(//div[@class='yt-spec-touch-feedback-shape yt-spec-touch-feedback-shape--touch-response-inverse'])[2]"))
                .click();

        //youtube logosunun goruldugunu test edin
        WebElement logoElementi=driver.findElement(By.xpath("(//yt-icon[@id='logo-icon'])[1]"));
        Assertions.assertTrue(logoElementi.isDisplayed());
        ReusableMethods.bekle(10);

        //https://testotomasyonu.com/javascriptAlert sayfasina gidin
        driver.get("https://testotomasyonu.com/javascriptAlert");

        //Click For JS alert butonuna basin
        driver.findElement(By.xpath("//button[@onclick='jsAlert()']")).click();

        /*
        Eger bir alert ciktiginda HTML kodlarini goruntuleyemiyor ve inspect edemiyorsak
        driver ile locate edip kullanamayiz
        Seleniumda driver methodlari icinde olan switchTo() bu tur durumlarda kullanilabilir.

         */

        // alert'de cikan yazinin "I am a JS Alert" oldugunu test edin
        String expectedAlertYazi="I am a JS Alert";
        String actualAlertYazi=driver.switchTo().alert().getText();
        Assertions.assertEquals(expectedAlertYazi,actualAlertYazi);

        // OK'e basarak alert'u kapatin
        driver.switchTo().alert().accept();

    }
}
