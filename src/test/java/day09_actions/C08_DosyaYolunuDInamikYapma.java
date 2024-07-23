package day09_actions;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C08_DosyaYolunuDInamikYapma {
    @Test
    public void test01(){
        /*
        Bir projede jod yazdigimizda kodun bulundugu her bilgisayarda calismasi gerekir

        Bunun icin dosya yolunu kisisel bilgilerden arindirmak gerekir

        Java bu tur ortak projelerde dosya yolunun saglikli calismasi icin
        standart 2 dosya yolu baslangici belirlemistir.

        System.getProperty("user.home") yazarsaniz bilgisayarin ana dosya yolunu verir

         */

        //C:\\Users\\User\\Downloads\\image.png
        //C:\Users\ismai\Downloads\sample.png
        //yukarida c vb kisimdan downloads olan kisma kadar tum bilgisayrlarda farklilik gosterir
        //yukarida bahsedilen Java methodu ile ortak yurutulen calismalarda user.home kullanilabilir

        String dosyaYolu=System.getProperty("user.home") + "\\Downloads\\image.png";
        Assertions.assertTrue(Files.exists(Paths.get(dosyaYolu)));

        String dosyayolu2="src/test/java/day09_actions/image (1).png";
        Assertions.assertTrue(Files.exists(Paths.get(dosyayolu2)));

       String dosyayolu3=System.getProperty("user.dir")+ "\\src\\test\\java\\day09_actions\\image (1).png";
        System.out.println(System.getProperty("user.dir"));
        //dinamik proje yolu

    }
}
