package day09_actions;

import Utilities.ReusableMethods;
import Utilities.TestBaseAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class C09_FileDownloadTesti extends TestBaseAll {
    @Test
    public void test01() throws IOException {
        //1. https://the-internet.herokuapp.com/download adresine gidelim.
        driver.get("https://the-internet.herokuapp.com/download");


        //2. logo.png dosyasını indirelim
        driver.findElement(By.xpath("//*[text()='luminoslogo.png']")).click();

        //3. Dosyanın başarıyla indirilip indirilmediğini test edelim
        ReusableMethods.bekle(3);

        //dosya Downloadsa inecek
        String dosyaDinamikYolu= System.getProperty("user.home") + "\\Downloads\\luminoslogo.png";
        Assertions.assertTrue(Files.exists(Paths.get(dosyaDinamikYolu)));

        ReusableMethods.bekle(3);
        Files.deleteIfExists(Paths.get(dosyaDinamikYolu));
    }
}
