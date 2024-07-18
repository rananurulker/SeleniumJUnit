package day05_maven_JunitFramework;

import jdk.dynalink.linker.LinkerServices;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C06_BeforeAll_AfterAll {
    //3 farkli test methodu olusturup
    //asagidaki 3 gorevi yerine getirin
    //1-testotomasyonu anasayfaya gidin ve dogru sayfaya gittginizi test edin
    //2-phone icin arama yapin ve arama sonucunda urun bulunabildigini test edin
    //3-ilk urunu tiklayin ve urun isminde case sensitive olmadan phone bulundugunu test edin

    /*
    JUnitte @Test methodlarinin hangi sira ile calisacagi bilinmez
    bu yuzden methodlarin ismini test01 test02 seklinde yapmaliyiz

    BeforeAll ve AfterAll icin static method olmali
     */

    static WebDriver driver;
    @BeforeAll
    public static void setup(){
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

    @AfterAll
    public static void tearDown(){
        driver.quit();

    }
    static List<WebElement> bulunanUrunElementleriList;
    @Test
    public void test01(){
        //1-testotomasyonu anasayfaya gidin ve dogru sayfaya gittginizi test edin
        driver.get("https://www.testotomasyonu.com");

        String expectedUrl="https://www.testotomasyonu.com/";
        String actualUrl=driver.getCurrentUrl();

        if (expectedUrl.equals(actualUrl)){
            System.out.println("Anasayfa testi PASSED");
        }else System.out.println("AnaSayfa testi FAILED");

    }
    @Test
    public void test02(){
        //2-phone icin arama yapin ve arama sonucunda urun bulunabildigini test edin
        WebElement aramaKutusu=driver.findElement(By.id("global-search"));
        aramaKutusu.sendKeys("phone"+ Keys.ENTER);

        bulunanUrunElementleriList=driver.findElements(By.xpath("//*[@class='product-detail mb-3']"));

        if (bulunanUrunElementleriList.size()>0){
            System.out.println("Element testi PASSED");
        }else System.out.println("Element testi FAILED");


    }
    @Test
    public void test03(){

        //3-ilk urunu tiklayin ve urun isminde case sensitive olmadan phone bulundugunu test edin
        bulunanUrunElementleriList.get(0).click();
        String urunAdi= "phone";
        WebElement urunIsimElementi = driver.findElement(By.xpath("//*[@class=' heading-sm mb-4']"));
        String actualIsim = urunIsimElementi.getText().toLowerCase();


        if (actualIsim.contains(urunAdi)){
            System.out.println("Urun ismi testi PASSED");
        }else System.out.println("Urun ismi testi FAILED");
    }

    }

