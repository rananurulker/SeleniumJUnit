package exercise01;

import Utilities.TestBaseAll;
import org.apache.hc.core5.util.Asserts;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;

public class E03_DriverManage02 extends TestBaseAll {
    @Test
    public void test01(){
        //1. https://www.testotomasyonu.com/ sayfasina gidin
        driver.get("https://www.testotomasyonu.com/");

        //2. Sayfanin konumunu ve boyutlarini yazdirin
        System.out.println(driver.manage().window().getPosition());
        System.out.println(driver.manage().window().getSize());

        //3. Sayfanin konumunu pixel olarak (50,50)’ye getirin
        driver.manage().window().setSize(new Dimension(50,50));

        //4. Sayfa boyutunu pixel olarak (1000,500)’ye ayarlayin
        driver.manage().window().setPosition(new Point(100,500));

        //5. Sayfanin istenen konum ve boyuta geldigini test edin
        System.out.println(driver.manage().window().getSize());
        System.out.println(driver.manage().window().getPosition());


    }
}
