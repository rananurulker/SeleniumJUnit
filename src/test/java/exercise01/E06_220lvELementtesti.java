package exercise01;

import Utilities.ReusableMethods;
import Utilities.TestBaseAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;

public class E06_220lvELementtesti extends TestBaseAll {
    @Test
    public void test01(){
        //https://220.lv/lv/lapaspuse/marketplace-piedavajumi e git
        //Rekomendējam yazisini test et

        driver.get("https://220.lv/lv/lapaspuse/marketplace-piedavajumi");
        WebElement rekomendejamElementi= driver.findElement(By.xpath("(//*[@class='filter-tooltip'])[1]"));

        String expectedElement="Rekomendējam";
        String actualElement= rekomendejamElementi.getText();

        Assertions.assertEquals(expectedElement,actualElement);


        ReusableMethods.bekle(3);
    }
}
