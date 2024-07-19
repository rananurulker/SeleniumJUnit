package day07_JsAllerts_IFrame;

import Utilities.ReusableMethods;
import Utilities.TestBaseEach;
import org.apache.commons.io.input.WindowsLineEndingInputStream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class C03_JsAllerts extends TestBaseEach {
    //3 test method'u olusturup asagidaki gorevi tamamlayin
    //1. Test
    // - https://testotomasyonu.com/javascriptAlert adresine gidin
    // - 1.alert'e tiklayin
    // - Alert'deki yazinin "I am a JS Alert" oldugunu test edin
    // - OK tusuna basip alert'i kapatin
    //2.Test
    // - https://testotomasyonu.com/javascriptAlert adresine gidin
    // - 2.alert'e tiklayalim
    // - Cancel'a basip, cikan sonuc yazisinin "You clicked: Cancel" oldugunu test edin
    //3.Test
    // - https://testotomasyonu.com/javascriptAlert adresine gidin
    // - 3.alert'e tiklayalim
    // - Cikan prompt ekranina "Abdullah" yazdiralim
    // - OK tusuna basarak alert'i kapatalim
    // - Cikan sonuc yazisinin Abdullah icerdigini test edelim
    @Test
    public void test01(){
        //1. Test
        // - https://testotomasyonu.com/javascriptAlert adresine gidin
        driver.get("https://testotomasyonu.com/javascriptAlert");
        // - 1.alert'e tiklayin
        driver.findElement(By.xpath("//button[@onclick='jsAlert()']")).click();
        // - Alert'deki yazinin "I am a JS Alert" oldugunu test edin
        String expectedAlertYazi="I am a JS Alert";
        String actualAlertYazi=driver.switchTo().alert().getText();
        Assertions.assertEquals(expectedAlertYazi,actualAlertYazi);
        // - OK tusuna basip alert'i kapatin
        driver.switchTo().alert().accept();

    }
    @Test
    public void test02(){
        //2.Test
        // - https://testotomasyonu.com/javascriptAlert adresine gidin
        driver.get("https://testotomasyonu.com/javascriptAlert");
        // - 2.alert'e tiklayalim
        driver.findElement(By.xpath("//*[@*='jsConfirm()']")).click();
        // - Cancel'a basip,
        driver.switchTo().alert().dismiss();
       // cikan sonuc yazisinin "You clicked: Cancel" oldugunu test edin
        WebElement sonucElementi=driver.findElement(By.id("result"));

        String expectedSonucYazisi="You clicked: Cancel";
        String actualSonucYazisi=sonucElementi.getText();

        Assertions.assertEquals(expectedSonucYazisi,actualSonucYazisi);
    }

    @Test
    public void test03(){
        // - https://testotomasyonu.com/javascriptAlert adresine gidin
        driver.get("https://testotomasyonu.com/javascriptAlert");
        // - 3.alert'e tiklayalim
        driver.findElement(By.xpath("//*[@*='jsPrompt()']")).click();
        // - Cikan prompt ekranina "Rana" yazdiralim
        driver.switchTo().alert().sendKeys("Rana");

        // - OK tusuna basarak alert'i kapatalim
        driver.switchTo().alert().accept();
        // - Cikan sonuc yazisinin Rana icerdigini test edelim
        WebElement sonucElementi=driver.findElement(By.id("result"));
        String expectedYaziIcerik="Rana";
        String actualYaziIcerik=sonucElementi.getText();
        Assertions.assertTrue(actualYaziIcerik.contains(expectedYaziIcerik));


    }
}
