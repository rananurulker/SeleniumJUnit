package exercise01;

import Utilities.ReusableMethods;
import Utilities.TestBaseAll;
import org.junit.jupiter.api.Test;


public class E02_driverManage extends TestBaseAll {
    @Test
    public void driverManage(){

        //1. https://www.testotomasyonu.com/ sayfasina gidin
        driver.get("https://www.testotomasyonu.com/");

        //2. Sayfanin konumunu ve boyutlarini yazdirin
        driver.manage().window().getPosition();
        driver.manage().window().getSize();

        //3. Sayfayi simge durumuna getirin
        driver.manage().window().minimize();

        //4. simge durumunda 3 saniye bekleyip sayfayi maximize yapin
        ReusableMethods.bekle(3);
        driver.manage().window().maximize();

        //5. Sayfanin konumunu ve boyutlarini maximize durumunda yazdirin
        System.out.println(driver.manage().window().getPosition());
        System.out.println(driver.manage().window().getSize());

        //6. Sayfayi fullscreen yapin
        driver.manage().window().fullscreen();

        //7. Sayfanin konumunu ve boyutlarini fullscreen durumunda yazdirin
        System.out.println(driver.manage().window().getSize());
        System.out.println(driver.manage().window().getPosition());


    }
}
