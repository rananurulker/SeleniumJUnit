package day05_maven_JunitFramework;

import Utilities.ReusableMethods;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C05_BeforeAfterNotasyonlari {


        /*
        Bu classda birbirinden bagimsiz calisabilecek
             3 test yapmak istiyorum.
             1-testotomasyonu.com'a gidip urlnin testotomasyonu icerdigini test etsin
             2-wisequarter.com a gidip url nin wisequarter icerdgini test etsin
             3-youtube.com a gidip url nin youtube icerdigini test etsin

             Classdaki 3 test methodunun hepsinin
             en basindaki 3 satir ve sonundaki 2 satir ayni
             bu satirlari tekrar yazmak istemezsek

         */
        WebDriver driver;

       @BeforeEach
        public void setup(){
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        }
        @AfterEach

        public void tearDown(){
            ReusableMethods.bekle(1);
            driver.quit();
        }


        @Test
        public void testotomasyonuTesti(){
            setup();

            // 1- testotomasyonu.com'a gidip url'in "testotomasyonu" icerdigini test etsin
            driver.get("https://www.testotomasyonu.com");

            String expectedUrlIcerik = "testotomasyonu";
            String actualUrl = driver.getCurrentUrl();

            if (actualUrl.contains(expectedUrlIcerik)){
                System.out.println("Testotomasyonu Url testi PASSED");
            }else System.out.println("Testotomasyonu Url testi FAILED");

            if (!actualUrl.contains(expectedUrlIcerik)){
                throw new IllegalArgumentException();
            }

        }

        @Test
        public void wisequarterTesti(){

            setup();
            // 2- wisequarter.com'a gidip url'in "wisequarter" icerdigini test etsin
            driver.get("https://www.wisequarter.com");

            String expectedUrlIcerik = "wisequarter";
            String actualUrl = driver.getCurrentUrl();

            if (actualUrl.contains(expectedUrlIcerik)){
                System.out.println("Wisequarter Url testi PASSED");
            }else System.out.println("Wisequarter Url testi FAILED");


        }

        @Test
        public void youtubeTesti(){

            setup();
            // 3- youtube.com'a gidip url'in "youtube" icerdigini test etsin
            driver.get("https://www.youtube.com");

            String expectedUrlIcerik = "youtube";
            String actualUrl = driver.getCurrentUrl();

            if (actualUrl.contains(expectedUrlIcerik)){
                System.out.println("Youtube Url testi PASSED");
            }else System.out.println("Youtube Url testi FAILED");


        }


    }

