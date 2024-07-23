package day09_actions;

import Utilities.ReusableMethods;
import Utilities.TestBaseAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class C03_MoveToElement extends TestBaseAll {
    @Test
    public void test01(){
        //1- https://www.testotomasyonu.com/ adresine gidin
        driver.get("https://www.testotomasyonu.com/");

        //2- “Kids Wear” menusunun acilmasi icin mouse’u bu menunun ustune getirin
        Actions actions=new Actions(driver);
        ReusableMethods.bekle(3);
        WebElement kidsWear= driver.findElement(By.xpath("(//a[text()='Kids Wear'])[3]"));

        actions.moveToElement(kidsWear).perform();
        ReusableMethods.bekle(13);

        //3- “Boys” linkine basin
        driver.findElement(By.partialLinkText("Boys")).click();


        //4- Acilan sayfadaki ilk urunu tiklayin
        driver.findElement(By.xpath("(//*[@*='prod-img'])[1]")).click();

        //5- Acilan sayfada urun isminin “Boys Shirt White Color” oldugunu test edin

        WebElement urunIsimElementi=driver.findElement(By.xpath("//*[@class=' heading-sm mb-4']"));
        String expectedIsim="Boys Shirt White Color";
        String actualIsim= urunIsimElementi.getText();

        Assertions.assertEquals(expectedIsim,actualIsim);

        ReusableMethods.bekle(3);
    }
}
