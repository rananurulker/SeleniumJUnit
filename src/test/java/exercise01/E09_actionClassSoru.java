package exercise01;

import Utilities.ReusableMethods;
import Utilities.TestBaseAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class E09_actionClassSoru extends TestBaseAll {

    @Test
    public void test01(){
        //1- https://testotomasyonu.com/click sitesine gidin
        driver.get("https://testotomasyonu.com/click");

        //2- “DGI Drones” uzerinde sag click yapin
        Actions actions=new Actions(driver);
        WebElement DGIDroneElement=driver.findElement(By.id("pic2_thumb"));
        actions.contextClick(DGIDroneElement).perform();
        ReusableMethods.bekle(3);

        //3- Alert’te cikan yazinin “Tebrikler!... Sağ click yaptınız.” oldugunu test edin.
        String expectedAlertYazisi="Tebrikler!... Sağ click yaptınız.";
        String actualAlertYazisi=driver.switchTo().alert().getText();

        Assertions.assertEquals(expectedAlertYazisi,actualAlertYazisi);
        ReusableMethods.bekle(2);

        //4- Tamam diyerek alert’i kapatalim
        driver.switchTo().alert().accept();
    }
}
