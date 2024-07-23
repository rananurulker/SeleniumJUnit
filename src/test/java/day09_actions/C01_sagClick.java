package day09_actions;

import Utilities.ReusableMethods;
import Utilities.TestBaseAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class C01_sagClick extends TestBaseAll {
    @Test
    public void test01(){
        //1- https://testotomasyonu.com/click sitesine gidin
        driver.get("https://testotomasyonu.com/click");

        //2- “DGI Drones” uzerinde sag click yapin
        Actions actions=new Actions(driver);
        WebElement cgiDronesElementi = driver.findElement(By.id("pic2_thumb"));
        ReusableMethods.bekle(3);
        actions.contextClick(cgiDronesElementi).perform();
        ReusableMethods.bekle(3);

        //3- Alert’te cikan yazinin “Tebrikler!... Sağ click yaptınız.” oldugunu test edin.

        String expectedAlert="Tebrikler!... Sağ click yaptınız.";
        String actualString=driver.switchTo().alert().getText();
        Assertions.assertEquals(expectedAlert,actualString);

        //4- Tamam diyerek alert’i kapatalim
        driver.switchTo().alert().accept();
        ReusableMethods.bekle(3);
    }
}
