package day10_waits_cookies;

import Utilities.ReusableMethods;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class C03_waits {
    /
    WebDriver driver;

    @Test
    public void implicitlyWait() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //1. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        //2. Remove butonuna basin.
        driver.findElement(By.xpath("//*[text()='Remove']")).click();


        //3. “It’s gone!” mesajinin goruntulendigini dogrulayin.
        WebElement itsGoneElementi=driver.findElement(By.xpath("//*[text()=\"It's gone!\"]"));

        Assertions.assertTrue(itsGoneElementi.isDisplayed());
        //4. Add buttonuna basin
        driver.findElement(By.xpath("//*[text()='Add']")).click();

        //5. It’s back mesajinin gorundugunu test edin
        WebElement itsBackElementi= driver.findElement(By.xpath("//*[text()=\"It's back!\"]"));
        Assertions.assertTrue(itsBackElementi.isDisplayed());
        ReusableMethods.bekle(3);
        driver.quit();
    }
    @Test
    public void explicitlyWait() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //1. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        //2. Remove butonuna basin.
        driver.findElement(By.xpath("//*[text()='Remove']")).click();

        //3. “It’s gone!” mesajinin goruntulendigini dogrulayin.
            //1. adim wait objesi olusturulur
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
            //2.adim mumkunse kullanacagimiz elementi locate edelim
            //eger mumkun degilse ikinci ve 3. adimi birlestirecegiz
            //bize kullanacagimiz webelementin locate bilgileri lazim.
            // xpathi bu olan bir locate //*[text()="It's gone!"]

            //3.adim locate bilgilerini kullanarak
            //locate beklenecek islemi birlikte tanimlayin

        WebElement itsGoneElementi=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()=\"It's gone!\"]")));




        //4. Add buttonuna basin
        driver.findElement(By.xpath("//*[text()='Add']")).click();

        //5. It’s back mesajinin gorundugunu test edin
            //1. adim wait objesi olustur kismini pass geciyoruz cunku yukarida olusturulustur
            //2. mumkunse kullanacagimiz elementi locate edelim


    }
}
