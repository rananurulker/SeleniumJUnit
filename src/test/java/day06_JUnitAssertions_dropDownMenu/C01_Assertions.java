package day06_JUnitAssertions_dropDownMenu;

import Utilities.ReusableMethods;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_Assertions {
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

        String expectedUrlIcerik = "youtubepp";
        String actualUrl = driver.getCurrentUrl();



        Assertions.assertTrue(actualUrl.contains(expectedUrlIcerik),"Actual URL does not contain  expected URL");


    }

}
