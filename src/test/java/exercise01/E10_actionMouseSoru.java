package exercise01;

import Utilities.ReusableMethods;
import Utilities.TestBaseAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class E10_actionMouseSoru extends TestBaseAll {
    @Test
    public void test01(){
        //1- Yeni bir class olusturalim: MouseActions1
        //2- https://the-internet.herokuapp.com/context_menu sitesine gidin
        driver.get("https://the-internet.herokuapp.com/context_menu");
        //3- Cizili alan uzerinde sag click yapin
        Actions actions=new Actions(driver);
        WebElement ciziliAlanElement=driver.findElement(By.id("hot-spot"));
        actions.contextClick(ciziliAlanElement).perform();

        ReusableMethods.bekle(3);

        //4- Alert’te cikan yazinin “You selected a context menu” oldugunu test edin.
        String expectedAlertText="You selected a context menu";
        String actualAlertText=driver.switchTo().alert().getText();


        Assertions.assertTrue(actualAlertText.contains(expectedAlertText));
        ReusableMethods.bekle(3);

        //5- Tamam diyerek alert’i kapatalim
        driver.switchTo().alert().accept();

        //6- Elemental Selenium linkine tiklayalim
        driver.findElement(By.xpath("//*[text()='Elemental Selenium']")).click();

        //7- Acilan sayfada h1 taginda “Elemental Selenium” yazdigini test edelim
        ReusableMethods.SwitchWindowbyURL(driver,"https://elementalselenium.com/");

        String expectedText="Elemental Selenium";
        String actualText= driver.findElement(By.xpath("//*[@class='hero__title']")).getText();

        Assertions.assertEquals(expectedText,actualText);
        ReusableMethods.bekle(3);

    }
}
