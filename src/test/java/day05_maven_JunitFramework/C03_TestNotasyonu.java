package day05_maven_JunitFramework;

import Utilities.ReusableMethods;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_TestNotasyonu {
    /*
         Bir test framework'unde kullanilacak her bagimsiz mini test
         farkli test gruplarinda (smoke, E2E testi, regression ...) calistirilabilir olmalidir

         Bu classda birbirinden bagimsiz calisabilecek
         3 test yapmak istiyorum.
         1-testotomasyonu.com'a gidip urlnin testotomasyonu icerdigini test etsin
         2-wisequarter.com a gidip url nin wisequarter icerdgini test etsin
         3-youtube.com a gidip url nin youtube icerdigini test etsin


         Yaptigimiz testleri bagimsiz calistirabilmek icin
         bagimsiz test methodlarinda hazirlamak guzel olur
         ANCAK javadaki klasik methodlar baska bir yerden cagirilmadikca calismazlar
         tek baslarina run edilemezler

         JUnit ile kazandigimiz en buyuk kolayliklardan biri
         siradan methodlari @Test notasyonu sayesinde
         tek basina calisabilir veya calistirilabilir methodlara donusmektedir.

         @ notasyonlar kucuk bilgiler iceren
         mini kod bloklaridir
         ve kendilerine tanimlanan gorevleri yaparlar
      */
    @Test
    public  void testOtomasyonuTest() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        // 1-testotomasyonu.com'a gidip urlnin testotomasyonu icerdigini test etsin

        driver.get("https://www.testotomasyonu.com");
        String expectedUrlIcerik = "testotomasyonu";
        String actualUrl = driver.getCurrentUrl();

        if (actualUrl.contains(expectedUrlIcerik)) {
            System.out.println("Test otomasyonu URL testi PASSED");
        } else System.out.println("Test otomasyonu URL testi FAILED");
        ReusableMethods.bekle(1);
        driver.quit();

    }

    @Test
    // 2-wisequarter.com a gidip url nin wisequarter icerdgini test etsin
    public  void WisequarterTest() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        // 1-testotomasyonu.com'a gidip urlnin testotomasyonu icerdigini test etsin

        driver.get("https://www.wisequarter.com");
        String expectedUrlIcerik = "wisequarter";
        String actualUrl = driver.getCurrentUrl();

        if (actualUrl.contains(expectedUrlIcerik)) {
            System.out.println("wisequarter URL testi PASSED");
        } else System.out.println("wisequarter URL testi FAILED");
        ReusableMethods.bekle(1);
        driver.quit();

    }

    @Test
   // 3-youtube.com a gidip url nin youtube icerdigini test etsin
   public  void YoutubeUrlTest() {
       WebDriver driver = new ChromeDriver();
       driver.manage().window().maximize();
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
       // 1-testotomasyonu.com'a gidip urlnin testotomasyonu icerdigini test etsin

       driver.get("https://www.youtube.com");
       String expectedUrlIcerik = "youtube";
       String actualUrl = driver.getCurrentUrl();

       if (actualUrl.contains(expectedUrlIcerik)) {
           System.out.println("youtube URL testi PASSED");
       } else System.out.println("youtube URL testi FAILED");
       ReusableMethods.bekle(1);
       driver.quit();
   }
}
