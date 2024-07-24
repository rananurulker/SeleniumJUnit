package day10_waits_cookies;

import Utilities.ReusableMethods;
import Utilities.TestBaseEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class C01_FIleUpload extends TestBaseEach {
    @Test
    public void fileUploadTesti(){
        //1.https://the-internet.herokuapp.com/upload adresine gidelim
        driver.get("https://the-internet.herokuapp.com/upload");

        //2.chooseFile butonuna basalim

        //3.Yuklemek istediginiz dosyayi secelim.
        WebElement chooseFileButonu=driver.findElement(By.id("file-upload"));
        String dosyaYolu=System.getProperty("user.dir")+ "/src/test/java/day09_actions/image (1).png";
        chooseFileButonu.sendKeys(dosyaYolu);
        //4.Upload butonuna basalim.
        driver.findElement(By.id("file-submit")).click();
        //5.“File Uploaded!” textinin goruntulendigini test edelim.
        String expectedYazi="File Uploaded!";
        WebElement yaziElementi=driver.findElement(By.tagName("h3"));
        String actualYazi=yaziElementi.getText();

        Assertions.assertEquals(expectedYazi,actualYazi);



        ReusableMethods.bekle(15);


    }
}
