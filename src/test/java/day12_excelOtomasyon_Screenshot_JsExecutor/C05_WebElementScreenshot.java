package day12_excelOtomasyon_Screenshot_JsExecutor;

import Utilities.ReusableMethods;
import Utilities.TestBaseEach;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.IOException;

public class C05_WebElementScreenshot extends TestBaseEach {
    @Test
    public void test01() throws IOException {
        //testotomasyonu anasayfasina gidin
        driver.get("https://www.testotomasyonu.com");
        //logo elementinin screenshoutunu alin
        //istenen webelementi kullanarak yapacagiz

        //1.adim webelementi locate et
        WebElement logoElementi=driver.findElement(By.xpath("(//*[@alt='Logo'])[1]"));

        //2.adim kaydedeceginiz doyayi olusturun
        File webElementSS=new File("target/ekrangoruntuleri/webElementSS.png");

        //3.adim webelementi kullanarak ss  alip gecici dosya olarak kaydedin
        File geciciDosya=logoElementi.getScreenshotAs(OutputType.FILE);

        //4.adim gecici dosyayi asil dosyaya kopyalayalim
        FileUtils.copyFile(geciciDosya,webElementSS);

        //phone icin arama yapin
        WebElement aramaKutusu= driver.findElement(By.id("global-search"));
        aramaKutusu.sendKeys("phone"+ Keys.ENTER);


        //arama sonuc yazisinin ss ini al
        WebElement aramaSonucElement=driver.findElement(By.className("product-count-text"));
        ReusableMethods.getWebelementScreenshot(aramaSonucElement);

    }
}
