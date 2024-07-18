package day06_JUnitAssertions_dropDownMenu;

import Utilities.ReusableMethods;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class C03_checkBox {
    //Gerekli yapiyi olusturun ve aşağıdaki görevi tamamlayın
    // a. Verilen web sayfasına gidin.
    //     https://testotomasyonu.com/form
    // b. Sirt Agrisi ve Carpinti checkbox’larini secin
    // c. Sirt Agrisi ve Carpinti checkbox’larininin seçili olduğunu test edin
    // d. Seker ve Epilepsi checkbox’larininin seçili olmadigini test edin

    WebDriver driver;

    @BeforeEach
    public void setup(){
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }
    @AfterEach
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void checkBoxTesti() throws InterruptedException {
        //Gerekli yapiyi olusturun ve aşağıdaki görevi tamamlayın
        // a. Verilen web sayfasına gidin.
        //     https://testotomasyonu.com/form
        driver.get("https://testotomasyonu.com/form");
        // b. Sirt Agrisi ve Carpinti checkbox’larini secin

        WebElement sirtAgrisiYazielementi= driver.findElement(By.xpath("//*[@for='gridCheck5']"));
        WebElement sirtAgrisiCheckBox=driver.findElement(By.xpath("//*[@id='gridCheck5']"));
        WebElement carpintiCheckBox= driver.findElement(By.xpath("//*[@id='gridCheck4']"));

        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(500);
        sirtAgrisiYazielementi.click();
        carpintiCheckBox.click();
        ReusableMethods.bekle(2);

        // c. Sirt Agrisi ve Carpinti checkbox’larininin seçili olduğunu test edin
        Assertions.assertTrue(sirtAgrisiCheckBox.isSelected());
        Assertions.assertTrue(carpintiCheckBox.isSelected());

        // d. Seker ve Epilepsi checkbox’larininin seçili olmadigini test edin
        WebElement sekerCheckBox= driver.findElement(By.xpath("//*[@id='hastalikCheck2']"));
        WebElement epilepsiCheckBox=driver.findElement(By.id("hastalikCheck7"));

        Assertions.assertFalse(sekerCheckBox.isSelected());
        Assertions.assertFalse(epilepsiCheckBox.isSelected());

    }
}
