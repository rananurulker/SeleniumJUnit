package day12_excelOtomasyon_Screenshot_JsExecutor;

import Utilities.ReusableMethods;
import Utilities.TestBaseEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class C04_TumSayfScreenShot extends TestBaseEach {

    @Test
    public void test01(){
        // http://zero.webappsecurity.com/
        driver.get("http://zero.webappsecurity.com/");

        //ekran goruntusu al
        ReusableMethods.getFullScreenshot(driver,"Zero anasayfa");

        //online banking menusune gir
        driver.findElement(By.xpath("//strong[text()='Online Banking']"));


        //ekran goruntusu al
        ReusableMethods.getFullScreenshot(driver,"online banking");

        //tekrar ekran goruntusu alin
        ReusableMethods.getFullScreenshot(driver);

    }
}
