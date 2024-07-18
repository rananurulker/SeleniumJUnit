package day06_JUnitAssertions_dropDownMenu;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_CinsiyetRadio {
    //Gerekli yapiyi olusturun ve aşağıdaki görevi tamamlayın.
    // a. Verilen web sayfasına gidin.
    //      https://testotomasyonu.com/form
    // b. Cinsiyet Radio button elementlerini locate edin
    // c. Iki farkli test method’u oluşturup yazidan veya direk buton’dan size uygun olani secin
    // d. Sectiginiz radio button’un seçili, ötekilerin seçili olmadigini test edin

    static WebDriver driver;

    @BeforeAll
    public static void setup(){
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }
    @AfterAll
    public static void tearDown(){
        driver.quit();
    }

    @Test
    public void yazidanSecmeTesti(){
        //Gerekli yapiyi olusturun ve aşağıdaki görevi tamamlayın.
        // a. Verilen web sayfasına gidin.
        //      https://testotomasyonu.com/form

        driver.get("https://testotomasyonu.com/form");

        WebElement erkekCheckboxYaziElementi= driver.findElement(By.xpath("//*[@for='inlineRadio2']"));

        WebElement erkekCheckbox=driver.findElement(By.id("inlineRadio2"));
        WebElement kadinCheckbox=driver.findElement(By.id("inlineRadio1"));
        WebElement digerCheckbox= driver.findElement(By.id("inlineRadio3"));

        erkekCheckbox.click();
        Assertions.assertTrue(erkekCheckbox.isSelected());
        Assertions.assertFalse(kadinCheckbox.isSelected());
        Assertions.assertFalse(digerCheckbox.isSelected());

    }
    @Test
    public void checkBoxSecmeTesti(){
        driver.get("https://testotomasyonu.com/form");
        WebElement erkekCheckbox=driver.findElement(By.id("inlineRadio2"));
        WebElement kadinCheckbox=driver.findElement(By.id("inlineRadio1"));
        WebElement digerCheckbox= driver.findElement(By.id("inlineRadio3"));

        erkekCheckbox.click();



    }


}
