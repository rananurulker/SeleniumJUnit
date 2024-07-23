package day09_actions;

import Utilities.ReusableMethods;
import Utilities.TestBaseAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.security.Key;

public class C04_keyboardsBaseACtions extends TestBaseAll {
    @Test
    public void test01(){
        //1- https://www.testotomasyonu.com sayfasina gidelim
        driver.get("https://www.testotomasyonu.com");

        //2- Arama kutusuna actions method’larini kullanarak
        // “DELL Core I3” yazdirin ve Enter’a basarak arama yaptirin

        WebElement aramaKutusu= driver.findElement(By.id("global-search"));

        Actions actions=new Actions(driver);
        actions.click(aramaKutusu)
                .keyDown(Keys.SHIFT)
                .sendKeys("dell c")
                .keyUp(Keys.SHIFT)
                .sendKeys("ore ")
                .keyDown(Keys.SHIFT)
                .sendKeys("I")
                .keyUp(Keys.SHIFT)
                .sendKeys("3").
                sendKeys(Keys.ENTER)
                .perform();

        //3- Bulunan urun isminde “DELL Core I3” bulundugunu test edin

        String expectedIsim="DELL Core I3";
        String actualIsim=driver.findElement(By.xpath("//*[@*='prod-title mb-3 ']"))
                .getText();

        Assertions.assertTrue(actualIsim.contains(expectedIsim));

        ReusableMethods.bekle(3);


    }
}

