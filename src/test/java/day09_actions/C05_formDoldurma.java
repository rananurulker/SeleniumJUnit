package day09_actions;

import Utilities.ReusableMethods;
import Utilities.TestBaseAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class C05_formDoldurma extends TestBaseAll {
    @Test
    public void test01(){
        //1- https://www.testotomasyonu.com adresine gidelim
        driver.get("https://www.testotomasyonu.com");

        //2- Account linkine tiklayin
        driver.findElement(By.xpath("(//*[text()='Account'])[1]")).click();

        //3- Sign Up linkine basalim
        //buradan sonra page down yap
        driver.findElement(By.xpath("//*[text()=' Sign Up']")).click();
        Actions actions=new Actions(driver);



        //4- Ad, soyad, mail ve sifre kutularina deger yazalim ve Sign Up butonuna basalim
        //bilgi yazmak icin her kutuyu ayri ayri locate etmek yerine
        //firstname kutusunu locate edip kalanlari TAB ile gezinebiliriz

        WebElement firstNameKutusu=driver.findElement(By.id("firstName"));
        actions.click(firstNameKutusu)
                .sendKeys(Keys.PAGE_DOWN)
                .sendKeys("Rana")
                .sendKeys(Keys.TAB)
                .sendKeys("Ulker")
                .sendKeys(Keys.TAB)
                .sendKeys("rananurulker@gmail.com")
                .sendKeys(Keys.TAB)
                .sendKeys("12345")
                .sendKeys(Keys.TAB)
                .sendKeys("12345")
                .perform();
        ReusableMethods.bekle(10);

        driver.findElement(By.id("btn-submit-form")).click();

        //5- Kaydin olusturuldugunu test edin
        //login yaparak hesabin olusturulabildigini test edelim
        WebElement emailKutusu= driver.findElement(By.id("email"));

        actions.click(emailKutusu)
                .sendKeys("rananurulker@gmail.com")
                .sendKeys(Keys.TAB)
                .sendKeys("12345")
                .perform();

        driver.findElement(By.id("submitlogin")).click();
        ReusableMethods.bekle(3);

        WebElement logoutButonu= driver.findElement(By.xpath("(//*[text()='Logout'])[2]"));

        Assertions.assertTrue(logoutButonu.isDisplayed());
        logoutButonu.click();



    }
}
