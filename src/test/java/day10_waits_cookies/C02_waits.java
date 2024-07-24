package day10_waits_cookies;

import Utilities.ReusableMethods;
import org.checkerframework.checker.units.qual.C;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class C02_waits {
    /*
    Implicitly wait sayfanin yuklenmesi ve web elenetlerin locate edilmesi icin
    belirlenmis bir global bir beklemedir.
    Locate ve sayfa yuklemesi disinda baska bir seyi beklemez.

    Explicitly Wait ya da web driver wait objesi ise sadece bir web element
    ve sadece bir expected condition icin calisir.
     */
    //Iki tane metod olusturun : implicitWaitTest , explicitWaitTest
    //Iki metod icin de asagidaki adimlari test edin.
    //1. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
    //2. Textbox’in etkin olmadigini(enabled) dogrulayın
    //3. Enable butonuna tıklayın ve textbox etkin oluncaya kadar bekleyin
    //4. Textbox’in etkin oldugunu(enabled) dogrulayın.
    //5. “It’s enabled!” mesajinin goruntulendigini dogrulayın.
    WebDriver driver=new ChromeDriver();

    @Test
    public void implicitlyWait(){
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //1. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        //2. Textbox’in etkin olmadigini(enabled) dogrulayın
        WebElement textBox = driver.findElement(By.xpath("//input[@type='text']"));
        Assertions.assertFalse(textBox.isEnabled());


        //3. Enable butonuna tıklayın
        driver.findElement(By.xpath("//button[text()='Enable']")).click();
        ReusableMethods.bekle(3);

        //ve textbox etkin oluncaya kadar bekleyin


        //4. Textbox’in etkin oldugunu(enabled) dogrulayın.
        Assertions.assertTrue(textBox.isEnabled());

        //5. “It’s enabled!” mesajinin goruntulendigini dogrulayın.
        WebElement itIsEnabledYAziElementi=driver.findElement(By.xpath("//*[text()=\"It's enabled!\"]"));
        Assertions.assertTrue(itIsEnabledYAziElementi.isEnabled());
        ReusableMethods.bekle(3);
        driver.quit();
    }

    @Test
    public void explicitlyWait(){
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //1. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        //2. Textbox’in etkin olmadigini(enabled) dogrulayın
        WebElement textBox = driver.findElement(By.xpath("//input[@type='text']"));
        Assertions.assertFalse(textBox.isEnabled());


        //3. Enable butonuna tıklayın
        driver.findElement(By.xpath("//button[text()='Enable']")).click();


        //4. Textbox’in etkin oldugunu(enabled) dogrulayın.
            //explicit wait kullanabilmek icin
            //1- adim bir wait objesi olusturacagiz
        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));

            //2-adim eger mumkunse kullanacagimiz web elementi locate etmek
            // bizim kullanacagimiz textbox zaten locate edildi

            //3. adim wait objesi ile baslayip beklenecek kosulu tanimlayin
        wait.until(ExpectedConditions.elementToBeClickable(textBox));

        //textbos in enable oldugunu test edebiliriz
        Assertions.assertTrue(textBox.isEnabled());

        //5. “It’s enabled!” mesajinin goruntulendigini dogrulayın.
        WebElement itIsEnabledYAziElementi=
                driver.findElement(By.xpath("//*[text()=\"It's enabled!\"]"));
        Assertions.assertTrue(itIsEnabledYAziElementi.isEnabled());
        ReusableMethods.bekle(3);
        driver.quit();
    }

}
