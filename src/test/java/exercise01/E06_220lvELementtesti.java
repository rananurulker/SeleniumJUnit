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
        String lvWHD=driver.getWindowHandle();
        WebElement rekomendejamElementi= driver.findElement(By.xpath("(//*[@class='filter-tooltip'])[1]"));

        String expectedElement="Rekomendējam";
        String actualElement= rekomendejamElementi.getText();

        Assertions.assertEquals(expectedElement,actualElement);


        ReusableMethods.bekle(3);

        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.wisequarter.com");
        String wiseWHD=driver.getWindowHandle();

        System.out.println(lvWHD);
        System.out.println(wiseWHD);

        driver.switchTo().window(lvWHD);

        ReusableMethods.bekle(3);
    }
}
