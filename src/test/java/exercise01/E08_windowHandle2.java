package exercise01;

import Utilities.ReusableMethods;
import Utilities.TestBaseAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class E08_windowHandle2 extends TestBaseAll {
    @Test
    public void test01(){
        //1- https://testotomasyonu.com/discount adresine gidin
        driver.get("https://testotomasyonu.com/discount");
        String ilkSayfaWHD= driver.getWindowHandle();

        //2- Elektronics Products yazisinin gorunur olduğunu test edin
        WebElement electronicsElementi=driver.findElement(By.xpath("(//*[text()='Electronics'])[3]"));
        Assertions.assertTrue(electronicsElementi.isDisplayed());

        //3- Dell bilgisayar urun isminin ‘DELL Core I3 11th Gen’ olduğunu test edin
        WebElement electronicsIframe = driver.findElement(By.xpath("(//iframe)[1]"));
        driver.switchTo().frame(electronicsIframe);

        WebElement dellBilgYaziElementi=driver.findElement(By.id("pictext1"));
        String expectedDellBilgYaziElement="DELL Core I3 11th Gen";
        String actualDellBilgYaziElement=dellBilgYaziElementi.getText();

        Assertions.assertEquals(expectedDellBilgYaziElement,actualDellBilgYaziElement);

        //4- Dell bilgisayar’a tiklayip acilan sayfada urun fiyatinin $399.00 olduğunu test edin.
        dellBilgYaziElementi.click();
        ReusableMethods.SwitchWindowbyURL(driver,"https://testotomasyonu.com/product/58");
        String expectedPrice="$399.00";
        String actualPrice=driver.findElement(By.id("priceproduct")).getText();

        Assertions.assertEquals(expectedPrice,actualPrice);

        //5- Ilk sayfaya donun ve Fashion yazisinin gorunur olduğunu test edin
        driver.switchTo().window(ilkSayfaWHD);
        WebElement fashionIframe=driver.findElement(By.xpath("(//iframe)[2]"));
        driver.switchTo().frame(fashionIframe);

        WebElement fashionYaziElementi=driver.findElement(By.tagName("h2"));
        Assertions.assertTrue(fashionYaziElementi.isDisplayed());


        ReusableMethods.bekle(3);
    }
}
