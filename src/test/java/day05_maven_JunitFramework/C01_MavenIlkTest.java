package day05_maven_JunitFramework;

import Utilities.ReusableMethods;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_MavenIlkTest {
    public static void main(String[] args)  {

        //ilgili ayarlari yapin
      //  WebDriverManager.chromedriver().setup();
        //ustteki satir, sirket bize ozel bir web driver verirse kullanilacak
        //ama biz seleniumun kendi web driverini kullanacagimiz icin
        //bu satira ihtiyacimiz yok
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //testotomasyonu ana sayfaya gidin
        driver.get("https://www.testotomasyonu.com");

        //titlein Test Otomasyon icerdigini test edin
        String expectedTitle="Test Otomasyon";
        String actualTitle=driver.getTitle();
        if (actualTitle.contains(expectedTitle)){
            System.out.println("Expected tile testi PASSED");

        }else System.out.println("Expected title testi FAILED");

        //sayfayi kapatin
        ReusableMethods.bekle(3);
        driver.quit();



    }
}
