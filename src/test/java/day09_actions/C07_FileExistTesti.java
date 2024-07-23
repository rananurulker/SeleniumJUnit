package day09_actions;

import Utilities.TestBaseAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C07_FileExistTesti  {
    @Test
    public void test01(){

        /*
        Selenium WebDriver adindan da anlayacagimiz uzere Webde calisir
        bilgisayarimizdaki local dosyalara erisemez.

        Eger testimizi gerceklestirirken localde(kendi bilgisayarimizda) bulunan bir dosyaya erismek gerekirse

       Java imdada yetisir.
       Javanin bilgisayarimizdaki bir dosyaya erisebilmesi icin dosya yoluna ihtiyaci vardir.

         */
        String dosyaYolu="C:\\Users\\User\\Downloads\\image.png";
        Assertions.assertTrue(Files.exists(Paths.get(dosyaYolu)));
        String dosyayolu2="src/test/java/day09_actions/image (1).png";
        Assertions.assertTrue(Files.exists(Paths.get(dosyayolu2)));




    }
}
