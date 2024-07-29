package day12_excelOtomasyon_Screenshot_JsExecutor;

import Utilities.ReusableMethods;
import Utilities.TestBaseEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class C06_WebElementScreenshot extends TestBaseEach {

@Test
public void test01(){
    //testotomasyonu ana sayfaya gidin
    driver.get("https://www.testotomasyonu.com");

    //urlin testotomasyonu icerdigini test edin ve tum sayfa sss alin
    String expectedURL="testotomasyonu";
    String actualURL=driver.getCurrentUrl();
    Assertions.assertTrue(actualURL.contains(expectedURL));

    ReusableMethods.getFullScreenshot(driver,"testotomasyonu_240729");

    //nutella icin arama yapin
    WebElement aramaKutusu= driver.findElement(By.id("global-search"));
    aramaKutusu.sendKeys("Nutella"+ Keys.ENTER);


    //arama sonucunda urun bulunamadigini test edin ve arama sonuc yazisinin ss ini alin
    WebElement aramaSonuc=driver.findElement(By.className("product-count-text"));

    String expectedSonuc="0 Products Found";
    String actualSonuc=aramaSonuc.getText();

    Assertions.assertEquals(expectedSonuc,actualSonuc);

    ReusableMethods.getWebelementScreenshot(aramaSonuc,"Nutella sonuc testi");


    //dress icin arama yapin
    aramaKutusu= driver.findElement(By.id("global-search"));
    ReusableMethods.bekle(3);
    aramaKutusu.sendKeys("dress"+Keys.ENTER);
    //ilk urune tiklayin
    driver.findElement(By.xpath("(//*[@*='prod-img'])[1]")).click();



    //urun isminin dress icerdigini tedt edin ve ss alin

    WebElement ilkUrunIsimElementi=driver.findElement(By.xpath("//*[@class=' heading-sm mb-4']"));

    String expectedUrunIcerik="dress";
    String actualIsimKucukHarf=ilkUrunIsimElementi.getText().toLowerCase();

    Assertions.assertTrue(actualIsimKucukHarf.contains(expectedUrunIcerik));
    ReusableMethods.getWebelementScreenshot(ilkUrunIsimElementi);

}
}
